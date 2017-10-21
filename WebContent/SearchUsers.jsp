<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="javascript/angular.min.js"></script>
<script src="javascript/myModule.js"></script>
<script src="javascript/SearchFriends.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body ng-app="myapp">
	<div  ng-controller="mycontroller_SearchFriends">
		      <input type="text" id="mytext" ng-change="getOtherUsers();" ng-model="mypostdata.mytext"/>
		      <table class="table">
				<tr ng-repeat="x in mydata">
					<td>{{x.name}}</td>
					<td>{{x.email}}</td>
					<td><center><input type="button" value="AddFriend" ng-click="add(x.id);" class="btn btn-primary"/></center></td>
				</tr>
			</table>
		     </div>
</body>
</html>