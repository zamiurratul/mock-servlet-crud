<%@ include file="/WEB-INF/header.jsp" %>
<%@ include file="/WEB-INF/navigation.jsp" %>

<div class="container">
	<div class="row">
	<br>
	<br>
		<h4 class="lead bg-primary text-white custom-center">Register New User!</h4>
	</div>
	<div class="row">
		<div class="container">
			<form class="app-form" action="<%=request.getContextPath() %>/registration" method="post">
				<div class="form-group row">
					<label for="employeeId" class="col-xl-2">Employee Id: </label>
					<input class="form-control col-xl-4" type="text" id="employeeId" name="employeeId">
				</div>
				<div class="form-group row">
					<label for="fullName" class="col-xl-2">Full Name: </label>
					<input class="form-control col-xl-4" type="text" id="fullName" name="fullName">
				</div>
				<div class="form-group row">
					<label for="designation" class="col-xl-2">Designation: </label>
					<input class="form-control col-xl-4" type="text" id="designation" name="designation">
				</div>
				<div class="form-group row">
					<label for="email" class="col-xl-2">Email: </label>
					<input class="form-control col-xl-4" type="text" id="email" name="email">
				</div>
				<div class="form-group row">
					<label for="contactNo" class="col-xl-2">Contact No: </label>
					<input class="form-control col-xl-4" type="text" id="contactNo" name="contactNo">
				</div>
				<div class="form-group row">
					<label for="gender" class="col-xl-2">Gender: </label>
					<select class="form-control col-xl-4" id="gender" name="gender">
						<option value="MALE">Male</option>
						<option value="FEMALE">Female</option>
						<option value="OTHER">Other</option>
					</select>
				</div>
				<div class="form-group row">
					<label for="joiningDate" class="col-xl-2">Joining Date: </label>
					<input class="form-control col-xl-4" type="date" id="joiningDate" name="joiningDate">
				</div>
				<div class="form-group row">
					<label for="password" class="col-xl-2">Password: </label>
					<input class="form-control col-xl-4" type="password" id="password" name="password">
				</div>
				<div class="form-group row">
					<button type="submit" class="btn btn-outline-primary">Submit</button>
				</div>
			</form>
		</div>
	</div>
</div>

<%@ include file="/WEB-INF/footer.jsp" %>