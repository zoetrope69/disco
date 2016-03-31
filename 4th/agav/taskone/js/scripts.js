var gl;
var pwgl = {}; //Many variables are added to this as properties
pwgl.ongoingImageLoads = [];
var canvas;

// Varibales for interactive control
var transY = 0, transZ=0;
var xRot =yRot =zRot =xOffs = yOffs = drag = 0;
pwgl.listOfPressedKeys = []; // Keep track of pressed down keys in a list

var shaderVertex = `
  attribute vec3 aVertexPosition;
  attribute vec3 aVertexNormal;
  attribute vec2 aTextureCoordinates;

  uniform mat4 uMVMatrix;
  uniform mat4 uPMatrix;
  uniform mat3 uNMatrix;

  uniform vec3 uLightPosition;
  uniform vec3 uAmbientLightColor;
  uniform vec3 uDiffuseLightColor;
  uniform vec3 uSpecularLightColor;

  varying vec2 vTextureCoordinates;
  varying vec3 vLightWeighting;

  const float shininess = 32.0;

  void main() {
    // get the vertex position in eye coordinates
    vec4 vertexPositionEye4 = uMVMatrix * vec4(aVertexPosition, 1.0);
    vec3 vertexPositionEye3 = vertexPositionEye4.xyz / vertexPositionEye4.w;

    // calculate the vector (L) to the light source
    vec3 vectorToLightSource = normalize(uLightPosition - vertexPositionEye3);

    // transform the normal (N) to eye coordinates
    vec3 normalEye = normalize(uNMatrix * aVertexNormal);

    // calculate N dot L for diffuse lighting
    float diffuseLightWeighting = max(dot(normalEye, vectorToLightSource), 0.0);

    // calculate the reflection vector (R) that is needed for specular light
    vec3 reflectionVector = normalize(reflect(-vectorToLightSource, normalEye));

    // the camera in eye coordinates is located in the origin and is pointing along the negative z-axis. Calculate view vector (V) in eye coordinates as: (0.0, 0.0, 0.0) - vertexPositionEye3
    vec3 viewVectorEye = -normalize(vertexPositionEye3);

    float rdotv = max(dot(reflectionVector, viewVectorEye), 0.0);

    float specularLightWeighting = pow(rdotv, shininess);

    // sum up all three reflection components and send to the fragment shader
    vLightWeighting = uAmbientLightColor + uDiffuseLightColor * diffuseLightWeighting + uSpecularLightColor * specularLightWeighting;

    // finally transform the geometry
    gl_Position = uPMatrix * uMVMatrix * vec4(aVertexPosition, 1.0);
    vTextureCoordinates = aTextureCoordinates;
  }
`;

var shaderFragment = `
  precision mediump float;
  varying vec2 vTextureCoordinates;
  varying vec3 vLightWeighting;
  uniform sampler2D uSampler;

  void main() {
    vec4 texelColor = texture2D(uSampler, vTextureCoordinates);
    gl_FragColor = vec4(vLightWeighting.rgb * texelColor.rgb, texelColor.a);
  }
`;

function createGLContext(canvas) {
  var names = ["webgl", "experimental-webgl"];
  var context = null;

  for (var i=0; i < names.length; i++) {
    try {
      context = canvas.getContext(names[i]);
    } catch(e) {}

    if (context) {
      break;
    }
  }

  if (context) {
    context.viewportWidth = canvas.width;
    context.viewportHeight = canvas.height;
  } else {
    return console.log("Failed to create WebGL context!");
  }
  return context;
}

function loadShader(shaderSource, shaderType) {
  var shader;

  if (!shaderSource) {
    return console.log('Couldn\'t find shader');
  }

  switch (shaderType) {
    case 'fragment':
      shader = gl.createShader(gl.FRAGMENT_SHADER);
      break;
    case 'vertex':
      shader = gl.createShader(gl.VERTEX_SHADER);
      break;
    default:
      return console.log('Not a valid shader script type');
  }

  gl.shaderSource(shader, shaderSource);
  gl.compileShader(shader);

  if (!gl.getShaderParameter(shader, gl.COMPILE_STATUS) && !gl.isContextLost()) {
    return console.log(gl.getShaderInfoLog(shader));
  }

  return shader;
}

