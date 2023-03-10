
package pokemonlambdas;

import java.util.Arrays;
import java.util.function.Predicate;

import java.util.Arrays;
import java.util.function.Predicate;

public class LambdaPokemon {
    public static void main(String[] args) {

        // Creamos varios objetos de la clase Pokemon con diferentes atributos
        Pokemon lunala = new Pokemon("Lunala", "Psiquico", 7898, 6985);
        Pokemon mimikyu = new Pokemon("Mimikyu", "Fantasma", 852, 4565);
        Pokemon spectrier = new Pokemon("Spectrier", "Fantasma", 2345, 3223);
        Pokemon ninetalesAlola = new Pokemon("Ninetales Alola", "Hielo", 8699, 9885);
        Pokemon sylveon = new Pokemon("Sylveon", "Hada", 2589, 9636);
        Pokemon darkrai = new Pokemon("Darkrai", "Siniestro", 1002, 7585);
        Pokemon giratina = new Pokemon("Giratina", "Dragon, Fantasma", 4568, 6525);
        Pokemon mismagius = new Pokemon("Mismagius", "Fantasma", 2365, 2562);
        Pokemon dragalge = new Pokemon("Dragalge", "Dragon, Veneno", 8856, 4525);
        Pokemon absol = new Pokemon("Absol", "Siniestro", 8525, 1474);

        // Creamos un array de Pokemon que contiene todos los objetos Pokemon creados anteriormente
        Pokemon[] pokemonNivel = {lunala, mimikyu, spectrier, ninetalesAlola, sylveon, darkrai, giratina, mismagius, dragalge, absol};

        // Ordenamos el array pokemonNivel por nivel, en orden descendente, utilizando una expresión lambda
        Arrays.sort(pokemonNivel, (p1, p2) -> p2.getNivel() - p1.getNivel());

        // Imprimimos en la consola todos los Pokemon ordenados por nivel
        System.out.println("POKEMON ORDENADOS POR NIVEL MAS ALTO:");
        Arrays.stream(pokemonNivel).forEach(System.out::println);

        // Filtramos el array pokemonNivel para obtener todos los Pokemon que tienen el tipo "Fantasma", utilizando una expresión lambda
        String tipo = "FANTASMA";
        Predicate<Pokemon> typeFilter = p -> p.getTipo().equals(tipo);
        Pokemon[] fantasmaPokemon = Arrays.stream(pokemonNivel).filter(typeFilter).toArray(Pokemon[]::new);

        // Imprimimos en la consola todos los Pokemon que tienen el tipo "Fantasma"
        System.out.println("POKEMONS TIPO  " + tipo + ":");
        Arrays.stream(fantasmaPokemon).forEach(System.out::println);

        // Filtramos el array pokemonNivel para obtener todos los Pokemon que tienen una defensa mayor a un valor máximo, utilizando una expresión lambda
        int defensaMax = 5000;
        Predicate<Pokemon> defensaFilter = p -> p.getDefensa() > defensaMax;
        Pokemon[] defensaPokemon = Arrays.stream(pokemonNivel).filter(defensaFilter).toArray(Pokemon[]::new);

        // Imprimimos en la consola todos los Pokemon que tienen una defensa mayor a un valor máximo
        System.out.println("POKEMON CON DEFENSA MAYOR A " + defensaMax + ":");
        Arrays.stream(defensaPokemon).forEach(System.out::println);
           
        // Encontrar el Pokemon con la menor defensa
        int defensaMinima = Arrays.stream(pokemonNivel)
                                  .mapToInt(Pokemon::getDefensa)
                                  .min()
                                  .orElse(0);
        
        // Filtrar los Pokemon con defensa menor o igual que la defensa minima
        Pokemon[] defensaBajaPokemon = Arrays.stream(pokemonNivel)
                                             .filter(p -> p.getDefensa() <= defensaMinima)
                                             .toArray(Pokemon[]::new);
        
        System.out.println("POKEMON CON DEFENSA MENOR A" + defensaMinima + ":");
        Arrays.stream(defensaBajaPokemon).forEach(System.out::println);
    }
}




