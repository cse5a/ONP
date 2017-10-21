package admin;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import connection.Myconnection;
@WebServlet("/AddDiscussion")
public class AddDiscussion extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		AddDiscussion ob=new AddDiscussion();
		PrintWriter pw=response.getWriter();
		pw.println("Please wait a minute ....");
		String topic=request.getParameter("topic");
		String description=request.getParameter("description");
		int category=Integer.parseInt(request.getParameter("category"));
		String date=request.getParameter("year")+"-"+request.getParameter("month")+"-"+request.getParameter("day");
		int adminId=Integer.parseInt(request.getParameter("adminId"));
		if(ob.saveData(topic, description, category, date, adminId)!=0)
		{
			response.sendRedirect("addDiscussion.jsp?flag=1");
		}
		else
		{
			response.sendRedirect("addDiscussion.jsp?flag=0");
		}
	}
	public int saveData(String topic,String description,int category,String date,int adminId)
	{
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		try
		{
			con=Myconnection.getConncetion();
			String sql="INSERT INTO discussion VALUES(null,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1,topic);
			ps.setString(2,description);
			ps.setInt(3,category);
			ps.setDate(4,java.sql.Date.valueOf(date));
			ps.setInt(5,adminId);
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
