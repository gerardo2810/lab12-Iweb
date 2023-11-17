package com.example.guerra.Beans;

public class    Personas {
    private int idPersonas;
    private String nombre;
    private Generos genero;
    private int consumo;
    private int moral;
    private int tiempoColonia;
    private int fuerza;

    private Profesiones profesion;
    private String produce;
    private String personaColonia;
    private boolean muereVive;
    private Jugadores idJugador;

    public int getIdPersonas() {
        return idPersonas;
    }

    public void setIdPersonas(int idPersonas) {
        this.idPersonas = idPersonas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Generos getGenero() {
        return genero;
    }

    public void setGenero(Generos genero) {
        this.genero = genero;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    public int getMoral() {
        return moral;
    }

    public void setMoral(int moral) {
        this.moral = moral;
    }

    public int getTiempoColonia() {
        return tiempoColonia;
    }

    public void setTiempoColonia(int tiempoColonia) {
        this.tiempoColonia = tiempoColonia;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public Profesiones getProfesion() {
        return profesion;
    }

    public void setProfesion(Profesiones profesion) {
        this.profesion = profesion;
    }

    public String getProduce() {
        return produce;
    }

    public void setProduce(String produce) {
        this.produce = produce;
    }

    public String getPersonaColonia() {
        return personaColonia;
    }

    public void setPersonaColonia(String personaColonia) {
        this.personaColonia = personaColonia;
    }

    public boolean isMuereVive() {
        return muereVive;
    }

    public void setMuereVive(boolean muereVive) {
        this.muereVive = muereVive;
    }

    public Jugadores getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Jugadores idJugador) {
        this.idJugador = idJugador;
    }




}
