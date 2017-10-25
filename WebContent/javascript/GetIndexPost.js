app.controller("GET_INDEX_POST",function($http,$scope){
	$scope.tablename="";
	$scope.getNews=function(id)
	{
		$scope.sendData={};
		$scope.sendData.id=id;
		$http.post("GET_HOME_POST",$scope.sendData).then(function(response){
			$scope.mylist=response.data.my_post_data;
		},function(error){
			
		});
	}
});