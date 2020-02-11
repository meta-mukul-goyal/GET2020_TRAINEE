<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" type="text/css" href="cssfile.css" />
	<script src="javascript.js"></script>
</head>
<body onload="changeCurrency('${vehicletype}')">

<%
	String vehicletype = request.getParameter("vehicletype");
	int id = Integer.parseInt(request.getParameter("id"));
	out.print(vehicletype);
%>

<form id="planid" action="vehicleplanservlet.jsp" method="get">
            <fieldset>
                <h1>Select your Plan:</h1><br>
                <input type="number" name="id" value=<%=id %> hidden>
      <label><strong><input type="radio" id="daily" name="plan" value="daily" >Daily<span  id = "dailyPriceRate"></span></strong></label>
      <label><strong><input type="radio" id="monthly" name="plan" value="monthly" >Monthly<span id = "monthlyPriceRate"></span ></strong></label>
      <label><strong><input type="radio" id="yearly" name="plan" value="yearly">Yearly<span id = "yearlyPriceRate" ></span></strong></label>
                <br><br><br>
                <strong>Select currency: </strong>
                <select onchange="changeCurrency()" id="selectcurrency" name="currency">
                <option value="INR" selected>INR</option>
                <option value="USD">USD</option>
                <option value="YEN">YEN</option>
                </select>
            <input type="text" id="price" name="price" hidden> 
                <input type="submit" value="Get Pass" onclick="getPass()">
                
            </fieldset>
 </form>

</body>
</html>