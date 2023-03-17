package com.pokedex.pokedexdemo.service;

import java.util.List;

import com.pokedex.pokedexdemo.entity.Pokemon;

public interface PokemonService {

    public List<Pokemon> getPokemons();

    public Pokemon savePokemon(Pokemon thePokemon);

    public Pokemon getPokemon(int theId);

    public void deletePokemon(int theId);

}
