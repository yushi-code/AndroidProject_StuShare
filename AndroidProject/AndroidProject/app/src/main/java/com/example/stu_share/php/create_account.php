<?php

	require 'connection.php';
	       
	$fname = $_GET['fname'];	
	$lname = $_GET['lname'];
	$email = $_GET['email'];
	$password = $_GET['password'];
	$college_code = $_GET['college_code'];	
	$program_code = $_GET['program_code'];	
	$registered_year = $_GET['registered_year'];
	$graduation_year = $_GET['graduation_year'];	
	$question = $_GET['question'];	
	$answer = $_GET['answer'];
	
	
		if($fname == '' || $lname == '' || $email == '' ||
		   $password =='' ||$college_code == '' || $program_code == '' || $registered_year == '' ||
		   $graduation_year == '' || $status == '' || $question == '' || $answer == '')
		{	
			echo 'please fill all values';
		}
		else{
			$sql = "SELECT * FROM user WHERE email='$email'";
	        $check = mysqli_fetch_array(mysqli_query($con,$sql));
			if(isset($check)){
				echo 'username or email already exist';
			}else{
				$sql = "INSERT INTO user (email,password,first_name,last_name,college_code,program_code,registered_year,expire_year,status,question,answer,role)
						VALUES('$email','$password','$fname','$lname','$college_code','program_code','$registered_year','$graduation_year','active','$question','$answer','Student')";
				if(mysqli_query($con,$sql)){
					echo 'successfully registered';	
				}
				else{				
					echo 'oops! Please try again!';		
				}
			}
			
	        mysqli_close($con);
		}		
		
?>