package com.example.guerra.Daos;

import com.example.guerra.Beans.Generos;
import com.example.guerra.Beans.Profesiones;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GenerosDao extends DaoBase{
    public ArrayList<Generos> obtenerListaGeneros() {
        ArrayList<Generos> listaGeneros = new ArrayList<>();

        try (Connection conn = getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Generos");) {

            while (rs.next()) {
                Generos genero = new Generos();

                genero.setGeneroId(rs.getInt(1));
                genero.setGeneroNombre(rs.getInt(2));


                listaGeneros.add(genero);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaGeneros;

    }
}
