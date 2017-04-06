<?php 
  $serversideerrortext = "ARG_ERROR";
	if(isset($_POST)){
		$author = $_POST["book-author"];
		$title = $_POST["book-title"];
		if($author != "Mergehez" || $title != "Book1"){
			echo $serversideerrortext;
		}
	}else{
		echo $serversideerrortext;
	}
