package admin;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import connection.Myconnection;
@WebServlet("/DeletePost")
public class DeletePost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id=Integer.parseInt(request.getParameter("id"));
		DeletePost obj=new DeletePost();
		int result=obj.deletePost(id);
		if(result>0)
		{
			response.sendRedirect("adminAllPost.jsp");
		}
		else
		{
			response.sendRedirect("adminAllPost.jsp");
		}
	}
	public int deletePost(int id)
	{
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		try
		{
			con=Myconnection.getConncetion();
			String sql="DELETE FROM adminPost WHERE admin_postId=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,id);
			result=ps.executeUpdate();
		}
		catch(SQLException e)
		{
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
