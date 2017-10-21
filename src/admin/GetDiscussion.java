package admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.Myconnection;
public class GetDiscussion 
{
	public static List<DiscussionBean> getAdminDiscussion(int adminId)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rst=null;
		List<DiscussionBean> mylist=null;
		try
		{
			con=Myconnection.getConncetion();
			String sql="SELECT * FROM discussion WHERE adminId=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,adminId);
			rst=ps.executeQuery();
			mylist=new ArrayList<DiscussionBean>();
			while(rst.next())
			{
				DiscussionBean obj=new DiscussionBean();
				obj.setId(rst.getInt("discussionId"));
				obj.setTopic(rst.getString("discussionTopic"));
				obj.setDescription(rst.getString("discussionDescription"));
				obj.setCategoryId(rst.getInt("discussionCategory"));
				obj.setDate(rst.getString("discussionDate"));
				obj.setAdminId(rst.getInt("adminId"));
				mylist.add(obj);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
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
		return mylist;
	}
	public static DiscussionBean getDiscussion(int id)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rst=null;
		DiscussionBean obj=new DiscussionBean();
		try
		{
			con=Myconnection.getConncetion();
			String sql="SELECT * FROM discussion WHERE discussionId=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,id);
			rst=ps.executeQuery();
			while(rst.next())
			{
				obj.setId(rst.getInt("discussionId"));
				obj.setTopic(rst.getString("discussionTopic"));
				obj.setDescription(rst.getString("discussionDescription"));
				obj.setCategoryId(rst.getInt("discussionCategory"));
				obj.setDate(rst.getString("discussionDate"));
				obj.setAdminId(rst.getInt("adminId"));
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
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
