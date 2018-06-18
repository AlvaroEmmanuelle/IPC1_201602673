package ventana;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Vector;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import pojo.Partida;
import pojo.ResumenJuego;
import utilidades.Constante;
import utilidades.Mov_AR_AB;
import utilidades.TirarDado;
import utilidades.Mov_IZ_DE;
import utilidades.TiempoJuego;

public class VentanaJuego extends javax.swing.JFrame {
    private Partida jugadorNuevo;
    private Vector<ResumenJuego> historialJuegos;
    private TiempoJuego tiempoJuego;
    private String  [][] matrizStr_Logica;
    private JButton [][] matrizBtn_Casillas;
    private Vector <Vector<JLabel>> listaVidas = new Vector<>();
    private Vector<JLabel> listaVidaJ1 = new Vector<>(), listaVidaJ2 = new Vector<>();
    private ImageIcon iconoJ1, iconoJ2, iconoFondo, iconoDado, iconoMover, 
            iconoJ1_Guerrero, iconoJ1_Princesa, iconoJ1_Mago, iconoJ2_Guerrero, iconoJ2_Princesa, iconoJ2_Mago;
    private int tam, valor_dado, turno;
    private String personajeJ1, personajeJ2, pathJ1Gue = "src/imagen/J1_Guerrero.PNG", pathJ1Pri = "src/imagen/J1_Princesa.PNG", pathJ1Mago = "src/imagen/J1_Mago.PNG",
            pathJ2Gue = "src/imagen/J2_Guerrero.PNG", pathJ2Pri = "src/imagen/J2_Princesa.PNG", pathJ2Mago = "src/imagen/J2_Mago.PNG";
    private Integer randomX, randomY, randomFondo, veces=0;
    private boolean inicia = true, esteJugadorTiroDado=false;
    private Color colorTurno;
    
    public VentanaJuego(Partida jugadorNuevo, Vector<ResumenJuego> historialJuegos, int dimensiones) {
        initComponents();
        this.jugadorNuevo = jugadorNuevo;
        this.historialJuegos = historialJuegos;
        this.tam = dimensiones;
        randomFondo = ThreadLocalRandom.current().nextInt(1, 15 + 1);
        colorTurno = new Color(64, 224, 208);
        
        tiempoJuego = new TiempoJuego(lblTiempo, this, historialJuegos, jugadorNuevo);
        tiempoJuego.start();
        lblTiempo=tiempoJuego.getLblTiempo();
        
        //<editor-fold defaultstate="collapsed" desc="Vidas J1 & J2">
        listaVidaJ1.add(j1_v1);
        listaVidaJ1.add(j1_v2);
        listaVidaJ1.add(j1_v3);
        listaVidaJ1.add(j1_v4);
        listaVidaJ1.add(j1_v5);
        listaVidaJ2.add(j2_v1);
        listaVidaJ2.add(j2_v2);
        listaVidaJ2.add(j2_v3);
        listaVidaJ2.add(j2_v4);
        listaVidaJ2.add(j2_v5);
        listaVidas.add(listaVidaJ1);
        listaVidas.add(listaVidaJ2);
//</editor-fold>
        
        lblJugador1.setForeground(colorTurno); 
        turno=1;
        
        nombreJ1.setText(jugadorNuevo.getNombreJugador1());
        lblJ1_P1.setText(jugadorNuevo.getListaPersonajesJ1().get(0).getNombrePersonaje());
        lblJ1_P2.setText(jugadorNuevo.getListaPersonajesJ1().get(1).getNombrePersonaje());
        lblJ1_P3.setText(jugadorNuevo.getListaPersonajesJ1().get(2).getNombrePersonaje());
        nombreJ2.setText(jugadorNuevo.getNombreJugador2());
        lblJ2_P1.setText(jugadorNuevo.getListaPersonajesJ2().get(0).getNombrePersonaje());
        lblJ2_P2.setText(jugadorNuevo.getListaPersonajesJ2().get(1).getNombrePersonaje());
        lblJ2_P3.setText(jugadorNuevo.getListaPersonajesJ2().get(2).getNombrePersonaje());
        
        iconoJ1_Guerrero = new ImageIcon(pathJ1Gue);
        iconoJ1_Princesa = new ImageIcon(pathJ1Pri);
        iconoJ1_Mago = new ImageIcon(pathJ1Mago);
        
        iconoJ2_Guerrero = new ImageIcon(pathJ2Gue);
        iconoJ2_Princesa = new ImageIcon(pathJ2Pri);
        iconoJ2_Mago = new ImageIcon(pathJ2Mago);
        
        colocarFondo();
        crearTablero();
        vidaMinaTablero();
        colocarPersonaje();
        
    }
    public void colocarFondo(){
        switch (randomFondo) {
            case 1: iconoFondo = new ImageIcon("src/imagen/fondoJuego_1.PNG"); break;
            case 2: iconoFondo = new ImageIcon("src/imagen/fondoJuego_2.PNG"); break;
        }
        lblImagenFondo.setIcon(iconoFondo);
    }
    
