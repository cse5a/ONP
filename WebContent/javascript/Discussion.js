app.controller("getControl_Discussion",function($scope,$http,$interval){
		$scope.flag=0;
		$http.get("GetDiscussion").then(function(response)
		{
			$scope.my_discussion=response.data.mydiscussion;
			$scope.length=$scope.my_discussion.length;
		},
		function(error)
		{
			
		});
		$scope.nextIndex=function()
		{
			if($scope.flag<($scope.length-1))
			{
				$scope.flag++;
			}
		}
		$scope.previousIndex=function()
		{
			if($scope.flag>0)
			{
				$scope.flag--;
			}
		}
		$scope.insertComment=function(name,email)
		{
			$http.post("PostComment","{\"id\":\""+$scope.my_discussion[$scope.flag].id+"\",\"name\":\""+name+"\",\"email\":\""+email+"\",\"text\":\""+$scope.mycomment+"\"}").then(function(response){
				alert("Hello Working");
				$scope.mycomment=null;
			},
			function(error)
			{
				alert("Hello Error");
			});
		}
		$interval(function(){
			$http.post("GetComments","{\"id\":\""+$scope.my_discussion[$scope.flag].id+"\"}").then(function(response){
				$scope.comments=response.data.mycomments;
			},
			function(error){
				
			});
		},1000);
		
	});
