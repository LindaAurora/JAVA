package com.pokedex.pokedexdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pokemons")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nopokedex")
    private String nopokedex;

    @Column(name = "pokemon")
    private String pokemon;

    @Column(name = "tipo")
    private String tipo;

    @Column(name = "imagen")
    private String imagen;


}





