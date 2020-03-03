<?php

	require 'connection.php';
	$nameJ=json_decode(file_get_contents('php://input'));
    $organizer_id = $nameJ->{'organizerId'};
    $status = $nameJ->{'status'};	
	$start_date = $nameJ->{'startDate'};	
	$start_time = $nameJ->{'startTime'};
	$end_date = $nameJ->{'endDate'};
	$end_time = $nameJ->{'endTime'};	
	$title = $nameJ->{'eventTitle'};
	$detail = $nameJ->{'eventDetail'};
	
	//New Attribute!This may require to get changed as the way code is generated.
	$eventCode=$nameJ->{'eventCode'};
	
				
	$sql = "INSERT INTO event (eventCode,organizerId,status,startDate,startTime,endDate,endTime,title,detail)
			VALUES('','$organizer_id','active','$start_date','$start_time','$end_date','$end_time','$title','$detail')";
			echo $sql;
	if(mysqli_query($con,$sql)){

		echo 'successfully registered';	
	}
	else{				
		echo 'oops! Please try again!';		
	}
	
	
    mysqli_close($con);
				
		
?>