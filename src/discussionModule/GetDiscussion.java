package discussionModule;
import connection.Myconnection;
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
import org.json.simple.JSONArray;;
@WebServlet("/GetDiscussion")
public class GetDiscussion extends HttpServlet
{
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		Connection con=null;
		ResultSet rst=null;
		PreparedStatement ps=null;
		JSONObject wrapperObj= new JSONObject();
		JSONArray wrapperArray=new JSONArray();
		try
		{
			con=Myconnection.getConncetion();
			String query="SELECT * FROM discussion WHERE discussionDate=CURDATE()";
			ps=con.prepareStatement(query);
			rst=ps.executeQuery();
			while(rst.next())
			{
				JSONObject obj=new JSONObject();
				obj.put("id",rst.getString(1));
				obj.put("topic",rst.getString(2));
				obj.put("text",rst.getString(3));
				obj.put("category",rst.getString(4));
				wrapperArray.add(obj);
			}
			wrapperObj.put("mydiscussion",wrapperArray);
			PrintWriter pw=response.getWriter();
			pw.println(wrapperObj);
		}
		catch(SQLException e)
		{
			//Redirect To An Error Page
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}
