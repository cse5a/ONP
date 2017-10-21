app.controller("mycontroller_Message",function($scope,$http,$interval){
	$scope.get_message_request={}
	//---------------- Get UserFriend List -----------------------
	$scope.my_Json={};
	$scope.my_Json.text="";
	$scope.my_secondJson={};
	$scope.my_Json.userid=$scope.id;
	$scope.my_secondJson.userId=$scope.id;
	$scope.mytext="";
	$scope.setValue=function(myid)
	{
		$scope.get_message_request.touserId=myid;
		$scope.my_secondJson.touserId=myid;
		$scope.getMessage();
	}
	$http.post("UserFriendList",$scope.my_Json).then(function(response){
		$scope.friendlist=response.data.myfriendlist;
	},function(error)
	{
		
	});
	//----------- Get Message --------------------
	$scope.getMessage=function()
	{
		$scope.get_message_request.userId=$scope.id;
		$http.post("MessageGet",$scope.get_message_request).then(function(response)
		{
			$scope.mymessage=response.data.myrecords;
		},
		function(error)
		{
			
		});
	}
	//---------- Send Message -------------------
	$scope.sendMessage=function(mytext)
	{
		$scope.my_secondJson.text=mytext;
		document.getElementById("message").value=null;
		$http.post("MessageSend",$scope.my_secondJson).then(function(response)
		{
			$scope.getMessage();
		},
		function(error)
		{
			
		});
	}
	//--------------------------------------
	$scope.getFriends=function()
	{
		$http.post("UserFriendList",$scope.my_Json).then(function(response){
			$scope.friendlist=response.data.myfriendlist;
		},function(error)
		{
			
		});
	}
	/*$interval(function()
	{
		$scope.getMessage();
	},500);*/
});