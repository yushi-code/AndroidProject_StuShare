
<?php

	require 'connection.php'	       
  
	$username = $_GET['email'];
	
	$sql = "SELECT * FROM user WHERE email='$username'";
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