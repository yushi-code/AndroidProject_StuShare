<?php
//#7.	remove reord in evnetreg
    require 'connection.php';
    
    $nameJ=json_decode(file_get_contents('php://input'));
    //$userID=$nameJ->{'userId'};
    $eventID = $nameJ->{'eventId'};
	$sql = "delete from event_reg where eventId='$eventID';";

    mysqli_query($con, $sql);
    echo $sql;
	mysqli_close($con);
    
?>  