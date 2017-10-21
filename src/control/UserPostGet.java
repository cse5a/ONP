package control;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
public class UserPostGet 
{
	public static List<UserPostGetBean> getmypost(int userId)
	{
		Connection con=null;
		ResultSet rst=null;
		PreparedStatement ps=null;
		List<UserPostGetBean> list=new ArrayList<UserPostGetBean>();
		con=Myconnection.getConncetion();
		try
		{
			String query="SELECT postId,postName,categoryId,postBody,postWork userpost FROM userpost WHERE userid=?";
			ps=con.prepareStatement(query);
			ps.setInt(1,userId);
			rst=ps.executeQuery();
			while(rst.next())
			{
				UserPostGetBean obj=new UserPostGetBean();
				obj.setPostId(Integer.parseInt(rst.getString(1)));
				obj.setName(rst.getString(2));
				obj.setCategoryId(Integer.parseInt(rst.getString(3)));
				obj.setBody(rst.getString(4));
				obj.setPostwork(rst.getString(5));
				list.add(obj);
			}
		}
		catch(SQLException e)
		{
			
		}
		return list;
	}
}
