package com.example.guerra.Daos;

import com.example.guerra.Beans.Generos;
import com.example.guerra.Beans.Jugadores;
import com.example.guerra.Beans.Personas;

import java.sql.*;
import java.util.ArrayList;

public class JugadoresDao extends DaoBase{
    public ArrayList<Jugadores> listarJugadores(){
        ArrayList<Jugadores> listarJugadores = new ArrayList<>();

        String sql = "SELECT * FROM jugadores j" //query para listar jugadores
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

    public void actualizarJugadores(Jugadores jugadores) throws SQLException {

        String sql = "UPDATE employees SET first_name = ?, last_name = ?, email = ?, phone_number = ?, "
                + "hire_date = ?, job_id = ?, salary = ?, commission_pct = ?, "
                + "manager_id = ?, department_id = ? WHERE employee_id = ?"; //cambiar query

        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            setJugadoresParams(pstmt, jugadores);
            pstmt.setInt(11, jugadores.getIdJugador());
            pstmt.executeUpdate();
        }
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

    public void borrarJugadores(int idJugador) throws SQLException {
        String sql = "DELETE FROM jugadores WHERE idJugador = ?";
        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, idJugador);
            pstmt.executeUpdate();
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public ArrayList<Jugadores> buscarJugadoresPorNombre(String nombre){

        ArrayList<Jugadores> listaJugadores = new ArrayList<>();

        String sql = "SELECT * FROM employees e \n"
                + "left join jobs j ON (j.job_id = e.job_id) \n"
                + "left join departments d ON (d.department_id = e.department_id)\n"
                + "left  join employees m ON (e.manager_id = m.employee_id)\n"
                + "WHERE e.first_name = ? OR e.last_name = ?"; // cambiar query

        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, nombre);

            try (ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    Jugadores jugadores = new Jugadores();
                    fetchJugadoresData(jugadores, rs);

                    listaJugadores.add(jugadores);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listaJugadores;
    }

    private Jugadores fetchJugadoresData(ResultSet rs) throws SQLException {
        Jugadores jugadores = new Jugadores();
        jugadores.setIdJugador(rs.getInt(1));
        jugadores.setNombre(rs.getString(2));
        jugadores.setEdad(rs.getInt(3));
        jugadores.setCorreo(rs.getString(4));
        jugadores.setUsuario(rs.getString(5));
        jugadores.setEdadLimite(rs.getBoolean(6));
        jugadores.setPazGuerra(rs.getBoolean(7));


        return jugadores;
    }

    private void setJugadoresParams(PreparedStatement pstmt,Jugadores jugadores) throws SQLException {
        pstmt.setString(1, jugadores.getNombre());
        pstmt.setInt(2, jugadores.getEdad());
        pstmt.setString(3, jugadores.getCorreo());
        pstmt.setString(4, jugadores.getUsuario());
        pstmt.setBoolean(5, jugadores.isEdadLimite());
        pstmt.setBoolean(6, jugadores.isPazGuerra());

    }

    public boolean validarUsuarioPassword(String username, String password){

        String sql = "SELECT * FROM jugadorcredentials where correo = ? and password = ?";

        boolean exito = false;

        try(Connection connection = getConection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setString(1,username);
            pstmt.setString(2,password);

            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    exito = true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return exito;
    }

    public boolean validarUsuarioPasswordHashed(String username, String password){

        String sql = "SELECT * FROM employees_credentials where correo = ? and passwordHashed = sha2(?,256)";

        boolean exito = false;

        try(Connection connection = getConection();
            PreparedStatement pstmt = connection.prepareStatement(sql)){

            pstmt.setString(1,username);
            pstmt.setString(2,password);

            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    exito = true;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return exito;
    }




}
