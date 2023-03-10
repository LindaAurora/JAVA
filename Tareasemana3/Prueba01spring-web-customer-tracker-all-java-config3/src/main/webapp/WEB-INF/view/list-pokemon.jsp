<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Pokemons</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>POKEDEX</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Customer -->
		
			<input type="button" value="Add Pokemon"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"/>
				   
			
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Tipo</th>
					<th>Imagen</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="tempPokemon" items="${pokemon}">
				
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/pokemon/showFormForUpdate">
						<c:param name="pokemonId" value="${tempPokemon.id}" />
					</c:url>					

					<!-- construct an "delete" link with customer id -->
					<c:url var="deleteLink" value="/pokemon/delete">
						<c:param name="pokemonId" value="${tempPokemon.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempPokemon.numero} </td>
						<td> ${tempPokemon.nombre} </td>
						<td> ${tempPokemon.tipo} </td>
						<td id="imagen"><img src="${tempPokemon.foto}" alt="Pokemon image"
						style="width: 100px;"></td>
						
						
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('Are you sure you want to delete this pokemon?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









