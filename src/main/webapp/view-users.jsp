<%@page import="java.util.ArrayList"%>
<%@page import="com.zamiurratul.mock.servlet.model.User"%>
<%@page import="java.util.List"%>
<%@ include file="/WEB-INF/header.jsp" %>
<%@ include file="/WEB-INF/navigation.jsp" %>
<div class="container">
	<div class="row">
		<h4 class="lead bg-primary">View All Employees</h4>
	</div>
	<div class="row">
		<%
		List<User> users = (ArrayList<User>)request.getAttribute("users");
		%>
		<%
		if (users != null && !users.isEmpty()) {
		%>
		<table class="table table-bordered table-hover">
			<thead class="thead-dark">
				<tr>
					<td>EmployeeId</td>
					<td>FullName</td>
					<td>Designation</td>
					<td>Email</td>
					<td>ContactNo</td>
					<td>Gender</td>
					<td>Joining Date</td>
					<td>Action</td>
					<td>Action</td>
				</tr>
			</thead>
			<tbody>
				<%
				for (User user : users) {
				%>
				<tr>
					<td><%=user.getEmployeeId()%></td>
					<td><%=user.getFullName()%></td>
					<td><%=user.getDesignation()%></td>
					<td><%=user.getEmail()%></td>
					<td><%=user.getContactNo()%></td>
					<td><%=user.getGender()%></td>
					<td><%=user.getJoiningDate()%></td>
					<td><a href="<%=request.getContextPath()%>/edit-user?id=<%=user.getId()%>">edit</a></td>
					<td><a href="<%=request.getContextPath()%>/delete-user?id=<%=user.getId()%>">delete</a></td>
				</tr>
				<% } %>
			</tbody>
		</table>
		<% } else { %>
		<p>NO DATA AVAILABLE</p>
		<% } %>
	</div>
	<div class="row">
	</div>
</div>
<%@ include file="/WEB-INF/footer.jsp" %>