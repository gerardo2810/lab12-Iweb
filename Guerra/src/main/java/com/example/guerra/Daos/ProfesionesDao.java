package com.example.guerra.Daos;

import com.example.guerra.Beans.Profesiones;
import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProfesionesDao extends DaoBase{
    public ArrayList<Profesiones> obtenerListaProfesiones() {
        ArrayList<Profesiones> listaProfesiones = new ArrayList<>();

        try (Connection conn = getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Profesiones");) {

            while (rs.next()) {
                Profesiones profesion = new Profesiones();

                profesion.setProfesionid(rs.getInt(1));
                profesion.setProfesionNombre(rs.getString(2));


                listaProfesiones.add(profesion);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaProfesiones;

    }
}
