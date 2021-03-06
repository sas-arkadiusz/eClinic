<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Spring MVC support for forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="pl.arkadiuszsas.eClinic.entity.Doctor"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Patient</title>
<link type="text/css" rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/style.css">
<link type="text/css" rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/add-doctor.css">
</head>

<body>

	<div class="container">

		<div class="header">
			<h3>eClinic - Patients Manager</h3>
		</div>

		<div class="adding_form">

			<form:form action="saveNewPatient" modelAttribute="addedPatient"
				method="POST">
				
				<form:hidden path="patientId" />

				<table>
					<tr>
						<td>First Name:</td>
						<td><form:input path="firstName" /></td>
					</tr>
					<tr>
						<td>Last Name:</td>
						<td><form:input path="lastName" /></td>
					</tr>
					<tr>
						<td>Date of Birth:</td>
						<td><form:input type="date" path="dateOfBirth" /></td>
					</tr>
					<tr>
						<td>Email Address:</td>
						<td><form:input type="email" path="emailAddress" /></td>
					</tr>
					<tr>
						<td>Phone Number:</td>
						<td><form:input type="tel" path="phoneNumber" /></td>
					</tr>
					<tr>
						<td>Street:</td>
						<td><form:input path="streetName" /></td>
					</tr>
					<tr>
						<td>City:</td>
						<td><form:input path="cityName" /></td>
					</tr>
					<tr>
						<td>Postal Code:</td>
						<td><form:input path="postalCode" /></td>
					</tr>
					<tr>
						<td>First Visit Date:</td>
						<td><form:input path="firstVisitDate" /></td>
					</tr>
					<tr>
						<td>Last Visit Date:</td>
						<td><form:input path="lastVisitDate" /></td>
					</tr>
					<tr>
						<td>Is Insurance:</td>
						<td><form:checkbox path ="isInsurance" /></td>
					</tr>
					<tr>
						<td>Doctor ID:</td>
						<td><select name="doctorId">
							<c:forEach var="theDoctor" items="${ allDoctorsList }">
								<option value="${theDoctor.doctorId}""> ${ theDoctor.doctorId} - ${ theDoctor.firstName } ${ theDoctor.lastName }</option>
							</c:forEach>
						</select></td>
					</tr>

					<tr>
						<td></td>
						<td><input type="submit" value="Save" class="button"></td>
					</tr>
				</table>

			</form:form>

			<table>
				<tr>
					<td></td>
					<td>
						<form
							action="${ pageContext.request.contextPath }/patient/showAllPatients"
							method="GET">
							<input type="submit" value="Back" class="button">
						</form>
					</td>
				</tr>
			</table>

		</div>

	</div>


</body>
</html>