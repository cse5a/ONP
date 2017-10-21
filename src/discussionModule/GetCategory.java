package discussionModule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.Myconnection;
public class GetCategory 
{
	public static String getCategory(String id)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rst=null;
		String Categoryname=null;
		try
		{
			con=Myconnection.getConncetion();
			String sql="SELECT * FROM category WHERE categoryId=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,Integer.parseInt(id));
			rst=ps.executeQuery();
			while(rst.next())
			{
				Categoryname=rst.getString("categoryName");
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return Categoryname;
	}
}
