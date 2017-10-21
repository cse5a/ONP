<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add News</title>
<link  href="bootstrap\css\bootstrap.css" rel="stylesheet"/>
<link  href="stylesheet\addNews.css" rel="stylesheet"/>
<script src="bootstrap\js\bootstrap.min.js"></script>
<script src="javascript\jquery-3.2.1.min.js"></script>
<script src="javascript\addNews.js"></script>
<%@ page import="control.GetCategory" %>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
</head>
<body>
	<div>
	<center>
	<div class="post">
		<form method="POST" action="UserPost" enctype="multipart/form-data" class="form-group myform">
			<table class="table">
				<tr>
					<td colspan="2">
						<h1><b>Add Your News</b></h1>
					</td>
				</tr>
				<tr>
					<td style="width:30%"><b>Post Name</b></td>
					<td style="width:70%"><input type="text" class="form-control" name="postName"/></td>
				</tr>
				<tr>
					<td><b>Post Category</b></td>
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
					<td colspan="2"><b>Body</b></td>
				</tr>
				<tr>
					<td colspan="2" >
						<textarea class="form-control" id="txtBody" name="postBody">
						</textarea>
					</td>
				</tr>
				<tr>
					<td colspan="2"><b>About Your Work</b></td>
				</tr>
				<tr>
					<td colspan="2" >
						<textarea class="form-control" name="postAboutYourWork">
						</textarea>
					</td>
				</tr>
				<tr>
					<td><b>First Image</b></td>
					<td style="overflow:hidden"><input type="file" class="btn btn-info" name="postImage1" id="postImage1" style="width:100%" onchange="Image1();" required/></td>
				</tr>
				<tr>
					<td colspan="2"><small id="image11" style="display:none"><b>Invalid Image Format</b></small><small id="image12" style="display:none"><b>Size is not suitable</b></small></td>
				</tr>
				<tr>
					<td><b>Second Image</b></td>
					<td style="overflow:hidden"><input type="file" class="btn btn-info" name="postImage2" id="postImage2" style="width:100%" onchange="Image2();" required/></td>
				</tr>
				<tr>
					<td colspan="2"><small id="image21" style="display:none"><b>Invalid Image Format</b></small><small id="image22" style="display:none"><b>Size is not suitable</b></small></td>
				</tr>
				<tr>
					<td><b>Video</b></td>
					<td style="overflow:hidden"><input type="file" class="btn btn-info" name="postVideo1" id="postVideo1" style="width:100%" onchange="Video1();" required/></td>
				</tr>
				<tr>
					<td colspan="2"><small id="image31" style="display:none"><b>Invalid Video Format</b></small><small id="image32" style="display:none"><b>Size is not suitable</b></small></td>
				</tr>
				<tr>
					<td><input type="submit" name="Post" id="add" class="form-control btn login" value="Post" onclick="return checkFiles();"/></td>
				</tr>
			</table>
		</form>
	</div>
	</center>
	</div>
</body>
</html>