package admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connection.Myconnection;

public class AdminUpdatePostClass
{
	public int UpdatePost(AdminAddPostBean obj)
	{
		int result=0;
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=Myconnection.getConncetion();
			String sql="UPDATE adminpost SET admin_postName=?,admin_postcategoryId=?,admin_postBody=?,admin_postWork=?,admin_postPublishDate=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,obj.getName());
			ps.setInt(2,obj.getCategoryId());
			ps.setString(3,obj.getBody());
			ps.setString(4,obj.getWork());
			ps.setString(5,obj.getDate());
			if(obj.getImage1()!=null)
			{
				sql=sql+",admin_postImagePrimary="+obj.getImage1()+"";
			}
			if(obj.getImage2()!=null)
			{
				sql=",admin_postImageSecondary="+obj.getImage2()+"";
			}
			if(obj.getVideo1()!=null)
			{
				sql=",admin_postVideo="+obj.getVideo1()+"";
			}
			sql=sql+" WHERE admin_postId="+obj.getPostId();
			result=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("My Error : "+e);
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
				e.printStackTrace();
			}
		}
		return result;
	}
}
