<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link  href="bootstrap\css\bootstrap.css" rel="stylesheet"/>
<script src="javascript/angular.min.js"></script>
<title>Insert title here</title>
<script>
	var app=angular.module("mydiscussion",[]);
	app.controller("getControl",function($scope,$http,$interval){
		$scope.flag=0;
		$http.get("GetDiscussion").then(function(response)
		{
			$scope.my_discussion=response.data.mydiscussion;
			$scope.length=$scope.my_discussion.length;
		},
		function(error)
		{
			
		});
		$scope.nextIndex=function()
		{
			if($scope.flag<($scope.length-1))
			{
				$scope.flag++;
			}
		}
		$scope.previousIndex=function()
		{
			if($scope.flag>0)
			{
				$scope.flag--;
			}
		}
		$interval(function(){
			$http.post("GetComments","{\"id\":\""+$scope.my_discussion[$scope.flag].id+"\"}").then(function(response){
				$scope.comments=response.data.mycomments;
			},
			function(error){
				
			});
		},3000);
	});
	app.controller("postComment",function($scope,$http){
		$scope.insertComment=function(id,name,email)
		{
			$http.post("PostComment","{\"id\":\""+id+"\",\"name\":\""+name+"\",\"email\":\""+email+"\",\"text\":\""+$scope.mycomment+"\"}").then(function(response){
				$scope.mycomment=null;
			},
			function(error)
			{
				
			});
		}
	})
</script>
</head>
<body>
	<c:set var="userName" value="${sessionScope.userName}" />
	<c:set var="userEmail" value="${sessionScope.userEmail}" />
	<div ng-app="mydiscussion" ng-controller="getControl">
		<p>{{my_discussion[flag].topic}}</p>
		<p>{{my_discussion[flag].text}}</p>
		<p>{{my_discussion[flag].category}}</p>
		<p>{{my_discussion[flag].topic}}</p>
		<h3>Comments Section</h3>
		<ul ng-repeat="x in comments">
			<li>{{x.name}}</li>
			<li>{{x.email}}</li>
			<li>{{x.comment}}</li>
		</ul>
		<div ng-controller="postComment" ng-hide="'${userName}'===''">
		<form name="myform">
		<input type="text" id="userComment" placeholder="Comment" ng-model="mycomment" name="mytext" required pattern="[a-zA-Z0-9 ]+"/>
		<input type="button" value="comment" ng-click="myform.mytext.$valid && insertComment(my_discussion[flag].id,'${userName}','${userEmail}')" />
		</form>
		</div>
		<input type="button" value="Next" ng-click="nextIndex()"/>
		<input type="button" value="Previous" ng-click="previousIndex()"/>
	</div>
</body>
</html>