<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Hogwarts</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Registro de estudiantes Hogwarts</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Add Student"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Edad</th>
					<th>Varita</th>
					<th>Casa</th>
					<th>Patronus</th>
					<th>Varita</th>
					<th>Mascota</th>
					<th>Foto</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempCustomer" items="${hogwarts}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/Hogwarts/showFormForUpdate">
						<c:param name="HogwartsId" value="${tempCustomer.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/Hogwarts/delete">
						<c:param name="HogwartsId" value="${tempCustomer.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempCustomer.nombre} </td>
						<td> ${tempCustomer.edad} </td>
						<td> ${tempCustomer.varita} </td>
						<td> ${tempCustomer.casa} </td>
						<td> ${tempCustomer.patronus} </td>
						<td> ${tempCustomer.varita} </td>
						<td> ${tempCustomer.mascota} </td>
						<td id="imagen"><img src="${tempCustomer.foto}" alt="Customer image"
						style="width: 100px;"> </td>
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('¿Quieres borrar a este estudiante?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>

