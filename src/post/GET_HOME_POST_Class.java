package post;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.Myconnection;
import java.util.List;
import java.util.ArrayList;
public class GET_HOME_POST_Class
{
	protected static List<POST_BEAN> GET_POST(int categoryId)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rst=null;
		List<POST_BEAN> mylist=new ArrayList<POST_BEAN>();
		try
		{
			con=Myconnection.getConncetion();
			String sql="SELECT admin_postId AS POSTID,"
					+ "admin_postName AS POSTNAME,"
					+ "admin_postcategoryId AS CATEGORY,"
					+ "admin_postBody AS BODY,"
					+ "admin_postWork AS WORK,"
					+ "adminId AS AUTHOR,"
					+ "admin_postPublishDate AS PUBLISHDATE,"
					+ "\"adminpost\" AS USER "
					+ "FROM adminpost "
					+ "WHERE admin_postcategoryId=? "
					+ "UNION "
					+ "SELECT postId AS POSTID,"
					+ "postName AS POSTNAME,"
					+ "categoryId AS CATEGORY,"
					+ "postBody AS BODY,"
					+ "postWork AS WORK,"
					+ "userId AS AUTHOR,"
					+ "date AS PUBLISHDATE,\"userpost\" AS USER "
					+ "FROM userpost WHERE categoryId=? "
					+ "ORDER BY PUBLISHDATE "
					+ "LIMIT 25";
			ps=con.prepareStatement(sql);
			ps.setInt(1,categoryId);
			ps.setInt(2,categoryId);
			rst=ps.executeQuery();
			while(rst.next())
			{
				POST_BEAN obj=new POST_BEAN();
				obj.setName(rst.getString("POSTNAME"));
				obj.setBody(rst.getString("BODY"));
				obj.setWork(rst.getString("WORK"));
				obj.setPostId(rst.getInt("POSTID"));
				obj.setPostUser(rst.getString("USER"));
				mylist.add(obj);
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
				
			}
		}
		return mylist;
	}
}
