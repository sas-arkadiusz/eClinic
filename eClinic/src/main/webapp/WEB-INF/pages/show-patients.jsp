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
			<h3>eClinic - Patients Manager</h3>
		</div>

		<form action="${ pageContext.request.contextPath }" method="GET">
			<input type="submit" value="Back" class="add-button">
		</form>
		<input class="add-button" type="button" value="Add Patient"
			onclick="window.location.href='addPatientForm'; return false;">

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
						<th>Doctor ID</th>
						<th>Is Insurance</th>
						<th>First Visit</th>
						<th>Last Visit</th>
						<th colspan="2">Action</th>

					</tr>

					<c:forEach var="thePatient" items="${ allPatientsList }">

						<c:url var="updateLink" value="updatePatientForm">
							<c:param name="updatedPatientId" value="${ thePatient.patientId }" />
						</c:url>
						
						<c:url var="deleteLink" value="deletePatient">
							<c:param name="deletedPatientId" value="${ thePatient.patientId }" />
						</c:url>

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
							<td>${ thePatient.doctorId.doctorId }</td>
							<td>${ thePatient.isInsurance}</td>
							<td>${ thePatient.firstVisitDate }</td>
							<td>${ thePatient.lastVisitDate }</td>
							<td><a href="${ updateLink }">Update</a></td>
							<td><a href="${ deleteLink }"
								   onclick="if (!(confirm('Are you sure you want to delete this patient? This operation can not be undone.'))) return false;">
							Delete</a></td>

						</tr>

					</c:forEach>
				</table>
			</div>

		</div>

	</div>

</body>
</html>