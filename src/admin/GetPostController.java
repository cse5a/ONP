package admin;
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

@WebServlet("/GetPostController")
public class GetPostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		StringBuilder sb=new StringBuilder();
		String temp,sql=null;
		BufferedReader br=request.getReader();
		while((temp=br.readLine())!=null)
		{
			sb.append(temp);
		}
		try
		{
			JSONParser parse=new JSONParser();
			Object obj=parse.parse(sb.toString());
			JSONObject job=(JSONObject)obj;
			sql=job.get("sql").toString();
		}
		catch(ParseException e)
		{
			
		}
		GetPostClass myobject=new GetPostClass();
		List<AdminAddPostBean> mylist=new ArrayList<AdminAddPostBean>();
		mylist=myobject.getPost(sql);
		JSONObject jsonWrapper=new JSONObject();
		JSONArray jsonArray=new JSONArray();
		for(int i=0;i<mylist.size();i++)
		{
			JSONObject job=new JSONObject();
			job.put("postId",Integer.toString(mylist.get(i).getPostId()));
			job.put("adminId",Integer.toString(mylist.get(i).getAdminId()));
			job.put("name",mylist.get(i).getName());
			job.put("body",mylist.get(i).getBody());
			job.put("work",mylist.get(i).getWork());
			job.put("date",mylist.get(i).getDate());
			job.put("object",mylist.get(i).toString());
			jsonArray.add(job);
		}
		jsonWrapper.put("adminpostdata",jsonArray);
		PrintWriter pw=response.getWriter();
		pw.println(jsonWrapper);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
