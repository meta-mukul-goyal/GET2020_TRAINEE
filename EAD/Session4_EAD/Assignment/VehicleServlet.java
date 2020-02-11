package Assignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class VehicleServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res ) throws IOException, ServletException{
		int id = Integer.parseInt(req.getParameter("id"));
		String vehiclename = req.getParameter("vehiclename");
		String vehicletype = req.getParameter("vehicletype");
		String vehiclenumber = req.getParameter("vehiclenumber");
		String employeeid = req.getParameter("empid");
		String vehicledescription = req.getParameter("vehicledescription");
		
		try {

			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Glengoyal@123");
			PreparedStatement ps=con.prepareStatement("insert into vehicleregister values(?,?,?,?,?,?)"); 
			ps.setInt(1, id );
			ps.setString(2, vehiclename );
			ps.setString(3, vehicletype);
			ps.setString(4, vehiclenumber);
			ps.setString(5, employeeid);
			ps.setString(6, vehicledescription);
			
			if(ps.executeUpdate() > 0) {
				System.out.println("Added successfully , "+vehicletype);
				req.setAttribute("vehicletype", vehicletype);
				req.setAttribute("id", id);
				RequestDispatcher rd = req.getRequestDispatcher("vehicleplan.jsp");
				rd.forward(req, res);
				con.close();

			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("sql exception");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("class not found");
		}  
		
		
		
	}
}
