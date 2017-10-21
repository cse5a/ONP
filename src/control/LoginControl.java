package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LoginControl")
public class LoginControl extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		try
		{
			Login obj=new Login();
			obj.setEmail(request.getParameter("email"));
			obj.setPassword(request.getParameter("password"));
			int flag=LoginClass.authenticateUser(obj);
			if(flag!=1)
			{
				request.setAttribute("errormessage","Error");
				request.getRequestDispatcher("Login.jsp").forward(request,response);
			}
			else
			{
				request.setAttribute("userId",obj.getUserId());
				request.getRequestDispatcher("UserHomeControl").forward(request,response);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
