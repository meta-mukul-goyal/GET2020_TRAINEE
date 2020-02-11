<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
<%@ page import="java.io.IOException"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><link rel="stylesheet" type="text/css" href="cssfile.css" /></head>
<body>
<%
	int id = Integer.parseInt(request.getParameter("id"));	
//String email=(String)session.getAttribute("empemail");
//out.print(email);
//if(email==null){
//	out.print(email);
//  response.sendRedirect("vehicleplan.jsp");
//}
%>
 

<div class="tab">
  <button class="tablinks" onclick="openCity(event, 'London')" id="defaultOpen">Employee Profile</button>
  <button class="tablinks" onclick="openCity(event, 'Paris')">Friends</button>
</div>
<div id="London" class="tabcontent">
  <div class="container">
		<div class="row">
			<div class="col">
				<h1>Employee Profile</h1>

				<%
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Glengoyal@123");
						PreparedStatement ps=con.prepareStatement("select * from register where empid=?");
						ps.setInt(1, id);
						ResultSet rs = ps.executeQuery();
				%>

				<table>
					<tr>
						<th>Employee id</th>
						<th>Employee Name</th>
						<th>Employee Gender</th>
						<th>Email</th>
						<th>Employee Contact</th>
						<th>Employee org</th>
						<%
						if(Integer.parseInt(request.getParameter("status")) == 0) {%>
						<th><a href="editemployeedetail.jsp?id=<%= id %>"  >Edit</a></th>
					</tr>
					<%}
						while (rs.next()) {
					%>
					<tr>
						<td><%=rs.getInt("empid")%></td>
						<td><%=rs.getString("empname")%></td>
						<td><%=rs.getString("empgender")%></td>
						<td><%=rs.getString("empemail")%></td>
						<td><%=rs.getString("empcontact")%></td>
						<td><%=rs.getString("emporganisation")%></td>
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
	<br><br>
	<div class="container">
		<div class="row">
			<div class="col">

				<%
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Glengoyal@123");
						PreparedStatement ps=con.prepareStatement("select * from vehicleregister where idvehicleregister=?");
						ps.setInt(1, id);
						ResultSet rs = ps.executeQuery();
				%>

				<table id="displayData">
					<tr>
						<th>Vehicle Name</th>
						<th>Vehicle Type</th>
						<th>Vehicle Number</th>
						<th>Vehicle Description</th>
					<%--	<th><a href="editvehicledetail.jsp?id=<%= id %>"  >Edit</a></th> --%>
					</tr>
					<%
						while (rs.next()) {
					%>
					<tr>
						<td><%=rs.getString("vehiclename")%></td>
						<td><%=rs.getString("vehiceltype")%></td>
						<td><%=rs.getString("vehiclenumber")%></td>
						<td><%=rs.getString("vehicledescription")%></td>
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
	<br><br>
	<div class="container">
		<div class="row">
			<div class="col">

				<%
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Glengoyal@123");
						PreparedStatement ps=con.prepareStatement("select * from vehicleplan where idvehicleplan=?");
						ps.setInt(1, id);
						ResultSet rs = ps.executeQuery();
				%>

				<table id="displayData">
					<tr>
						<th>Plan</th>
						<th>Currency</th>
						<th>Price</th>
					</tr>
					<%
						while (rs.next()) {
					%>
					<tr>
						<td><%=rs.getString("plan")%></td>
						<td><%=rs.getString("currency")%></td>
						<td><%=rs.getString("price")%></td>
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
  
</div>

<div id="Paris" class="tabcontent">
   <div class="container">
		<div class="row">
			<div class="col">
				<h1>Friends</h1>

				<%
					try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Glengoyal@123");
						PreparedStatement ps=con.prepareStatement("select emporganisation from register where empid=?");
						ps.setInt(1, id);
						ResultSet rs = ps.executeQuery();
						rs.next();
						out.print(rs.getString("emporganisation"));
					    ps=con.prepareStatement("select empname,empid from register where emporganisation=? and empid!=?");
						ps.setString(1, rs.getString("emporganisation"));
						ps.setInt(2, id);
					    rs = ps.executeQuery();

				%>
				<table>
					<tr><th>Employee Name</th></tr>
					<%
						while (rs.next()) {
							int id1 = rs.getInt("empid");
					%>
					<tr>
						<td><a href="homepage.jsp?id=<%= id1 %>&status=1" ><%=rs.getString("empname")%></a></td>
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
</div>
<input type="submit" align="right" onclick="logout()" value="logout" >




<script>

function logout(){
<%
//session.invalidate();
//response.sendRedirect("register.html");
%>
	//window.href="register.html";
}

function openCity(evt, cityName) {
  var i, tabcontent, tablinks;
  tabcontent = document.getElementsByClassName("tabcontent");
  for (i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  }
  tablinks = document.getElementsByClassName("tablinks");
  for (i = 0; i < tablinks.length; i++) {
    tablinks[i].className = tablinks[i].className.replace(" active", "");
  }
  document.getElementById(cityName).style.display = "block";
  evt.currentTarget.className += " active";
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();

</script>

</body>
</html>
