<?php

	require 'connection.php';
    $nameJ=json_decode(file_get_contents('php://input'));
    $name=$nameJ->{'email'};
	$sql = "SELECT * FROM user WHERE email='$name'";
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