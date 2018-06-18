package utilidades;

import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import pojo.Partida;

public class Mov_IZ_DE extends Thread{
    private String  [][] matrizStr_Logica;
    private JButton [][] matrizBtn_Casillas;
    private Partida jugadorActual;
    private Vector <Vector<JLabel>> listaVidas;
    private String direccion, jugadorTurno, jugadorDescanso;
    private int cantidadMover, tam, fila, col, j, v, m=0;
    private Integer randomX, randomY, random12;
    private ImageIcon iconoVida;
    private boolean movido = false, encontrado =false;
    private int n=1, centroAprox;

    public Mov_IZ_DE(String direccion, int cantidadMover, String  [][] matrizStr_Logica, JButton [][] matrizBtn_Casillas, 
            Vector <Vector<JLabel>> listaVidas, Partida jugadorActual, String jugadorTurno, int tam) {
        this.cantidadMover = cantidadMover;
        this.matrizStr_Logica = matrizStr_Logica;
        this.matrizBtn_Casillas = matrizBtn_Casillas;
        this.jugadorActual = jugadorActual;
        this.listaVidas = listaVidas;
        this.direccion = direccion;
        this.tam = tam;
        centroAprox = (int) Math.round(((float)tam) /2);
        iconoVida = new ImageIcon("src/imagen/vida (3).PNG");
        this.jugadorTurno = jugadorTurno;
        
        if(jugadorTurno.equals(Constante.J1)){
            this.jugadorTurno = jugadorTurno;
            this.jugadorDescanso = Constante.J2;
        }else{
            this.jugadorTurno = Constante.J2;
            this.jugadorDescanso = Constante.J1;
        }
        for (int yy = 0; yy < tam; yy++) {
            for (int xx = 0; xx < tam; xx++) {
                if (matrizStr_Logica[xx][yy].equals(jugadorTurno)) {
                    fila = xx;
                    col = yy;
                }
            }
        }
    }
    
