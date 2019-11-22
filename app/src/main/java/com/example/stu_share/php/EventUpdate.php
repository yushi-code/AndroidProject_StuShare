
<?php
//#7.	remove reord in evnetreg
    require 'connection.php';
    $nameJ=json_decode(file_get_contents('php://input'));
    $startDate=$nameJ->{'startDate'};
    $endDate=$nameJ->{'endDate'};
    $startTime=$nameJ->{'startTime'};
    $endTime=$nameJ->{'endTime'};
    $title=$nameJ->{'title'};
    $detail=$nameJ->{'detail'};
    $eventID = $nameJ->{'eventID'};
	$sql = "UPDATE `event` SET  `startDate` = '$startDate ', `startTime` = '$startTime ', `endDate` = '$endDate ', `endTime` = '$endTime ', `title` = '$title', `detail` = '$detail ' WHERE `event`.`id` = $eventID;";
 mysqli_query($con, $sql);
echo $sql;
	mysqli_close($con);
?>