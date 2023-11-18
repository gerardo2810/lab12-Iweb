package com.example.guerra.Controller;
import com.example.guerra.Daos.GenerosDao;
import com.example.guerra.Daos.ProfesionesDao;
import com.example.guerra.Beans.Personas;
import com.example.guerra.Beans.Profesiones;
import com.example.guerra.Daos.PersonasDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "PersonasServlet", value = "/PersonasServlet")
public class PersonasServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action") == null ? "lista" : request.getParameter("action");

        RequestDispatcher view;
        PersonasDao personasDao = new PersonasDao();
        GenerosDao generosDao = new GenerosDao();
        ProfesionesDao profesionesDao = new ProfesionesDao();
        switch (action) {
            case "lista":
                request.setAttribute("listaPersonas", personasDao.listarPersonas());
                view = request.getRequestDispatcher("Personas/listaPersonas.jsp");
                view.forward(request, response);
                break;
            case "formCrear":
                request.setAttribute("listaProfesiones",profesionesDao.obtenerListaProfesiones());
                request.setAttribute("listaGeneros",generosDao.obtenerListaGeneros());
                view = request.getRequestDispatcher("Personas/formularioNuevo.jsp");
                view.forward(request, response);
                break;
            case "editar":
                if (request.getParameter("id") != null) {
                    String employeeIdString = request.getParameter("id");
                    int employeeId = 0;
                    try {
                        employeeId = Integer.parseInt(employeeIdString);
                    } catch (NumberFormatException ex) {
                        response.sendRedirect("PersonasServlet");

                    }

                    Personas per = personasDao.obtenerPersonas(employeeId);

                    if (per != null) {
                        request.setAttribute("empleado", per);
                        view = request.getRequestDispatcher("Personas/formularioEditar.jsp");
                        view.forward(request, response);
                    } else {
                        response.sendRedirect("PersonasServlet");
                    }

                } else {
                    response.sendRedirect("PersonasServlet");
                }

                break;
            case "borrar":
                if (request.getParameter("id") != null) {
                    String personasIdString = request.getParameter("id");
                    int IdPersonas = 0;
                    try {
                        IdPersonas = Integer.parseInt(personasIdString);
                    } catch (NumberFormatException ex) {
                        response.sendRedirect("PersonasServlet");
                    }

                    Personas per = personasDao.obtenerPersonas(IdPersonas);

                    if (per != null) {
                        try {
                            personasDao.borrarPersonas(IdPersonas);
                            response.sendRedirect("PersonaServlet?msg=Persona borrado exitosamente");
                        } catch (SQLException e) {
                            response.sendRedirect("PersonaServlet?err=Error al borrar a la persona");
                        }
                    }
                } else {
                    response.sendRedirect("PersonaServlet?err=Error al borrar a la persona");
                }
                break;
            default:
                response.sendRedirect("PersonaServlet");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