function setupShaders() {
var vertexShader = loadShader(shaderVertex, 'vertex');
var fragmentShader = loadShader(shaderFragment, 'fragment');
var shaderProgram = gl.createProgram();
gl.attachShader(shaderProgram, vertexShader);
gl.attachShader(shaderProgram, fragmentShader);
gl.linkProgram(shaderProgram);

if (!gl.getProgramParameter(shaderProgram, gl.LINK_STATUS)
&&!gl.isContextLost()) {
alert("Failed to link shaders: " +
gl.getProgramInfoLog(shaderProgram));
}

gl.useProgram(shaderProgram);

pwgl.vertexPositionAttributeLoc = gl.getAttribLocation(shaderProgram,
"aVertexPosition");
pwgl.vertexTextureAttributeLoc = gl.getAttribLocation(shaderProgram,
"aTextureCoordinates");
pwgl.uniformMVMatrixLoc = gl.getUniformLocation(shaderProgram,
"uMVMatrix");
pwgl.uniformProjMatrixLoc = gl.getUniformLocation(shaderProgram,
"uPMatrix");
pwgl.uniformSamplerLoc = gl.getUniformLocation(shaderProgram,
"uSampler");

pwgl.uniformNormalMatrixLoc = gl.getUniformLocation(shaderProgram,
"uNMatrix");
pwgl.vertexNormalAttributeLoc = gl.getAttribLocation(shaderProgram,
"aVertexNormal");
pwgl.uniformLightPositionLoc =gl.getUniformLocation(shaderProgram,
"uLightPosition");
pwgl.uniformAmbientLightColorLoc = gl.getUniformLocation(shaderProgram,
"uAmbientLightColor");
pwgl.uniformDiffuseLightColorLoc = gl.getUniformLocation(shaderProgram,
"uDiffuseLightColor");
pwgl.uniformSpecularLightColorLoc = gl.getUniformLocation(shaderProgram,
"uSpecularLightColor");

gl.enableVertexAttribArray(pwgl.vertexNormalAttributeLoc);
gl.enableVertexAttribArray(pwgl.vertexPositionAttributeLoc);
gl.enableVertexAttribArray(pwgl.vertexTextureAttributeLoc);

pwgl.modelViewMatrix = mat4.create();
pwgl.projectionMatrix = mat4.create();
pwgl.modelViewMatrixStack = [];
}

function pushModelViewMatrix() {
var copyToPush = mat4.create(pwgl.modelViewMatrix);
pwgl.modelViewMatrixStack.push(copyToPush);
}

function popModelViewMatrix() {
  if (pwgl.modelViewMatrixStack.length == 0) {
throw "Error popModelViewMatrix() - Stack was empty ";
  }
  pwgl.modelViewMatrix = pwgl.modelViewMatrixStack.pop();
}

function setupFloorBuffers() {
  pwgl.floorVertexPositionBuffer = gl.createBuffer();
  gl.bindBuffer(gl.ARRAY_BUFFER, pwgl.floorVertexPositionBuffer);
  var floorVertexPosition = [
      // Plane in y=0
       5.0,   0.0,  5.0,  //v0
       5.0,   0.0, -5.0,  //v1
      -5.0,   0.0, -5.0,  //v2
      -5.0,   0.0,  5.0]; //v3

  gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(floorVertexPosition),
gl.STATIC_DRAW);
  pwgl.FLOOR_VERTEX_POS_BUF_ITEM_SIZE = 3;
  pwgl.FLOOR_VERTEX_POS_BUF_NUM_ITEMS = 4;

  // Specify normals to be able to do lighting calculations
  pwgl.floorVertexNormalBuffer = gl.createBuffer();
  gl.bindBuffer(gl.ARRAY_BUFFER, pwgl.floorVertexNormalBuffer);

  var floorVertexNormals = [
       0.0,   1.0,  0.0,  //v0
       0.0,   1.0,  0.0,  //v1
       0.0,   1.0,  0.0,  //v2
       0.0,   1.0,  0.0]; //v3

  gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(floorVertexNormals),
