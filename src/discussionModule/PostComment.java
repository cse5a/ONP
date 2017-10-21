package discussionModule;

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
@WebServlet("/PostComment")
public class PostComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Connection con=null;
		PreparedStatement ps=null;
		StringBuilder sb=new StringBuilder();
		BufferedReader br=request.getReader();
		String temp=null;
		while((temp=br.readLine())!=null)
		{
			sb.append(temp);
		}
		try
		{
			JSONParser parse=new JSONParser();
			Object obj=parse.parse(sb.toString());
			JSONObject jobj=(JSONObject)obj;
			con=Myconnection.getConncetion();
			String query="INSERT INTO discussioncomments VALUES(null,?,?,?,?)";
			ps=con.prepareStatement(query);
			ps.setInt(1,Integer.parseInt(jobj.get("id").toString()));
			ps.setString(2,jobj.get("name").toString());
			ps.setString(3,jobj.get("email").toString());
			ps.setString(4,jobj.get("text").toString());
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
