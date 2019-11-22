<?php
    
    $host = "gblearn.com";
    $user_name = "f9team1_f9team1";
    $user_password = "Stushare127";
    $db_name = "f9team1_stushare";

    $con = mysqli_connect($host, $user_name,$user_password, $db_name);
    
// 	require 'user_email_pass.php';
	
	$email = $_GET['email'];    	
	$password = $_GET['password'];
	$firstName = $_GET['firstName'];	
	$lastName = $_GET['lastName'];
	$collegeCode =$_GET['collegeCode'];
	$programCode = $_GET['programCode'];	
	$registeredYear = $_GET['registeredYear'];
	$exprireYear = $_GET['exprireYear'];
	$status = $_GET['status'];
	$question = $_GET['question'];	
	$answer = $_GET['answer'];
	$role = $_GET['role'];
	
// 		if($pass=="no")
// 		{	
// 			echo 'The email already exists.';
// 		}
// 		else{
			$sql = "INSERT INTO user(email, password, firstName, lastName,
			collegeCode, programCode, registeredYear, exprireYear, status, question, answer, role) VALUES ('$email','$password','$firstName','$lastName','$collegeCode','$programCode','$registeredYear','$exprireYear','$status','$question','$answer','$role')";
			
			if(mysqli_query($con,$sql)){
				echo 'successfully registered';	
			}
			else{				
				echo 'oops! Please try again!';		
			}
// 		}
			
	        mysqli_close($con);
		
		
?>