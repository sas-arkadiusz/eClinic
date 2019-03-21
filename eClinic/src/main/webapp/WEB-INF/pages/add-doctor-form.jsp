<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!-- Spring MVC support for forms -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Doctor</title>
<link type="text/css" rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/style.css">
<link type="text/css" rel="stylesheet"
	href="${ pageContext.request.contextPath }/resources/css/add-doctor.css">
</head>

<body>

	<div class="container">

		<div class="header">
			<h3>eClinic - Employed Doctors Manager</h3>
		</div>

		<div class="adding_form">

			<form:form action="saveNewDoctor" modelAttribute="addDoctor"
				method="POST">
				
				<form:hidden path="doctorId" />

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
						<td>Salary:</td>
						<td><form:input path="salary" /></td>
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
						<form action="${ pageContext.request.contextPath }/doctor/showAllDoctors" method="GET">
							<input type="submit" value="Back" class="button">
						</form>
					</td>
				</tr>
			</table>

		</div>

	</div>


</body>
</html>