package com.example.guerra.Beans;

import java.util.Date;

public class HistorialGuerra {
    private int idHistorialGuerras;
    private Date fecha;
    private String resultado;
    private  String contrincante;
    private String historialGuerrasCol;
    private Jugadores idJugador;

    public int getIdHistorialGuerras() {
        return idHistorialGuerras;
    }

    public void setIdHistorialGuerras(int idHistorialGuerras) {
        this.idHistorialGuerras = idHistorialGuerras;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getContrincante() {
        return contrincante;
    }

    public void setContrincante(String contrincante) {
        this.contrincante = contrincante;
    }

    public Jugadores getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Jugadores idJugador) {
        this.idJugador = idJugador;
    }
}
