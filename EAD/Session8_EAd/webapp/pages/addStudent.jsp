<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="../includes/header.jsp" %>
<br>
	<div class="container form-container">
			<form:form modelAttribute="student" action="studentRegister">
	
			<form:errors />
			<div class="form-group">
				<form:label path="firstName">First Name</form:label>
				<form:input path="firstName" type="text" class="form-control"
					id="exampleInputFirstName1" placeholder="First Name" />
				<form:errors path="firstName" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<form:label path="lastName">Last Name</form:label>
				<form:input path="lastName" type="text" class="form-control"
					id="exampleInputLastName1" placeholder="Last Name" />
				<form:errors path="lastName" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<form:label path="fatherName">Father Name</form:label>
				<form:input path="fatherName" type="text" class="form-control"
					id="exampleInputFatherName1" placeholder="Father Name" />
				<form:errors path="fatherName" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<form:label path="email">Email</form:label>
				<form:input path="email" type="text" class="form-control"
					id="exampleInputEmail1" placeholder="Email" />
				<form:errors path="email" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<form:label path="classs">Class</form:label>
				<form:input path="classs" type="text" class="form-control"
					id="exampleInputClass1" placeholder="Class" />
				<form:errors path="classs" cssClass="text-danger" />
			</div>
			
			<div class="form-group">
				<form:label path="age">Age</form:label>
				<form:input path="age" type="text" class="form-control"
					id="exampleInputAge1" placeholder="Age" />
				<form:errors path="age" cssClass="text-danger" />
			</div>
			
			<button type="submit" class="btn btn-primary">Submit</button>		
		
		</form:form>
	</div>
	
<%@ include file="../includes/footer.jsp" %>