gl.STATIC_DRAW);
  pwgl.FLOOR_VERTEX_NORMAL_BUF_ITEM_SIZE = 3;
  pwgl.FLOOR_VERTEX_NORMAL_BUF_NUM_ITEMS = 4;

  // Setup texture coordinates buffer
  pwgl.floorVertexTextureCoordinateBuffer = gl.createBuffer();
  gl.bindBuffer(gl.ARRAY_BUFFER, pwgl.floorVertexTextureCoordinateBuffer);
  var floorVertexTextureCoordinates = [
      2.0, 0.0,
      2.0, 2.0,
      0.0, 2.0,
      0.0, 0.0];

  gl.bufferData(gl.ARRAY_BUFFER, new
		Float32Array(floorVertexTextureCoordinates), gl.STATIC_DRAW);
  pwgl.FLOOR_VERTEX_TEX_COORD_BUF_ITEM_SIZE = 2;
  pwgl.FLOOR_VERTEX_TEX_COORD_BUF_NUM_ITEMS = 4;

  // Setup index buffer
  pwgl.floorVertexIndexBuffer = gl.createBuffer();
  gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, pwgl.floorVertexIndexBuffer);
  var floorVertexIndices = [0, 1, 2, 3];

  gl.bufferData(gl.ELEMENT_ARRAY_BUFFER, new
Uint16Array(floorVertexIndices), gl.STATIC_DRAW);
  pwgl.FLOOR_VERTEX_INDEX_BUF_ITEM_SIZE = 1;
  pwgl.FLOOR_VERTEX_INDEX_BUF_NUM_ITEMS = 4;
}

function setupCubeBuffers() {
  pwgl.cubeVertexPositionBuffer = gl.createBuffer();
  gl.bindBuffer(gl.ARRAY_BUFFER, pwgl.cubeVertexPositionBuffer);
  var cubeVertexPosition = [
       // Front face
       1.0,  1.0,  1.0, //v0
      -1.0,  1.0,  1.0, //v1
      -1.0, -1.0,  1.0, //v2
       1.0, -1.0,  1.0, //v3

       // Back face
       1.0,  1.0, -1.0, //v4
      -1.0,  1.0, -1.0, //v5
      -1.0, -1.0, -1.0, //v6
       1.0, -1.0, -1.0, //v7

       // Left face
      -1.0,  1.0,  1.0, //v8
      -1.0,  1.0, -1.0, //v9
      -1.0, -1.0, -1.0, //v10
      -1.0, -1.0,  1.0, //v11

       // Right face
       1.0,  1.0,  1.0, //12
       1.0, -1.0,  1.0, //13
       1.0, -1.0, -1.0, //14
       1.0,  1.0, -1.0, //15

        // Top face
        1.0,  1.0,  1.0, //v16
        1.0,  1.0, -1.0, //v17
       -1.0,  1.0, -1.0, //v18
       -1.0,  1.0,  1.0, //v19

        // Bottom face
        1.0, -1.0,  1.0, //v20
        1.0, -1.0, -1.0, //v21
       -1.0, -1.0, -1.0, //v22
       -1.0, -1.0,  1.0, //v23
  	];

  gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(cubeVertexPosition),
                gl.STATIC_DRAW);
  pwgl.CUBE_VERTEX_POS_BUF_ITEM_SIZE = 3;
  pwgl.CUBE_VERTEX_POS_BUF_NUM_ITEMS = 24;

  // Setup buffer with index
  pwgl.cubeVertexIndexBuffer = gl.createBuffer();
  gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, pwgl.cubeVertexIndexBuffer);

  var cubeVertexIndices = [
            0, 1, 2,      0, 2, 3,    // Front face
            4, 6, 5,      4, 7, 6,    // Back face
            8, 9, 10,     8, 10, 11,  // Left face
            12, 13, 14,   12, 14, 15, // Right face
            16, 17, 18,   16, 18, 19, // Top face
            20, 22, 21,   20, 23, 22  // Bottom face
        ];

  gl.bufferData(gl.ELEMENT_ARRAY_BUFFER, new
Uint16Array(cubeVertexIndices), gl.STATIC_DRAW);
  pwgl.CUBE_VERTEX_INDEX_BUF_ITEM_SIZE = 1;
  pwgl.CUBE_VERTEX_INDEX_BUF_NUM_ITEMS = 36;

  // Setup buffer with texture coordinates
  pwgl.cubeVertexTextureCoordinateBuffer = gl.createBuffer();
  gl.bindBuffer(gl.ARRAY_BUFFER, pwgl.cubeVertexTextureCoordinateBuffer);
  var textureCoordinates = [
    //Front face
    0.0, 0.0, //v0
    1.0, 0.0, //v1
    1.0, 1.0, //v2
    0.0, 1.0, //v3

    // Back face
    0.0, 1.0, //v4
    1.0, 1.0, //v5
    1.0, 0.0, //v6
    0.0, 0.0, //v7

    // Left face
    0.0, 1.0, //v1
    1.0, 1.0, //v5
    1.0, 0.0, //v6
    0.0, 0.0, //v2

    // Right face
    0.0, 1.0, //v0
    1.0, 1.0, //v3
    1.0, 0.0, //v7
    0.0, 0.0, //v4

    // Top face
    0.0, 1.0, //v0
    1.0, 1.0, //v4
    1.0, 0.0, //v5
    0.0, 0.0, //v1

    // Bottom face
    0.0, 1.0, //v3
    1.0, 1.0, //v7
    1.0, 0.0, //v6
    0.0, 0.0, //v2
  ];

  gl.bufferData(gl.ARRAY_BUFFER, new
Float32Array(textureCoordinates),gl.STATIC_DRAW);
  pwgl.CUBE_VERTEX_TEX_COORD_BUF_ITEM_SIZE = 2;
  pwgl.CUBE_VERTEX_TEX_COORD_BUF_NUM_ITEMS = 24;



  // Specify normals to be able to do lighting calculations
  pwgl.cubeVertexNormalBuffer = gl.createBuffer();
  gl.bindBuffer(gl.ARRAY_BUFFER, pwgl.cubeVertexNormalBuffer);
  var cubeVertexNormals = [
       // Front face
       0.0,  0.0,  1.0, //v0
       0.0,  0.0,  1.0, //v1
       0.0,  0.0,  1.0, //v2
       0.0,  0.0,  1.0, //v3

       // Back face
       0.0,  0.0, -1.0, //v4
       0.0,  0.0, -1.0, //v5
       0.0,  0.0, -1.0, //v6
       0.0,  0.0, -1.0, //v7

      // Left face
      -1.0,  0.0,  0.0, //v1
      -1.0,  0.0,  0.0, //v5
      -1.0,  0.0,  0.0, //v6
      -1.0,  0.0,  0.0, //v2

      // Right face
      1.0,  0.0,  0.0, //0
      1.0,  0.0,  0.0, //3
      1.0,  0.0,  0.0, //7
      1.0,  0.0,  0.0, //4

      // Top face
      0.0,  1.0,  0.0, //v0
      0.0,  1.0,  0.0, //v4
      0.0,  1.0,  0.0, //v5
      0.0,  1.0,  0.0, //v1

      // Bottom face
      0.0, -1.0,  0.0, //v3
      0.0, -1.0,  0.0, //v7
      0.0, -1.0,  0.0, //v6
      0.0, -1.0,  0.0, //v2
];

  gl.bufferData(gl.ARRAY_BUFFER, new Float32Array(cubeVertexNormals),
gl.STATIC_DRAW);
  pwgl.CUBE_VERTEX_NORMAL_BUF_ITEM_SIZE = 3;
  pwgl.CUBE_VERTEX_NORMAL_BUF_NUM_ITEMS = 24;
}



