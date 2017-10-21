package user;

public class UserBean 
{
	public int userId=0;
	public String userName=null,userEmail=null,userPassword=null,userGender=null;
	public String getUserGender() 
	{
		return userGender;
	}
	public void setUserGender(String userGender) 
	{
		this.userGender = userGender;
	}
	public int getUserId() 
	{
		return userId;
	}
	public void setUserId(int userId) 
	{
		this.userId = userId;
	}
	public String getUserName() 
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	public String getUserEmail() 
	{
		return userEmail;
	}
	public void setUserEmail(String userEmail)
	{
		this.userEmail = userEmail;
	}
	public String getUserPassword() 
	{
		return userPassword;
	}
	public void setUserPassword(String userPassword) 
	{
		this.userPassword = userPassword;
	}
	
}
