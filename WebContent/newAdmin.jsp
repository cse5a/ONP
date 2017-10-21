<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="stylesheet/jquery-ui.css">
<script src="javascript/jquery-3.2.1.min.js"></script>
<script src="javascript/jquery-ui.js"></script>
<script src="javascript/angular.min.js"></script>
<title>Insert title here</title>
<script>
$(function() 
{
    $( ".mydate" ).datepicker({ 
    	dateFormat: 'yy-mm-dd',
        changeYear: true,
        changeMonth: true,
        yearRange: '1945:'+'2020:'
    	}); 
});
var app=angular.module("myapp",[]);
app.controller("mycontroller",function($scope,$http){
	$scope.getEmail=function()
	{
		$scope.email=document.getElementById("email").value;
		$http.post("GetValidate",'{"function":"1","value":\"'+$scope.email+'\"}').then(function(response){
			$scope.flag1=response.data.flag;
		},
		function(error)
		{
			
		});
		
	}
	$scope.getContactNo=function()
	{
		$scope.contactNo=document.getElementById("contactNo").value;
		$http.post("GetValidate",'{"function":"2","value":\"'+$scope.contactNo+'\"}').then(function(response){
			$scope.flag2=response.data.flag;
		},
		function(error)
		{
			
		});
	}
});
</script>
</head>
<body ng-app="myapp" ng-controller="mycontroller" >
	<form action="AdminAdd" method="POST">
		<table>
			<tr>
				<td>Name : </td>
				<td><input type="text" name="name" required pattern="[a-zA-Z ]+"/></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td>
					<input type="radio" name="gender" value="Male" />Male
					<input type="radio" name="gender" value="Female" />Female
				</td>
			</tr>
			<tr>
				<td>Date Of Birth</td>
				<td><input type="date" class="mydate" name="dob"/></td>
			</tr>
			<tr>
				<td>City</td>
				<td><input type="text" name="city"/></td>
			</tr>
			<tr>
				<td>State</td>
				<td><input type="text" name="state"/></td>
			</tr>
			<tr>
				<td>Country</td>
				<td><input type="text" name="country"/></td>
			</tr>
			<tr>
				<td>Address</td>
				<td>
					<textarea name="address">
					</textarea>
				</td>
			</tr>
			<tr>
				<td>Contact Number</td>
				<td>
					<input type="text" name="number" required pattern="[0-9]{10}" ng-keyup="getContactNo();" id="contactNo" />
				</td>
				<td>
					<p ng-show="flag2" ng-cloak>Contact Number Already Registered</p>
				</td>
			</tr>
			<tr>
				<td>Email</td>
				<td>
					<input type="email" name="email" ng-keyup="getEmail();" id="email"/>
				</td>
				<td>
					<p ng-show="flag1" ng-cloak>Email Already Registered</p>
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td>
					<input type="text" name="password" ng-model="password"/>
				</td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td>
					<input type="text" name="confpassword" ng-model="confpassword"/>
				</td>
				<td>
					<p ng-hide="password===confpassword" ng-cloak>Invalid Password</p>
				</td>
			</tr>
			<tr>
				<td><input type="submit" value="Add" ng-disabled="flag1 || flag2"/></td>
			</tr>
		</table>
	</form>
</body>
</html>