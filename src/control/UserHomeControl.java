package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/UserHomeControl")
public class UserHomeControl extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int userId=Integer.parseInt(request.getAttribute("userId").toString());
		List<User> li=new ArrayList<User>();
		li=UserHomeClass.getUserDetail(userId);
		if(li!=null)
		{
			request.setAttribute("userDetail",li);
			HttpSession session=request.getSession();
			session.setAttribute("userId",li.get(0).getUserId());
			session.setAttribute("userName",li.get(0).getName());
			session.setAttribute("userEmail",li.get(0).getEmail());
			request.getRequestDispatcher("UserHome.jsp").forward(request,response);
		}
		else
		{
			request.setAttribute("errormessage","Something Went Wrong !");
			request.getRequestDispatcher("Login.jsp").forward(request,response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
