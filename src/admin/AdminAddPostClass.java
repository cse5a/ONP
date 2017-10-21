package admin;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import connection.Myconnection;
public class AdminAddPostClass 
{
	public int InsertPost(AdminAddPostBean obj)
	{
		int result=0;
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=Myconnection.getConncetion();
			String sql="INSERT INTO adminpost VALUES(null,?,?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setInt(1,obj.getAdminId());
			ps.setString(2,obj.getName());
			ps.setInt(3,obj.getCategoryId());
			ps.setString(4,obj.getBody());
			ps.setString(5,obj.getWork());
			ps.setBlob(6,obj.getImage1());
			ps.setBlob(7,obj.getImage2());
			ps.setBlob(8,obj.getVideo1());
			ps.setString(9,obj.getDate());
			result=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("My Error : "+e);
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
		return result;
	}
}
