package control;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
public class Myconnection 
{
	public static Connection getConncetion()
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String link="jdbc:mysql://localhost:3306/mediahouse";
			String user="root";
			String password="";
			con=DriverManager.getConnection(link,user,password);
		}
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println("Something Went Wrong !");
		}
		return con;
	}
}
