import { Component, OnInit } from '@angular/core';
import { Pokemon } from '../models/pokemon';
import { SearchPokemonService } from './search/search-pokemon.service';

@Component({
  selector: 'app-pokedex',
  templateUrl: './pokedex.component.html',
  styleUrls: ['./pokedex.component.css']
})
export class PokedexComponent implements OnInit {
  currentPokemon: Pokemon;
  isEditing: boolean = false;
  isUpdating: boolean = false;
  isAdding: boolean = false;
  freePokemon: boolean = false;
  isPokemon: boolean = false;
  templatePokemon: Pokemon;
  id_input: string = '';

  constructor(
    private searchPokemonService: SearchPokemonService,
  ) {
    this.currentPokemon = this.setPokemon();
    this.templatePokemon = this.setPokemon();
  }

  ngOnInit(): void {
  }

  setPokemon(): Pokemon {
    var pokemon = {
      id: 0,
      pokemon: '-',
      nopokedex: '0000',
      tipo: '-',
      imagen: ''
    }
    return pokemon;
  }

  editPokemon(btn: string): void {
    this.isEditing = true;
    if (btn == 'update') {
      this.templatePokemon = this.currentPokemon;
      this.isUpdating = true;
    }
    if (btn == 'add') {
      this.isAdding = true;
    }
  }

  cancelEditing(): void {
    this.isEditing = false;
    this.isUpdating = false;
    this.isAdding = false;
    this.freePokemon = false;
  }

  cleanSearch(): void {
    this.isPokemon = false;
    this.currentPokemon = this.setPokemon();
    this.templatePokemon = this.setPokemon();
  }

  freeingPokemon(): void {
    this.freePokemon = true;
  }

  getPokemon(): void {
    const id = this.id_input;
    this.searchPokemonService.getPokemon(id)
      .subscribe(res => {
        this.currentPokemon = res;
        console.log("final");
        console.log(this.currentPokemon);
        this.isPokemon = true;
      });
  }

  savePokemon(): void {
    console.log("save");
    this.searchPokemonService.savePokemon(
      this.templatePokemon
    )
      .subscribe(res => {
        this.currentPokemon = res;
        this.templatePokemon = this.setPokemon();
        this.cancelEditing();
      });
  }

  deletePokemon(): void {
    const name = this.currentPokemon.pokemon;
    const id = this.currentPokemon.id;

    this.searchPokemonService.deletePokemon(id)
      .subscribe(res => {
        this.currentPokemon = this.setPokemon();
        this.templatePokemon = this.setPokemon();
        this.cleanSearch();
        this.currentPokemon.pokemon = `¡Adiós, ${name}!`;
        this.cancelEditing();
      });
      this.currentPokemon = this.setPokemon();
      this.templatePokemon = this.setPokemon();
      this.cleanSearch();
      this.currentPokemon.pokemon = `¡Adiós, ${name}!`;
      this.cancelEditing();
  }

  updatePokemon(): void {
    console.log("update");
    this.searchPokemonService.updatePokemon(
      this.templatePokemon
    )
      .subscribe(res => {
        this.currentPokemon = res;
        this.templatePokemon = this.setPokemon();
        this.cancelEditing();
      });
  }

}
