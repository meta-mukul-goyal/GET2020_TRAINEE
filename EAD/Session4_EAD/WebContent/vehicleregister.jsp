<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="cssfile.css" />
	<script src="javascript.js"></script>
</head>
<body>
<%
	int id = Integer.parseInt(request.getParameter("id"));
%>
<form  id="vehicleformid" method="post" action="vehicleregister"  >
            <fieldset>

                <h1>Vehicle Form</h1>
                <input type="number" name="id" value=<%=id %> hidden>
                <input id="vehicleName" type="text" placeholder="VehicleName" name="vehiclename" required><br><br>
                <select id=selectVehicleType name="vehicletype" >
                <option>Select Vehicle Type</option>
                <option value="Bicycle">Bicycle</option>
                <option value="Motorcycle">Motor Cycle</option>
                <option value="Fourwheelers">Four Wheeler</option>
                </select>
                <br><br>
                <input type="text" placeholder="Vehicle Number" name="vehiclenumber" required><br><br>
                <input id="empId" type="text" placeholder="Employee Id" name="empid" required><br><br>
                <textarea placeholder="Description" name="vehicledescription"></textarea><br><br>
                <input type="submit" value="Submit">
            </fieldset>
        </form>

</body>
</html>