function setupTextures() {
  // Texture for the table
  pwgl.woodTexture = gl.createTexture();
  loadImageForTexture("images/wood_128x128.jpg", pwgl.woodTexture);

  // Texture for the floor
  pwgl.groundTexture = gl.createTexture();
  loadImageForTexture("images/metal_floor_256.jpg", pwgl.groundTexture);

  // Texture for the box on the table
  pwgl.boxTexture = gl.createTexture();
  loadImageForTexture("images/wicker_256.jpg", pwgl.boxTexture);
}

function loadImageForTexture(url, texture) {
  var image = new Image();
  image.onload = function() {
    pwgl.ongoingImageLoads.splice(pwgl.ongoingImageLoads.indexOf(image), 1);

    textureFinishedLoading(image, texture);
  }
  pwgl.ongoingImageLoads.push(image);
  image.src = url;
}

function textureFinishedLoading(image, texture) {
  gl.bindTexture(gl.TEXTURE_2D, texture);
  gl.pixelStorei(gl.UNPACK_FLIP_Y_WEBGL, true);

  gl.texImage2D(gl.TEXTURE_2D, 0, gl.RGBA, gl.RGBA, gl.UNSIGNED_BYTE,
                			image);

  gl.generateMipmap(gl.TEXTURE_2D);

  gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MAG_FILTER, gl.LINEAR);
  gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_MIN_FILTER, gl.LINEAR);

  gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_S, gl.MIRRORED_REPEAT);
  gl.texParameteri(gl.TEXTURE_2D, gl.TEXTURE_WRAP_T, gl.MIRRORED_REPEAT);
  gl.bindTexture(gl.TEXTURE_2D, null);
}

