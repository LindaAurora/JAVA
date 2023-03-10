<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Pokemon</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>POKEDEX</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save</h3>
	
		<form:form action="savePokemon" modelAttribute="pokemon" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>ID:</label></td>
						<td><form:input path="numero" /></td>
					</tr>
				
					<tr>
						<td><label>Nombre:</label></td>
						<td><form:input path="nombre" /></td>
					</tr>

					<tr>
						<td><label>Tipo:</label></td>
						<td><form:input path="tipo" /></td>
					</tr>
					
					<tr>
						<td><label>Imagen:</label></td>
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
			<a href="${pageContext.request.contextPath}/pokemon/list">Back to List</a>
		</p>
	
	</div>

</body>

</html>










