var app=angular.module("myapp",[]);
app.controller("myctrl",function($scope,$http)
{
	$scope.emailMessage=false;
	$scope.passwordMessage=false;
	$flag=false;
	$scope.checkEmail=function()
	{
		var email=document.getElementById("email").value;
		$http.post("getEmail",'{"email":"'+email+'"}').then(function(response)
		{
			if(response.data.valid=="true")
			{
				$scope.emailMessage=true;
				if($scope.passwordMessage || $scope.emailMessage)
				{
					$scope.flag=true;
				}
			}
			else
			{
				$scope.emailMessage=false;
				if(!$scope.passwordMessage && !$scope.emailMessage)
				{
					$scope.flag=false;
				}
			}
		},
		function(error)
		{
			
		});
	}
	$scope.confirmPassword=function()
	{
		var password=document.getElementById("password").value;
		var confpassword=document.getElementById("confpassword").value;
		if(password!=confpassword)
		{
			$scope.passwordMessage=true;
			if($scope.emailMessage || $scope.passwordMessage)
			{
				$scope.flag=true
			}
		}
		else
		{
			$scope.passwordMessage=false;
			if(!$scope.passwordMessage && !$scope.emailMessage)
			{
				$scope.flag=false;
			}
		}
	}
});