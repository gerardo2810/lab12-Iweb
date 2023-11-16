package com.example.guerra.Beans;

public class Jugadores {
    private int idJugador;
    private String nombre;
    private int edad;
    private  String correo;
    private String usuario;
    private String contraseña;
    private boolean edadLimite;
    private boolean pazGuerra;

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public boolean isEdadLimite() {
        return edadLimite;
    }

    public void setEdadLimite(boolean edadLimite) {
        this.edadLimite = edadLimite;
    }

    public boolean isPazGuerra() {
        return pazGuerra;
    }

    public void setPazGuerra(boolean pazGuerra) {
        this.pazGuerra = pazGuerra;
    }
}
