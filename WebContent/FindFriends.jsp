<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="javascript/angular.min.js"></script>
<link  href="bootstrap\css\bootstrap.css" rel="stylesheet"/>
<link  href="stylesheet\FindFriends.css" rel="stylesheet"/>
<title>Insert title here</title>
<c:set var="userId" value='${sessionScope.userId}' />
<script>
	var app=angular.module("myapp",[]);
	app.controller("myctrl",function($scope,$http){
		$scope.search=function()
		{
			var myid="<c:out value='${userId}' />";
			var mytext=document.getElementById("mytext").value;
			$http.post("SearchFriends",'{"mytext":"'+mytext+'","myid":"'+myid+'"}').then(function(response)
			{
				$scope.mydata=response.data.myrecords;
				if(response.data.myrecords[0]==null)
				{
					document.getElementById("message1").style.display="block";
				}
				else
				{
					document.getElementById("message1").style.display="none";
				}
			},
			function(error)
			{
				
			});
		}
		$scope.add=function(fid)
		{
			var myid="<c:out value='${userId}' />";
			$http.post("AddFriends",'{"userId1":"'+myid+'","userId2":"'+fid+'"}').then(function(response)
			{
				if(response.data.flag==1)
				{
					alert("You Are Friends !");
					$scope.search();
				}
				else
				{
					alert("Soory Something Went Wrong !");
				}
			},
			function(error)
			{
				
			});
		}
	});
</script>
</head>
<body ng-app="myapp" ng-controller="myctrl">
	<center>
			<table class="table">
				<tr>
					<td><h2><b>Search For Friends</b></h2></td>
				</tr>
				<tr>
					<td><b>Enter The Name</b></td>
				</tr>
				<tr>
					<td><input type="text" placeholder="Enter Name" ng-keyup="search();" id="mytext" class="form-control" style="width:100%"/></td>
				</tr>
			</table>
			<div class="wrapper">
			<table class="table">
				<tr ng-repeat="x in mydata | limitTo: mydata.length-1">
					<td>{{x.name}}</td>
					<td>{{x.email}}</td>
					<td><center><input type="button" value="AddFriend" ng-click="add(x.id);" class="btn btn-primary"/></center></td>
				</tr>
			</table>
		</div>
	</center>
</body>
</html>