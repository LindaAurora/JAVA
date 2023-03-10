package com.luv2code.springMvcHibernateJdbcSBootV0.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.luv2code.springMvcHibernateJdbcSBootV0.entity.Hogwarts;

@Repository
@Primary

public class CustomerDAOImpl implements CustomerDAO {

	// define field for entitymanager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public CustomerDAOImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Hogwarts> getHogwarts() {
		
		System.out.println("PASO POR CustomerDAOHibernate");
		
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query ... sort by last name
		Query<Hogwarts> theQuery = currentSession.createQuery("from Hogwarts order by Nombre", Hogwarts.class);

		// execute query and get result list
		List<Hogwarts> Hogwarts = theQuery.getResultList();

		// return the results
		return Hogwarts;
	}

	@Override
	public void saveHogwarts(Hogwarts theHogwarts) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theHogwarts);

	}

	@Override
	public Hogwarts getHogwarts(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// now retrieve/read from database using the primary key
		Hogwarts theHogwarts = currentSession.get(Hogwarts.class, theId);

		return theHogwarts;
	}

	@Override
	public void deleteHogwarts(int theId) {

		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// delete object with primary key
		Query theQuery = currentSession.createQuery("delete from Hogwarts where id=:HogwartsId");
		theQuery.setParameter("HogwartsId", theId);

		theQuery.executeUpdate();
	}

}
