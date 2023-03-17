package com.pokedex.pokedexdemo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pokedex.pokedexdemo.entity.Pokemon;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class PokemonDAOJpa implements PokemonDAO {

    // define field for entitymanager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public PokemonDAOJpa(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }


    @Override
    public List<Pokemon> getPokemons() {
        // create a query
        TypedQuery<Pokemon> theQuery = entityManager.createQuery("from Pokemon order by nopokedex", Pokemon.class);

        // execute query and get result list
        List<Pokemon> pokemons = theQuery.getResultList();

        // return the results
        return pokemons;
    }

    @Override
    public Pokemon savePokemon(Pokemon thePokemon) {
        Pokemon pokemon = entityManager.merge(thePokemon);
        return pokemon;
    }

    @Override
    public Pokemon getPokemon(int theId) {
        Pokemon thePokemon = entityManager.find(Pokemon.class, theId);
        return thePokemon;
    }

    @Override
    public void deletePokemon(int theId) {
        Pokemon thePokemon = entityManager.find(Pokemon.class, theId);
        entityManager.remove(thePokemon);

    }

}
