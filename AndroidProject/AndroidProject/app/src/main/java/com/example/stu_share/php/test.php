
<?php


    $nameJ=json_decode(file_get_contents('php://input'));

	require 'connection.php';
    $name=$nameJ->{'name'};


	$sql = "INSERT INTO test (id, name) VALUES (NULL, '$name')";
	echo $sql;
	mysqli_query($con,$sql);


	mysqli_close($con);
?>