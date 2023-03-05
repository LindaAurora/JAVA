<!DOCTYPE html>
<html>

<head>
	<title>Add coffee</title>

	<link type="text/css" rel="stylesheet" href="css/style.css">
	<link type="text/css" rel="stylesheet" href="css/add-student-style.css">	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Ethereal Coffee</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Add coffee</h3>
		
		<form action="CoffeeControllerServlet" method="GET">
		
			<input type="hidden" name="command" value="ADD" />
			
			<table>
				<tbody>
					<tr>
						<td><label>Bebida:</label></td>
						<td><input type="text" name="name" /></td>
					</tr>

					<tr>
						<td><label>Topping:</label></td>
						<td><input type="text" name="toppings" /></td>
					</tr>

					<tr>
						<td><label>Precio:</label></td>
						<td><input type="text" name="price" /></td>
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











