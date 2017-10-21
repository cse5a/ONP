package user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import connection.Myconnection;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

@WebServlet("/CountFollowing")
public class CountFollowing extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unchecked")
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
		} catch (ParseException e) 
		{
			e.printStackTrace();
		}
		JSONObject jobj=(JSONObject)obj;
		int id=Integer.parseInt(jobj.get("userid").toString());
		CountFollowing cf_obj=new CountFollowing();
		int count=cf_obj.Count_Following(id);
		JSONObject sendJSON=new JSONObject();
		sendJSON.put("following",count);
		PrintWriter pw=response.getWriter();
		pw.println(sendJSON);
	}
	protected int Count_Following(int id)
	{
		int count=0;
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rst=null;
		try
		{
			con=Myconnection.getConncetion();
			String sql="SELECT COUNT(*) AS following FROM `friendlist` WHERE userId1=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,id);
			rst=ps.executeQuery();
			while(rst.next())
			{
				count=rst.getInt("following");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
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
				e.printStackTrace();
			}
		}
		return count;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
