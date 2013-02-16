<?php

	include('header.php');
	echo "<main class='worklog'>";
	include "worklog/head.html";
	include "worklog/post.php";
	include "worklog/date.php";
	include "worklog/tags.php";
	
	echo "<!-- Term 1 -->";
	
	$currentWeek = 12;
	
	for ($weekNo = 12; $weekNo > 0; $weekNo--){
		include "worklog/logs/" . $weekNo . ".php";
	}	

	echo "<!-- Term 2 -->";
	
	include "worklog/foot.html";

	echo "</main>";
	
?>