    public void crearTablero(){
        matrizBtn_Casillas = new JButton[tam][tam];
        matrizStr_Logica = new String[tam][tam];

        JPanel buttonPane = new JPanel(new GridLayout(tam, tam));
        buttonPane.setBorder(new LineBorder(Color.BLACK));
        buttonPane.setOpaque(false);
        int columna = 0;
        int fila = 0;

        for (int i = 0; i < (tam*tam); i++) {
            //Logica de arreglo
            JButton b = new JButton();
            b.setToolTipText(""+i);
            b.setPreferredSize(new Dimension(25, 25));
            b.setToolTipText(""+fila+"-"+columna);
            b.setContentAreaFilled(false);
            b.setBorder(new LineBorder(Color.BLACK));
            //Se agrega el boton a ListaBotones
            matrizBtn_Casillas[fila][columna] = b;
            //Se agrega el valor del boton a ListaLogicaBotones
            matrizStr_Logica[fila][columna] = "";
            if(columna==(tam-1)){
                columna = 0;
                fila++;
            }else{
                columna++;
            }
        }
        //Agrega ListaBotones al PanelBotones
        for(int ar = 0; ar<tam; ar++){
            for(int cl = 0; cl<tam; cl++){
                buttonPane.add(matrizBtn_Casillas[ar][cl]);
            }
        }
        pnlTablero.add(buttonPane);
        pnlTablero.setOpaque(false);
    }
    
    public void vidaMinaTablero (){
        ImageIcon iconoBomb= new ImageIcon("src/imagen/bomb.PNG");
        ImageIcon iconoLife= new ImageIcon("src/imagen/life.PNG");
        
        //minado 10%
        int minas = (int) Math.round(((float)tam*tam) *(.10));
        //vidas 5%
        int vidas = (int) Math.round(((float)tam*tam) *(.05));
        
        System.out.println("minas"+minas+"- vidas"+vidas);
        
        int m=0, li=0;
        
        while(m<minas){
            //Genera posicion aleatoria 
            randomX = ThreadLocalRandom.current().nextInt(0, (tam-2) + 1);
            randomY = ThreadLocalRandom.current().nextInt(0, (tam-2) + 1);
            
            matrizStr_Logica[randomX][randomY] = Constante.M;
            matrizBtn_Casillas[randomX][randomY].setIcon(iconoBomb);
            
            m++;
        }
        
        while(li<vidas){
            //Genera posicion aleatoria 
            randomX = ThreadLocalRandom.current().nextInt(0, (tam-2) + 1);
            randomY = ThreadLocalRandom.current().nextInt(0, (tam-2) + 1);
            
            matrizStr_Logica[randomX][randomY] = Constante.V;
            matrizBtn_Casillas[randomX][randomY].setIcon(iconoLife);
            
            li++;
        }
    }
    
