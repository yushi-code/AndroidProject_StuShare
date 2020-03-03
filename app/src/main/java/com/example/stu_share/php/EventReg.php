


<?php
//#7.1.	insert reord in evnetreg
    require 'connection.php';
    $nameJ=json_decode(file_get_contents('php://input'));
        $userID=$nameJ->{'userId'};

    $eventID = $nameJ->{'eventId'};
    
	$sql = "INSERT INTO `event_reg` ( `eventId`, `userId`, `status`) VALUES ( '$eventID', '$userID', 'registered');";
    echo $sql;
	
    mysqli_query($con, $sql);


	mysqli_close($con);
?>