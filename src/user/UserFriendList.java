package user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import control.FriendListClass;
import control.FriendsDetail;
@WebServlet("/UserFriendList")
public class UserFriendList extends HttpServlet 
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
		JSONParser Parser=new JSONParser();
		Object obj=null;
		try 
		{
			obj = Parser.parse(sb.toString());
		} catch (ParseException e) 
		{
			e.printStackTrace();
		}
		JSONObject my_json_object=(JSONObject)obj;
		int userId=Integer.parseInt(my_json_object.get("userid").toString());
		String mytext=my_json_object.get("text").toString();
		List<FriendsDetail> mylist=new ArrayList<FriendsDetail>();
		mylist=FriendListClass.myFriendList(userId,mytext);
		JSONObject json_wrapper=new JSONObject();
		JSONArray json_array=new JSONArray();
		for(FriendsDetail fd_obj:mylist)
		{
			JSONObject temp_obj=new JSONObject();
			temp_obj.put("f_Id",fd_obj.getUserId());
			temp_obj.put("f_name",fd_obj.getName());
			temp_obj.put("f_email",fd_obj.getEmail());
			temp_obj.put("f_gender",fd_obj.getGender());
			json_array.add(temp_obj);
		}
		json_wrapper.put("myfriendlist",json_array);
		PrintWriter pw=response.getWriter();
		pw.println(json_wrapper);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
