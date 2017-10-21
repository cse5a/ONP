package user;

public class PostBean
{
	int postId=0,userId,categoryId=0;
	String postName=null,postBody=null,postWork=null,date=null;
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPostId() 
	{
		return postId;
	}
	public void setPostId(int postId)
	{
		this.postId = postId;
	}
	public int getUserId() 
	{
		return userId;
	}
	public void setUserId(int userId) 
	{
		this.userId = userId;
	}
	public int getCategoryId() 
	{
		return categoryId;
	}
	public void setCategoryId(int categoryId)
	{
		this.categoryId = categoryId;
	}
	public String getPostName() 
	{
		return postName;
	}
	public void setPostName(String postName) 
	{
		this.postName = postName;
	}
	public String getPostBody() 
	{
		return postBody;
	}
	public void setPostBody(String postBody) 
	{
		this.postBody = postBody;
	}
	public String getPostWork() 
	{
		return postWork;
	}
	public void setPostWork(String postWork)
	{
		this.postWork = postWork;
	}
	
}
