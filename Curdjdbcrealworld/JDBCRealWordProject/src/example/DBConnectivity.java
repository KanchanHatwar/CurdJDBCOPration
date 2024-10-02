package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectivity {

	


	
	private static Connection connection;
	private static final String URL="jdbc:mysql://localhost:3306/curdopration";
	private static final String password="root";
	private static final String username="root";
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName(Driver);
		
		connection=DriverManager.getConnection(URL,password,username);
		System.out.println("Connection succsussfully");
		
		try {
			
		} catch (Exception e) {
e.printStackTrace();// TODO: handle exception
		}
		return connection;
	}
	
	
	
}
