<?php

	require 'connection.php';
	
	//This may require to get changed as the way code is generate.
	$roomCode=$_GET['roomCode'];
	       
    $title = $_GET['title'];
	$available_date = $_GET['available_date'];
	$offering_wanted = $_GET['offering_wanted'];
	$lease = $_GET['lease'];
	$room_number = $_GET['room_number'];
	$pets =$_GET['pets'];
	$house_type = $_GET['house_type'];
	$rent = $_GET['rent'];
	$location = $_GET['location'];
	$details = $_GET['details'];	
	
	$sql = "INSERT INTO event (roomCode,title,available_date,offering_wanted,lease,room_number,pets,house_type,rent,location,details)
			VALUES('$roomCode','$title','$available_date','$offering_wanted','$lease,room_number','$pets','$house_type','$rent','$location','$details')";
	if(mysqli_query($con,$sql)){
		echo 'successfully rental share posting created!';	
	}
	else{				
		echo 'oops! Please try again!';		
	}
	
	
    mysqli_close($con);
				
		
?>