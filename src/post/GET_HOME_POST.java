package post;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.List;
import java.util.ArrayList;

@WebServlet("/GET_HOME_POST")
public class GET_HOME_POST extends HttpServlet {
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
		JSONObject GET_JSON_OBJ=(JSONObject)obj;
		int categoryId=Integer.parseInt(GET_JSON_OBJ.get("id").toString());
		List<POST_BEAN> mylist=new ArrayList<POST_BEAN>();
		mylist=GET_HOME_POST_Class.GET_POST(categoryId);
		JSONObject JSON_WRAPPER=new JSONObject();
		JSONArray JSON_ARRAY=new JSONArray();
		for(POST_BEAN i : mylist)
		{
			JSONObject temp_obj=new JSONObject();
			temp_obj.put("name",i.getName());
			temp_obj.put("body",i.getBody());
			temp_obj.put("work",i.getWork());
			temp_obj.put("postId",i.getPostId());
			temp_obj.put("tablename",i.getPostUser());
			JSON_ARRAY.add(temp_obj);
		}
		JSON_WRAPPER.put("my_post_data",JSON_ARRAY);
		PrintWriter pw=response.getWriter();
		pw.println(JSON_WRAPPER);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
