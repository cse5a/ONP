app.controller("mycontroller_Wall",function($scope,$http,$interval){
	$scope.myjson={};
	$scope.myjson.id=$scope.id;
	$http.post("GetUserWall",$scope.myjson).then(function(response){
		$scope.mylist=response.data.mylist;
	},function(error)
	{
		
	});
});