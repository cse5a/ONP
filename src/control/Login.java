package control;
public class Login 
{
	protected String email=null,password=null;
	protected int userId=0;
	protected int getUserId() 
	{
		return userId;
	}

	protected void setUserId(int userId) {
		this.userId = userId;
	}

	protected String getEmail() 
	{
		return email;
	}

	protected void setEmail(String email) 
	{
		this.email = email;
	}

	protected String getPassword() 
	{
		return password;
	}

	protected void setPassword(String password) 
	{
		this.password = password;
	}
	
}
