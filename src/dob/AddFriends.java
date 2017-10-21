package dob;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import control.Myconnection;

/**
 * Servlet implementation class AddFriends
 */
@WebServlet("/AddFriends")
public class AddFriends extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb=new StringBuilder();
		BufferedReader br=request.getReader();
		PrintWriter pw=response.getWriter();
		String temp=null;
		Connection con=null;
		Statement stmt=null;
		if((temp=br.readLine())!=null)
		{
			sb.append(temp);
		}
		try
		{
			JSONParser Parse=new JSONParser();
			Object object=Parse.parse(sb.toString());
			JSONObject job=(JSONObject)object;
			con=Myconnection.getConncetion();
			stmt=con.createStatement();
			int userId1=Integer.parseInt(job.get("userId1").toString());
			int userId2=Integer.parseInt(job.get("userId2").toString());
			stmt.addBatch("INSERT INTO friendlist VALUES(null,"+userId1+","+userId2+",now())");
			stmt.addBatch("INSERT INTO friendlist VALUES(null,"+userId2+","+userId1+",now())");
			stmt.addBatch("INSERT INTO follownotify VALUES(null,"+userId2+","+userId1+",now())");
			stmt.executeBatch();
			pw.print("{\"flag\":\"1\"}");
		}
		catch(ParseException | SQLException e)
		{
			pw.print("{\"flag\":\"0\"}");
		}
		finally
		{
			try
			{
				if(stmt!=null)
				{
					stmt.close();
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
