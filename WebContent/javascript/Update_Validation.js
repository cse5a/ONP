app.controller("myctrl_Update",function($scope,$http)
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
});