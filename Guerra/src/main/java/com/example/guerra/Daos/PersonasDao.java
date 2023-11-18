package com.example.guerra.Daos;

import com.example.guerra.Beans.Generos;
import com.example.guerra.Beans.Jugadores;
import com.example.guerra.Beans.Personas;

import java.sql.*;
import java.util.ArrayList;

public class PersonasDao extends DaoBase{
    public ArrayList<Personas> listarPersonas(){
        ArrayList<Personas> listarPersonas = new ArrayList<>();

        String sql = "SELECT * FROM personas p" ;
        try (Connection conn = this.getConection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Personas personas = new Personas();
                fetchPersonasData(personas, rs);

                listarPersonas.add(personas);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return listarPersonas;
    }

    public Personas obtenerPersonas(int idPersonas) {

        Personas personas = null;

        String sql = "SELECT * FROM employees e \n"
                + "left join jobs j ON (j.job_id = e.job_id) \n"
                + "left join departments d ON (d.department_id = e.department_id)\n"
                + "left  join employees m ON (e.manager_id = m.employee_id)\n"
                + "WHERE e.employee_id = ?";  //cambiar el query

        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idPersonas);

            try (ResultSet rs = pstmt.executeQuery()) {

                if (rs.next()) {
                    personas = new Personas();
                    fetchPersonasData(personas, rs);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return personas;
    }

    public void guardarPersonas(Personas personas) throws SQLException {

        String sql = "INSERT INTO employees (first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            setPersonasParams(pstmt, personas);
            pstmt.executeUpdate();
        }
    }

    public void actualizarPersonas(Personas personas) throws SQLException {

        String sql = "UPDATE employees SET first_name = ?, last_name = ?, email = ?, phone_number = ?, "
                + "hire_date = ?, job_id = ?, salary = ?, commission_pct = ?, "
                + "manager_id = ?, department_id = ? WHERE employee_id = ?";

        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            setPersonasParams(pstmt, personas);
            pstmt.setInt(11, personas.getIdPersonas());
            pstmt.executeUpdate();
        }
    }

    public void borrarPersonas(int IdPersonas) throws SQLException {
        String sql = "DELETE FROM employees WHERE employee_id = ?";
        try (Connection conn = this.getConection();
             PreparedStatement pstmt = conn.prepareStatement(sql);) {
            pstmt.setInt(1, IdPersonas);
            pstmt.executeUpdate();
        }
    catch (SQLException ex) {
        ex.printStackTrace();
    }

    }


    private Personas fetchPersonasData(Personas personas, ResultSet rs) throws SQLException {
        personas.setIdPersonas(rs.getInt(1));
        personas.setNombre(rs.getString(2));
        Generos genero = new Generos();
        genero.setGeneroId(rs.getInt(3));
        genero.setGeneroNombre(rs.getInt("genero"));
        personas.setConsumo(rs.getInt(4));
        personas.setMoral(rs.getInt(5));
        personas.setTiempoColonia(rs.getInt(6));
        personas.setProduce(rs.getString(7));


        return personas;
    }

    private void setPersonasParams(PreparedStatement pstmt,Personas persona) throws SQLException {
        pstmt.setString(1, persona.getNombre());
        pstmt.setInt(2, persona.getGenero().getGeneroId());
        pstmt.setInt(3, persona.getConsumo());
        pstmt.setInt(4, persona.getMoral());
        pstmt.setInt(5, persona.getTiempoColonia());
        pstmt.setInt(5, persona.getFuerza());
        pstmt.setInt(6, persona.getProfesion().getProfesionid());
        pstmt.setString(7, persona.getProduce());
        pstmt.setString(8, persona.getPersonaColonia());
        pstmt.setBoolean(6, persona.isMuereVive());




    }
}
