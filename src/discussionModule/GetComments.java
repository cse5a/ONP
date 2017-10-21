package discussionModule;
import connection.Myconnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
@WebServlet("/GetComments")
public class GetComments extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rst=null;
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
			String query="SELECT * FROM discussioncomments WHERE discussionId=?";
			ps=con.prepareStatement(query);
			ps.setInt(1,Integer.parseInt(jobj.get("id").toString()));
			rst=ps.executeQuery();
			JSONObject wrapperObj=new JSONObject();
			JSONArray wrapperArray=new JSONArray();
			while(rst.next())
			{
				JSONObject itemObj=new JSONObject();
				itemObj.put("name",rst.getString(3));
				itemObj.put("email",rst.getString(4));
				itemObj.put("comment",rst.getString(5));
				wrapperArray.add(itemObj);
			}
			wrapperObj.put("mycomments",wrapperArray);
			PrintWriter pw=response.getWriter();
			pw.println(wrapperObj);
		}
		catch(ParseException | SQLException e)
		{
			
		}
		finally
		{
			try
			{
				if(rst!=null)
				{
					rst.close();
				}
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