    public void colocarPersonaje (){
        if(jugadorNuevo.getListaPersonajesJ1().get(0).getNombrePersonaje().equals(Constante.GUE)){
            iconoJ1 = iconoJ1_Guerrero;
            personajeJ1 = Constante.GUE;
        }
        else if(jugadorNuevo.getListaPersonajesJ1().get(0).getNombrePersonaje().equals(Constante.PRI)){
            iconoJ1 = iconoJ1_Princesa;
            personajeJ1 = Constante.PRI;
        }
        else{ iconoJ1 = iconoJ1_Mago; personajeJ1 = Constante.MAG; }
        
        if(jugadorNuevo.getListaPersonajesJ2().get(0).getNombrePersonaje().equals(Constante.GUE)){
            iconoJ2 = iconoJ2_Guerrero;
            personajeJ2 = Constante.GUE;
        }
        else if(jugadorNuevo.getListaPersonajesJ2().get(0).getNombrePersonaje().equals(Constante.PRI)){
            iconoJ2 = iconoJ2_Princesa;
            personajeJ2 = Constante.PRI;
        }
        else{ iconoJ2 = iconoJ2_Mago; personajeJ2 = Constante.MAG;}
        
        //Genera posicion aleatoria 
        randomX = ThreadLocalRandom.current().nextInt(0, (tam-2) + 1);
        randomY = ThreadLocalRandom.current().nextInt(0, (tam-2) + 1);
        boolean colocadoJ1 = false, colocadoJ2 = false;
        
        while(!colocadoJ1 || !colocadoJ2){
            if(matrizStr_Logica[randomX][randomY].equals("")){
                if(!colocadoJ1){
                    matrizStr_Logica[randomX][randomY] = Constante.J1;
                    matrizBtn_Casillas[randomX][randomY].setIcon(iconoJ1);
                    colocadoJ1 = true;
                }else{
                    matrizStr_Logica[randomX][randomY] = Constante.J2;
                    matrizBtn_Casillas[randomX][randomY].setIcon(iconoJ2);
                    colocadoJ2 = true;
                }
            }else{
                randomX = ThreadLocalRandom.current().nextInt(0, (tam-2) + 1);
                randomY = ThreadLocalRandom.current().nextInt(0, (tam-2) + 1);
            }
        }
    }
    
    public void tirarDado (){
        TirarDado tirar = new TirarDado(lblDado);
        tirar.start();
        lblDado = tirar.getLbldado();
    }
    
    public void moverPersonaje (String direccion){
        //Mueve el que este pintado, porque ese tiene aun el turno
        String jt;
        if(inicia){
            mensajeTirarDado();
        }else{
            if(direccion.equals(Constante.DER)){
                //Mueve el que este pintado, porque ese tiene aun el turno
                if(turno==1){ jt = Constante.J1; }else{ jt = Constante.J2; }
                Mov_IZ_DE movD = new Mov_IZ_DE(direccion,Integer.parseInt(lblDado.getToolTipText()), matrizStr_Logica, matrizBtn_Casillas, listaVidas, jugadorNuevo, jt, tam);
                movD.start();
                this.listaVidas = movD.getListaVidas();
                this.jugadorNuevo = movD.getJugadorActual();
                this.matrizStr_Logica = movD.getMatrizStr_Logica();
                this.matrizBtn_Casillas = movD.getMatrizBtn_Casillas();
            }
            if(direccion.equals(Constante.IZQ)){
                if(turno==1){ jt = Constante.J1; }else{ jt = Constante.J2; }
                Mov_IZ_DE movI = new Mov_IZ_DE(direccion,Integer.parseInt(lblDado.getToolTipText()), matrizStr_Logica, matrizBtn_Casillas, listaVidas, jugadorNuevo, jt, tam);
                movI.start();
                this.listaVidas = movI.getListaVidas();
                this.jugadorNuevo = movI.getJugadorActual();
                this.matrizStr_Logica = movI.getMatrizStr_Logica();
                this.matrizBtn_Casillas = movI.getMatrizBtn_Casillas();
            }
            if(direccion.equals(Constante.ARR)){
                if(turno==1){ jt = Constante.J1; }else{ jt = Constante.J2; }
                Mov_AR_AB movArr = new Mov_AR_AB(Constante.ARR, Integer.parseInt(lblDado.getToolTipText()), matrizStr_Logica, matrizBtn_Casillas, listaVidas, jugadorNuevo, jt, tam);
                movArr.start();
                this.listaVidas = movArr.getListaVidas();
                this.jugadorNuevo = movArr.getJugadorActual();
                this.matrizStr_Logica = movArr.getMatrizStr_Logica();
                this.matrizBtn_Casillas = movArr.getMatrizBtn_Casillas();
            }
            if(direccion.equals(Constante.ABA)){
                if(turno==1){ jt = Constante.J1; }else{ jt = Constante.J2; }
                Mov_AR_AB movAba = new Mov_AR_AB(Constante.ABA, Integer.parseInt(lblDado.getToolTipText()), matrizStr_Logica, matrizBtn_Casillas, listaVidas, jugadorNuevo, jt, tam);
                movAba.start();
                this.listaVidas = movAba.getListaVidas();
                this.jugadorNuevo = movAba.getJugadorActual();
                this.matrizStr_Logica = movAba.getMatrizStr_Logica();
                this.matrizBtn_Casillas = movAba.getMatrizBtn_Casillas();
            }
        }
    }
    
