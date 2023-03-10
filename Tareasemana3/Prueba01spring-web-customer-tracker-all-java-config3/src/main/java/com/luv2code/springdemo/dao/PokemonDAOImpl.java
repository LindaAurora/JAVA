package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Pokemon;

@Repository
public class PokemonDAOImpl implements PokemonDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Pokemon> getPokemon() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Pokemon> theQuery = 
				currentSession.createQuery("from Pokemon order by numero",
											Pokemon.class);
		
		// execute query and get result list
		List<Pokemon> pokemon = theQuery.getResultList();
				
		// return the results		
		return pokemon;
	}

	@Override
	public void savePokemon(Pokemon thePokemon) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(thePokemon);
		
	}

	@Override
	public Pokemon getPokemon(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Pokemon thePokemon = currentSession.get(Pokemon.class, theId);
		
		return thePokemon;
	}

	@Override
	public void deletePokemon(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Pokemon where id=:pokemonid");
		theQuery.setParameter("pokemonid", theId);
		
		theQuery.executeUpdate();		
	}

}












