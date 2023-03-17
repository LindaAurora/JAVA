<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Pokemons</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Poke - Pokemon Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- put new button: Add Pokemon -->
		
			<input type="button" value="Add Pokemon"
				   onclick="window.location.href='showFormForAdd'; return false;"
				   class="add-button"
			/>
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>No Pokedex</th>
					<th>Pokemon</th>
					<th>Tipo</th>
					<th>Imagen</th>
					<th>Action</th>
				</tr>
				
				<!-- loop over and print our pokemons -->
				<c:forEach var="tempPokemon" items="${pokemons}">
				
					<!-- construct an "update" link with pokemon id -->
					<c:url var="updateLink" value="/pokemon/showFormForUpdate">
						<c:param name="pokemonId" value="${tempPokemon.id}" />
					</c:url>					

					<!-- construct an "delete" link with pokemon id -->
					<c:url var="deleteLink" value="/pokemon/delete">
						<c:param name="pokemonId" value="${tempPokemon.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempPokemon.nopokedex} </td>
						<td> ${tempPokemon.pokemon} </td>
						<td> ${tempPokemon.tipo} </td>
						<td><img src="${tempPokemon.imagen}" alt="image"
											 style="width: 100px;"> </td>
						
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