    public void cambiaTurno (){
        boolean cambioPersonaje=false;
        int siguiente;
        
        if(turno==1){
            //Turno lo tiene el J1
            lblJugador1.setForeground(null);
            turno=2;
            lblJugador2.setForeground(colorTurno);
            cambioPersonaje=false;
            
            //<editor-fold defaultstate="collapsed" desc="Cambio personaje J1 a otro">
            while(!cambioPersonaje){
                for (int r = 0; r < 3; r++) {
                    if (jugadorNuevo.getListaPersonajesJ1().get(r).getNombrePersonaje().equals(personajeJ1) && !cambioPersonaje) {
                        siguiente = (r == 2) ? 0 : r + 1;
                        for (int xx = 0; xx < tam; xx++) {
                            if(!cambioPersonaje){
                                for (int yy = 0; yy < tam; yy++) {
                                    if (matrizStr_Logica[xx][yy].equals(Constante.J1)) {
                                        if (jugadorNuevo.getListaPersonajesJ1().get(siguiente).getNombrePersonaje().equals(Constante.GUE)) {
                                            iconoJ1 = iconoJ1_Guerrero;
                                            personajeJ1 = Constante.GUE;
                                        } else if (jugadorNuevo.getListaPersonajesJ1().get(siguiente).getNombrePersonaje().equals(Constante.PRI)) {
                                            iconoJ1 = iconoJ1_Princesa;
                                            personajeJ1 = Constante.PRI;
                                        } else {
                                            iconoJ1 = iconoJ1_Mago;
                                            personajeJ1 = Constante.MAG;
                                        }
                                        matrizBtn_Casillas[xx][yy].setIcon(iconoJ1);
                                        cambioPersonaje = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
//</editor-fold>
        
        }else{
            lblJugador2.setForeground(null);
            lblJugador1.setForeground(colorTurno);
            turno=1;
            cambioPersonaje=false;
            
            //<editor-fold defaultstate="collapsed" desc="Cambio personaje J2 a otro">
            while(!cambioPersonaje){
                for (int r = 0; r < 3; r++) {
                    if (jugadorNuevo.getListaPersonajesJ2().get(r).getNombrePersonaje().equals(personajeJ2) && !cambioPersonaje) {
                        siguiente = (r == 2) ? 0 : r + 1;
                        for (int xx = 0; xx < tam; xx++) {
                            if(!cambioPersonaje){
                                for (int yy = 0; yy < tam; yy++) {
                                    if (matrizStr_Logica[xx][yy].equals(Constante.J2)) {
                                        if (jugadorNuevo.getListaPersonajesJ2().get(siguiente).getNombrePersonaje().equals(Constante.GUE)) {
                                            iconoJ2 = iconoJ2_Guerrero;
                                            personajeJ2 = Constante.GUE;
                                        } else if (jugadorNuevo.getListaPersonajesJ2().get(siguiente).getNombrePersonaje().equals(Constante.PRI)) {
                                            iconoJ2 = iconoJ2_Princesa;
                                            personajeJ2 = Constante.PRI;
                                        } else {
                                            iconoJ2 = iconoJ2_Mago;
                                            personajeJ2 = Constante.MAG;
                                        }
                                        matrizBtn_Casillas[xx][yy].setIcon(iconoJ2);
                                        cambioPersonaje = true;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
//</editor-fold>
        }
        //El jugador que ahora tiene el turno no ha tirado el dado
        esteJugadorTiroDado = false;
    }

    public void atacar (String direccion){
        int filaPersonajeActual=0, colPersonajeActual=0, dano, alcance, j, v,
                rangoIz, rangoDe, rangoAr, rangoAb, revisado = 1;
        String jugadorTurnoActual, personajeTurnoActual, jugadorDescanso;
        boolean enRango = false;
        
        if(turno==1){ 
            jugadorTurnoActual= Constante.J1;
            jugadorDescanso = Constante.J2;
            personajeTurnoActual = personajeJ1;
        }else{ 
            jugadorTurnoActual= Constante.J2;
            jugadorDescanso = Constante.J1;
            personajeTurnoActual = personajeJ2;
        }
        
        for (int yy = 0; yy < tam; yy++) {
            for (int xx = 0; xx < tam; xx++) {
                if (matrizStr_Logica[xx][yy].equals(jugadorTurnoActual)) {
                    filaPersonajeActual = xx;
                    colPersonajeActual = yy;
                }
            }
        }
        
        if(personajeTurnoActual.equals(Constante.GUE)){
            //ataca a 2 de distancia, resta 2 vida
            dano=2;
            alcance=2;
        } else if (personajeTurnoActual.equals(Constante.PRI)){
            //ataca a 1 de distancia, resta 1 vida
            //quita siguiente turno (cambiar turno)
            dano=1;
            alcance=1;
        }else{
            //ataca a 4 de distancia, resta 1 vida
            dano=1;
            alcance=4;
        }
        
        try{
            if(direccion.equals(Constante.DER)){
                for (int yy = 1; yy <= alcance; yy++) {
                    if (matrizStr_Logica[filaPersonajeActual][colPersonajeActual+yy].equals(jugadorDescanso)) {
                        enRango = true;
                    }
                }
            }
            if(direccion.equals(Constante.ABA)){
                for (int yy = 1; yy <= alcance; yy++) {
                    if (matrizStr_Logica[filaPersonajeActual+yy][colPersonajeActual].equals(jugadorDescanso)) {
                        enRango = true;
                    }
                }
            }
            if(direccion.equals(Constante.IZQ)){
                for (int yy = 1; yy <= alcance; yy++) {
                    if (matrizStr_Logica[filaPersonajeActual][colPersonajeActual-yy].equals(jugadorDescanso)) {
                        enRango = true;
                    }
                }
            }
            if(direccion.equals(Constante.ARR)){
                for (int yy = 1; yy <= alcance; yy++) {
                    if (matrizStr_Logica[filaPersonajeActual-yy][colPersonajeActual].equals(jugadorDescanso)) {
                        enRango = true;
                    }
                }
            }
        }catch(Exception exception){
            System.out.println("cachao");
        }
        
        if(enRango){
            //Si el jugador actual es el J1 se le resta al 2 la vida porque esta en rango de ataque
            if(jugadorTurnoActual.equals(Constante.J2)){
                //Resta vida - LOGICO
                jugadorNuevo.setVidaJugador1(jugadorNuevo.getVidaJugador1()-dano);
                j=0; v=jugadorNuevo.getVidaJugador1(); 
            }else{
                //Resta vida - LOGICO
                jugadorNuevo.setVidaJugador2(jugadorNuevo.getVidaJugador2()-dano);
                j=1; v=jugadorNuevo.getVidaJugador2(); 
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
                    jugadorNuevo.setVidaJugador1(0);
                }else{
                    jugadorNuevo.setVidaJugador2(0);
                }
            }
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblTiempo = new javax.swing.JLabel();
        btnTirar = new javax.swing.JButton();
        lblDado = new javax.swing.JLabel();
        pnlJ1 = new javax.swing.JPanel();
        lblJugador1 = new javax.swing.JLabel();
        lblJ1_P1 = new javax.swing.JLabel();
        lblJ1_P2 = new javax.swing.JLabel();
        lblJ1_P3 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        j1_v2 = new javax.swing.JLabel();
        j1_v3 = new javax.swing.JLabel();
        j1_v4 = new javax.swing.JLabel();
        j1_v5 = new javax.swing.JLabel();
        j1_v1 = new javax.swing.JLabel();
        nombreJ1 = new javax.swing.JLabel();
        pnlJ2 = new javax.swing.JPanel();
        lblJugador2 = new javax.swing.JLabel();
        lblJ2_P1 = new javax.swing.JLabel();
        lblJ2_P2 = new javax.swing.JLabel();
        lblJ2_P3 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        j2_v2 = new javax.swing.JLabel();
        j2_v3 = new javax.swing.JLabel();
        j2_v4 = new javax.swing.JLabel();
        j2_v5 = new javax.swing.JLabel();
        j2_v1 = new javax.swing.JLabel();
        nombreJ2 = new javax.swing.JLabel();
        pnlMovimiento = new javax.swing.JPanel();
        btnMover_Arriba = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        btnMover_Abajo = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        pnlAtaque = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        pnlFondoJuego = new javax.swing.JPanel();
        pnlTablero = new javax.swing.JPanel();
        lblEjemplo = new javax.swing.JLabel();
        lblImagenFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/if_clock_1055090 (1).png"))); // NOI18N
        jLabel1.setText("Tiempo");

        lblTiempo.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblTiempo.setText("tiempo");

        btnTirar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/dado.png"))); // NOI18N
        btnTirar.setText("Tirar");
        btnTirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTirarActionPerformed(evt);
            }
        });

        lblDado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/dado_1.png"))); // NOI18N

        lblJugador1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblJugador1.setText("Jugador 1");

        lblJ1_P1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblJ1_P1.setText("Personaje");

        lblJ1_P2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblJ1_P2.setText("Personaje");

        lblJ1_P3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblJ1_P3.setText("Personaje");

        j1_v2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/vida (3).png"))); // NOI18N

        j1_v3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/vida (3).png"))); // NOI18N

        j1_v4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/vida (3).png"))); // NOI18N

        j1_v5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/vida (3).png"))); // NOI18N

        j1_v1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/vida (3).png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(j1_v1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(j1_v2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(j1_v3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(j1_v4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(j1_v5)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(j1_v2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(j1_v4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(j1_v3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(j1_v5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(j1_v1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        nombreJ1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        nombreJ1.setText("nombreJ2");
        nombreJ1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnlJ1Layout = new javax.swing.GroupLayout(pnlJ1);
        pnlJ1.setLayout(pnlJ1Layout);
        pnlJ1Layout.setHorizontalGroup(
            pnlJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJ1Layout.createSequentialGroup()
                .addGroup(pnlJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlJ1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlJ1Layout.createSequentialGroup()
                                .addComponent(lblJugador1)
                                .addGap(18, 18, 18)
                                .addComponent(nombreJ1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlJ1Layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addGroup(pnlJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblJ1_P1)
                                    .addComponent(lblJ1_P2)
                                    .addComponent(lblJ1_P3)))))
                    .addGroup(pnlJ1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        pnlJ1Layout.setVerticalGroup(
            pnlJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlJ1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlJ1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJugador1)
                    .addComponent(nombreJ1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblJ1_P1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblJ1_P2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblJ1_P3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        lblJugador2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        lblJugador2.setText("Jugador 2");

        lblJ2_P1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblJ2_P1.setText("Personaje");

        lblJ2_P2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblJ2_P2.setText("Personaje");

        lblJ2_P3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        lblJ2_P3.setText("Personaje");

        j2_v2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/vida (3).png"))); // NOI18N

        j2_v3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/vida (3).png"))); // NOI18N

        j2_v4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/vida (3).png"))); // NOI18N

        j2_v5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/vida (3).png"))); // NOI18N

        j2_v1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/vida (3).png"))); // NOI18N

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(j2_v1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(j2_v2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(j2_v3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(j2_v4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(j2_v5)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(j2_v2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(j2_v4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(j2_v3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(j2_v5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(j2_v1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        nombreJ2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        nombreJ2.setText("nombreJ2");
        nombreJ2.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout pnlJ2Layout = new javax.swing.GroupLayout(pnlJ2);
        pnlJ2.setLayout(pnlJ2Layout);
        pnlJ2Layout.setHorizontalGroup(
            pnlJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlJ2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlJ2Layout.createSequentialGroup()
                        .addComponent(lblJugador2)
                        .addGap(18, 18, 18)
                        .addComponent(nombreJ2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlJ2Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addGroup(pnlJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblJ2_P1)
                            .addComponent(lblJ2_P2)
                            .addComponent(lblJ2_P3)))
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        pnlJ2Layout.setVerticalGroup(
            pnlJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlJ2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlJ2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblJugador2)
                    .addComponent(nombreJ2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblJ2_P1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblJ2_P2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblJ2_P3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        pnlMovimiento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMover_Arriba.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/redonda_1.png"))); // NOI18N
        btnMover_Arriba.setBorder(null);
        btnMover_Arriba.setBorderPainted(false);
        btnMover_Arriba.setContentAreaFilled(false);
        btnMover_Arriba.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMover_ArribaActionPerformed(evt);
            }
        });
        pnlMovimiento.add(btnMover_Arriba, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, 70));

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/redonda_2.png"))); // NOI18N
        jButton6.setBorder(null);
        jButton6.setBorderPainted(false);
        jButton6.setContentAreaFilled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        pnlMovimiento.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 70));

        btnMover_Abajo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/redonda_3.png"))); // NOI18N
        btnMover_Abajo.setBorder(null);
        btnMover_Abajo.setBorderPainted(false);
        btnMover_Abajo.setContentAreaFilled(false);
        btnMover_Abajo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMover_AbajoActionPerformed(evt);
            }
        });
        pnlMovimiento.add(btnMover_Abajo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, -1, -1));

        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/redonda_4.png"))); // NOI18N
        jButton8.setBorder(null);
        jButton8.setBorderPainted(false);
        jButton8.setContentAreaFilled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        pnlMovimiento.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, 70));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Movimiento"));
        pnlMovimiento.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 180));

        pnlAtaque.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/punta_ar.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        pnlAtaque.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 64, 52));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/punta_iz.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        pnlAtaque.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 64, 52));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/punta_ab.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        pnlAtaque.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 64, 52));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/punta_de.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnlAtaque.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 64, 52));

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Ataque"));
        pnlAtaque.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 140));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/home.png"))); // NOI18N
        jButton1.setText("Menu");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        pnlFondoJuego.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTablero.setOpaque(false);
        pnlTablero.setLayout(new java.awt.BorderLayout());
        pnlTablero.add(lblEjemplo, java.awt.BorderLayout.PAGE_START);

        pnlFondoJuego.add(pnlTablero, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 670, 550));
        pnlFondoJuego.add(lblImagenFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 690, 570));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFondoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(lblTiempo))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pnlJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(pnlJ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTirar, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(lblDado)))
                        .addGap(47, 47, 47)
                        .addComponent(pnlMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jButton1)
                        .addGap(59, 59, 59)
                        .addComponent(pnlAtaque, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(lblTiempo)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlJ1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlJ2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnTirar)
                        .addGap(6, 6, 6)
                        .addComponent(lblDado, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(pnlAtaque, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTirarActionPerformed
        String personajeTurnoActual;
        if(inicia){
            tirarDado();
            inicia = false;
        }else{
            if(!esteJugadorTiroDado){
                tirarDado();
                esteJugadorTiroDado=true;
                if(turno==1){ 
                    personajeTurnoActual = personajeJ1;
                }else{ 
                    personajeTurnoActual = personajeJ2;
                }

                if (personajeTurnoActual.equals(Constante.PRI) && veces==0){
                    //Deja tirar otra vez, doble turno
                    esteJugadorTiroDado=false;
                    veces++;
                }else{
                    esteJugadorTiroDado = true;
                    veces=0;
                    cambiaTurno();
                }
            }
        }
    }//GEN-LAST:event_btnTirarActionPerformed
    
    public void mensajeTirarDado (){
        iconoDado = new ImageIcon("src/imagen/dado.PNG");
        JOptionPane.showMessageDialog(null, "Debe tirar el dado para moverse", "No permitido", JOptionPane.DEFAULT_OPTION, iconoDado);
    }
    
    
    private void btnMover_AbajoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMover_AbajoActionPerformed
        moverPersonaje(Constante.ABA);
    }//GEN-LAST:event_btnMover_AbajoActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        moverPersonaje(Constante.DER);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btnMover_ArribaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMover_ArribaActionPerformed
        moverPersonaje(Constante.ARR);
    }//GEN-LAST:event_btnMover_ArribaActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        moverPersonaje(Constante.IZQ);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        atacar(Constante.ABA);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        atacar(Constante.DER);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        atacar(Constante.ARR);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        atacar(Constante.IZQ);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tiempoJuego.interrupt();
        VentanaPrincipal vp = new VentanaPrincipal(historialJuegos);
        vp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaJuego(null, null, 0).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMover_Abajo;
    private javax.swing.JButton btnMover_Arriba;
    private javax.swing.JButton btnTirar;
    private javax.swing.JLabel j1_v1;
    private javax.swing.JLabel j1_v2;
    private javax.swing.JLabel j1_v3;
    private javax.swing.JLabel j1_v4;
    private javax.swing.JLabel j1_v5;
    private javax.swing.JLabel j2_v1;
    private javax.swing.JLabel j2_v2;
    private javax.swing.JLabel j2_v3;
    private javax.swing.JLabel j2_v4;
    private javax.swing.JLabel j2_v5;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblDado;
    private javax.swing.JLabel lblEjemplo;
    private javax.swing.JLabel lblImagenFondo;
    private javax.swing.JLabel lblJ1_P1;
    private javax.swing.JLabel lblJ1_P2;
    private javax.swing.JLabel lblJ1_P3;
    private javax.swing.JLabel lblJ2_P1;
    private javax.swing.JLabel lblJ2_P2;
    private javax.swing.JLabel lblJ2_P3;
    private javax.swing.JLabel lblJugador1;
    private javax.swing.JLabel lblJugador2;
    private javax.swing.JLabel lblTiempo;
    private javax.swing.JLabel nombreJ1;
    private javax.swing.JLabel nombreJ2;
    private javax.swing.JPanel pnlAtaque;
    private javax.swing.JPanel pnlFondoJuego;
    private javax.swing.JPanel pnlJ1;
    private javax.swing.JPanel pnlJ2;
    private javax.swing.JPanel pnlMovimiento;
    private javax.swing.JPanel pnlTablero;
    // End of variables declaration//GEN-END:variables
}
