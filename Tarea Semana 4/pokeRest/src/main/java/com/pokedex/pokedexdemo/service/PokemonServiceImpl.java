package com.pokedex.pokedexdemo.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pokedex.pokedexdemo.entity.Pokemon;

@Service
public class PokemonServiceImpl implements PokemonService {

	private RestTemplate restTemplate;
	private String crmRestUrl;
	private Logger logger = Logger.getLogger(getClass().getName());

	@Autowired
	public PokemonServiceImpl(RestTemplate theRestTemplate, @Value("${crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
		logger.info("Loaded property: crm.rest.url=" + crmRestUrl);
	}

	@Override
	public List<Pokemon> getPokemons() {

		logger.info("in getPokemons(): Calling REST API " + crmRestUrl);

		// make REST call

		ResponseEntity<List<Pokemon>> responseEntity = restTemplate.exchange(crmRestUrl, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Pokemon>>() {
				});

		// get the list of pokemons from response

		List<Pokemon> pokemons = responseEntity.getBody();

		logger.info("in getPokemons(): pokemons" + pokemons);

		return pokemons;

	}

	@Override
	public void savePokemon(Pokemon thePokemon) {

		logger.info("in savePokemon(): Calling REST API " + crmRestUrl);

		int employeeId = thePokemon.getId();
		// make REST call

		if (employeeId == 0) {
			// add employee
			restTemplate.postForEntity(crmRestUrl, thePokemon, String.class);
		} else {
			// update employee 
			restTemplate.put(crmRestUrl, thePokemon);
		}

		logger.info("in savePokemon(): success");

	}

	@Override
	public Pokemon getPokemon(int theId) {

		logger.info("in getPokemon(): Calling REST API " + crmRestUrl);

		// make REST call

		Pokemon thePokemon = restTemplate.getForObject(crmRestUrl + "/" + theId, Pokemon.class);

		logger.info("in savePokemon(): thePokemon=" + thePokemon);

		return thePokemon;
	}

	@Override
	public void deletePokemon(int theId) {
		
		logger.info("in deletePokemon(): Calling REST API " + crmRestUrl);

		// make REST call
		
		System.out.println("ACEITUNA");
		System.out.println(crmRestUrl + "/" + theId);

		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deletePokemon(): deleted pokemon theId="+ theId);

	}
}