    public void run(){
        System.out.println("____(Inicia)Hilo Mover ID");
        try {
            while(m<cantidadMover){
                if(direccion.equals(Constante.DER)){
                    if(!matrizStr_Logica[fila][col+1].equals(jugadorDescanso)){
                        //<editor-fold defaultstate="collapsed" desc="Derecha">
                        if(matrizStr_Logica[fila][col+1].equals(Constante.M)){ piezaDano(1); }
                        if(matrizStr_Logica[fila][col+1].equals(Constante.V) && (jugadorActual.getVidaJugador1()<5 &&
                                jugadorActual.getVidaJugador1()>0)){ piezaVida(); }
                        //Mueve Jugador - LOGICO
                        matrizStr_Logica[fila][col+1] = jugadorTurno;
                        matrizStr_Logica[fila][col] = "";
                        //Mueve Jugador - GRAFICO
                        matrizBtn_Casillas[fila][col+1].setIcon(matrizBtn_Casillas[fila][col].getIcon());
                        matrizBtn_Casillas[fila][col].setIcon(new JButton().getIcon());
                        Thread.sleep(500);
                        col++;
                        m++;
//</editor-fold>
                    }else{
                        random12 = ThreadLocalRandom.current().nextInt(0, 0 + 1);
                        if(random12 == 0 ){ 
                            System.out.println("***Inicia subHilo moviendo AR_AB con mov faltantes: "+(cantidadMover-m));
                            Mov_AR_AB movArr = new Mov_AR_AB(Constante.ARR, (cantidadMover-m), matrizStr_Logica, matrizBtn_Casillas, listaVidas, jugadorActual, jugadorTurno, tam);
                            movArr.start();
                            this.listaVidas = movArr.getListaVidas();
                            this.jugadorActual = movArr.getJugadorActual();
                            this.matrizStr_Logica = movArr.getMatrizStr_Logica();
                            this.matrizBtn_Casillas = movArr.getMatrizBtn_Casillas();
                            m=cantidadMover;
                        } else { 
                            System.out.println("***Inicia subHilo moviendo AR_AB con mov faltantes: "+(cantidadMover-m));
                            Mov_AR_AB movArr = new Mov_AR_AB(Constante.ABA, (cantidadMover-m), matrizStr_Logica, matrizBtn_Casillas, listaVidas, jugadorActual, jugadorTurno, tam);
                            movArr.start();
                            this.listaVidas = movArr.getListaVidas();
                            this.jugadorActual = movArr.getJugadorActual();
                            this.matrizStr_Logica = movArr.getMatrizStr_Logica();
                            this.matrizBtn_Casillas = movArr.getMatrizBtn_Casillas();
                            m=cantidadMover;
                        }
                    }
                }
                if(direccion.equals(Constante.IZQ)){
                    if(!matrizStr_Logica[fila][col-1].equals(jugadorDescanso)){
                        //<editor-fold defaultstate="collapsed" desc="Izquierda">
                        if(matrizStr_Logica[fila][col-1].equals(Constante.M)){ piezaDano(1); }
                        if(matrizStr_Logica[fila][col-1].equals(Constante.V) && (jugadorActual.getVidaJugador1()<5 &&
                                jugadorActual.getVidaJugador1()>0)){ piezaVida(); }
                        //Mueve Jugador - LOGICO
                        matrizStr_Logica[fila][col-1] = jugadorTurno;
                        matrizStr_Logica[fila][col] = "";
                        //Mueve Jugador - GRAFICO
                        matrizBtn_Casillas[fila][col-1].setIcon(matrizBtn_Casillas[fila][col].getIcon());
                        matrizBtn_Casillas[fila][col].setIcon(new JButton().getIcon());
                        Thread.sleep(500);
                        col--;
                        m++;
//</editor-fold>
                    }else{
                        random12 = ThreadLocalRandom.current().nextInt(0, 0 + 1);
                        if(random12 == 0 ){ 
                            System.out.println("***Inicia subHilo moviendo AR_AB con mov faltantes: "+(cantidadMover-m));
                            Mov_AR_AB movArr = new Mov_AR_AB(Constante.ARR, (cantidadMover-m), matrizStr_Logica, matrizBtn_Casillas, listaVidas, jugadorActual, jugadorTurno, tam);
                            movArr.start();
                            this.listaVidas = movArr.getListaVidas();
                            this.jugadorActual = movArr.getJugadorActual();
                            this.matrizStr_Logica = movArr.getMatrizStr_Logica();
                            this.matrizBtn_Casillas = movArr.getMatrizBtn_Casillas();
                            m=cantidadMover;
                        } else { 
                            System.out.println("***Inicia subHilo moviendo AR_AB con mov faltantes: "+(cantidadMover-m));
                            Mov_AR_AB movArr = new Mov_AR_AB(Constante.ABA, (cantidadMover-m), matrizStr_Logica, matrizBtn_Casillas, listaVidas, jugadorActual, jugadorTurno, tam);
                            movArr.start();
                            this.listaVidas = movArr.getListaVidas();
                            this.jugadorActual = movArr.getJugadorActual();
                            this.matrizStr_Logica = movArr.getMatrizStr_Logica();
                            this.matrizBtn_Casillas = movArr.getMatrizBtn_Casillas();
                            m=cantidadMover;
                        }
                    }
                }
            }
            System.out.println("____(Termina)Hilo Mover ID");
            this.interrupt();
        }catch(Exception e){
            salioTablero(matrizBtn_Casillas[fila][col].getIcon(), fila, col);
        }
    }
        
    public void salioTablero (Icon icono, int fi, int co){
        //Genera posicion centro
        int reubicadoX = centroAprox, reubicadoY =centroAprox, cuentaProbados=0;
        
        boolean colocadoJ1 = true, colocadoJ2 = false;
        
        if(jugadorTurno.equals(Constante.J1)){
            colocadoJ1 = false;
            colocadoJ2 = true;
        }
        
        while(!colocadoJ1 || !colocadoJ2){
            if(matrizStr_Logica[reubicadoX][reubicadoY].equals("")){
                if(!colocadoJ1){
                    matrizStr_Logica[fi][co] = "";
                    matrizBtn_Casillas[fi][co].setIcon(new JButton().getIcon());
                    matrizStr_Logica[reubicadoX][reubicadoY] = Constante.J1;
                    matrizBtn_Casillas[reubicadoX][reubicadoY].setIcon(icono);
                    colocadoJ1 = true;
                }else if(!colocadoJ2){
                    matrizStr_Logica[fi][co] = "";
                    matrizBtn_Casillas[fi][co].setIcon(new JButton().getIcon());
                    matrizStr_Logica[reubicadoX][reubicadoY] = Constante.J2;
                    matrizBtn_Casillas[reubicadoX][reubicadoY].setIcon(icono);
                    colocadoJ2 = true;
                }
            }else{
                if(!encontrado){
                    for(int probFila = (centroAprox-n); probFila <= (centroAprox+n); probFila++){
                        if(!encontrado){
                            for(int probCol = (centroAprox-n); probCol <= (centroAprox+n); probCol++){
                                if(matrizStr_Logica[probFila][probCol].equals("")){
                                    reubicadoX = probFila;
                                    reubicadoY = probCol;
                                    cuentaProbados++;
                                    encontrado = true;
                                    break;
                                }else{
                                    cuentaProbados++;
                                }
                            }
                        }
                    }
                    if(n==1 && cuentaProbados==8){ n++; cuentaProbados=0; }
                    if(n==2 && cuentaProbados==16){ n++; cuentaProbados=0; }
                    if(n==3 && cuentaProbados==33){ n++; cuentaProbados=0; }
                }
            }
        }
        piezaDano(1);
    }
    
