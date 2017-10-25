<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="user.UserBean" %>
<%@ page import="user.UserBasicInfo" %>
<%@ page import="control.GetCategory" %>
<%@ page import="user.CountUserPost" %>
<%@ page import="control.FriendListClass" %>
<%@ page import="user.PostBean" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- --------------------------------- Importing All the style-sheet  & Java-script ---------------------------------------- -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="stylesheet/UpdateUserInfo.css">
<link rel="stylesheet" href="stylesheet/UserDashboard.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="javascript/angular.min.js"></script>
<script src="javascript/myModule.js"></script>
<script src="javascript/Discussion.js"></script>
<script src="javascript/UserFriends.js"></script>
<script src="javascript/SearchFriends.js"></script>
<script src="javascript/Update_Validation.js"></script>
<script src="javascript/UpdateNews.js"></script>
<script src="javascript/Message.js"></script>
<script src="javascript/addNews.js"></script>
<script src="javascript/GetWall.js"></script>
<script src="javascript/GetUserPost.js"></script>
<!-- --------------------------------------- Importing End ---------------------------------------------------------------- -->
<!-- ============== Get the userId From cookie ============== -->
<c:set var="id" value="${cookie.DEMOCRATIC_User_id.value}" />
<c:if test="${id==null}">
		<c:redirect url="Login.jsp" />
