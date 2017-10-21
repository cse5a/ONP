//----------------------------------------- User Friend Controller -----------------------------
app.controller("mycontroller_UserFriends",function($scope,$http){
	$scope.my_json={};
	$scope.my_secondJson={};
	$scope.my_thirdJson={};
	$scope.my_json.userid=$scope.id;
	$http.post("CountFollowing",$scope.my_json).then(function(response){
		$scope.following=response.data.following;
	},function(error)
	{
		
	});
	$scope.recount=function()
	{
		$http.post("CountFollowing",$scope.my_json).then(function(response){
			$scope.following=response.data.following;
		},function(error)
		{
			
		});
	}
	$scope.getMyFriends_Click=function(id)
	{
		$scope.my_secondJson.text="";
		$scope.my_secondJson.userid=id;
		$http.post("UserFriendList",$scope.my_secondJson).then(function(response){
			$scope.friendlist=response.data.myfriendlist;
			$scope.recount();
		},function(error)
		{
			
		});
	}
	$scope.getMyFriends=function(id)
	{
		$scope.my_secondJson.text=$scope.mytext;
		$scope.my_secondJson.userid=id;
		$http.post("UserFriendList",$scope.my_secondJson).then(function(response){
			$scope.friendlist=response.data.myfriendlist;
			$scope.recount();
		},function(error)
		{
			
		});
	}
	$scope.unfollow=function(userId1,userId2)
	{
		$scope.my_thirdJson.userId1=userId1;
		$scope.my_thirdJson.userId2=userId2;
		$http.post("UserUnfollow",$scope.my_thirdJson).then(function(response){
			$scope.result=response.data.result;
			if($scope.result>0)
			{
				$scope.getMyFriends_Click(userId1);
				$scope.recount();
			}
			else
			{
				alert("Something Went Wrong !");
			}
		},function(error)
		{
			
		});
	}
});