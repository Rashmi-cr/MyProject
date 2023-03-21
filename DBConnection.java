package empapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {

	 //static Connection connection;
	static Connection connection=null;
	//static method which returns database connection
	public static Connection createDBConnection() {
		
	
		try {
			//load driver--mysql
		Class.forName("com.mysql.cj.jdbc.Driver");
		//connect to database
		connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeeDB", "root", "2000");
		
		}
		catch(ClassNotFoundException e)
		{
			System.out.println(e.getMessage()+"   "+e.getClass());
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return connection;
	}
	
}
