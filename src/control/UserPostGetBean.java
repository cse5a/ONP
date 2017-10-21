package control;

public class UserPostGetBean 
{
	public int postId,categoryId;
	public String name=null,body=null,postwork=null;
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getPostwork() {
		return postwork;
	}
	public void setPostwork(String postwork) {
		this.postwork = postwork;
	}
	
}
