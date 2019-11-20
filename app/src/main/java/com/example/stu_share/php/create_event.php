<?php

	require 'connection.php'
	       
    $organizer_id = $_GET['organizer_id'];	
	$start_date = $_GET['start_date'];	
	$start_time = $_GET['start_time'];
	$end_date = $_GET['end_date'];
	$end_time = $_GET['end_time'];	
	$title = $_GET['title'];	
	$detail = $_GET['detail'];
	
	
		if($organizer_id == '' || $start_date == '' || $start_time == '' ||
		   $end_date =='' ||$end_time == '' || $title == '' || $detail == '')
		{	
			echo 'please fill all values';
		}
		else{		
			$sql = "INSERT INTO event (organizer_id,status,start_date,start_time,end_date,end_time,title,detail)
					VALUES('$organizer_id','Active','$start_date','$start_time','$end_date','$end_time','$title','$detail')";
			if(mysqli_query($con,$sql)){
				echo 'successfully registered';	
			}
			else{				
				echo 'oops! Please try again!';		
			}
			}
			
	        mysqli_close($con);
		}		
		
?>