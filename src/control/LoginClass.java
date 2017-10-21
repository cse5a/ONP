package control;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class LoginClass 
{
	public static int authenticateUser(Login obj)
	{
		ResultSet rst=null;
		Connection con=null;
		try
		{
			con=Myconnection.getConncetion();
			Statement stmt=con.createStatement();
			rst=stmt.executeQuery("SELECT * FROM user");
			while(rst.next())
			{
				if(rst.getString(4).equals(obj.getEmail()) && rst.getString(5).equals(obj.getPassword()))
				{
					obj.setUserId(rst.getInt(1));
					return 1;
				}
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
				if(rst!=null)
				{
					rst.close();
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
		return 0;
	}
}