function setupBuffers() {
  setupFloorBuffers();
  setupCubeBuffers();
}


function setupLights() {
  gl.uniform3fv(pwgl.uniformLightPositionLoc, [0.0, 20.0, 5.0]);
  gl.uniform3fv(pwgl.uniformAmbientLightColorLoc, [0.2, 0.2, 0.2]);
  gl.uniform3fv(pwgl.uniformDiffuseLightColorLoc, [0.7, 0.7, 0.7]);
  gl.uniform3fv(pwgl.uniformSpecularLightColorLoc, [0.8, 0.8, 0.8]);
}

function uploadNormalMatrixToShader() {
  var normalMatrix = mat3.create();
  mat4.toInverseMat3(pwgl.modelViewMatrix, normalMatrix);
  mat3.transpose(normalMatrix);
  gl.uniformMatrix3fv(pwgl.uniformNormalMatrixLoc, false, normalMatrix);

}

function uploadModelViewMatrixToShader() {
  gl.uniformMatrix4fv(pwgl.uniformMVMatrixLoc, false,
  pwgl.modelViewMatrix);
}

function uploadProjectionMatrixToShader() {
  gl.uniformMatrix4fv(pwgl.uniformProjMatrixLoc, false,
  pwgl.projectionMatrix);
}

function drawFloor() {
  // Bind position buffer
  gl.bindBuffer(gl.ARRAY_BUFFER, pwgl.floorVertexPositionBuffer);
  gl.vertexAttribPointer(pwgl.vertexPositionAttributeLoc,
pwgl.FLOOR_VERTEX_POS_BUF_ITEM_SIZE, gl.FLOAT,false, 0, 0);

  // Bind normal buffer
  gl.bindBuffer(gl.ARRAY_BUFFER, pwgl.floorVertexNormalBuffer);
  gl.vertexAttribPointer(pwgl.vertexNormalAttributeLoc,
                         pwgl.FLOOR_VERTEX_NORMAL_BUF_ITEM_SIZE,
                         gl.FLOAT, false, 0, 0);

  // Bind texture coordinate buffer
  gl.bindBuffer(gl.ARRAY_BUFFER, pwgl.floorVertexTextureCoordinateBuffer);
  gl.vertexAttribPointer(pwgl.vertexTextureAttributeLoc,
                         pwgl.FLOOR_VERTEX_TEX_COORD_BUF_ITEM_SIZE,
     gl.FLOAT, false, 0, 0);
  gl.activeTexture(gl.TEXTURE0);
  gl.bindTexture(gl.TEXTURE_2D, pwgl.groundTexture);

  gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, pwgl.floorVertexIndexBuffer);
  gl.drawElements(gl.TRIANGLE_FAN, pwgl.FLOOR_VERTEX_INDEX_BUF_NUM_ITEMS,
gl.UNSIGNED_SHORT, 0);
}

function drawCube(texture) {
  // Bind position buffer
 gl.bindBuffer(gl.ARRAY_BUFFER, pwgl.cubeVertexPositionBuffer);
  gl.vertexAttribPointer(pwgl.vertexPositionAttributeLoc,
               		pwgl.CUBE_VERTEX_POS_BUF_ITEM_SIZE,
gl.FLOAT, false, 0, 0);

  // Bind normal buffer
  gl.bindBuffer(gl.ARRAY_BUFFER, pwgl.cubeVertexNormalBuffer);
  gl.vertexAttribPointer(pwgl.vertexNormalAttributeLoc,
                         pwgl.CUBE_VERTEX_NORMAL_BUF_ITEM_SIZE,
                         gl.FLOAT, false, 0, 0);

  // bind texture coordinate buffer
  gl.bindBuffer(gl.ARRAY_BUFFER, pwgl.cubeVertexTextureCoordinateBuffer);
  gl.vertexAttribPointer(pwgl.vertexTextureAttributeLoc,
                         pwgl.CUBE_VERTEX_TEX_COORD_BUF_ITEM_SIZE,
 			     gl.FLOAT, false, 0, 0);
  gl.activeTexture(gl.TEXTURE0);
  gl.bindTexture(gl.TEXTURE_2D, texture);

  // Bind index buffer and draw cube
  gl.bindBuffer(gl.ELEMENT_ARRAY_BUFFER, pwgl.cubeVertexIndexBuffer);
  gl.drawElements(gl.TRIANGLES, pwgl.CUBE_VERTEX_INDEX_BUF_NUM_ITEMS,
gl.UNSIGNED_SHORT, 0);
}

