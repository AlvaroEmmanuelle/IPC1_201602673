package pojo;

import java.io.Serializable;
import java.util.Vector;

public class Partida implements Serializable{
    private String nombreJugador1;
    private String nombreJugador2;
    private int vidaJugador1;
    private int vidaJugador2;
    private int duracionPartidaSeg;
    private Vector<Personaje> listaPersonajesJ1;
    private Vector<Personaje> listaPersonajesJ2;

    public Partida(String nombreJugador1, String nombreJugador2) {
        this.nombreJugador1 = nombreJugador1;
        this.nombreJugador2 = nombreJugador2;
        this.vidaJugador1 = 5;
        this.vidaJugador2 = 5;
    }

    public String getNombreJugador1() {
        return nombreJugador1;
    }

    public void setNombreJugador1(String nombreJugador1) {
        this.nombreJugador1 = nombreJugador1;
    }

    public String getNombreJugador2() {
        return nombreJugador2;
    }

    public void setNombreJugador2(String nombreJugador2) {
        this.nombreJugador2 = nombreJugador2;
    }

    public Vector<Personaje> getListaPersonajesJ1() {
        return listaPersonajesJ1;
    }

    public void setListaPersonajesJ1(Vector<Personaje> listaPersonajesJ1) {
        this.listaPersonajesJ1 = listaPersonajesJ1;
    }

    public Vector<Personaje> getListaPersonajesJ2() {
        return listaPersonajesJ2;
    }

    public void setListaPersonajesJ2(Vector<Personaje> listaPersonajesJ2) {
        this.listaPersonajesJ2 = listaPersonajesJ2;
    }

    public int getVidaJugador1() {
        return vidaJugador1;
    }

    public void setVidaJugador1(int vidaJugador1) {
        this.vidaJugador1 = vidaJugador1;
    }

    public int getVidaJugador2() {
        return vidaJugador2;
    }

    public void setVidaJugador2(int vidaJugador2) {
        this.vidaJugador2 = vidaJugador2;
    }

    public int getDuracionPartidaSeg() {
        return duracionPartidaSeg;
    }

    public void setDuracionPartidaSeg(int duracionPartidaSeg) {
        this.duracionPartidaSeg = duracionPartidaSeg;
    }
    
}
