package control;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
public class FriendListClass 
{
	public static List<FriendsDetail> myFriendList(int userId,String mytext)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<FriendsDetail> li=new ArrayList<FriendsDetail>();
		try
		{
			con=Myconnection.getConncetion();
			ps=con.prepareStatement("SELECT * FROM user WHERE userId IN (select userId2 FROM friendlist WHERE userId1=?) AND userName LIKE ?");
			ps.setInt(1,userId);
			mytext=mytext+"%";
			ps.setString(2,mytext);
			rs=ps.executeQuery();
			while(rs.next())
			{
				FriendsDetail obj=new FriendsDetail();
				obj.setUserId(rs.getInt(1));
				obj.setName(rs.getString(2));
				obj.setEmail(rs.getString(4));
				obj.setGender(rs.getString(3));
				li.add(obj);
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
		return li;
	}
}
