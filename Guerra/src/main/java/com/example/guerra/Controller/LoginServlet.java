package com.example.guerra.Controller;

import com.example.guerra.Beans.Jugadores;
import com.example.guerra.Daos.JugadoresDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        String action = request.getParameter("action") == null ? "iniciosesion" : request.getParameter("action");


        switch (action){
            case "iniciosesion":
                request.getRequestDispatcher("loginFrom.jsp").forward(request,response);
                break;
            case "registrojugador":
                request.getRequestDispatcher("RegistroJugador.jsp").forward(request,response);
                break;
            case "cerrarsesion":
                HttpSession httpSession = request.getSession();
                httpSession.invalidate(); //Lo que hace invalidate es borrar todos los atributos y la sesion la deja en blanco
                request.getRequestDispatcher("loginFrom.jsp").forward(request,response);
                response.sendRedirect(request.getContextPath() + "/LoginServlet");
                break;


        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        System.out.println("username: " + username + " | password: " + password);
        JugadoresDao jugadoresDao = new JugadoresDao();

        if(jugadoresDao.validarUsuarioPasswordHashed(username,password)){
            System.out.println("usuario y password válidos");
            Jugadores jugadores = jugadoresDao.obtenerJugador(username);
            HttpSession httpSession = request.getSession();
            httpSession.setAttribute("usuarioLogueado",jugadores);
            response.sendRedirect(request.getContextPath());
        }else{
            System.out.println("usuario o password incorrectos");
            request.setAttribute("err","Usuario o password incorrectos");
            request.getRequestDispatcher("loginFrom.jsp").forward(request,response);
        }
    }
}
