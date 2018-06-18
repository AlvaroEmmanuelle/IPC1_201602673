package utilidades;

import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JLabel;
import pojo.Partida;
import pojo.ResumenJuego;
import ventana.VentanaFinJuego;

public class TiempoJuego extends Thread{
    private int minutoFinJuego, minutoActual, segundoActual;
    private Vector<ResumenJuego> historialJuegos;
    private Partida partidaActual;
    private JLabel lblTiempo;
    private JFrame interfazJuego;
    private boolean ganaXfinTiempo;
    
    public TiempoJuego(JLabel lblTiempo, JFrame interfazJuego, Vector<ResumenJuego> historialJuegos, Partida partidaActual) {
        minutoFinJuego = 5;
        minutoActual = 0;
        segundoActual = 0;
        this.lblTiempo = lblTiempo;
        this.interfazJuego = interfazJuego;
        this.historialJuegos = historialJuegos;
        this.partidaActual = partidaActual;
        ganaXfinTiempo=true;
    }
        
    public void run(){
        try {
            while(minutoActual<minutoFinJuego){
                if(partidaActual.getVidaJugador1()>0 && partidaActual.getVidaJugador2()>0){
                    segundoActual=segundoActual+1;
                    if(segundoActual==60){
                        minutoActual=minutoActual+1;
                        segundoActual=0;
                    }
                    lblTiempo.setText("0"+minutoActual+":"+segundoActual);
                    Thread.sleep(1000);
                }else{
                    //si entra aca un jugador tiene puntaje 0, mataron a sus personajes
                    //No gano por que se acabara el tiempo
                    ganaXfinTiempo = false;
                    minutoActual=minutoFinJuego;
                }
            }
            System.out.println("INICIA PROCESO DE FINALIZAR TODO");
            interfazJuego.dispose();
            System.out.println("Hilo "+this.getName()+" TiempoJuego ha finalizado");
            
            ResumenJuego resumen_juegoActual;
            
            int tiempoSeg;
            
            try {
                String parts [] = lblTiempo.getText().toString().split(":");
                tiempoSeg = (Integer.parseInt(parts[0])*60)+Integer.parseInt(parts[1]);
            } catch (NumberFormatException eee){
                tiempoSeg = 3;
            }

            if(ganaXfinTiempo){
                resumen_juegoActual = new ResumenJuego(partidaActual, lblTiempo.getText(), tiempoSeg, true);
            }else{
                resumen_juegoActual = new ResumenJuego(partidaActual, lblTiempo.getText(), tiempoSeg, false);
            }
            
            if(resumen_juegoActual.getPartidaJugada().getVidaJugador1()<0){
                resumen_juegoActual.getPartidaJugada().setVidaJugador1(0);
            }
            if(resumen_juegoActual.getPartidaJugada().getVidaJugador2()<0){
                resumen_juegoActual.getPartidaJugada().setVidaJugador2(0);
            }
            
            //Se agrega al vector y ordena, si es >10 el tam se quita el ultimo
            historialJuegos.add(resumen_juegoActual);
            historialJuegos = metodoBurbuja_menorAmayor(historialJuegos);
            if(historialJuegos.size()>10){
                historialJuegos.remove(10);
            }
                        
            VentanaFinJuego vfg = new VentanaFinJuego(historialJuegos, resumen_juegoActual, partidaActual);
            vfg.setVisible(true);
            this.interrupt();
        }catch(Exception e){}
    }
    
    public Vector<ResumenJuego> metodoBurbuja_menorAmayor( Vector<ResumenJuego> historialJuegos ){
        int i;
        boolean flag = true;
        ResumenJuego temp;
 
        while(flag){
            flag = false;  
            for( i=0;  i < historialJuegos.size() -1;  i++ ){
                if(historialJuegos.get(i).getTiempoPartidaSeg() > historialJuegos.get(i+1).getTiempoPartidaSeg()){
                    temp = historialJuegos.get(i);
                    historialJuegos.set(i, historialJuegos.get(+1));
                    historialJuegos.set(i+1, temp);
                    flag = true; 
                } 
            } 
        } 
        return historialJuegos;
    }
    
    public JLabel getLblTiempo() {
        return lblTiempo;
    }

    public void setLblTiempo(JLabel lblTiempo) {
        this.lblTiempo = lblTiempo;
    }

    public TiempoJuego(Partida jugadorActual) {
        this.partidaActual = jugadorActual;
    }
    
}