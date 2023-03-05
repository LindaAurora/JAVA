package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/CoffeeControllerServlet")
public class CoffeeControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private CoffeeDbUtil  coffeeDbUtil;
	//private StudentDbDummy studentDbUtil;
	
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		// create our student db util ... and pass in the conn pool / datasource
		try {
			coffeeDbUtil = new CoffeeDbUtil(dataSource);
			
			//studentDbUtil = new StudentDbDummy();
			
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			// read the "command" parameter
			String theCommand = request.getParameter("command");
			System.out.println("theCommand: " + theCommand);
			
			// if the command is missing, then default to listing students
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listCoffees(request, response);
				break;
				
			case "ADD":
				addCoffee(request, response);
				break;
				
			case "LOAD":
				loadCoffee(request, response);
				break;
				
			case "UPDATE":
				updateCoffee(request, response);
				break;
			
			case "DELETE":
				deleteCoffee(request, response);
				break;
				
			default:
				listCoffees(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
		
	}

	private void deleteCoffee(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read coffee id from form data
		String theCoffeeId = request.getParameter("coffeeId");
		
		// delete coffee from database
		coffeeDbUtil.deleteCoffee(theCoffeeId);
		
		// send them back to "list coffee" page
		listCoffees(request, response);
	}

	private void updateCoffee(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		// read coffee info from form data
		int id = Integer.parseInt(request.getParameter("coffeeId"));
		String name = request.getParameter("name");
		String toppings= request.getParameter("toppings");
		String price = request.getParameter("price");
		
		// create a new coffee object
		Coffee theCoffee = new Coffee(id, name, toppings, price);
		
		// perform update on database
		coffeeDbUtil.updateCoffee(theCoffee);
		
		// send them back to the "list coffees" page
		listCoffees(request, response);
		
	}

	private void loadCoffee(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {

		// read coffee id from form data
		String theCoffeeId = request.getParameter("coffeeId");
		
		// get coffee from database (db util)
		Coffee theCoffee = coffeeDbUtil.getCoffee(theCoffeeId);
		
		// place coffee in the request attribute
		request.setAttribute("THE_COFFEE", theCoffee);
		
		// send to jsp page: update-coffee-form.jsp
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("/update-coffees-form.jsp");
		dispatcher.forward(request, response);		
	}

	private void addCoffee(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read coffee info from form data
		String name = request.getParameter("name");
		String toppings = request.getParameter("toppings");
		String price = request.getParameter("price");		
		
		// create a new coffee object
		Coffee theCoffee = new Coffee(name, toppings, price);
		
		// add the coffee to the database
		coffeeDbUtil.addCoffee(theCoffee);
				
		// send back to main page (the coffee list)
		listCoffees(request, response);
	}

	private void listCoffees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// get coffees from db util
		List<Coffee> coffees = coffeeDbUtil.getCoffees();
		
		// add coffees to the request
		request.setAttribute("LISTA_CAFES", coffees);
				
		// send to JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-coffees.jsp");
		dispatcher.forward(request, response);
	}

}













