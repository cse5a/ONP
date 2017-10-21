package control;

import java.io.BufferedReader;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
@WebServlet("/MessageSend")
public class MessageSend extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection con=null;
		PreparedStatement ps=null;
		con=Myconnection.getConncetion();
		try
		{
			StringBuilder sb=new StringBuilder();
			BufferedReader br=request.getReader();
			String temp;
			while((temp=br.readLine())!=null)
			{
				sb.append(temp);
			}
			JSONParser parse=new JSONParser();
			Object obj=parse.parse(sb.toString());
			JSONObject jobj=(JSONObject)obj;
			int userId=Integer.parseInt(jobj.get("userId").toString());
			int touserId=Integer.parseInt(jobj.get("touserId").toString());
			String text=jobj.get("text").toString();
			ps=con.prepareStatement("INSERT INTO message VALUES(null,?,?,?,now())");
			ps.setInt(1,userId);
			ps.setInt(2,touserId);
			ps.setString(3,text);
			ps.executeUpdate();
		}
		catch(ParseException | SQLException e)
		{
			
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
				
			}
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
