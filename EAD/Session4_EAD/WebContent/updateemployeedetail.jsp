<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>

<%
//String email=(String)session.getAttribute("empemail");

//redirect user to home page if already logged in
//if(email==null){
	//out.print(email);
    //response.sendRedirect("login.jsp");
//}
%>

		<%
			int id = Integer.parseInt(request.getParameter("id").trim());
			
			String empname = request.getParameter("empname");
			String empgender = request.getParameter("empgender");
			String empemail = request.getParameter("empemail");
			String emppassword = request.getParameter("emppassword");
			String empcontact = request.getParameter("empcontact");
			String emporganisation = request.getParameter("emporganisation");
			
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Glengoyal@123");
				PreparedStatement ps=con.prepareStatement( "Update register set empname=?,empgender=?,empemail=?,emppassword=?,empcontact=?,emporganisation=? where empid=?");
				ps.setString(1, empname);
				ps.setString(2, empgender);
				ps.setString(3, empemail);
				ps.setString(4, emppassword);
				ps.setString(5, empcontact);
				ps.setString(6, emporganisation);
				ps.setInt(7, id);
			if ( ps.executeUpdate() > 0) 
				out.print("Record Updated Successfully");
			else 
				out.print("There is a problem in updating Record.");
			} 
			catch (SQLException sql) {
			out.println(sql);
			}
			
			%>

	
	</body>
</html>
