package com.pokedex.pokedexdemo.pokemon;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pokedex.pokedexdemo.entity.Pokemon;
import com.pokedex.pokedexdemo.service.PokemonService;

@Controller
@RequestMapping("/pokemon")
public class PokemonController {

	// need to inject our pokemon service
	@Autowired
	private PokemonService pokemonService;
	
	@GetMapping("/list")
	public String listPokemons(Model theModel) {
		
		// get pokemons from the service
		List<Pokemon> thePokemons = pokemonService.getPokemons();
				
		// add the pokemons to the model
		theModel.addAttribute("pokemons", thePokemons);
		
		return "list-pokemons";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Pokemon thePokemon = new Pokemon();
		
		theModel.addAttribute("pokemon", thePokemon);
		
		return "pokemon-form";
	}
	
	@PostMapping("/savePokemon")
	public String savePokemon(@ModelAttribute("pokemon") Pokemon thePokemon) {
		
		// save the pokemon using our service
		pokemonService.savePokemon(thePokemon);
		
		return "redirect:/pokemon/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("pokemonId") int theId,
									Model theModel) {
		
		// get the pokemon from our service
		Pokemon thePokemon = pokemonService.getPokemon(theId);
		
		// set pokemon as a model attribute to pre-populate the form
		theModel.addAttribute("pokemon", thePokemon);
		
		// send over to our form		
		return "pokemon-form";
	}
	
	@GetMapping("/delete")
	public String deletePokemon(@RequestParam("pokemonId") int theId) {
		System.out.println(theId);
		
		// delete the pokemon
		pokemonService.deletePokemon(theId);
		
		return "redirect:/pokemon/list";
	}
}










