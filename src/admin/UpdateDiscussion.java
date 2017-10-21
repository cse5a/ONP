package admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import connection.Myconnection;
@WebServlet("/UpdateDiscussion")
public class UpdateDiscussion extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		//------ Object Creation ------------------
		UpdateDiscussion ob=new UpdateDiscussion();
		PrintWriter pw=response.getWriter();
		pw.println("Please wait a minute ....");
		//---------------------------------- Fetch The Parameter --------------------------------------------------
		String topic=request.getParameter("topic");
		String description=request.getParameter("description");
		int category=Integer.parseInt(request.getParameter("category"));
		String date=request.getParameter("year")+"-"+request.getParameter("month")+"-"+request.getParameter("day");
		int id=Integer.parseInt(request.getParameter("id"));
		//----------------------------------------------------------------------------------------------------------
		if(ob.UpdateData(topic, description, category, date, id)!=0)
		{
			response.sendRedirect("adminAllDiscussion.jsp");
		}
		else
		{
			response.sendRedirect("adminAllDiscussion.jsp");
		}
	}
	
	//----------------------------------------- Function to update Discussion ----------------------------------------------------------
	public int UpdateData(String topic,String description,int category,String date,int id)
	{
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		try
		{
			con=Myconnection.getConncetion();
			String sql="UPDATE discussion SET discussionTopic=?,discussionDescription=?,discussionCategory=?,discussionDate=? WHERE discussionId=?";
			ps=con.prepareStatement(sql);
			ps.setString(1,topic);
			ps.setString(2,description);
			ps.setInt(3,category);
			ps.setDate(4,java.sql.Date.valueOf(date));
			ps.setInt(5,id);
			result=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Mysql Error" +e);
			return 0;
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
				return 0;
			}
		}
		return result;
	}
	//------------------------------------------------------------------------------------------------------------------------------------------
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
