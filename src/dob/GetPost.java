package dob;

import java.io.IOException;
import java.io.OutputStream;

import control.Myconnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.Blob;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/GetPost")
public class GetPost extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	static Blob image1;
    public GetPost() 
    {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		try 
		{
			int id=Integer.parseInt(request.getParameter("id"));
			int image=Integer.parseInt(request.getParameter("image"));
			Connection con=Myconnection.getConncetion();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM userpost WHERE postId=?");
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			OutputStream out=response.getOutputStream();
			while(rs.next())
			{
				image1=rs.getBlob(image);
				byte[] myimage = image1.getBytes(1, (int) image1.length());
				out.write(myimage);
				out.flush();
				out.close();
			}
		} catch (SQLException e) 
		{
			
			e.printStackTrace();
		}
	}
	public static List<byte[]> Image()
	{
		List<byte[]> mylist=new ArrayList<byte[]>();
		try {
			Connection con=Myconnection.getConncetion();
			PreparedStatement ps=con.prepareStatement("SELECT * FROM userpost");
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				byte[] myimage = null;
				image1=rs.getBlob(7);
				myimage = image1.getBytes(1, (int) image1.length());
				mylist.add(myimage);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mylist;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
