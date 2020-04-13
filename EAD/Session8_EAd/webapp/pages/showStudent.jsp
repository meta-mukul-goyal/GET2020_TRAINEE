<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>        
<%@include file="../includes/header.jsp" %>

<br>
<table class="table table-striped">
    <thead >
      <tr>
      	<th>First Name</th>
        <th>Last Name</th>
        <th>Father Name</th>
        <th>Email</th>
        <th>Class</th>
		<th>Age</th>      
      </tr>
    </thead>
    <tbody>
 <c:forEach items="${studentList}" var="student">

 <tr>   
 		<td>${student.firstName}</td>
        <td>${student.lastName}</td>
        <td>${student.fatherName}</td>
        <td>${student.email}</td>
        <td>${student.classs} </td>
        <td>${student.age} </td>
</tr>
</c:forEach>
     
      
    </tbody>
</table>



<%@include file="../includes/footer.jsp" %>

