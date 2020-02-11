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
<form id="registerformid" action="updateemployeedetail.jsp" method="get">

<%
//String email=(String)session.getAttribute("empemail");

//redirect user to home page if already logged in
//if(email==null){
	//out.print(email);
    //response.sendRedirect("login.jsp");
//}
%>

<%		
	try {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Glengoyal@123");
		PreparedStatement ps=con.prepareStatement("select * from register where empid=?"); 
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		rs.next();
%>
	
		<fieldset>
			<h1>Employee Detail Form</h1>
			<input name="id" value="<%=id %> " hidden>
			<strong>Employee Name: </strong><input id="firstname" type="text"  name="empname" value= "<%=rs.getString("empname") %>" ><br><br> 
			<strong>Employee Gender:</strong><input id="lastname" type="text" name="empgender" value= "<%= rs.getString("empgender") %>"  ><br><br> 
			<strong>Employee Email:</strong><input id="fathername" type="email" name="empemail" value="<%= rs.getString("empemail") %>"><br><br> 
		    <strong>Employee password:
		    </strong><input id="text" type="text"  name="emppassword" value= "<%= rs.getString("emppassword") %>" ><br><br> 
		    <strong>Employee Contact: 
		    </strong><input id="class" type="text" name="empcontact" value= "<%= rs.getString("empcontact") %>" ><br><br> 
		    <strong>Employee org: &emsp;&emsp;
		    </strong><select id=selectVehicleType name="emporganisation">
				<option>Select Organisation Type</option>
				<option value="Metacube">Metacube</option>
				<option value="In time Tech">In time Tech</option>
				<option value="Infosys">Infosys</option>
				<option value="TCS">TCS</option>
			</select> <br><br> 
			<input type="submit" value="Submit"><br><br>
		</fieldset>
		  <%
									
							con.close();
						} catch (Exception ex) {
							out.println("Unable to connect to database.");
						}
					%>
	</form>
	
</body>
</html>