package control;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class GetCategory 
{
	public static List<Category> category()
	{
		
		List<Category> objList = null;
		ResultSet rs=null;
		Connection con=null;
		try
		{
			con=Myconnection.getConncetion();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM category");
			rs=ps.executeQuery();
			objList=new ArrayList<Category>();
			while(rs.next())
			{
				Category obj=new Category();
				obj.setCategoryId(rs.getInt(1));
				obj.setCategoryName(rs.getString(2));
				objList.add(obj);
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
		return objList; 
	}
}
