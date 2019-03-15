<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link type="text/css"
		  rel="stylesheet"
		  href="${ pageContext.request.contextPath }/resources/css/style.css" >
</head>

<body>

	<div id="container">

		<div id="header">
			<h3>eClinic - Employed Doctors Manager</h3>
		</div>

		<div id="data">

			<div id="tables">
				<table>
					<tr>
						<th>First Name</th>
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