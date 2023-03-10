package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Pokemon;

public interface PokemonDAO {

	public List<Pokemon> getPokemon();

	public void savePokemon(Pokemon thePokemon);

	public Pokemon getPokemon(int theId);

	public void deletePokemon(int theId);
	
}
