package user;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import connection.Myconnection;
import java.sql.Connection;
@WebServlet("/UserLoginController")
public class UserLoginController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			String email=request.getParameter("email");
			String password=request.getParameter("password");
			UserLoginController ulc_obj=new UserLoginController();
			if(ulc_obj.userLogin(email, password).getUserId()!=0)
			{
				Cookie ck1=new Cookie("DEMOCRATIC_User_id",ulc_obj.userLogin(email, password).getUserId()+"");
				response.addCookie(ck1);
				response.sendRedirect("UserDashboard.jsp");
			}
			else
			{
				request.setAttribute("errormessage","Error");
				request.getRequestDispatcher("Login.jsp").forward(request,response);
			}
	}
	protected UserBean userLogin(String email,String password)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rst=null;
		UserBean ub_obj=new UserBean();
		String sql="SELECT * FROM user WHERE userEmail=? AND userPassword=?";
		try
		{
			con=Myconnection.getConncetion();
			ps=con.prepareStatement(sql);
			ps.setString(1,email);
			ps.setString(2,password);
			rst=ps.executeQuery();
			while(rst.next())
			{
				ub_obj.setUserId(rst.getInt("userId"));
			}
			con.close();
			ps.close();
			rst.close();
			return ub_obj;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
