package user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import connection.Myconnection;
@WebServlet("/GetUserWall")
public class GetUserWall extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		StringBuilder sb=new StringBuilder();
		BufferedReader br=request.getReader();
		String temp=null;
		while((temp=br.readLine())!=null)
		{
			sb.append(temp);
		}
		JSONParser Parse=new JSONParser();
		Object obj=null;
		try 
		{
			obj=Parse.parse(sb.toString());
		} 
		catch (ParseException e) 
		{
			e.printStackTrace();
		}
		JSONObject json_obj=(JSONObject)obj;
		int id=Integer.parseInt(json_obj.get("id").toString());
		List<PostBean> mylist=new ArrayList<PostBean>();
		mylist=GetUserWall.getPost(id);
		JSONObject JSON_Wrapper=new JSONObject();
		JSONArray JSON_Array=new JSONArray();
		for(PostBean li:mylist)
		{
			JSONObject temp_obj=new JSONObject();
			temp_obj.put("postid",li.getPostId());
			temp_obj.put("userid",li.getUserId());
			temp_obj.put("name",li.getPostName());
			temp_obj.put("body",li.getPostBody());
			temp_obj.put("work",li.getPostWork());
			temp_obj.put("date",li.getDate());
			JSON_Array.add(temp_obj);
		}
		JSON_Wrapper.put("mylist",JSON_Array);
		PrintWriter pw=response.getWriter();
		pw.println(JSON_Wrapper);
	}
	protected static List<PostBean> getPost(int id)
	{
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rst=null;
		List<PostBean> mylist=new ArrayList<PostBean>();
		try
		{
			con=Myconnection.getConncetion();
			String sql="SELECT * FROM userpost WHERE userId IN (SELECT userId2 FROM friendlist WHERE userId1=?) OR userId=?";
			ps=con.prepareStatement(sql);
			ps.setInt(1,id);
			ps.setInt(2,id);
			rst=ps.executeQuery();
			while(rst.next())
			{
				PostBean obj=new PostBean();
				obj.setPostId(rst.getInt("postId"));
				obj.setUserId(rst.getInt("userId"));
				obj.setPostBody(rst.getString("postBody"));
				obj.setPostName(rst.getString("postName"));
				obj.setPostWork(rst.getString("postWork"));
				obj.setCategoryId(rst.getInt("categoryId"));
				obj.setDate(rst.getString("date"));
				mylist.add(obj);
			}
		}
		catch(SQLException e)
		{
			
		}
		return mylist;
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
