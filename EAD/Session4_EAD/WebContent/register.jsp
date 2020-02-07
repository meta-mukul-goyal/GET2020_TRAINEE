<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String empname = request.getParameter("empname");
String empemail = request.getParameter("empemail");
String empgender = request.getParameter("empgender");
String emppassword = request.getParameter("emppassword");
String empcontact = request.getParameter("empcontact");
String emporganisation = request.getParameter("emporganisation");

try {
//	PrintWriter out = res.getWriter();
//	out.println("result is "+empemail + empcontact);
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
		
//		res.sendRedirect("vehicleregister.html");
	}
	ps=con.prepareStatement("select empid from register where empname=?"); 
	ps.setString(1, empname);
	ResultSet rs = ps.executeQuery();
	rs.next();
	int id = rs.getInt("empid");
	response.sendRedirect("vehicleregister.jsp?id="+id);

	//			req.setAttribute();
//	RequestDispatcher rd = req.getRequestDispatcher("/register.html");
//	rd.forward(req, res);
	con.close();
	
} catch (SQLException e) {
	e.printStackTrace();
} catch (ClassNotFoundException e) {
	e.printStackTrace();
}  
%>
</body>
</html>