</c:if>
<c:set var="userObject" value="${UserBasicInfo.getUserdata(id)}" />
<!-- ========================== End ========================== -->
<title>Welcome ${userObject.getUserName()}</title>
</head>
<body>
	<!-- ============= upper navigation bar ================= -->
	<nav class="navbar mynavbar">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Democratic</a>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="index.jsp">Home</a></li>
			<li><a href="UserLogoutController">Logout</a></li>
		</ul>
	</div>
	</nav>
	<!-- ============= upper navigation bar end ============= -->
	
	<!-- ================== Header start ==================== -->
	<haeder class="col-sm-12 myheader" style="">
		<div class="col-sm-12">
			<h1><b>Democratic</b></h1>
			<h3>Welcome ${userObject.getUserName()}</h3>
		</div>
		<div class="col-sm-5" style="margin-top: 2%">
			<blockquote style="color:white">
				START WHERE YOU ARE USE WHAT YOU HAVE DO WHAT YOU CAN
			</blockquote>
		</div>
	</haeder>
	<!-- =================== Header End ===================== -->
	<!-- ================================================================= WebPage Main Section ================================================================= -->
	<section class="mySection" ng-app="myapp" ng-init="id=${id}">
	<!-- ======================================= Discussion Section Start ======================================= -->
	<section class="col-sm-3" ng-controller="getControl_Discussion">
		<div>
			<h5><b>{{my_discussion[flag].topic}}</b></h5>
			<p>{{my_discussion[flag].text}}</p>
			<h3>Comments Section</h3>
			<button data-toggle="collapse" data-target="#demo">Comments</button>
			<div class="insertComment" id="demo">
				<ul ng-repeat="x in comments" >
					<li>{{x.name}}</li>
					<li>{{x.email}}</li>
					<li>{{x.comment}}</li>
				</ul>
			</div>
			<div>
			<!-- ng-controller="postComment_Discussion" -->
				<form name="myform">
					<!-- ===================================== Working On This Filed =================================== -->
					<input type="text" id="userComment" placeholder="Comment" ng-model="mycomment" name="mytext" required pattern="[a-zA-Z0-9 ]+"/>
					<input type="button" value="comment" ng-click="insertComment('${userObject.getUserName()}','${userObject.getUserEmail()}')" />
					<!-- ===================================== Working On This Filed =================================== -->
				</form>
			</div>
			<input type="button" value="Next" ng-click="nextIndex()"/>
			<input type="button" value="Previous" ng-click="previousIndex()"/>
		</div>
	</section>
	<!-- ======================================= Discussion Section End ======================================= -->
	<!-- ======================================= Navigation Section Start ===================================== -->
	<section class="col-sm-9 mymainSection">
	  <ul class="nav nav-tabs">
	    <li class="active"><a data-toggle="tab" href="#home">Home</a></li>
	    <li><a data-toggle="tab" href="#menu1"><b>Wall</b></a></li>
	    <li><a data-toggle="tab" href="#menu2"><b>Post your news</b></a></li>
	    <li><a data-toggle="tab" href="#menu3"><b>Edit And Delete Post</b></a></li>
	    <li><a data-toggle="tab" href="#menu4"><b>Follow your friends</b></a></li>
	    <li><a data-toggle="tab" href="#menu5"><b>Following</b></a></li>
	    <li><a data-toggle="tab" href="#menu6"><b>Message</b></a></li>
	    <li><a data-toggle="tab" href="#menu7"><b>Edit Account</b></a></li>
	  </ul>
	  <div class="tab-content">
	  	<!-- ===================== Home Menu Start ========================== -->
	    <div id="home" class="tab-pane fade in active">
	      <h3>HOME</h3>
	      <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</p>
	    </div>
	    <!-- ===================== Home Menu End ============================ -->
	    <!-- ===================== Walll Start ========================== -->
	    <div id="menu1" class="tab-pane fade" ng-controller="mycontroller_Wall">
	      <h3>Wall</h3>
	      <p>{{$scope.name}}</p>
	      <div style="height:900px;overflow:auto">
	      <div ng-repeat="x in mylist">
	      	<h4>{{x.name}}</h4>
	      	<a data-toggle="collapse" data-target="#post{{x.postid}}image" style="text-decoration:none"><b>Images</b></a>
	      	<div class="collapse" id="post{{x.postid}}image">
	      	<div class="col-sm-6"><image src="GetPost?image=7&id={{x.postid}}" width="400px" height="300px"/></div>
	      	<div class="col-sm-6"><image src="GetPost?image=8&id={{x.postid}}" width="400px" height="300px"/></div>
	      	</div>
	      	<p>{{x.body}}</p>
	      	<h6>{{x.work}}</h6>
	      	<small>{{x.date}}</small>
	      	<a data-toggle="collapse" data-target="#post{{x.postid}}video" style="text-decoration:none"><b>Video</b></a>
	      	<div class="collapse" id="post{{x.postid}}video">
		      	<video width="500" height="240" controls>
		  		<source src="GetPost?image=9&id={{x.postid}}" type="video/mp4">
				</video> 
			</div>
	      </div>
	      </div>
	    </div>
	    <!-- ===================== Wall End ============================ -->
	    <!-- ===================== Add your news start ====================== -->
	    <div id="menu2" class="tab-pane fade">
	    		<!-- =============== Left Section of Add-News menu Start =============== -->
		      	<div class="col-sm-4">
		      		<h1 style="color:#34495e"><b>Add Your News</b></h1>
		      		<blockquote>
		      		Think before you post a news you can only post one news per day.
		      		</blockquote>
		      	</div>
		      	<!-- =============== Left Section of Add-News menu End ================= -->
		      	<!-- =============== Right Section of Add-News menu Start ============== -->
				<div class="col-sm-8">
				<c:set var="count" value="${CountUserPost.getNumber(id)}" />
				<c:choose>
					<c:when test="${count==0}">
						<div class="addNews_Div">
						<form method="POST" action="UserPost?id=${id}" enctype="multipart/form-data">
							<table class="addNews_Table" cellspacing="10">
								<tr>
									<td style="width:30%"><b style="color:#34495e">Post Name</b></td>
									<td style="width:90%"><input type="text" class="form-control" name="postName"/></td>
								</tr>
								<tr>
									<td><b style="color:#34495e">Post Category</b></td>
									<td>
										<select class="form-control" name="postCategory">
											<c:set var="list" value="${GetCategory.category()}"/>  
											<c:forEach items="${list}" var="element">
												<option value="${element.getCategoryId()}">
												${element.getCategoryName()}
												</option>
											</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<td colspan="2"><b style="color:#34495e">Body</b></td>
								</tr>
								<tr>
									<td colspan="2" style="height:50px" >
										<textarea class="form-control" id="txtBody" name="postBody" rows="20" cols="50" required>
										</textarea>
									</td>
								</tr>
								<tr>
									<td colspan="2"><b style="color:#34495e">About Your Work</b></td>
								</tr>
								<tr>
									<td colspan="2" >
										<textarea class="form-control" id="txtWork" name="postAboutYourWork" rows="5" cols="50" required>
										</textarea>
									</td>
								</tr>
								<tr>
									<td><b style="color:#34495e">First Image</b></td>
									<td style="overflow:hidden"><input type="file" class="btn btn-info" name="postImage1" id="postImage1" style="width:100%" onchange="Image1();" required/></td>
								</tr>
								<tr>
									<td colspan="2"><small id="image11" style="display:none;color:red"><b>Invalid Image Format</b></small><small id="image12" style="display:none;color:red"><b>Size is not suitable</b></small></td>
								</tr>
								<tr>
									<td><b style="color:#34495e">Second Image</b></td>
									<td style="overflow:hidden"><input type="file" class="btn btn-info" name="postImage2" id="postImage2" style="width:100%" onchange="Image2();" required/></td>
								</tr>
								<tr>
									<td colspan="2"><small id="image21" style="display:none;color:red"><b>Invalid Image Format</b></small><small id="image22" style="display:none;color:red"><b>Size is not suitable</b></small></td>
								</tr>
								<tr>
									<td><b style="color:#34495e">Video</b></td>
									<td style="overflow:hidden"><input type="file" class="btn btn-info" name="postVideo1" id="postVideo1" style="width:100%" onchange="Video1();" required/></td>
								</tr>
								<tr>
									<td colspan="2"><small id="image31" style="display:none;color:red"><b>Invalid Video Format</b></small><small id="image32" style="display:none;color:red"><b>Size is not suitable</b></small></td>
								</tr>
								<tr>
									<td colspan="2"><center><input type="submit" name="Post" id="add" class="form-control btn addNews_Button" value="Post" onclick="return checkFiles();" style="width:40%"/></center></td>
								</tr>
							</table>
						</form>
						</div>
					</c:when>
					<c:otherwise>
						<div class="addNews_SecondDiv">
							<h3><b>Sorry you can only post one news per day ...</b></h3>
						</div>
					</c:otherwise>
					</c:choose>
				</div>
				<!-- =============== Right Section of Add-News menu End ============== -->
		</div>
		<!-- ===================== Add your news End ====================== -->
		<!-- ===================== Edit & delete post Start ===================== -->
		<div id="menu3" class="tab-pane fade" ng-controller="mycontroller_GetUserPost">
			<div class="div_EditAndDelete">
			<div class="col-sm-4">
				<table style="width:100%">
					<tr>
						<td style="width:90%">
						 	<select ng-change="setThePost()"  ng-model="my_post_no" class="form-control">
						 		<option selected ng-repeat="x in mylist" value="{{$index}}">{{x.name}}</option>
					 		</select>
					 	</td>
					 	<td style="width:10%">
					 		<input type="button" value="Delete" class="btn btn-danger" ng-click="DeletePost()" ng-disabled="my_secondJson.postid==undefined"/>
					 	</td>
				 	</tr>
			 	</table>
		 	</div>
		 	<!-- ========================= Add And Delete Your Post Working ============================= -->
		 	<div class="col-sm-8 updateNews_Div">
		 	<form method="POST" action="{{url}}" enctype="multipart/form-data">
							<table class="addNews_Table">
								<tr>
									<td style="width:40%"><b style="color:#34495e">Post Name</b></td>
									<td style="width:60%"><input type="text" class="form-control" name="postName" ng-model="my_secondJson.name"/></td>
								</tr>
								<tr>
									<td><b style="color:#34495e">Post Category</b></td>
									<td>
										<select class="form-control" name="postCategory" >
											<c:set var="list" value="${GetCategory.category()}"/>  
											<c:forEach items="${list}" var="element">
												<option value="${element.getCategoryId()}" ng-selected="my_secondJson.categoryId==${element.getCategoryId()}">
												${element.getCategoryName()}
												</option>
											</c:forEach>
										</select>
									</td>
								</tr>
								<tr>
									<td colspan="2"><b style="color:#34495e">Body</b></td>
								</tr>
								<tr>
									<td colspan="2" style="height:50px" >
										<textarea class="form-control" id="txtBody" name="postBody" rows="20" cols="50" ng-model="my_secondJson.body" required>
											
										</textarea>
									</td>
								</tr>
								<tr>
									<td colspan="2"><b style="color:#34495e">About Your Work</b></td>
								</tr>
								<tr>
									<td colspan="2" >
										<textarea class="form-control" id="txtWork" name="postAboutYourWork" rows="5" cols="50" ng-model="my_secondJson.work" required>
										</textarea>
									</td>
								</tr>
								<tr>
									<td><b style="color:#34495e" data-toggle="collapse" data-target="#image1">First Image&nbsp;&nbsp;<small style="color:red">Click to see your previous page</small></b></td>
									<td style="overflow:hidden"><input type="file" class="btn btn-info" name="postImage1" id="postImage1_u" style="width:100%" onchange="Image1_u();" required/></td>
								</tr>
								<tr>
									<td colspan="2"><small id="image11_u" style="display:none;color:red"><b>Invalid Image Format</b></small><small id="image12_u" style="display:none;color:red"><b>Size is not suitable</b></small></td>
								</tr>
								<tr>
									<td><div class="collapse" id="image1"><a><image src="GetPost?image=7&id={{my_secondJson.postid}}" width="400px" height="300px"/></a></div></td>
								</tr>
								<tr>
									<td><b style="color:#34495e" data-toggle="collapse" data-target="#image2">Second Image&nbsp;&nbsp;<small style="color:red">Click to see your previous page</small></b></td>
									<td style="overflow:hidden"><input type="file" class="btn btn-info" name="postImage2" id="postImage2_u" style="width:100%" onchange="Image2_u(this.id);" required/></td>
								</tr>
								<tr>
									<td colspan="2"><small id="image21_u" style="display:none;color:red"><b>Invalid Image Format</b></small><small id="image22_u" style="display:none;color:red"><b>Size is not suitable</b></small></td>
								</tr>
								<tr>
									<td><div class="collapse" id="image2"><a><image src="GetPost?image=8&id={{my_secondJson.postid}}" width="400px" height="300px"/></a></div></td>
								</tr>
								<tr>
									<td data-toggle="collapse" data-target="#video"><b style="color:#34495e">Video&nbsp;&nbsp;<small style="color:red">Click to see your previous page</small></b></td>
									<td style="overflow:hidden"><input type="file" class="btn btn-info" name="postVideo1" id="postVideo1_u" style="width:100%" onchange="Video1_u(this.id);" required/></td>
								</tr>
								<tr>
									<td colspan="2"><small id="image31_u" style="display:none;color:red"><b>Invalid Video Format</b></small><small id="image32_u" style="display:none;color:red"><b>Size is not suitable</b></small></td>
								</tr>
								<tr>
									<td>
										<div class="collapse" id="video">
											<video width="500" height="240" controls ng-src="GetPost?image=9&id={{my_secondJson.postid}}" type="video/mp4">
											</video> 
										</div>
									</td>
								</tr>
								<tr>
									<td colspan="2"><center><input type="submit" name="Post" id="add" class="form-control btn addNews_Button" value="Update Post" onclick="return checkFiles();" style="width:40%"/></center></td>
								</tr>
							</table>
						</form>
					</div>
			</div>
			<!-- =============================================== Working ===================================== -->
	    </div>
		<!-- ===================== Edit & delete post End ======================= -->
		<!-- ===================== Following Section ====================== -->
		 <div id="menu5" class="tab-pane fade" ng-controller="mycontroller_UserFriends">
		 	<div class="col-sm-7">
			 	<div class="following_countDiv">
			 		<center><h5 style="color:#5d6d7e"><b>Your Are Following &nbsp;<b style="color:#c0392b">{{following}}</b>&nbsp; Users</b></h5></center>
			 	</div>
			 	<div style="margin-top:5%;margin-bottom:5%">
			 		<table>
				 		<tr>
				 			<td style="width:10%"><b style="color:#5d6d7e">Enter name</b></td>
					 		<td style="width:60%;padding:1%"><input type="text" name="mytext" ng-change="getMyFriends(id)" ng-model="mytext" class="form-control"/></td>
					 		<td style="width:10%"><input type="button" name="mybutton" ng-click="getMyFriends_Click(id)" value="All" class="form-control btn allUser_Button"/></td>
				 		</tr>
			 		</table>
			 	</div>
			 	<div class="userList_Div">
					<table>
						<tr ng-repeat="x in friendlist ">
							<td style="width:40%;padding:1%"><b style="color:#34495e">{{x.f_name}}</b></td>
							<td style="width:40%;padding:1%"><b style="color:#34495e">{{x.f_email}}</b></td>
							<td style="width:10%;padding:1%"><input type="button" value="Unfollow" ng-click="unfollow(id,x.f_Id);" class="form-control btn unfollow_Button"/></td>
						</tr>
					</table>
		 		</div>
	 		</div>
	    </div>
		<!-- ===================== Following Section End ================== -->
		<!-- ===================== Find & Add Friend ====================== -->
	    <div id="menu4" class="tab-pane fade">
	    	<!-- =============== Follow friends functionality =============== -->
	    	<div ng-controller="mycontroller_SearchFriends" class="col-sm-8">
	    	<div>
	    		<table class="table_UserSearch">
	    			<tr>
	    				<td style="width:20%"><b style="color:#34495e">Enter the name</b></td>
	    				<td style="width:60%"><input type="text" id="mytext" ng-change="getOtherUsers();" ng-model="mypostdata.mytext" class="form-control"/></td>
	    			</tr>
		      	</table>
	      	</div>
	      	<div class="userList_Div">
		      	<p id="message1" style="display:none;color:#c0392b"><b>No such user found...</b></p>
		      	<table>
					<tr ng-repeat="x in mydata">
						<td style="width:40%;padding:1%"><b style="color:#34495e">{{x.name}}</b></td>
						<td style="width:40%;padding:1%"><b style="color:#34495e">{{x.email}}</b></td>
						<td style="width:10%;padding:1%"><center><input type="button" value="Follow" ng-click="add(x.id,x.name);" class="btn follow_Button"/></center></td>
					</tr>
				</table>
			</div>
			</div>
			<!-- ==================== Follow friends instruction =============== -->
			<div class="col-sm-4">
				<h1 style="color:#34495e"><b>Follow your friends</b></h1>
	      		<blockquote>
	      		Follow your friends to chat with them
	      		</blockquote>
			</div>
	    </div>
	    <!-- ==================== Find & Add Friend End ==================== -->
	    <!-- ============================= Message Section Start  =========================== -->
	    <div id="menu6" class="tab-pane fade" ng-controller="mycontroller_Message">
	    	<h3 ng-click="getFriends()">Message Section</h3>
	    	<div class="col-sm-8 message_section">
	    		<div id="messageDiv" class="panel-group">
	    			<div ng-repeat="x in friendlist" class="panel panel-default" style="box-shadow: 3px 3px 3px black;margin-bottom:1%;width:70%">
	    				<div class="panel-heading">
	    				<a style="text-decoration:none" href="#message{{x.f_Id}}id" data-toggle="collapse" data-parent="#messageDiv"  ng-click="setValue(x.f_Id);"><lable style="font-size:20px">{{x.f_name}}</lable></a><br>
	    				</div>
	    				<div id="message{{x.f_Id}}id" class="panel-collapse collapse" ng-mouseover="getMessage()">
	    					<div class="messageBox_div_wrapper">
		    					<div class="messageBox_div">
			    					<table style="width:100%">
			    						<tr ng-repeat="x in mymessage">
			    							<td ng-hide="x.id1!=id" style="width:40%"></td>
			    							<td style="width:40%" ng-hide="x.id1!=id" ><p style="color:#34495e"><b>{{x.text}}</b><br><small>{{x.date}}</small></p></td>
			    							<td style="width:40%" ng-hide="x.id1==id" ><p style="color:#117a65"><b>{{x.text}}</b><br><small>{{x.date}}</small></td>
			    							<td ng-hide="x.id1==id" style="width:40%"></td>
			    						</tr>
			    					</table>
		    					</div>
    							<table style="width:100%;margin:1%">
		    						<tr>
		    							<td style="width:80%"><input type="text" id="message" ng-model="mytext" class="form-control"/></td>
		    							<td style="width:20%"><center><input type="button" ng-click="sendMessage(mytext);" value="send"  class="form-control btn send_Button"/></center></td>
		    						</tr>
		    					</table>
	    					</div>
	    				</div>
	    			</div>
	    		</div>
	    	</div>
	    </div>
	    <!-- ============================= Message Section End    =========================== -->
	    <div id="menu7" class="tab-pane fade">
	      <div ng-controller="myctrl_Update">
      		<h2 class="heading_edityouraccount" data-toggle="collapse" data-target="#updateTable"><b>Edit Your Account</b></h2>
      		<div class="collapse" id="updateTable">
      		<form method="POST" action="SignUp">
				<table class="mytable" id="updateTable">
					<tr>
						<td><b>Name</b></td>
						<td><input type="text" required pattern="[a-zA-Z ]+" title="Invalid Name Format" name="name" class="form-control" value="${userObject.getUserName()}"/></td>
					</tr>
					<tr>
						<td><b>Gender</b></td>
						<td>
							<c:choose>
								<c:when test="${userObject.getUserGender()=='Male'}">
									<input type="radio" name="gender" value="Male" checked="checked"/><b>Male</b>&nbsp;&nbsp;
								</c:when>
								<c:otherwise>
									<input type="radio" name="gender" value="Male" checked="checked"/><b>Male</b>&nbsp;&nbsp;
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${userObject.getUserGender()=='Female'}">
									<input type="radio" name="gender" value="Female" /><b>Female</b>
								</c:when>
								<c:otherwise>
									<input type="radio" name="gender" value="Female" /><b>Female</b>
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<td><b>Email</b></td>
						<td>
							<input type="email" name="email" required ng-keyup="checkEmail();" id="email" class="form-control" value="${userObject.getUserEmail()}" />
							<p ng-show="emailMessage" class="error"><small><b>Email Already Registered</b></small></p>
						</td>
					</tr>
					<tr>
						<td><input type="submit" name="add" value="Update Detail" id="btn_submit" ng-disabled="flag" class="form-control btn btn-success"/></td>
					</tr>
				</table>
			</form>
			</div>
	      </div>
	       <div>
	    	<h2 class="heading_edityouraccount" data-toggle="collapse" data-target="#updatePasswordTable"><b>Edit Your Password</b></h2>
      		<div class="collapse" id="updatePasswordTable">
      		<form method="POST" action="SignUp">
				<table class="mytable" id="updateTable">
					<tr>
						<td><b>Old Password</b></td>
						<td><input type="text" required name="oldPassword" class="form-control" /></td>
					</tr>
					<tr>
						<td><b>New Password</b></td>
						<td><input type="text" required name="newPassword" class="form-control" /></td>
					</tr>
					<tr>
						<td><b>Confirm Password</b></td>
						<td><input type="text" required name="confPassword" class="form-control" /></td>
					</tr>
					<tr>
						<td><input type="submit" name="add" value="Update Detail" id="btn_submit" ng-disabled="flag" class="form-control btn btn-success"/></td>
					</tr>
				</table>
			</form>
      		</div>
	    </div>
	    </div> 
	  </div>
	  </section>
	  <!-- ======================================= Navigation Section End ===================================== -->
	</section>
	<!-- ================================================================= WebPage Main End ================================================================= -->
	<!-- =============================================================== WebPage Footer Start =============================================================== --> 
	<footer style="" class="myfooter">
		<center><h1>Thankyou To Join Us</h1></center>
	</footer>
	<!-- =============================================================== WebPage Footer End ================================================================= -->
</body>
</html>