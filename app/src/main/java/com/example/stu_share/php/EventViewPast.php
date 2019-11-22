<?php
// #8 Return event ends before today
    require 'connection.php';	       
    $userID = $_GET['userID'];
    $Date = date('m/d/Y');
    $Time =  date("H:i:s");
	
	$sql = "select * from event where enddate>=$Date and endtime>$Time and organizer_id=$userID";
	$check = mysqli_fetch_array(mysqli_query($con,$sql));

	if ($result = mysqli_query($con, $sql)){
		 
		 $resultArray = array();
		 $tempArray = array();
		 
		
		 while($row = $result->fetch_object())
		 {
		
		 $tempArray = $row;
			 array_push($resultArray, $tempArray);
		 }
		 
		
		 echo json_encode($resultArray);
	}
	 
	
	mysqli_close($con);
?>