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
int id = Integer.parseInt(request.getParameter("id"));
String plan = request.getParameter("plan");
String currency = request.getParameter("currency");
String price = request.getParameter("price");
out.print(price);


try {

	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Glengoyal@123");
	PreparedStatement ps=con.prepareStatement("insert into vehicleplan values(?,?,?,?)"); 
	ps.setInt(1, id);
	ps.setString(2, plan );
	ps.setString(3, currency);
	ps.setString(4, price);
	
	if(ps.executeUpdate() > 0) {
		System.out.println("Added successfully price");
		response.sendRedirect("homepage.jsp?id="+id);
		con.close();

	}
} catch (SQLException e) {
	e.printStackTrace();
	System.out.println("sql exception");
} catch (ClassNotFoundException e) {
	e.printStackTrace();
	System.out.println("class not found");
}  

%>
</body>
</html>