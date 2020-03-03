<?php
//#7.	remove reord in evnetreg
    require 'connection.php';
    
    $nameJ=json_decode(file_get_contents('php://input'));
    $userID=$nameJ->{'userId'};
    $eventID = $nameJ->{'eventId'};
	//$sql1 = "delete from event_reg where eventId='$eventID';";
	$sql = "UPDATE event SET status='suspended' where id='$eventID';delete from event_reg where eventId='$eventID';";
";
    echo $eventID;
	echo $sql;
    mysqli_query($con, $sql);

	mysqli_close($con);
    
?>    