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
	<div class="container">
		<div class="row">
			<div class="col">
				<h1>List Of Students</h1>

				<%
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb","root","Glengoyal@123");
						PreparedStatement ps=con.prepareStatement("select * from studentregister");
						ResultSet rs = ps.executeQuery();
				%>

				<table id="displayData">
					<tr>
						<th>Student Name</th>
						<th>Father's Name</th>
						<th>Email</th>
						<th>Class</th>
						<th>Age</th>
						<th>Edit</th>
						<th></th>
					</tr>
					<%
						while (rs.next()) {
							int id = rs.getInt("idstudentregister");
							
					%>
					<tr>
						<td><%=rs.getString("firstname") +" "+ rs.getString("lastname")%></td>
						<td><%=rs.getString("fathername")%></td>
						<td><%=rs.getString("email")%></td>
						<td><%=rs.getInt("class")%></td>
						<td><%=rs.getInt("age")%></td>
						<td>
							<a href="edit.jsp?id=<%= id %>"  >Edit</a>
						</td>
					</tr>
					<%}
									
							con.close();
						} catch (Exception ex) {
							out.println("Unable to connect to database.");
						}
					%>
				</table>
			</div>
		</div>
	</div>
</body>
</html>