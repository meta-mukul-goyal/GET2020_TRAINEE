package Assignment;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RegisterServlet extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res ) throws IOException, ServletException{
		String empname = req.getParameter("empname");
		String empemail = req.getParameter("empemail");
		String empgender = req.getParameter("empgender");
		String emppassword = req.getParameter("emppassword");
		String empcontact = req.getParameter("empcontact");
		String emporganisation = req.getParameter("emporganisation");
		
		try {
//			PrintWriter out = res.getWriter();
//			out.println("result is "+empemail + empcontact);
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Glengoyal@123");
			PreparedStatement ps=con.prepareStatement("insert into register values(?,?,?,?,?,?,empid)"); 
			ps.setString(1, empname);
			ps.setString(2, empgender);
			ps.setString(3, empemail);
			ps.setString(4, emppassword);
			ps.setString(5, empcontact);
			ps.setString(6, emporganisation);
			
			
			if(ps.executeUpdate()>0) {
				System.out.println("Added successfully");
				
//				res.sendRedirect("vehicleregister.html");
			}
			ps=con.prepareStatement("select empid from register where empname=?"); 
			ps.setString(1, empname);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int id = rs.getInt("empid");
			res.sendRedirect("vehicleregister.jsp?id="+id);

			//			req.setAttribute();
//			RequestDispatcher rd = req.getRequestDispatcher("/register.html");
//			rd.forward(req, res);
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}  
		
		
	}
	
}	
//	public void doGet(HttpServletRequest req,HttpServletResponse res ) throws IOException, ServletException{
//		
//		
//		
//		int i = Integer.parseInt(req.getParameter("num1"));
//		int j = Integer.parseInt(req.getParameter("num2"));
//		int k=i+j;
//		
//		PrintWriter out = res.getWriter();
//		out.println("<html><body><h1>");
//		out.println("output: "+k);
//		out.print("</h1></body></html>");
		
//		Cookie cookie =new Cookie("k",k+"");
//		res.addCookie(cookie);
		
//		HttpSession session = req.getSession();
//		session.setAttribute("k", k);
//		res.sendRedirect("sq");
		
		

//		req.setAttribute("k", k);
//		RequestDispatcher rd = req.getRequestDispatcher("/sq");
//		rd.forward(req, res);

//		ServletContext ctx = getServletContext();
//		String str = ctx.getInitParameter("name");
//		out.print(str);
		
//		ServletConfig cg = getServletConfig();
//		String str = cg.getInitParameter("name");
//		out.print(str);
	
//}
