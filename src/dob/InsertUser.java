package dob;
import control.Myconnection;
import control.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class InsertUser
{
	public static int Insert(User obj)
	{
		int i=0;
		Connection con=Myconnection.getConncetion();
		PreparedStatement ps=null;
		try
		{
			ps=con.prepareStatement("INSERT INTO user VALUES(null,?,?,?,?)");
			ps.setString(1,obj.getName());
			ps.setString(2,obj.getGender());
			ps.setString(3,obj.getEmail());
			ps.setString(4,obj.getPassword());
			i=ps.executeUpdate();
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
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
				
			}
		}
		return i;
	}
}
