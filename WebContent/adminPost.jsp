<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="MaterialDesign/material.min.js"></script>
<link href="MaterialDesign/material.indigo-pink.min.css" rel="stylesheet" />
<link href="MaterialDesign/icon.css" rel="stylesheet" />
<script src="javascript/jquery-3.2.1.min.js"></script>
<link rel="stylesheet" href="stylesheet/jquery-ui.css">
<script src="javascript/jquery-ui.js"></script>
<script src="javascript/addNews.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@ page import="control.GetCategory" %>
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Insert title here</title>
<script>
	$(function() 
			{
			    $( ".mydate" ).datepicker({ 
			    	dateFormat: 'yy-mm-dd',
			        changeYear: true,
			        changeMonth: true,
			        yearRange: '2016:'+'2200:'
			    	}); 
			});
</script>
</head>
<body>
	<center>
		<div class="mdl-card mdl-shadow--2dp" style="width:50%">
		<form action="AdminAddPost" method="POST" enctype="multipart/form-data">
			<table>
				<tr>
					<td>Post Name</td>
					<td><input type="text" name="name"/></td>
				</tr>
				<tr>
					<td>Post Category</td>
					<td>
						<select name="category">
							<c:set var="list" value="${GetCategory.category()}" />
							<c:forEach items="${list}" var="element">
							<option value="${element.getCategoryId()}">${element.getCategoryName()}</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td>Post Body</td>
					<td>
						<textarea name="body">
						</textarea>
					</td>
				</tr>
				<tr>
					<td>Post Work</td>
					<td>
						<textarea name="work">
						</textarea>
					</td>
				</tr>
				<tr>
					<td>Primary Image</td>
					<td><input type="file" name="image1" onchange="Image1();" id="postImage1" required/></td>
				</tr>
				<tr>
					<td colspan="2"><small id="image11" style="display:none"><b>Invalid Image Format</b></small><small id="image12" style="display:none"><b>Size is not suitable</b></small></td>
				</tr>
				<tr>
					<td>Secondary Image</td>
					<td><input type="file" name="image2" onchange="Image2();" id="postImage2" required/></td>
				</tr>
				<tr>
					<td colspan="2"><small id="image21" style="display:none"><b>Invalid Image Format</b></small><small id="image22" style="display:none"><b>Size is not suitable</b></small></td>
				</tr>
				<tr>
					<td>Video</td>
					<td><input type="file" name="video1" onchange="Video1();" id="postVideo1" required/></td>
				</tr>
				<tr>
					<td colspan="2"><small id="image31" style="display:none"><b>Invalid Video Format</b></small><small id="image32" style="display:none"><b>Size is not suitable</b></small></td>
				</tr>
				<tr>
					<td>Date To Publish</td>
					<td><input type="date" name="date" class="mydate"/></td>
				</tr>
				<tr>
					<td><input type="submit" name="Post" id="add"  value="Post" onclick="return checkFiles();"/></td>
				</tr>
			</table>
		</form>
		</div>
	</center>
</body>
</html>