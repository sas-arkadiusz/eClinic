<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>eClinic</title>
<link type="text/css" rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/style.css">
</head>

<body>

	<div class="container">

		<div class="header">
			<h3>eClinic - Employed Doctors Manager</h3>
		</div>

		<form action="${ pageContext.request.contextPath }" method="GET">
			<input type="submit" value="Back" class="add-button">
		</form>
		<input class="add-button" type="button" value="Add Doctor"
			onclick="window.location.href='showAddDoctorForm'; return false;">

		<div id="data">

			<div class="tables">
				<table>
					<tr class="table_header">
						<th id="first_name">First Name</th>
						<th>Last Name</th>
						<th>Date of Birth</th>
						<th>Email Address</th>
						<th>Phone Number</th>
						<th>Street</th>
						<th>City</th>
						<th>Postal Code</th>
						<th>Salary</th>
					</tr>

					<c:forEach var="theDoctor" items="${ allDoctors }">

						<tr>
							<td>${ theDoctor.firstName }</td>
							<td>${ theDoctor.lastName }</td>
							<td>${ theDoctor.dateOfBirth }</td>
							<td>${ theDoctor.emailAddress }</td>
							<td>${ theDoctor.phoneNumber }</td>
							<td>${ theDoctor.streetName }</td>
							<td>${ theDoctor.cityName }</td>
							<td>${ theDoctor.postalCode }</td>
							<td>${ theDoctor.salary }</td>
						</tr>

					</c:forEach>
				</table>
			</div>

		</div>

	</div>

</body>
</html>