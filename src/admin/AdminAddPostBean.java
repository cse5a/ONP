package admin;
import java.io.InputStream;
public class AdminAddPostBean 
{
	int postId,adminId,categoryId;
	String name=null,body=null,work=null,date=null;
	InputStream image1=null,image2=null,video1=null;
	public int getCategoryId() 
	{
		return categoryId;
	}
	public void setCategoryId(int categoryId) 
	{
		this.categoryId = categoryId;
	}
	public InputStream getImage1() {
		return image1;
	}
	public void setImage1(InputStream image1) 
	{
		this.image1 = image1;
	}
	public InputStream getImage2() 
	{
		return image2;
	}
	public void setImage2(InputStream image2) 
	{
		this.image2 = image2;
	}
	public InputStream getVideo1() 
	{
		return video1;
	}
	public void setVideo1(InputStream video1) 
	{
		this.video1 = video1;
	}
	public int getPostId() 
	{
		return postId;
	}
	public void setPostId(int postId) 
	{
		this.postId = postId;
	}
	public int getAdminId() 
	{
		return adminId;
	}
	public void setAdminId(int adminId) 
	{
		this.adminId = adminId;
	}
	public String getName() 
	{
		return name;
	}
	public void setName(String name) 
	{
		this.name = name;
	}
	public String getBody() 
	{
		return body;
	}
	public void setBody(String body) 
	{
		this.body = body;
	}
	public String getWork() 
	{
		return work;
	}
	public void setWork(String work) 
	{
		this.work = work;
	}
	public String getDate() 
	{
		return date;
	}
	public void setDate(String date) 
	{
		this.date = date;
	}
}
