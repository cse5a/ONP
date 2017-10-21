package dob;
import java.io.InputStream;
public class Post 
{
	String name=null,body=null,aboutWork=null;
	int category,userId;
	InputStream image1=null,image2=null,video1=null;	
	protected int getUserId() 
	{
		return userId;
	}
	protected void setUserId(int userId) 
	{
		this.userId = userId;
	}
	protected String getName() 
	{
		return name;
	}
	protected void setName(String name) 
	{
		this.name = name;
	}
	protected String getBody() 
	{
		return body;
	}
	protected void setBody(String body) 
	{
		this.body = body;
	}
	protected String getAboutWork() 
	{
		return aboutWork;
	}
	protected void setAboutWork(String aboutWork) 
	{
		this.aboutWork = aboutWork;
	}
	protected int getCategory() 
	{
		return category;
	}
	protected void setCategory(int category)
	{
		this.category = category;
	}
	protected InputStream getImage1() 
	{
		return image1;
	}
	protected void setImage1(InputStream image1) 
	{
		this.image1 = image1;
	}
	protected InputStream getImage2() 
	{
		return image2;
	}
	protected void setImage2(InputStream image2) 
	{
		this.image2 = image2;
	}
	protected InputStream getVideo1() 
	{
		return video1;
	}
	protected void setVideo1(InputStream video1) 
	{
		this.video1 = video1;
	}
}
