package Assignment;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StudentRegisterServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res ) throws IOException, ServletException{
		String firstname = req.getParameter("firstname");
		String lastname = req.getParameter("lastname");
		String fathername = req.getParameter("fathername");
		String email = req.getParameter("email");
		int classs = Integer.parseInt(req.getParameter("class"));
		int age = Integer.parseInt(req.getParameter("age"));
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","Glengoyal@123");
			PreparedStatement ps=con.prepareStatement("insert into studentregister values(idstudentregister,?,?,?,?,?,?)"); 
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setString(3, fathername);
			ps.setString(4, email);
			ps.setInt(5, classs);
			ps.setInt(6, age);
			
			if(ps.executeUpdate()>0) {
				System.out.println("Added successfully");
				res.sendRedirect("homepage.html");
				con.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		
		
	}
}