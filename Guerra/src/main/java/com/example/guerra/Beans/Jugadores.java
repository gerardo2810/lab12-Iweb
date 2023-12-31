package com.example.guerra.Beans;

public class Jugadores {
    private int idJugador;
    private String nombre;
    private int edad;
    private  String correo;
    private String usuario;
    private boolean edadLimite;
    private boolean pazGuerra;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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
