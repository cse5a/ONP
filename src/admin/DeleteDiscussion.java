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

@WebServlet("/DeleteDiscussion")
public class DeleteDiscussion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id=Integer.parseInt(request.getParameter("id"));
		DeleteDiscussion ob=new DeleteDiscussion();
		ob.deletePost(id);
		response.sendRedirect("adminAllDiscussion.jsp");
	}
	public void deletePost(int id)
	{
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=Myconnection.getConncetion();
			String sql="DELETE FROM discussion WHERE discussionId=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
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
				
			}
		}
	}
}
