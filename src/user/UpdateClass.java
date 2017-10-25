package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import control.Myconnection;
public class UpdateClass 
{
	public int Post(Post obj)
	{
		Connection con=null;
		int flag=0;
		con=Myconnection.getConncetion();
		try 
		{
			PreparedStatement ps=con.prepareStatement("UPDATE userpost SET userId=?,postName=?,categoryId=?,postBody=?,postWork=?,image1=?,image2=?,video=? WHERE postId=?");
			ps.setInt(1,obj.getUserId());
			ps.setString(2,obj.getName());
			ps.setInt(3,obj.getCategory());
			ps.setString(4,obj.getBody());
			ps.setString(5,obj.getAboutWork());
			ps.setBlob(6,obj.getImage1());
			ps.setBlob(7,obj.getImage2());
			ps.setBlob(8,obj.getVideo1());
			ps.setInt(9,obj.getPostId());
			flag=ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			System.out.println("Something Went Wrong"+e);
		}
		return flag;
	}
}
