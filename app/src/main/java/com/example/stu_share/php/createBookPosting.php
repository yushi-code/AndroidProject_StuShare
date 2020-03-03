<?php

	require 'connection.php';
	
	//This may require to get changed as the way code is generate.
	$bookCode=$_GET['bookCode'];
	       
    $title = $_GET['title'];
    $edition = $_GET['edition'];	
	$author = $_GET['author'];	
	$price = $_GET['price'];
	$isbnNumber = $_GET['isbnNumber'];
	$details = $_GET['details'];	
	
	
	
				
	$sql = "INSERT INTO event (bookCode,title,edition,author,price,isbnNumber,details)
			VALUES('$bookCode','$title','$edition','$author','$price','$isbnNumber', '$details')";
	if(mysqli_query($con,$sql)){
		echo 'successfully book posting created!';	
	}
	else{				
		echo 'oops! Please try again!';		
	}
	
	
    mysqli_close($con);
				
		
?>