package dob;
import control.Myconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class InsertPost 
{
	public int Post(Post obj)
	{
		Connection con=null;
		int flag=0;
		con=Myconnection.getConncetion();
		try 
		{
			PreparedStatement ps=con.prepareStatement("INSERT INTO userpost VALUES(null,?,?,?,?,?,?,?,?,now());");
			ps.setInt(1,obj.getUserId());
			ps.setString(2,obj.getName());
			ps.setInt(3,obj.getCategory());
			ps.setString(4,obj.getBody());
			ps.setString(5,obj.getAboutWork());
			ps.setBlob(6,obj.getImage1());
			ps.setBlob(7,obj.getImage2());
			ps.setBlob(8,obj.getVideo1());
			flag=ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			System.out.println("Something Went Wrong"+e);
		}
		return flag;
	}
}
