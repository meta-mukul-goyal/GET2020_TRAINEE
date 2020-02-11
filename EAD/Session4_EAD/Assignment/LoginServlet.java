package Assignment;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res ) throws IOException{
		String empemail = req.getParameter("empemail");
		String emppassword = req.getParameter("emppassword");
		PrintWriter out =res.getWriter(); 

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Glengoyal@123");
			PreparedStatement ps=con.prepareStatement("select * from register where empemail=? and emppassword=?");  
			ps.setString(1,empemail);
			ps.setString(2, emppassword);
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rsmd=rs.getMetaData();  
			int row=rsmd.getColumnCount();
			rs.next();
			if( row>0 ){
				System.out.println("matched successfully");
				int id = rs.getInt("empid");

//				HttpSession session = req.getSession();
//				session.setAttribute("empemail",empemail);
				res.sendRedirect("homepage.jsp?id="+id+"&status=0");
				con.close();
			}
			
		} catch (Exception e) {
			out.println("No Result is Found in database.");
			
		}
		
		
//		HttpSession session = req.getSession();
//		int k = (int)session.getAttribute("k");
//		int k=0;
//		Cookie cookies[] = req.getCookies();
//		
//		for ( Cookie c:cookies){
//			if ( c.getName().equals("k"))
//				k = Integer.parseInt(c.getValue());
//		}
//		


//		req.setAttribute();
//		RequestDispatcher rd = req.getRequestDispatcher("/vehicle.html");
//		rd.forward(req, res);	
	}
}
