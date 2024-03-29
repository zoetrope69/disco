<?php include('header.php'); ?>

	<article class="home">

		<a href="cv.php" class="tile cv cvtile">
			<section class="head">
				<ul>
					<li class="min"></li>
					<li class="max"></li>
					<li class="close">X</li>
				</ul>
				<h1>curriculum vitae - Notepad</h1>
			</section>

			<ul>
				<li>File</li>
				<li>Edit</li>
				<li>Format</li>
				<li>Help</li>
			</ul>

			<section class="textarea">
				<h1>My name is Zac Colley</h1>

				<p>----------</p>

				<p>&#009993;: <span class="link">z@ccolley.com</span></p>

				<p>----------</p>

				<p>This did have an old copy of my CV for my coursework but...</p>

				<p>You can <span class="link">email me</span> for it or check out my <span class="link">LinkedIn</span> profile.</p>
			</section>

		</a>

		<a href="litreview.php" class="tile litreviewtile">
			<h1>The evolution of mobile application design</h1>
			<p>This literature review will be discussing the evolution of mobile application design and how application design for mobile devices compares to desktop.</p>			
		</a>

		<a href="worklog.php" class="tile worklogtile">
			<h1>My Worklog</h1>
		</a>

		<section class="tile imagetile">

			<?php /* This grabs my gravatar or reverts to a default image if it can't get it. */
			
			$myEmail = "zaccolley@gmail.com";
			$defaultImg = "img/defaultimg.png";
			$imgDimensions = 100;
			$gravatarURL = "http://www.gravatar.com/avatar/" . md5($myEmail)  . "?d=" . urlencode($defaultImg) . "&amp;s=" . $imgDimensions;
		
			?>

			<img src="<?php echo $gravatarURL; ?>" alt="My gravatar image">

		</section>
		
		<section class="tile validatetile">
			<p>I've got the site validating to the standards for <a href="http://validator.w3.org/check?uri=referer" target="_blank">HTML</a>
			and for <a href="http://jigsaw.w3.org/css-validator/check/referer" target="_blank">CSS!</a></p>
		</section>

		<section class="tile videotile">
			<video controls preload="none" poster="img/videoposter.png">
		        <source src="video/scrollydownycodeything.webm" type='video/webm; codecs="vp8.0, vorbis"'/>
		        <source src="video/scrollydownycodeything.ogg" type='video/ogg; codecs="theora, vorbis"'/>
		        <source src="video/scrollydownycodeything.mp4" type='video/mp4; codecs="avc1.4D401E, mp4a.40.2"'/>
		        <p>Oops, no video sorry!</p>
			</video>
		</section>

	</article>

<?php include('footer.php'); ?>