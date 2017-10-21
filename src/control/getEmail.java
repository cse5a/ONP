package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;
@WebServlet("/getEmail")
public class getEmail extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection con=null;
		PreparedStatement ps=null;
		StringBuilder sb=new StringBuilder();
		BufferedReader br=request.getReader();
		String temp;
		while((temp=br.readLine())!=null)
		{
			sb.append(temp);
		}
		try
		{
			JSONParser parse=new JSONParser();
			Object obj=parse.parse(sb.toString());
			JSONObject job=(JSONObject)obj;
			con=Myconnection.getConncetion();
			ps=con.prepareStatement("SELECT * FROM user WHERE userEmail=?");
			ps.setString(1,job.get("email").toString());
			ResultSet rst=ps.executeQuery();
			PrintWriter pw=response.getWriter();
			pw.print("{\"valid\":\""+rst.next()+"\"}");
		}
		catch(ParseException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(ps!=null)
				{
					ps.close();
				}
				if(con!=null)
				{
					con.close();
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