function drawTable(){
pushModelViewMatrix();
mat4.translate(pwgl.modelViewMatrix, [0.0, 1.0, 0.0],
				pwgl.modelViewMatrix);
mat4.scale(pwgl.modelViewMatrix, [2.0, 0.1, 2.0], pwgl.modelViewMatrix);
uploadModelViewMatrixToShader();
uploadNormalMatrixToShader();
drawCube(pwgl.woodTexture); // Draw the tabletop with woodTexture
popModelViewMatrix();

// Draw the table legs
for (var i=-1; i<=1; i+=2) {
for (var j= -1; j<=1; j+=2) {
pushModelViewMatrix();
mat4.translate(pwgl.modelViewMatrix, [i*1.9, -0.1, j*1.9],
pwgl.modelViewMatrix);
mat4.scale(pwgl.modelViewMatrix, [0.1, 1.0, 0.1],
pwgl.modelViewMatrix);
uploadModelViewMatrixToShader();
uploadNormalMatrixToShader();
   		drawCube(pwgl.woodTexture);  //Draw the legs with woodTexture
popModelViewMatrix();
}
}
}

function draw() {
  pwgl.requestId = requestAnimFrame(draw);

  var currentTime = Date.now();


  handlePressedDownKeys();

  // Update FPS if a second or more has passed since last FPS update
  if(currentTime - pwgl.previousFrameTimeStamp >= 1000) {
pwgl.fpsCounter.innerHTML = pwgl.nbrOfFramesForFPS;
pwgl.nbrOfFramesForFPS = 0;
pwgl.previousFrameTimeStamp = currentTime;
  }

//console.log("1   xRot= "+xRot+"    yRot="+yRot+"  t= "+transl);
mat4.translate(pwgl.modelViewMatrix, [0.0, transY, transZ],
	pwgl.modelViewMatrix);
mat4.rotateX(pwgl.modelViewMatrix, xRot/50, pwgl.modelViewMatrix);
mat4.rotateY(pwgl.modelViewMatrix, yRot/50, pwgl.modelViewMatrix);

yRot = xRot = zRot =transY=transZ=0;

uploadModelViewMatrixToShader();
uploadProjectionMatrixToShader();
uploadNormalMatrixToShader();
gl.uniform1i(pwgl.uniformSamplerLoc, 0);

gl.viewport(0, 0, gl.viewportWidth, gl.viewportHeight);
gl.clear(gl.COLOR_BUFFER_BIT | gl.DEPTH_BUFFER_BIT);

drawFloor();

// Draw table
pushModelViewMatrix();
mat4.translate(pwgl.modelViewMatrix, [0.0, 1.1, 0.0],
					pwgl.modelViewMatrix);
uploadModelViewMatrixToShader();
uploadNormalMatrixToShader();
drawTable();
popModelViewMatrix();

// Calculate the position for the box that is initially
// on top of the table but will then be moved during animation
pushModelViewMatrix();
if (currentTime === undefined) {
currentTime = Date.now();
}

if (pwgl.animationStartTime === undefined) {
pwgl.animationStartTime = currentTime;
}

// Update the position of the box
if (pwgl.y < 5) {
pwgl.y = 2.7 + (currentTime - pwgl.animationStartTime)/3000 *
					(5.0 - 2.7);
} else {
pwgl.angle = (currentTime - pwgl.animationStartTime)/2000*2*Math.PI %
(2*Math.PI);
pwgl.x = Math.cos(pwgl.angle) * pwgl.circleRadius;
pwgl.z = Math.sin(pwgl.angle) * pwgl.circleRadius;
}

mat4.translate(pwgl.modelViewMatrix, [pwgl.x, pwgl.y, pwgl.z],
pwgl.modelViewMatrix);
mat4.scale(pwgl.modelViewMatrix, [0.5, 0.5, 0.5], pwgl.modelViewMatrix);
uploadModelViewMatrixToShader();
uploadNormalMatrixToShader();
drawCube(pwgl.boxTexture);
popModelViewMatrix();

// Update number of drawn frames to be able to count fps
pwgl.nbrOfFramesForFPS++;
}

