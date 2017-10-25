package user;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import connection.Myconnection;
@WebServlet("/DeleteUserPost")
public class DeleteUserPost extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		StringBuilder sb=new StringBuilder();
		BufferedReader br=request.getReader();
		String temp=null;
		if((temp=br.readLine())!=null)
		{
			sb.append(temp);
		}
		JSONParser Parse=new JSONParser();
		Object obj=null;
		try 
		{
			obj = Parse.parse(sb.toString());
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		JSONObject json_obj=(JSONObject)obj;
		int id=Integer.parseInt(json_obj.get("id").toString());
		DeletePost(id);
	}
	protected static void DeletePost(int postId)
	{
		Connection con=null;
		PreparedStatement ps=null;
		try
		{
			con=Myconnection.getConncetion();
			String sql="DELETE FROM userpost WHERE postid=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,postId);
			ps.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
