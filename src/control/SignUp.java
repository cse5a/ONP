package control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import dob.InsertUser;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		User user_ob=new User();
		user_ob.setName(request.getParameter("name"));
		user_ob.setGender(request.getParameter("gender"));
		user_ob.setEmail(request.getParameter("email"));
		user_ob.setPassword(request.getParameter("password"));
		int result=InsertUser.Insert(user_ob);
		if(result>0)
		{
			response.sendRedirect("Login.jsp?status=1");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
