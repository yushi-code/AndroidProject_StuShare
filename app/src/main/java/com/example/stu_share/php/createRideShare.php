<?php

	require 'connection.php';
	
	//This may require to get changed as the way code is generate.
	$carCode=$_GET['carCode'];
	       
    $title = $_GET['title'];
    $brand = $_GET['brand'];	
	$available_date = $_GET['available_date'];
	$model = $_GET['model'];
	$year = $_GET['year'];
	$mileage = $_GET['mileage'];
	$price = $_GET['price'];
	$location = $_GET['location'];
	$details = $_GET['details'];	
	
	$sql = "INSERT INTO event (carCode,title,brand,available_date,model,year,mileage,price,location,details)
			VALUES('$carCode','$title','$brand','$available_date','$model','$year','$mileage','$price','$location','$details')";
	if(mysqli_query($con,$sql)){
		echo 'successfully rideshare posting created!';	
	}
	else{				
		echo 'oops! Please try again!';		
	}
	
	
    mysqli_close($con);
				
		
?>