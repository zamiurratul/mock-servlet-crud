<%@page import="com.zamiurratul.mock.servlet.model.User"%>
<%@ include file="/WEB-INF/header.jsp" %>
<%@ include file="/WEB-INF/navigation.jsp" %>

<div class="container">
	<div class="row">
	<br>
	<br>
		<h4 class="lead bg-primary text-white">Edit User</h4>
	</div>
	<div class="row">
		<% User user = (User) request.getAttribute("user"); %>
		<div class="container">
			<form class="app-form" action="<%=request.getContextPath() %>/edit-user?id=<%=user.getId()%>" method="post">
				<input type="hidden" id="id" name="id" value="<%=user.getId() %>">
				<div class="form-group row">
						<label for="employeeId" class="col-xl-2">Employee Id: </label>
						<input class="form-control col-xl-4" type="text" id="employeeId" name="employeeId" value="<%=user.getEmployeeId()%>">
					</div>
					<div class="form-group row">
						<label for="fullName" class="col-xl-2">Full Name: </label>
						<input class="form-control col-xl-4" type="text" id="fullName" name="fullName" value="<%=user.getFullName()%>">
					</div>
					<div class="form-group row">
						<label for="designation" class="col-xl-2">Designation: </label>
						<input class="form-control col-xl-4" type="text" id="designation" name="designation" value="<%=user.getDesignation()%>">
					</div>
					<div class="form-group row">
						<label for="email" class="col-xl-2">Email: </label>
						<input class="form-control col-xl-4" type="text" id="email" name="email" value="<%=user.getEmail()%>">
					</div>
					<div class="form-group row">
						<label for="contactNo" class="col-xl-2">Contact No: </label>
						<input class="form-control col-xl-4" type="text" id="contactNo" name="contactNo"  value="<%=user.getContactNo()%>">
					</div>
					<div class="form-group row">
						<label for="gender" class="col-xl-2">Gender: </label>
						<select class="form-control col-xl-4" id="gender" name="gender"  value="<%=user.getGender()%>">
							<option value="MALE">Male</option>
							<option value="FEMALE">Female</option>
							<option value="OTHER">Other</option>
						</select>
					</div>
					<div class="form-group row">
						<label for="joiningDate" class="col-xl-2">Joining Date: </label>
						<input class="form-control col-xl-4" type="date" id="joiningDate" name="joiningDate" value="<%=user.getJoiningDate()%>">
					</div>
					<div class="form-group row">
						<label for="password" class="col-xl-2">Password: </label>
						<input class="form-control col-xl-4" type="password" id="password" name="password" value="<%=user.getPassword()%>">
					</div>
					<div class="form-group row">
						<button type="submit" class="btn btn-outline-primary">Submit</button>
					</div>
			</form>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/footer.jsp" %>