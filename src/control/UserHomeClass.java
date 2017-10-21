package control;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class UserHomeClass 
{
	public static List<User> getUserDetail(int userId)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<User> li=null;
		User obj=new User();
		try
		{
			li=new ArrayList<User>();
			con=Myconnection.getConncetion();
			ps=con.prepareStatement("SELECT * FROM user WHERE userId=?");
			ps.setInt(1,userId);
			rs=ps.executeQuery();
			while(rs.next())
			{
				obj.setUserId(rs.getInt(1));
				obj.setName(rs.getString(2));
				obj.setGender(rs.getString(3));
				obj.setEmail(rs.getString(4));
				li.add(obj);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null)
				{
					rs.close();
				}
				if(ps!=null)
				{
					ps.close();
				}
				if(con!=null)
				{
					con.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
		return li;
	}
}
