<?php
// #9 Take user ID from App and query joined events
    require 'connection.php';
        $nameJ=json_decode(file_get_contents('php://input'));
 $userID=$nameJ->{'userid'};

	$sql = "SELECT * FROM  event e INNER JOIN event_reg erg ON e.id=erg.eventId WHERE erg.userId='$userID';";

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