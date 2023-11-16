package com.example.guerra.Daos;

import com.example.guerra.Beans.Jugadores;
import com.example.guerra.Beans.Personas;

import java.sql.*;
import java.util.ArrayList;

public class PersonasDao extends DaoBase{
    public ArrayList<Personas> listarPersonas(){
        ArrayList<Personas> listarPersonas = new ArrayList<>();

        String sql = "" //query para listar jugadores
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
                    personas = new Jugadores();
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
    }




}
