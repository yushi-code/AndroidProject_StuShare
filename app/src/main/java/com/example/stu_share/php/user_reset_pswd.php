
<?php

	require 'connection.php';
    $nameJ=json_decode(file_get_contents('php://input'));
     $userID=$nameJ->{'userId'};
     $password=$nameJ->{'password'};

	$sql = "UPDATE `user` SET `password` = '$password' WHERE `user`.`id` = '$userID';";
 mysqli_query($con, $sql);
 echo $sql;
	mysqli_close($con);
?>