    public void piezaDano (int tipoDano){
        if(jugadorTurno.equals(Constante.J1)){
            //Resta vida - LOGICO
            jugadorActual.setVidaJugador1(jugadorActual.getVidaJugador1()-tipoDano);
            j=0; v=jugadorActual.getVidaJugador1(); 
        }else{
            //Resta vida - LOGICO
            jugadorActual.setVidaJugador2(jugadorActual.getVidaJugador2()-tipoDano);
            j=1; v=jugadorActual.getVidaJugador2(); 
        }
        //Resta vida - GRAFICO
        if(v==4){
            listaVidas.get(j).get(4).setIcon(new JButton().getIcon());
        }
        if(v==3){
            listaVidas.get(j).get(4).setIcon(new JButton().getIcon());
            listaVidas.get(j).get(3).setIcon(new JButton().getIcon());
        }
        if(v==2){
            listaVidas.get(j).get(4).setIcon(new JButton().getIcon());
            listaVidas.get(j).get(3).setIcon(new JButton().getIcon());
            listaVidas.get(j).get(2).setIcon(new JButton().getIcon());
        }
        if(v==1){
            listaVidas.get(j).get(4).setIcon(new JButton().getIcon());
            listaVidas.get(j).get(3).setIcon(new JButton().getIcon());
            listaVidas.get(j).get(2).setIcon(new JButton().getIcon());
            listaVidas.get(j).get(1).setIcon(new JButton().getIcon());
        }
        if(v==0 || v<0){
            if(j==0){
                jugadorActual.setVidaJugador1(0);
            }else{
                jugadorActual.setVidaJugador2(0);
            }
        }
    }
    
    public void piezaVida (){
        if(jugadorTurno.equals(Constante.J1)){
            //Suma vida - LOGICO
            jugadorActual.setVidaJugador1(jugadorActual.getVidaJugador1()+1);
            j=0; v=jugadorActual.getVidaJugador1(); 
        } else {
            //Suma vida - LOGICO
            jugadorActual.setVidaJugador1(jugadorActual.getVidaJugador2()+1);
            j=1; v=jugadorActual.getVidaJugador2(); 
        }
        //Suma vida - GRAFICO
        if(v==1){
            listaVidas.get(j).get(0).setIcon(iconoVida);
        }
        if(v==2){
            listaVidas.get(j).get(1).setIcon(iconoVida);
            listaVidas.get(j).get(0).setIcon(iconoVida);
        }
        if(v==3){
            listaVidas.get(j).get(2).setIcon(iconoVida);
            listaVidas.get(j).get(1).setIcon(iconoVida);
            listaVidas.get(j).get(0).setIcon(iconoVida);
        }
        if(v==4){
            listaVidas.get(j).get(3).setIcon(iconoVida);
            listaVidas.get(j).get(2).setIcon(iconoVida);
            listaVidas.get(j).get(1).setIcon(iconoVida);
            listaVidas.get(j).get(0).setIcon(iconoVida);
        }
    }

    public Vector<Vector<JLabel>> getListaVidas() {
        return listaVidas;
    }

    public Partida getJugadorActual() {
        return jugadorActual;
    }

    public String[][] getMatrizStr_Logica() {
        return matrizStr_Logica;
    }

    public JButton[][] getMatrizBtn_Casillas() {
        return matrizBtn_Casillas;
    }
    
}
