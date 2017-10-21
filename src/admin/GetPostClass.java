package admin;
import connection.Myconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class GetPostClass 
{
	public List<AdminAddPostBean> getPost(String sql)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rst=null;
		List<AdminAddPostBean> mylist=null;
		try
		{
			con=Myconnection.getConncetion();
			//query="SELECT admin_postId,adminId,admin_postName,admin_postBody,admin_postWork,admin_postPublishDate,admin_postcategoryId FROM adminPost WHERE admin_postcategoryId=4 AND admin_postPublishDate=CURDATE()";
			ps=con.prepareStatement(sql);
			rst=ps.executeQuery();
			mylist=new ArrayList<AdminAddPostBean>();
			while(rst.next())
			{
				AdminAddPostBean obj=new AdminAddPostBean();
				obj.setPostId(rst.getInt(1));
				obj.setAdminId(rst.getInt(2));
				obj.setName(rst.getString(3));
				obj.setBody(rst.getString(4));
				obj.setWork(rst.getString(5));
				obj.setDate(rst.getString(6));
				obj.setCategoryId(rst.getInt(7));
				mylist.add(obj);
			}
		}
		catch(SQLException e)
		{
			System.out.println("My Error"+e);
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
				System.out.println("My Error"+e);
			}
		}
		return mylist;
	}
}
