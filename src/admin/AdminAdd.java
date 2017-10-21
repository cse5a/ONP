package admin;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import connection.Myconnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AdminAdd")
public class AdminAdd extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String name=request.getParameter("name");
		String gender=request.getParameter("gender");
		String dob=request.getParameter("dob");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		String address=request.getParameter("address");
		String contactno=request.getParameter("number");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		AdminAdd ob=new AdminAdd();
		int result=ob.CreateAdmin(name, gender, dob, city, state, country, address, contactno, email, password);
		if(result>0)
		{
			response.sendRedirect("adminLogin.jsp");
		}
		else
		{
			PrintWriter pw=response.getWriter();
			pw.println("Something went wrong...");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	public int CreateAdmin(String name,String gender,String dob,String city,String state,String country,String address,String contactno,String email,String password)
	{
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		try
		{
			con=Myconnection.getConncetion();
			String sql="INSERT INTO admin VALUES(null,?,?,?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(sql);
			ps.setString(1,name);
			ps.setString(2,gender);
			ps.setString(3,dob);
			ps.setString(4,city);
			ps.setString(5,state);
			ps.setString(6,country);
			ps.setString(7,address);
			ps.setString(8,contactno);
			ps.setString(9,email);
			ps.setString(10,password);
			result=ps.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println("Having Problem");
			return 0;
		}
		finally
		{
			
		}
		return result;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
