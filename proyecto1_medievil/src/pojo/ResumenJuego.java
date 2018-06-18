package pojo;

import java.io.Serializable;

public class ResumenJuego implements Serializable{
    private Partida partidaJugada;
    private String tiempoPartida;
    private Boolean seAcaboTiempo;
    private String resultadoPartida;
    private int tiempoPartidaSeg;

    public ResumenJuego(Partida partidaJugada, String tiempoPartida, int tiempoPartidaSeg, Boolean seAcaboTiempo) {
        this.partidaJugada = partidaJugada;
        this.tiempoPartida = tiempoPartida;
        this.seAcaboTiempo = seAcaboTiempo;
        
        if(seAcaboTiempo){
            if(partidaJugada.getVidaJugador1()>partidaJugada.getVidaJugador2()){
                this.resultadoPartida = "Ganador J1:"+partidaJugada.getNombreJugador1();
                this.tiempoPartidaSeg = partidaJugada.getVidaJugador1();
            }else if (partidaJugada.getVidaJugador2()>partidaJugada.getVidaJugador1()){
                this.resultadoPartida = "Ganador J2:"+partidaJugada.getNombreJugador2();
                this.tiempoPartidaSeg = partidaJugada.getVidaJugador2();
            }else{
                this.resultadoPartida = "Empate";
                this.tiempoPartidaSeg = 300;
            }
            this.tiempoPartida = "5:00";
        }else{
            //Sino se acabo el tiempo significa que alguien mato todos los personajes de alguien
            if(partidaJugada.getVidaJugador1()>partidaJugada.getVidaJugador2()){
                this.resultadoPartida = "Ganador J1:"+partidaJugada.getNombreJugador1();
            }else if (partidaJugada.getVidaJugador2()>partidaJugada.getVidaJugador1()){
                this.resultadoPartida = "Ganador J2:"+partidaJugada.getNombreJugador2();
            }else{
                this.resultadoPartida = "Empate";
            }
            this.tiempoPartida = tiempoPartida;
            this.tiempoPartidaSeg = tiempoPartidaSeg;
        }
    }

    public Partida getPartidaJugada() {
        return partidaJugada;
    }

    public void setPartidaJugada(Partida partidaJugada) {
        this.partidaJugada = partidaJugada;
    }

    public String getTiempoPartida() {
        return tiempoPartida;
    }

    public void setTiempoPartida(String tiempoPartida) {
        this.tiempoPartida = tiempoPartida;
    }

    public Boolean getSeAcaboTiempo() {
        return seAcaboTiempo;
    }

    public void setSeAcaboTiempo(Boolean seAcaboTiempo) {
        this.seAcaboTiempo = seAcaboTiempo;
    }

    public String getResultadoPartida() {
        return resultadoPartida;
    }

    public void setResultadoPartida(String resultadoPartida) {
        this.resultadoPartida = resultadoPartida;
    }

    public int getTiempoPartidaSeg() {
        return tiempoPartidaSeg;
    }

    public void setTiempoPartidaSeg(int tiempoPartidaSeg) {
        this.tiempoPartidaSeg = tiempoPartidaSeg;
    }
    
}
