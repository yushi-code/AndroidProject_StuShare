<?php
// #9 Take user ID from App and query joined events
    require 'connection.php';	       
    $userID = $_GET['userID'];
	
	$sql = "SELECT * FROM  event e INNER JOIN eventreg erg ON e._id=erg.event_id WHERE erg.user_id='$user_id'";
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