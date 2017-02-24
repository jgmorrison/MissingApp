package charley;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnector {

public Connection getConnection() {
		
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
    		conn = DriverManager.getConnection("jdbc:mysql://172.16.48.214:3306/Missing", "jmorrison", "sparky2040");
	    	System.out.println("Connection succesful!");
			
		} catch (Exception e) {
			
			System.out.println(e);
			System.exit(0);
		}
		
		return conn;
	}
}
