package com.example.guerra.Daos;

import com.example.guerra.Beans.Jugadores;

import java.sql.*;
import java.util.ArrayList;

public class JugadoresDao extends DaoBase{
    public ArrayList<Jugadores> listarJugadores(){
        ArrayList<Jugadores> listarJugadores = new ArrayList<>();

        String sql = "" //query para listar jugadores
        try (Connection conn = this.getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Jugadores jugadores = new Jugadores();
                fetchJugadoresData(jugadores, rs);

                listarJugadores.add(jugadores);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listarJugadores;
    }

    public Jugadores obtenerJugadores(int idJugador) {

        Jugadores jugadores = null;

        String sql = "SELECT * FROM employees e \n"
                + "left join jobs j ON (j.job_id = e.job_id) \n"
                + "left join departments d ON (d.department_id = e.department_id)\n"
                + "left  join employees m ON (e.manager_id = m.employee_id)\n"
                + "WHERE e.employee_id = ?";  //cambiar el query

        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idJugador);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    jugadores = new Jugadores();
                    fetchJugadoresData(jugadores, rs);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return jugadores;
    }

    public void guardarJugadores(Jugadores jugadores) throws SQLException {

        String sql = "INSERT INTO employees (first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";  //cambiar query

        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            setJugadoresParams(pstmt, jugadores);
            pstmt.executeUpdate();
        }
    }


}
