<?php

	require 'connection.php';
	       
    $organizer_id = $_GET['organizer_id'];
    $status = $_GET['status'];	
	$start_date = $_GET['startDate'];	
	$start_time = $_GET['startTime'];
	$end_date = $_GET['endDate'];
	$end_time = $_GET['endTime'];	
	$title = $_GET['title'];	
	$detail = $_GET['detail'];
	
				
	$sql = "INSERT INTO event (organizerId,status,startDate,startTime,endDate,endTime,title,detail)
			VALUES(123,'$status','$start_date','$start_time','$end_date','$end_time','$title','$detail')";
	if(mysqli_query($con,$sql)){
		echo 'successfully registered';	
	}
	else{				
		echo 'oops! Please try again!';		
	}
	
	
    mysqli_close($con);
				
		
?>