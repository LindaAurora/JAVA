package com.pokedex.pokedexdemo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PokemonErrorRespuesta {

    private int status;
    private String message;
    private long timeStamp;

}
