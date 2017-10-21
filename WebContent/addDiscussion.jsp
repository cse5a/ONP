<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="admin.AdminBean" %>
<%@ page import="control.GetCategory" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@  taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<title>Add Discussion</title>
<style>
	table,tr,td
	{
		 border: 2px solid black;
	}
</style>
</head>
<body>
	<center>
	<c:set var="myobject" value="${sessionScope['adminObject']}"></c:set>
	<c:if test="${myobject==null}">
		 <c:redirect url = "adminLogin.jsp"/>
	</c:if>
	<a href="adminDashboard.jsp">Back</a>
	<form method="POST" action="AddDiscussion?adminId=${myobject.getId()}">
		<table cellpadding="10">
			<tr>
				<td>
					Topic
				</td>
				<td>
					Description
				</td>
				<td>
					Category
				</td>
				<td colspan="3">
					Publish
				</td>
				<td>
					Add
				</td>
			</tr>
			<tr>
				<td>
					<textarea required name="topic"></textarea>
				</td>
				<td>
					<textarea required name="description"></textarea>
				</td>
				<td>
					<select name="category" id="category" required>
						<option value="" selected>-- Category --</option>
						<c:set var="list" value="${GetCategory.category()}"/>  
						<c:forEach items="${list}" var="element">
							<option value="${element.getCategoryId()}">
							${element.getCategoryName()}
							</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<select name="day" id="day" required>
						<option value="" selected>-- Day --</option>
						<c:forEach var="i" begin="1" end="31">
							<option value="${i}">${i}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<select name="month" id="month" required>
						<option value="" selected>-- Month --</option>
						<c:forEach var="i" begin="1" end="12">
							<option value="${i}">${i}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<select name="year" id="year" required>
						<option value="" selected>-- Year --</option>
						<c:forEach var="i" begin="2017" end="2100" >
							<option value="${i}">${i}</option>
						</c:forEach>
					</select>
				</td>
				<td>
					<input type="submit" value="Add" onclick="validate();"/>
				</td>
			</tr>
		</table>
	</form>
	</center>
</body>
</html>