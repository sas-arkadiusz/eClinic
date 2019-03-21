<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!-- Spring MVC support for forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	
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
			onclick="window.location.href='addDoctorForm'; return false;">
			
		<div class="search">
			<form:form action="search" method="GET">
				<input type="text" name="requestesDoctorLastName">
				<input class="search-button" type="submit" value="Search">
			</form:form>
		</div>
		
		<br><br>

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
						<th colspan="2">Action</th>						
					</tr>

					<c:forEach var="theDoctor" items="${ allDoctors }">

						<c:url var="updateLink" value="updateDoctorForm">
							<c:param name="updatedDoctorId" value="${ theDoctor.doctorId }" />
						</c:url>
						
						<c:url var="deleteLink" value="deleteDoctor"> 
							<c:param name="deletedDoctorId" value="${ theDoctor.doctorId }" />
						</c:url>

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
							<td><a href="${ updateLink }">Update</a></td>
							<td><a href="${ deleteLink }"
							       onclick="if (!(confirm('Are you sure you want to delete this doctor? This operation can not be undone.'))) return false;">
							       Delete</a></td>
						</tr>

					</c:forEach>
				</table>
			</div>

		</div>

	</div>

</body>
</html>