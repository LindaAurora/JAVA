package com.pokedex.pokedexdemo.service;

import com.pokedex.pokedexdemo.dao.PokemonDAO;
import com.pokedex.pokedexdemo.entity.Pokemon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PokemonServiceImpl implements PokemonService {

    @Autowired
    //@Qualifier("pokemonDAOJpa")
    @Qualifier("pokemonDAOjdbc")
    //@Qualifier("pokemonDAOHibernate")
    private PokemonDAO pokemonDAO;

    @Override
    @Transactional
    public List<Pokemon> getPokemons() {
        return pokemonDAO.getPokemons();
    }

    @Override
    @Transactional
    public Pokemon savePokemon(Pokemon thePokemon) {
        Pokemon pokemon = pokemonDAO.savePokemon(thePokemon);
        return pokemon;
    }

    @Override
    @Transactional
    public Pokemon getPokemon(int theId) {

        return pokemonDAO.getPokemon(theId);
    }

    @Override
    @Transactional
    public void deletePokemon(int theId) {

        pokemonDAO.deletePokemon(theId);
    }
}





