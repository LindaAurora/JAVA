package com.pokedex.pokedexdemo.controller;

public class PokemonNoEncontradoExcepcion extends RuntimeException {

    public PokemonNoEncontradoExcepcion(String message) {
        super(message);
    }

}
