<?php

require 'connection.php';

$nameJ=json_decode(file_get_contents('php://input'));
$userID=$nameJ->{'userid'};

$sql = "select * from event where enddate< CURRENT_DATE() and id='$userID';";
//and endtime> CURRENT_TIME()


// Confirm there are results
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