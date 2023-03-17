package com.pokedex.pokedexdemo.dao;

import java.util.List;

import com.pokedex.pokedexdemo.entity.Pokemon;

public interface PokemonDAO {

    public List<Pokemon> getPokemons();

    abstract Pokemon savePokemon(Pokemon thePokemon);

    public Pokemon getPokemon(int theId);

    public void deletePokemon(int theId);

}
