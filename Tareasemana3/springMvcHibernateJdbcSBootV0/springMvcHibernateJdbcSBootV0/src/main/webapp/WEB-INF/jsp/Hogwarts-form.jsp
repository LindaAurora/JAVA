<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Registro de estudiante</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save</h3>
	
		<form:form action="saveHogwarts" modelAttribute="Hogwarts" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Nombre</label></td>
						<td><form:input path="nombre" /></td>
					</tr>
				
					<tr>
						<td><label>Edad</label></td>
						<td><form:input path="edad" /></td>
					</tr>

					<tr>
						<td><label>Casa</label></td>
						<td><form:input path="casa" /></td>
					</tr>
					
					<tr>
						<td><label>Patronus</label></td>
						<td><form:input path="patronus" /></td>
					</tr>
	<tr>
						<td><label>Varita</label></td>
						<td><form:input path="varita" /></td>
					</tr>
						<tr>
						<td><label>Mascota</label></td>
						<td><form:input path="mascota" /></td>
					</tr>
						<tr>
						<td><label>Foto</label></td>
						<td><form:input path="foto" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/Hogwarts/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>










