


<?php
//#7.	remove reord in evnetreg
    require 'connection.php';	       
    $userID = $_GET['userID'];
    $eventID = $_GET['eventID'];
    
	
	$sql = "delete from event_reg where event_id=$eventID and user_id=$userID";
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