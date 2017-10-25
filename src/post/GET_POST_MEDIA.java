package post;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import connection.Myconnection;

@WebServlet("/GET_POST_MEDIA")
public class GET_POST_MEDIA extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		Statement  stmt=null;
		ResultSet rst=null;
		int requestFileId=Integer.parseInt(request.getParameter("requestFileIndex"));
		int requestId=Integer.parseInt(request.getParameter("requestId"));
		String requestTableName=request.getParameter("requestTableName");
		System.out.println(requestFileId+" "+requestId+" "+requestTableName);
		try
		{
			con=Myconnection.getConncetion();
			String sql=null;
			if(requestTableName.equals("adminpost"))
			{
				sql="SELECT admin_postImagePrimary,admin_postImageSecondary,admin_postVideo FROM "+requestTableName+" WHERE admin_postid="+requestId;
			}
			else
			{
				sql="SELECT image1,image2,video FROM "+requestTableName+" WHERE postid="+requestId;
			}
			stmt=con.createStatement();
			rst=stmt.executeQuery(sql);
			System.out.println("Working New Four !");
			byte[] myimage=null;
			while(rst.next())
			{
				myimage=rst.getBytes(requestFileId);
				
			}
			response.setContentLengthLong(myimage.length);
			response.getOutputStream().write(myimage);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
