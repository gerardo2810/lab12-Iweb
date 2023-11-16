package com.example.guerra.Beans;

public class Personas {
    private int idPersonas;
    private String nombre;
    private String genero;
    private String consumo;
    private String moral;
    private int tiempoColonia;
    private int fuerza;
    private int alimentaXdia;
    private String profesion;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getConsumo() {
        return consumo;
    }

    public void setConsumo(String consumo) {
        this.consumo = consumo;
    }

    public String getMoral() {
        return moral;
    }

    public void setMoral(String moral) {
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

    public int getAlimentaXdia() {
        return alimentaXdia;
    }

    public void setAlimentaXdia(int alimentaXdia) {
        this.alimentaXdia = alimentaXdia;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
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
