package user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import connection.Myconnection;
public class UserBasicInfo 
{
	public static UserBean getUserdata(int id)
	{
		UserBean ub_obj=new UserBean();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rst=null;
		try
		{
			con=Myconnection.getConncetion();
			String sql="SELECT * FROM user WHERE userId=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,id);
			rst=ps.executeQuery();
			while(rst.next())
			{
				ub_obj.setUserId(rst.getInt("userId"));
				ub_obj.setUserName(rst.getString("userName"));
				ub_obj.setUserGender(rst.getString("userGender"));
				ub_obj.setUserEmail(rst.getString("userEmail"));
				ub_obj.setUserPassword(rst.getString("userPassword"));
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
		return ub_obj;
	}
}
