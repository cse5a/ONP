//------------------------------------------------- My controller for find & follow other user ---------------------------------------------
app.controller("mycontroller_SearchFriends",function($scope,$http)
{
		//----------- JSON Data ------------
		$scope.mypostdata={};
		$scope.addFriend={};
		//----------------------------------
		//------------------------------------------ Function to get user ------------------------------------
		$scope.getOtherUsers=function()
		{
			$scope.mypostdata.id=$scope.id
			if($scope.mypostdata.mytext!="")
			{
				//------------------------------- Post data to control-package->SearchFriends.java -------------------------------
				$http.post("SearchFriends",$scope.mypostdata).then(function(response)
				{
					$scope.mydata=response.data.myrecords;
					//-------------------------- If the records are empty ----------------------
					if(response.data.myrecords[0]==null)
					{
						document.getElementById("message1").style.display="block";
					}
					//-------------------------- If else hide the message  ---------------------
					else
					{
						document.getElementById("message1").style.display="none";
					}
				},
				function(error)
				{
					alert("Sorry Something Went Wrong Please Logout And Login ...");
				});
			}
		}
		//------------------------------------------------------------------------------
		//----------------------------- Function to follow user ------------------------
		$scope.add=function(fid,name)
		{
			$scope.addFriend.userId1=$scope.id;
			$scope.addFriend.userId2=fid;
			//------------------------------- Post data to dob-package->AddFriends.java -------------------------------
			$http.post("AddFriends",$scope.addFriend).then(function(response)
			{
				if(response.data.flag==1)
				{
					alert("You are now following "+name+" !");
					$scope.getOtherUsers();
				}
				else
				{
					alert("Sorry Something Went Wrong !");
				}
			},
			function(error)
			{
				alert("Sorry Something Went Wrong Please Logout And Login ...");
			});
		}
		//--------------------------------------------------------------------------------------------------------------
});
//------------------------------------------------------------------ End -------------------------------------------------------