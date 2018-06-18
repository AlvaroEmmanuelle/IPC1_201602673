package pojo;

import java.io.Serializable;

public class Personaje implements Serializable{
    protected String nombrePersonaje;
    protected int ataque;
    protected int casillasAlcance;
    protected boolean quitaSiguienteTurno;

    public Personaje(String nombrePersonaje, int ataque, int casillasAlcance, boolean quitaSiguienteTurno) {
        this.nombrePersonaje = nombrePersonaje;
        this.ataque = ataque;
        this.casillasAlcance = casillasAlcance;
        this.quitaSiguienteTurno = quitaSiguienteTurno;
    }

    public boolean isQuitaSiguienteTurno() {
        return quitaSiguienteTurno;
    }

    public void setQuitaSiguienteTurno(boolean quitaSiguienteTurno) {
        this.quitaSiguienteTurno = quitaSiguienteTurno;
    }

    public String getNombrePersonaje() {
        return nombrePersonaje;
    }

    public void setNombrePersonaje(String nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getCasillasAlcance() {
        return casillasAlcance;
    }

    public void setCasillasAlcance(int casillasAlcance) {
        this.casillasAlcance = casillasAlcance;
    }
    
}
