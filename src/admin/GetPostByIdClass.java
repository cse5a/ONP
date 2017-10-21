package admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.Myconnection;
public class GetPostByIdClass 
{
	public static AdminAddPostBean getPost(int id)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rst=null;
		AdminAddPostBean obj=new AdminAddPostBean();
		try
		{
			con=Myconnection.getConncetion();
			String sql="SELECT * FROM adminPost WHERE admin_postId=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,id);
			rst=ps.executeQuery();
			while(rst.next())
			{
				obj.setAdminId(rst.getInt("adminId"));
				obj.setName(rst.getString("admin_postName"));
				obj.setBody(rst.getString("admin_postBody"));
				obj.setWork(rst.getString("admin_postWork"));
				obj.setCategoryId(rst.getInt("admin_postcategoryId"));
				obj.setDate(rst.getString("admin_postPublishDate"));
				obj.setPostId(rst.getInt("admin_postId"));
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
		return obj;
	}
}