function handleContextLost(event) {
  event.preventDefault();
  cancelRequestAnimFrame(pwgl.requestId);
  // Ignore all ongoing image loads by removing their onload handler
  for (var i = 0; i < pwgl.ongoingImageLoads.length; i++) {
pwgl.ongoingImageLoads[i].onload = undefined;
  }
  pwgl.ongoingImageLoads = [];
}

function init() {
// Initialization that is performed during first startup and when the
// event webglcontextrestored is received is included in this function.
setupShaders();
setupBuffers();
setupLights();
setupTextures();
gl.clearColor(0.0, 0.0, 0.0, 1.0);
gl.enable(gl.DEPTH_TEST);

// Initialize some varibles for the moving box
pwgl.x = 0.0;
pwgl.y = 2.7;
pwgl.z = 0.0;
pwgl.circleRadius = 4.0;
pwgl.angle = 0;

// Initialize some variables related to the animation
pwgl.animationStartTime = undefined;
pwgl.nbrOfFramesForFPS = 0;
pwgl.previousFrameTimeStamp = Date.now();


mat4.perspective(60, gl.viewportWidth / gl.viewportHeight,
1, 100.0, pwgl.projectionMatrix);
mat4.identity(pwgl.modelViewMatrix);
mat4.lookAt([8, 12, 8],[0, 0, 0], [0, 1,0], pwgl.modelViewMatrix);
}

function handleContextRestored(event) {
  init();
  pwgl.requestId = requestAnimFrame(draw,canvas);
}

function handleKeyDown(event) {
  pwgl.listOfPressedKeys[event.keyCode] = true;
}

function handleKeyUp(event) {
  pwgl.listOfPressedKeys[event.keyCode] = false;
}

function handlePressedDownKeys() {
  if (pwgl.listOfPressedKeys[38]) {
// Arrow up, increase radius of circle
pwgl.circleRadius += 0.1;
  }

if (pwgl.listOfPressedKeys[40]) {
// Arrow down, decrease radius of circle
pwgl.circleRadius -= 0.1;
if (pwgl.circleRadius < 0) {
    pwgl.circleRadius = 0;
}
}
}



function startup() {
canvas = document.querySelector(".canvas");
canvas = WebGLDebugUtils.makeLostContextSimulatingCanvas(canvas);
canvas.addEventListener('webglcontextlost', handleContextLost, false);
canvas.addEventListener('webglcontextrestored', handleContextRestored,
false);
document.addEventListener('keydown', handleKeyDown, false);
document.addEventListener('keyup', handleKeyUp, false);
canvas.addEventListener('mousemove', mymousemove, false);
canvas.addEventListener('mousedown', mymousedown, false);
canvas.addEventListener('mouseup', mymouseup, false);
canvas.addEventListener('mousewheel', wheelHandler, false);
canvas.addEventListener('DOMMouseScroll', wheelHandler, false);

gl = createGLContext(canvas);

init();

pwgl.fpsCounter = document.querySelector(".fps");

// Draw the complete scene
draw();
}

function mymousedown( ev ){
drag  = 1;
xOffs = ev.clientX;
yOffs = ev.clientY;
}

function mymouseup( ev ){
  drag  = 0;
}

function mymousemove( ev ){
if ( drag == 0 ) return;
if ( ev.shiftKey ) {
transZ = (ev.clientY - yOffs)/10;
//zRot = (xOffs - ev.clientX)*.3;
} else if (ev.altKey) {
transY = -(ev.clientY - yOffs)/10;
} else {
yRot = - xOffs + ev.clientX;
xRot = - yOffs + ev.clientY;
}
xOffs = ev.clientX;
yOffs = ev.clientY;
//console.log("xRot= "+xRot+"    yRot="+yRot+"   trans=  "+transl);
//console.log("xOff= "+xOffs+"    yOff="+yOffs);
}

function wheelHandler(ev) {
if (ev.altKey) transY = -ev.detail/10;
else transZ =ev.detail/10;
//console.log("delta ="+ev.detail);
ev.preventDefault();
}

document.addEventListener('DOMContentLoaded', startup);
