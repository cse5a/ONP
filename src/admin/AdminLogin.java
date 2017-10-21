package admin;
import connection.Myconnection;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		AdminLogin ob= new AdminLogin();
		ResultSet rst=ob.Login(email, password);
		try
		{
			if(rst.next())
			{
				AdminBean obj= new AdminBean();
				obj.setId(rst.getInt(1));
				obj.setName(rst.getString(2));
				obj.setGender(rst.getString(3));
				obj.setDob(rst.getString(4));
				obj.setCity(rst.getString(5));
				obj.setState(rst.getString(6));
				obj.setCountry(rst.getString(7));
				obj.setAddress(rst.getString(8));
				obj.setContactno(rst.getString(9));
				obj.setEmail(rst.getString(10));
				HttpSession session=request.getSession();
				session.setAttribute("adminObject",obj);
				request.getRequestDispatcher("adminDashboard.jsp").forward(request,response);
			}
			else
			{
				request.setAttribute("message","Invalid email or password");
				request.getRequestDispatcher("adminLogin.jsp").forward(request,response);
			}
		}
		catch(SQLException e)
		{
			
		}
		
	}
	public ResultSet Login(String email,String password)
	{
		String sql="SELECT * FROM admin WHERE adminEmail=? AND adminPassword=?";
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rst=null;
		try
		{
			con=Myconnection.getConncetion();
			ps=con.prepareStatement(sql);
			ps.setString(1,email);
			ps.setString(2,password);
			rst=ps.executeQuery();
		}
		catch(SQLException e)
		{
			
		}
		return rst;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
