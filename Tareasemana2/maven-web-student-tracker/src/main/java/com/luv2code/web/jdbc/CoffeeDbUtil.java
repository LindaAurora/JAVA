package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class CoffeeDbUtil {

	private DataSource dataSource;

	public CoffeeDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	

	public List<Coffee> getCoffees(){

		List<Coffee> coffees = new ArrayList<>();

		// create sql statement
		String sql = "select * from coffee order by name";

		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql)) {

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String name = myRs.getString("name");
				String toppings = myRs.getString("toppings");
				String price = myRs.getString("price");

				// create new coffee object
				Coffee tempCoffee = new Coffee(id, name, toppings, price);

				// add it to the list of cofffee
				coffees.add(tempCoffee);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return coffees;

	}

	public void addCoffee(Coffee theCoffee) throws Exception {
		
		String sql = "insert into coffee " + "(name, toppings, price) " + "values (?, ?, ?)";

		try (Connection myConn = dataSource.getConnection(); PreparedStatement ps = myConn.prepareStatement(sql);) {

			ps.setString(1, theCoffee.getName());
			ps.setString(2, theCoffee.getToppings());
			ps.setString(3, theCoffee.getPrice());

			ps.execute();
		}
	}

// NO ES NECESARIO PORQUE NO SE UTILIZA UN TERCER RECURSO COMO EN getStudent
//	public void addStudent(Student theStudent) throws Exception {
//
//		try (Connection myConn = dataSource.getConnection();
//			 PreparedStatement ps = crearStatementAddStudent(myConn, theStudent);) {
//			
//			ps.execute();
//		}
//	}

//	private PreparedStatement crearStatementAddStudent(Connection myConn, Student theStudent) throws SQLException {
//		String sql = "insert into student " + "(first_name, last_name, email) " + "values (?, ?, ?)";
//		PreparedStatement ps = myConn.prepareStatement(sql);
//		// set the param values for the student
//		ps.setString(1, theStudent.getFirstName());
//		ps.setString(2, theStudent.getLastName());
//		ps.setString(3, theStudent.getEmail());
//		return ps;
//	}

	public Coffee getCoffee(String theCoffeeId) throws Exception {

		Coffee theCoffee = null;
		int coffeeId = Integer.parseInt(theCoffeeId);

		try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = crearStatementGetCoffee(myConn, coffeeId);
				ResultSet myRs = myStmt.executeQuery()) {

			// retrieve data from result set row
			if (myRs.next()) {
				String name = myRs.getString("name");
				String toppings = myRs.getString("toppings");
				String price = myRs.getString("price");

				// use the studentId during construction
				theCoffee = new Coffee(coffeeId, name, toppings, price);
			} else {
				throw new Exception("Could not find student id: " + coffeeId);
			}

			return theCoffee;
		}
	}

	private PreparedStatement crearStatementGetCoffee(Connection myConn, int coffeeId) throws SQLException {
		String sql = "select * from coffee where id=?";
		PreparedStatement ps = myConn.prepareStatement(sql);
		ps.setInt(1, coffeeId);
		return ps;
	}

	public void updateCoffee(Coffee theCoffee) throws Exception {

		// create SQL update statement
		String sql = "update coffee " + "set name=?, toppings=?, price=? " + "where id=?";

		try (Connection myConn = dataSource.getConnection();
			 PreparedStatement myStmt = myConn.prepareStatement(sql);) { 
			
			// set params
			myStmt.setString(1, theCoffee.getName());
			myStmt.setString(2, theCoffee.getToppings());
			myStmt.setString(3, theCoffee.getPrice());
			myStmt.setInt(4, theCoffee.getId());

			// execute SQL statement
			myStmt.execute();
		} 
	}

	public void deleteCoffee(String theCoffeeId) throws Exception {

		// create sql to delete student
		String sql = "delete from coffee where id=?";

		try (Connection myConn = dataSource.getConnection();
			 PreparedStatement myStmt = myConn.prepareStatement(sql);) {
			
			// convert coffee id to int
			int coffeeId = Integer.parseInt(theCoffeeId);

			// set params
			myStmt.setInt(1, coffeeId);

			// execute sql statement
			myStmt.execute();
		} 
	}
}
