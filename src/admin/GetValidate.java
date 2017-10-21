package admin;
import connection.Myconnection;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.simple.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
@WebServlet("/GetValidate")
public class GetValidate extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rst=null;
		con=Myconnection.getConncetion();
		StringBuilder sb=new StringBuilder();
		String temp=null;
		BufferedReader br=request.getReader();
		while((temp=br.readLine())!=null)
		{
			sb.append(temp);
		}
		JSONParser parse=new JSONParser();
		try
		{
			Object obj=parse.parse(sb.toString());
			JSONObject jobj=(JSONObject)obj;
			GetValidate ob= new GetValidate();
			if(Integer.parseInt(jobj.get("function").toString())==1)
			{
				boolean flagEmail=ob.getEmail(con,ps,rst,jobj.get("value").toString());
				PrintWriter pw=response.getWriter();
				JSONObject jobj1=new JSONObject();
				jobj1.put("flag",flagEmail);
				pw.println(jobj1);
			}
			else
			{
				boolean flagNumber=ob.getNumber(con,ps,rst,jobj.get("value").toString());
				PrintWriter pw=response.getWriter();
				JSONObject jobj1=new JSONObject();
				jobj1.put("flag",flagNumber);
				pw.println(jobj1);
			}
		}
		catch(ParseException e)
		{
			
		}
	}
	public boolean getEmail(Connection con,PreparedStatement ps,ResultSet rst,String email)
	{
		int number=0;
		try
		{
			ps=con.prepareStatement("SELECT COUNT(adminId) AS flag FROM admin WHERE adminEmail=?");
			ps.setString(1,email);
			rst=ps.executeQuery();
			while(rst.next())
			{
				number=rst.getInt(1);
			}
		}
		catch (Exception e) 
		{
			return false;
		}
		if(number>0)
			return true;
		else
			return false;
	}
	public boolean getNumber(Connection con,PreparedStatement ps,ResultSet rst,String contactNumber)
	{
		int number=0;
		try
		{
			ps=con.prepareStatement("SELECT COUNT(adminId) AS flag FROM admin WHERE adminContactNo=?");
			ps.setInt(1,Integer.parseInt(contactNumber));
			rst=ps.executeQuery();
			while(rst.next())
			{
				number=rst.getInt(1);
			}
		}
		catch (Exception e) 
		{
			return false;
		}
		if(number>0)
			return true;
		else
			return false;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
