<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="user.UserBean" %>
<%@ page import="user.UserBasicInfo" %>
<%@ page import="control.Category" %>
<%@ page import="control.GetCategory" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Democratic</title>
<!-- ------------------------------------ External Links ------------------------------------ -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="javascript/angular.min.js"></script>
<script src="javascript/myModule.js"></script>
<script src="javascript/GetIndexPost.js"></script>
<link rel="stylesheet" href="stylesheet/index.css">
<!-- ------------------------------------------------------------------------------------------ -->
<c:set var="id" value="${cookie.DEMOCRATIC_User_id.value}" />
<c:set var="userObject" value="${UserBasicInfo.getUserdata(id)}" />
</head>
<body ng-app="myapp">
	<!-- ============= upper navigation bar ================= -->
	<nav class="navbar mynavbar navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Democratic</a>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<c:choose>
				<c:when test="${id!=null}">
					<li><a href="UserDashboard.jsp">Welcome ${userObject.getUserName()}</a></li>
					<li><a href="UserLogoutController">Logout</a></li>
				</c:when>
				<c:otherwise>
					<li><a href="signUp.jsp">Signup</a></li>
					<li><a href="Login.jsp">Login</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</div>
	</nav>
	<!-- ============= upper navigation bar end ============= -->
	<!-- ================== Header start ==================== -->
	<haeder class="col-sm-12 myheader">
		<div class="col-sm-12">
			<center><h1><b>Democratic</b></h1></center>
			<div class="col-sm-5" style="margin-top: 2%">
			<blockquote style="color:white">
				START WHERE YOU ARE USE WHAT YOU HAVE DO WHAT YOU CAN
			</blockquote>
		</div>
		</div>
	</haeder>
	<!-- =================== Header End ===================== -->
	<!-- ==================== Main Image Slider =================== -->
	<div style="height:30%">
	<div id="myCarousel" class="carousel slide" data-ride="carousel" style="margin-top:0px">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
    </ol>
    <!-- Wrapper for slides -->
    <div class="carousel-inner">
      <div class="item active" style="height:500px">
        <img src="images/sports.jpg" alt="Sports News" style="width:100%">
        <div class="carousel-caption">
          <h3>Get Global Sports News</h3>
          <p>Fastest Sports News Update</p>
        </div>
      </div>
      <div class="item" style="height:500px" >
        <img src="images/tech.jpg" alt="Chicago" style="width:100%">
        <div class="carousel-caption">
          <h3>Chicago</h3>
          <p>Thank you, Chicago!</p>
        </div>
      </div>
      <div class="item" style="height:500px" >
        <img src="images/poli.jpg" alt="New York" style="width:100%">
        <div class="carousel-caption">
          <h3>New York</h3>
          <p>We love the Big Apple!</p>
        </div>
      </div>
    </div>
  </div>
  </div>
  <!-- ==================== Main Image Slider End =================== -->
  <!-- ==================== My Navigation Bar ======================= -->
  <c:set var="Category" value="${GetCategory.category()}" />
  <div ng-controller="GET_INDEX_POST">
	<nav>
	 	<ul class="nav navbar-nav" >
	 		<c:forEach var="object" items="${Category}">
	 		<li><a href="#" ng-click="getNews(${object.getCategoryId()})">${object.getCategoryName()}</a></li>
	 		</c:forEach>
	 	</ul>
	</nav><br>
	<input type="radio" ng-model="tablename" value="adminpost"/>UserPost
	<input type="radio" ng-model="tablename" value="userpost"/>AdminPost
	<input type="radio" ng-model="tablename" value=""/>All
	<div class="col-sm-12">
		<div style="height:900px;overflow:auto">
	      <div ng-repeat="x in mylist" ng-hide="x.tablename==tablename">
	      	<h4>{{x.name}}</h4>
	      	<a data-toggle="collapse" data-target="#post{{x.postId}}image" style="text-decoration:none"><b>Images</b></a>
	      	<div class="collapse" id="post{{x.postId}}image">
	      	<div class="col-sm-6"><image src="GET_POST_MEDIA?requestFileIndex=1&requestId={{x.postId}}&requestTableName={{x.tablename}}" width="400px" height="300px"/></div>
	      	<div class="col-sm-6"><image src="GET_POST_MEDIA?requestFileIndex=2&requestId={{x.postId}}&requestTableName={{x.tablename}}" width="400px" height="300px"/></div>
	      	</div>
	      	<p>{{x.body}}</p>
	      	<h6>{{x.work}}</h6>
	      	<a data-toggle="collapse" data-target="#post{{x.postId}}video" style="text-decoration:none"><b>Video</b></a>
	      	<div class="collapse" id="post{{x.postId}}video">
		      	<video width="500" height="240" controls>
		  		<source src="GET_POST_MEDIA?requestFileIndex=3&requestId={{x.postId}}&requestTableName={{x.tablename}}" type="video/mp4">
				</video> 
			</div>
	      </div>
	      </div>
	</div>
  </div>
  <!-- ==================== My Navigation Bar ======================= -->
</body>
</html>