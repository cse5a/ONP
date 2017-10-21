package control;

public class FriendsDetail 
{
	private int id=0;
	private int userId=0;
	private String name=null;
	private String gender=null;
	private String email=null;
	private String date=null;
	public String getDate() 
	{
		return date;
	}
	public void setDate(String date) 
	{
		this.date = date;
	}
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public int getUserId() 
	{
		return userId;
	}
	public void setUserId(int userId) 
	{
		this.userId = userId;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
}
