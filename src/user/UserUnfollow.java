package user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import connection.Myconnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Servlet implementation class UserUnfollow
 */
@WebServlet("/UserUnfollow")
public class UserUnfollow extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb=new StringBuilder();
		BufferedReader br=request.getReader();
		String temp=null;
		if((temp=br.readLine())!=null)
		{
			sb.append(temp);
		}
		JSONParser Parser=new JSONParser();
		Object obj=null;
		try 
		{
			obj=Parser.parse(sb.toString());
		}catch (ParseException e) 
		{
			e.printStackTrace();
		}
		JSONObject json_obj=(JSONObject)obj;
		int id1=Integer.parseInt(json_obj.get("userId1").toString());
		int id2=Integer.parseInt(json_obj.get("userId2").toString());
		int result=UserUnfollow.deleteUser(id1, id2);
		JSONObject send_obj=new JSONObject();
		send_obj.put("result",result);
		PrintWriter pw=response.getWriter();
		pw.println(send_obj);
	}
	protected static int deleteUser(int id1,int id2)
	{
		Connection con=null;
		Statement stmt=null;
		int result[]={};
		try
		{
			con=Myconnection.getConncetion();
			stmt=con.createStatement();
			stmt.addBatch("DELETE FROM friendlist WHERE userId1="+id1+" AND userId2="+id2+"");
			stmt.addBatch("DELETE FROM friendlist WHERE userId1="+id2+" AND userId2="+id1+"");
			stmt.addBatch("INSERT INTO unfollownotify VALUES(null,"+id2+","+id1+",now())");
			result=stmt.executeBatch();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
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
				e.printStackTrace();
			}
		}
		return result[1];
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
