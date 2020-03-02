<?php

    require 'connection.php';
    
    $nameJ=json_decode(file_get_contents('php://input'));
    $userID=$nameJ->{'userId'};
    $eventID = $nameJ->{'eventId'};
	//$sql1 = "delete from event_reg where organizerId='$userID';";
	$sql = "UPDATE event SET status='suspended' where organizerId='$userID';";
 mysqli_query($con, $sql);
echo $sql;
	mysqli_close($con);
    
?>    