package com.pokedex.pokedexdemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pokedex.pokedexdemo.entity.Pokemon;

import javax.persistence.EntityManager;



@Repository
public class PokemonDAOHibernate implements PokemonDAO {

    // define field for entitymanager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public PokemonDAOHibernate(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Pokemon> getPokemons() {

        System.out.println("PASO POR PokemonDAOHibernate");

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query ... sort by last name
        Query<Pokemon> theQuery = currentSession.createQuery("from Pokemon order by nopokedex", Pokemon.class);

        // execute query and get result list
        List<Pokemon> pokemons = theQuery.getResultList();

        // return the results
        return pokemons;
    }

    @Override
    public Pokemon savePokemon(Pokemon thePokemon) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save/upate the customer ... finally LOL
        currentSession.saveOrUpdate(thePokemon);

        return thePokemon;

    }

    @Override
    public Pokemon getPokemon(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // now retrieve/read from database using the primary key
        Pokemon thePokemon = currentSession.get(Pokemon.class, theId);

        return thePokemon;
    }

    @Override
    public void deletePokemon(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery = currentSession.createQuery("delete from Pokemon where id=:pokemonId");
        theQuery.setParameter("pokemonId", theId);

        theQuery.executeUpdate();
    }
}