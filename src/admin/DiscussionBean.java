package admin;

public class DiscussionBean 
{
	String topic=null,description=null,date=null;
	int adminId=0,categoryId=0,id=0;
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	public String getTopic() 
	{
		return topic;
	}
	public void setTopic(String topic)
	{
		this.topic = topic;
	}
	public String getDescription() 
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getDate() 
	{
		return date;
	}
	public void setDate(String date)
	{
		this.date = date;
	}
	public int getAdminId()
	{
		return adminId;
	}
	public void setAdminId(int adminId) 
	{
		this.adminId = adminId;
	}
	public int getCategoryId() 
	{
		return categoryId;
	}
	public void setCategoryId(int categoryId) 
	{
		this.categoryId = categoryId;
	}

}
