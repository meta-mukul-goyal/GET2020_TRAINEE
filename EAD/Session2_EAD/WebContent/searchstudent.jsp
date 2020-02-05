<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="cssfile.css" />
</head>
<body>
<%		
	try {
		int studentclass=Integer.parseInt(request.getParameter("studentclass"));
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","Glengoyal@123");
		PreparedStatement ps;
		if( studentclass==0 ){
			 ps=con.prepareStatement("select * from studentregister where firstname=? or lastname=? order by class");
			ps.setString(1, firstname);
			ps.setString(2, lastname);
		}
	else{
			ps=con.prepareStatement("select * from studentregister where (firstname=? or lastname=?) and class=?");
			ps.setString(1, firstname);
			ps.setString(2, lastname);
			ps.setInt(3, studentclass);
		}
		ResultSet rs = ps.executeQuery();

		int row=rs.getRow();  
		if( row>=0 ){
%>
		<h1>Result:</h1>
		<tr>
			<th>
			<form action="searchstudent.jsp?firstname=<%=firstname%>&lastname=<%=lastname%>"  method="post">
				<label>Filter Class</label>
				 <select name="studentclass">
					<%
						for (int i = 1; i <= 12; i++) {
					%>
					<option value="<%=i%>"><%=i%></option>
					<%
						}
					%>
				</select>
				<input type="submit" value="Filter"/>
			</form></th>
		</tr>
			<table id="displayData">
		<tr>
			<th>Student Name</th>
			<th>Father's Name</th>
			<th>Email</th>
			<th>Class</th>
			<th>Age</th>
			<th></th>
		</tr>
		
		<%
			while (rs.next()) {		
		%>
		
		<tr>
			<td><%=rs.getString("firstname") +" "+ rs.getString("lastname")%></td>
			<td><%=rs.getString("fathername")%></td>
			<td><%=rs.getString("email")%></td>
			<td><%=rs.getInt("class")%></td>
			<td><%=rs.getInt("age")%></td>
		</tr>
	
<%		
			}
		}
		else
			out.println("No Result is Found");
		con.close();
	}
		catch (Exception ex) {
				out.println("Unable to connect to database.");
		}
%>
	
</body>
</html>