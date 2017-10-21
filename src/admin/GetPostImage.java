package admin;
import connection.Myconnection;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
@WebServlet("/GetPostImage")
public class GetPostImage extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{ 
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rst=null;
		int requestFileId=Integer.parseInt(request.getParameter("requestFileIndex"));
		int requestId=Integer.parseInt(request.getParameter("requestId"));
		System.out.println(requestFileId+" "+requestId);
		try
		{
			con=Myconnection.getConncetion();
			String query="SELECT admin_postImagePrimary,admin_postImageSecondary,admin_postVideo FROM adminPost WHERE admin_postid=?";
			ps=con.prepareStatement(query);
			ps.setInt(1,requestId);
			rst=ps.executeQuery();
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
