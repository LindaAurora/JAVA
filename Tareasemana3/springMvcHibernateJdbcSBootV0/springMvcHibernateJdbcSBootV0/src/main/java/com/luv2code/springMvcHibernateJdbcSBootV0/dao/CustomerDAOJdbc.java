package com.luv2code.springMvcHibernateJdbcSBootV0.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.luv2code.springMvcHibernateJdbcSBootV0.entity.Hogwarts;

@Repository


public class CustomerDAOJdbc implements CustomerDAO {

	@Autowired
	DataSource dataSource;

	@Override
	public List<Hogwarts> getHogwarts() {

		System.out.println("PASO POR CustomerDAOJdbc");
		List<Hogwarts> Hogwarts = new ArrayList<>();

		// create sql statement
		String sql = "select * from hogwarts order by Nombre";

		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql)) {

			// process result set
			while (myRs.next()) {

				// retrieve data from result set row
				int id = myRs.getInt("id");
				String name = myRs.getString("Nombre");
				String age = myRs.getString("Edad");
				String house = myRs.getString("Casa");
				String patronus = myRs.getString("Patronus");
				String wand = myRs.getString("Varita");
				String pet = myRs.getString("Mascota");
				String photo = myRs.getString("Foto");

				// create new student object
				Hogwarts tempHogwarts = new Hogwarts(id, name, age, house, patronus, wand, pet, photo);

				// add it to the list of students
				Hogwarts.add(tempHogwarts);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Hogwarts;

	}

	@Override
	public void saveHogwarts(Hogwarts theHogwarts) {
		
		String sql = null;
		if(theHogwarts.getId() == 0)
			sql = "insert into hogwarts " + "(nombre, edad, casa, patronus, varita, mascota, foto) " + "values (?, ?, ?, ?, ?, ?, ?)";
		else
			sql = "update hogwarts " + "set nombre=?, edad=?, casa=?, patronus=?, varita=?, mascota=?, foto =?" + "where id=?";

		try (Connection myConn = dataSource.getConnection(); 
			PreparedStatement ps = myConn.prepareStatement(sql)) {

			ps.setString(1, theHogwarts.getNombre());
			ps.setString(2, theHogwarts.getEdad());
			ps.setString(3, theHogwarts.getCasa());
			ps.setString(4, theHogwarts.getPatronus());
			ps.setString(5, theHogwarts.getVarita());
			ps.setString(6, theHogwarts.getMascota());
			ps.setString(7, theHogwarts.getFoto());
			
			//id para where del update
			if(theHogwarts.getId() != 0)
				ps.setInt(8, theHogwarts.getId());

			ps.execute();
			
		}catch (SQLException e){
			e.printStackTrace();
		}

	}

	@Override
	public Hogwarts getHogwarts(int theId) {
		Hogwarts theHogwarts = null;

		try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = crearStatementGetCustomer(myConn, theId);
				ResultSet myRs = myStmt.executeQuery()) {

			// retrieve data from result set row
			if (myRs.next()) {
				String name = myRs.getString("Nombre");
				String age = myRs.getString("Edad");
				String house = myRs.getString("Casa");
				String patronus = myRs.getString("Patronus");
				String wand = myRs.getString("Varita");
				String pet = myRs.getString("Mascota");
				String photo = myRs.getString("Foto");

				// use the studentId during construction
				theHogwarts = new Hogwarts(theId, name, age, house, patronus, wand, pet, photo);
			} else {
				System.out.println("Could not find customer id: " + theId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return theHogwarts;
	}

	private PreparedStatement crearStatementGetCustomer(Connection myConn, int customerId) throws SQLException {
		String sql = "select * from hogwarts where id=?";
		PreparedStatement ps = myConn.prepareStatement(sql);
		ps.setInt(1, customerId);
		return ps;
	}

	@Override
	public void deleteHogwarts(int theId) {

		// create sql to delete student
		String sql = "delete from hogwarts where id=?";

		try (Connection myConn = dataSource.getConnection(); 
				PreparedStatement myStmt = myConn.prepareStatement(sql);) {

			// set params
			myStmt.setInt(1, theId);

			// execute sql statement
			myStmt.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
