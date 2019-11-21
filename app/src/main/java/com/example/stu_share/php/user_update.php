
<?php

	require 'connection.php';
    $nameJ=json_decode(file_get_contents('php://input'));
     $userID=$nameJ->{'userId'};
     $firstname=$nameJ->{'firstname'};
     $lastname=$nameJ->{'lastname'};
     $question=$nameJ->{'question'};
     $answer=$nameJ->{'answer'};
	$sql = "UPDATE `user` SET `firstName` = '$firstname', `lastName` = '$lastname ', `question` = '$question ', `answer` = '$answer ' WHERE `user`.`id` = '$userID';";
 mysqli_query($con, $sql);
	mysqli_close($con);
?>