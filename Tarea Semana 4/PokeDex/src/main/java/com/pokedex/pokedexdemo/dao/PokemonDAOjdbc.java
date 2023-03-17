package com.pokedex.pokedexdemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pokedex.pokedexdemo.entity.Pokemon;




@Repository
public class PokemonDAOjdbc implements PokemonDAO {

    @Autowired
    DataSource dataSource;

    @Override
    public List<Pokemon> getPokemons() {

        System.out.println("PASO POR PokemonDAOJdbc");
        List<Pokemon> pokemons = new ArrayList<>();

        // create sql statement
        String sql = "select * from pokemons order by nopokedex";

        try (Connection myConn = dataSource.getConnection();
             Statement myStmt = myConn.createStatement();
             ResultSet myRs = myStmt.executeQuery(sql)) {

            // process result set
            while (myRs.next()) {

                // retrieve data from result set row
                int id = myRs.getInt("id");
                String nopokedex = myRs.getString("nopokedex");
                String pokemon = myRs.getString("pokemon");
                String tipo = myRs.getString("tipo");
                String imagen = myRs.getString("imagen");

                // create new student object
                Pokemon tempPokemon = new Pokemon(id, nopokedex, pokemon, tipo, imagen);

                // add it to the list of students
                pokemons.add(tempPokemon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pokemons;

    }

   /* @Override
    public List<Pokemon> getPokemon() {
        return null;
    }*/

    @Override
    public Pokemon savePokemon(Pokemon thePokemon) {

        String sql = null;
        if(thePokemon.getId() == 0)
            sql = "insert into pokemons " + "(nopokedex, pokemon, tipo, imagen) " + "values (?, ?, ?, ?)";
        else
            sql = "update pokemons " + "set nopokedex=?, pokemon=?, tipo=?, imagen=? " + "where id=?";

        try (Connection myConn = dataSource.getConnection();
             PreparedStatement ps = myConn.prepareStatement(sql)) {

            ps.setString(1, thePokemon.getNopokedex());
            ps.setString(2, thePokemon.getPokemon());
            ps.setString(3, thePokemon.getTipo());
            ps.setString(4, thePokemon.getImagen());

            //id para where del update
            if(thePokemon.getId() != 0)
                ps.setInt(5, thePokemon.getId());

            ps.execute();

        }catch (SQLException e){
            e.printStackTrace();
        }

        return thePokemon;

    }

    @Override
    public Pokemon getPokemon(int theId) {
        Pokemon thePokemon = null;

        try (Connection myConn = dataSource.getConnection();
             PreparedStatement myStmt = crearStatementGetPokemon(myConn, theId);
             ResultSet myRs = myStmt.executeQuery()) {

            // retrieve data from result set row
            if (myRs.next()) {
                String nopokedex = myRs.getString("nopokedex");
                String pokemon = myRs.getString("pokemon");
                String tipo = myRs.getString("tipo");
                String imagen = myRs.getString("imagen");

                // use the studentId during construction
                thePokemon = new Pokemon(theId, nopokedex, pokemon, tipo, imagen);
            } else {
                System.out.println("Could not find pokemon id: " + theId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return thePokemon;
    }

    private PreparedStatement crearStatementGetPokemon(Connection myConn, int pokemonId) throws SQLException {
        String sql = "select * from pokemons where id=?";
        PreparedStatement ps = myConn.prepareStatement(sql);
        ps.setInt(1, pokemonId);
        return ps;
    }

    @Override
    public void deletePokemon(int theId) {

        // create sql to delete student
        String sql = "delete from pokemons where id=?";

        try (Connection myConn = dataSource.getConnection();
             PreparedStatement myStmt = myConn.prepareStatement(sql);) {

            // set params
            myStmt.setInt(1, theId);

            // execute sql statement
            myStmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
