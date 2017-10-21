package admin;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@WebServlet("/AdminAddPost")
@MultipartConfig
public class AdminAddPost extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter pw=response.getWriter();
		pw.println("Please Wait ....");
		AdminAddPostBean apb_obj=new AdminAddPostBean();
		AdminAddPost ap_obj=new AdminAddPost();
		AdminAddPostClass apc_obj=new AdminAddPostClass();
		HttpSession session=request.getSession();
		AdminBean obj=(AdminBean)session.getAttribute("adminObject");
		System.out.println(obj.getId());
		apb_obj.setAdminId(obj.getId());
		apb_obj.setName(request.getParameter("name"));
		apb_obj.setCategoryId(Integer.parseInt(request.getParameter("category")));
		apb_obj.setBody(request.getParameter("body"));
		apb_obj.setWork(request.getParameter("work"));
		apb_obj.setImage1(ap_obj.myInputStream(request.getPart("image1")));
		apb_obj.setImage2(ap_obj.myInputStream(request.getPart("image2")));
		apb_obj.setVideo1(ap_obj.myInputStream(request.getPart("video1")));
		apb_obj.setDate(request.getParameter("date"));
		int result=apc_obj.InsertPost(apb_obj);
		if(result>0)
		{
			pw.println("Data Saved");
		}
	}
	protected InputStream myInputStream(Part content)
	{
		InputStream mystream=null;
		try
		{
			if(content!=null)
			{
				mystream=content.getInputStream();
				return mystream;
			}
			else
			{
				System.out.println("Error : "+content);
				return null;
			}
		}
		catch(IOException e)
		{
			System.out.println("Error : "+e);
			return null;
			
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
