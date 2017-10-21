<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="control.FriendListClass" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script src="javascript\jquery-3.2.1.min.js"></script>
<script src="javascript/angular.min.js"></script>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link  href="bootstrap\css\bootstrap.css" rel="stylesheet"/>
<link rel="stylesheet" href="stylesheet\bootstrap1.min.css">
<script>
	var app=angular.module("myapp",[]);
	app.controller("myctrl",function($scope,$http)
	{
		$scope.removeFriend=function(id)
		{
			if(confirm('Are you scure you want to remove this friend !'))
			{
			
			}
			else
			{
			
			}
		}
	});
</script>
<style>
	body
	{
		padding:2%;
	}
	.message a
	{
		text-decoration:none;
		font-weight:bold;
	}
	.message a:hover
	{
		text-decoration:none;
		color: #d35400;
	}
	.delete a
	{
		text-decoration:none;
		font-weight:bold;
		color:#e74c3c;
	}
	.delete a:hover
	{
		text-decoration:none;
		color:  #f1c40f;
	}
	.detail
	{
		font-weight: bold;
		color: #34495e;
	}
	.textbox
	{
		width:50%;
		margin-bottom:2%
	}
	.heading
	{
		color: #7f8c8d;
	}
</style>
</head>
<body ng-app="myapp" ng-controller="myctrl">
	<c:set var="userId" value='${sessionScope.userId}' />
	<c:set var="list" value='${FriendListClass.myFriendList(1)}' />  
	<div>
		<div>
		<h5 class="heading"><b>Your Friend List</b></h5>
		<input type="text" class="form-control textbox" placeholder="Search For Friend"/>
		</div>
		<table class="table table-striped">
			<c:forEach items="${list}" var="element">
			<tr>
				<td class="detail">${element.getName()}</td>
				<td class="detail">${element.getEmail()}</td>
				<td class="delete"><a href="#" ng-click="removeFriend(${element.getId()})" class="unfriendIcon">Delete</a></td>
				<td class="message"><a href="Message.jsp?Id1=${sessionScope.userId}&Id2=${element.getUserId()}&name=${element.getName()}">Message</a></td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>