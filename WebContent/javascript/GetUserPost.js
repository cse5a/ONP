app.controller("mycontroller_GetUserPost",function($scope,$http){
	$scope.myjson={};
	$scope.myjson.id=$scope.id;
	$scope.my_secondJson={};
	$scope.postId={};
	$scope.url="UpdateUserPost?id="+$scope.id+"&postId=";
	$http.post("GetUserPost",$scope.myjson).then(function(response){
		$scope.mylist=response.data.mylist;
	},function(error)
	{
		
	});
	$scope.setThePost=function()
	{
		$scope.my_secondJson.name=$scope.mylist[$scope.my_post_no].name;
		$scope.my_secondJson.body=$scope.mylist[$scope.my_post_no].body;
		$scope.my_secondJson.work=$scope.mylist[$scope.my_post_no].work;
		$scope.my_secondJson.categoryId=$scope.mylist[$scope.my_post_no].categoryId;
		$scope.my_secondJson.postid=$scope.mylist[$scope.my_post_no].postid;
		$scope.url=$scope.url+$scope.mylist[$scope.my_post_no].postid;
	}
	//---------------- Delete The Post -----------------
	$scope.DeletePost=function()
	{
		if(confirm("Are you sure you want to delete this post !"))
		{
			$scope.postId.id=$scope.my_secondJson.postid;
			$http.post("DeleteUserPost",$scope.postId).then(function(reponse){
				$scope.my_secondJson={};
				$scope.postId={};
				$scope.my_post_no="";
				$scope.RecallPost();
			},function(error){
				
			});
		}
		else
		{
			alert("Enter To else Block");
		}
	}
	//----------------- Get The post Recall ----------------------
	$scope.RecallPost=function()
	{
		$http.post("GetUserPost",$scope.myjson).then(function(response){
			$scope.mylist=response.data.mylist;
		},function(error)
		{
			
		});
	}
});