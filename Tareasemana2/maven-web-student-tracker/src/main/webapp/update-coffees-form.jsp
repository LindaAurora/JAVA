<!DOCTYPE html>
<html>

<head>
	<title>Actualizar Cafes</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-coffees-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Ethereal Coffee</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Update Coffee</h3>
		
		<form action="CoffeeControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="UPDATE" />

			<input type="hidden" name="coffeeId" value="${THE_COFFEE.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Name:</label></td>
						<td><input type="text" name="name" 
								   value="${THE_STUDENT.firstName}" /></td>
					</tr>

					<tr>
						<td><label>Toppings:</label></td>
						<td><input type="text" name="toppings" 
								   value="${THE_STUDENT.lastName}" /></td>
					</tr>

					<tr>
						<td><label>Price:</label></td>
						<td><input type="text" name="price" 
								   value="${THE_STUDENT.email}" /></td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form>
		
		<div style="clear: both;"></div>
		
		<p>
			<a href="CoffeeControllerServlet">Back to List</a>
		</p>
	</div>
</body>

</html>











