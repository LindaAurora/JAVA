import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { Pokemon } from 'src/app/models/pokemon';
import { environment } from 'src/environments/environment.prod';

@Injectable({
  providedIn: 'root'
})
export class SearchPokemonService {
  apiUrl = `${environment.apiUrl}/rest`;

  constructor(
    private http: HttpClient,
  ) { }

  getPokemon(id: string): Observable<Pokemon> {
    const headers = this.getHeader();
    return this.http.get<Pokemon>(`${this.apiUrl}/pokemons/${id}`, headers)
      .pipe(
        map((res: Pokemon) => {
          return res
        })
      )
  }

  savePokemon(
    pokemon: Pokemon
  ): Observable<Pokemon> {
    return this.http.post<Pokemon>(`${this.apiUrl}/pokemons`, pokemon);
  }

  updatePokemon(
    pokemon: Pokemon
  ): Observable<Pokemon> {
    return this.http.put<Pokemon>(`${this.apiUrl}/pokemons`, pokemon);
  }

  deletePokemon(id: number) {
    return this.http.delete<Pokemon>(`${this.apiUrl}/pokemons/${id}`);
  }

  private getHeader(): Object {
    const headers = new HttpHeaders()
    headers.append('Content-Type', 'application/json');
    headers.append('Access-Control-Allow-Origin', '*');
    return headers;
  }
}
