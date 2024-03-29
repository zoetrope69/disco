<?php

	$links =  array(
		"0" => array(
				"file" => "cv.php",
				"name" => "CV",
				),
		"1" => array(
				"file" => "litreview.php",
				"name" => "Lit Review",
				),
		"2" => array(
				"file" => "worklog.php",
				"name" => "Worklog",
				)
		);

	$fileName = basename($_SERVER['PHP_SELF']);  // Get filename
	$title = "";
	foreach ($links as $link){
		if ($fileName == $link["file"]){ // Creating titles
			$title =  $link["name"] . " - ";
		}
	}

	?>

<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title><?php echo($title); ?>Zac Colley</title>
	<link rel="shortcut icon" href="img/favicon.ico" />
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/experi.css">
	<script src="js/jquery.js" type="text/javascript"></script>  <!-- jQuery! :D -->
	<script src="js/scripts.js" type="text/javascript"></script> <!-- My scripts -->
</head>
<body>

	<a href="#" class="toTheTop">Top</a>

	<header>
		<section class="validation">
			<p>Validates for <a href="http://validator.w3.org/check?uri=referer" target="_blank">HTML</a>
			and <a href="http://jigsaw.w3.org/css-validator/check/referer" target="_blank">CSS</a>!</p>
		</section>

	<nav>	
		<section class="links">
			<?php
				echo "<a href='index.php'>Home</a> \n";

				$fileName = basename($_SERVER['PHP_SELF']);  // Get filename
				foreach ($links as $link){
					if ($fileName == $link["file"]){ // Creating titles
						echo "<a class='current' href='" . $link['file'] . "'>" . $link['name'] . "</a> \n";
					}
				}
					
			?>
		</section>
		<h1>Zac Colley</h1>
	</nav>
	</header>