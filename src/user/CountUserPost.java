package user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.Myconnection;
public class CountUserPost 
{
	public static int getNumber(int id)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rst=null;
		int count=0;
		try
		{
			con=Myconnection.getConncetion();
			String sql="SELECT COUNT(*) AS number FROM userpost WHERE date=CURDATE() AND userId=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,id);
			rst=ps.executeQuery();
			while(rst.next())
			{
				count=rst.getInt("number");
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
		return count;
	}
}
