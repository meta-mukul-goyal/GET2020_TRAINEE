package EAD6.com.assignment;

import java.sql.*;

public class mysqlConnection {
	public static Connection initializeDatabase() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");  
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bookdetail","root","Glengoyal@123");
	    return con;
	}
}

