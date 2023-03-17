package com.pokedex.pokedexdemo.controller;

import com.pokedex.pokedexdemo.entity.Pokemon;
import com.pokedex.pokedexdemo.service.PokemonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class PokemonController {

    // need to inject our pokemon service
    @Autowired
    private PokemonService pokemonService;

    @GetMapping("/pokemons")
    @CrossOrigin(origins="*")
    public List<Pokemon> findAll() {
        return pokemonService.getPokemons();
    }

    @GetMapping("/pokemons/{pokemonId}")
    @CrossOrigin(origins="*")
    public Pokemon getPokemon(@PathVariable int pokemonId) throws Exception {

        Pokemon thePokemon = pokemonService.getPokemon(pokemonId);

        if (thePokemon == null) {
            throw new PokemonNoEncontradoExcepcion("Pokemon id not found - " + pokemonId);
        }

        return thePokemon;
    }

    @PostMapping("/pokemons")
    @CrossOrigin(origins="*")
    public Pokemon addPokemon(@RequestBody Pokemon thePokemon) {

        thePokemon.setId(0);

        Pokemon addPokemon = pokemonService.savePokemon(thePokemon);

        return addPokemon;
    }

    @PutMapping("/pokemons")
    @CrossOrigin(origins="*")
    public Pokemon updatePokemon(@RequestBody Pokemon thePokemon) {

        Pokemon Pokemon = pokemonService.savePokemon(thePokemon);

        return Pokemon;
    }

    @DeleteMapping("/pokemons/{pokemonId}")
    @CrossOrigin(origins="*")
    public String deletePokemon(@PathVariable int pokemonId) {

        Pokemon tempEmployee = pokemonService.getPokemon(pokemonId);

        if (tempEmployee == null) {
            throw new PokemonNoEncontradoExcepcion("Pokemon id not found - " + pokemonId);
        }

        pokemonService.deletePokemon(pokemonId);

        return "Deleted pokemon id - " + pokemonId;
    }


}










