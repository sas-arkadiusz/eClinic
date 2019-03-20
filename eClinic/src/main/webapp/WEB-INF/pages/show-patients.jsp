<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	<title>eClinic</title>
	<link type="text/css"
		  rel="stylesheet"
		  href="${ pageContext.request.contextPath }/resources/css/style.css" >
</head>

<body>

	<div class="container">

		<div class="header">
			<h3>eClinic - Patients Manager</h3>
		</div>

		<div id="data">

			<div class="tables">
				<table>
					<tr class="table_header">
						<th>First Name</th>
						<th>Last Name</th>
						<th>Date of Birth</th>
						<th>Email Address</th>
						<th>Phone Number</th>
						<th>Street</th>
						<th>City</th>
						<th>Postal Code</th>
						<th>File ID</th>
						<th>Is Insurance</th>
						<th>First Visit</th>
						<th>Last Visit</th>

					</tr>

					<c:forEach var="thePatient" items="${ allPatients }">

						<tr>
							<td>${ thePatient.firstName }</td>
							<td>${ thePatient.lastName }</td>
							<td>${ thePatient.dateOfBirth }</td>
							<td>${ thePatient.emailAddress }</td>
							<td>${ thePatient.phoneNumber }</td>
							<td>${ thePatient.streetName }</td>
							<td>${ thePatient.cityName }</td>
							<td>${ thePatient.postalCode }</td>
							<td>${ thePatient.fileId }</td>
							<td>${ thePatient.isInsurance}</td>
							<td>${ thePatient.firstVisitDate }</td>
							<td>${ thePatient.lastVisitDate }</td>
							
							<!-- Missing one attribute: doctorID -->

						</tr>

					</c:forEach>
				</table>
			</div>

		</div>

	</div>

</body>
</html>