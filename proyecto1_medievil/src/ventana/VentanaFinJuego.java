package ventana;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import pojo.Partida;
import pojo.ResumenJuego;

public class VentanaFinJuego extends javax.swing.JFrame {
    public Vector<ResumenJuego> historialJuegos;
    public Partida jugadaTerminada;
    private ResumenJuego juegoActual;
    
    public VentanaFinJuego(Vector<ResumenJuego> historialJuegos, ResumenJuego juegoActual, Partida jugadaTerminada) {
        initComponents();
        this.historialJuegos = historialJuegos;
        this.juegoActual = juegoActual;
        this.jugadaTerminada = jugadaTerminada;
        
        nombreJ1.setText(jugadaTerminada.getNombreJugador1());
        nombreJ2.setText(jugadaTerminada.getNombreJugador2());
        vidaJ1.setText(""+jugadaTerminada.getVidaJugador1());
        vidaJ2.setText(""+jugadaTerminada.getVidaJugador2());
        estadoJuego.setText(juegoActual.getResultadoPartida());
        tiempoPartida.setText(juegoActual.getTiempoPartida());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jLabel3 = new javax.swing.JLabel();
        estadoJuego2 = new javax.swing.JLabel();
        tiempoPartida = new javax.swing.JLabel();
        estadoJuego1 = new javax.swing.JLabel();
        estadoJuego = new javax.swing.JLabel();
        vidaJ1 = new javax.swing.JLabel();
        nombreJ1 = new javax.swing.JLabel();
        vidaJ2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nombreJ2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        lblPartidaTerminada = new javax.swing.JLabel();
        ImagenFondo = new javax.swing.JLabel();
        ColorFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Fin de la Partida");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(767, 520));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(767, 500));

        jLayeredPane1.setMinimumSize(new java.awt.Dimension(32767, 32767));
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(767, 521));

        jLabel3.setFont(new java.awt.Font("Encino Caps", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 102, 0));
        jLabel3.setText("Vida");
        jLayeredPane1.add(jLabel3);
        jLabel3.setBounds(20, 190, 120, 50);

        estadoJuego2.setFont(new java.awt.Font("Encino Caps", 1, 18)); // NOI18N
        estadoJuego2.setForeground(new java.awt.Color(51, 255, 0));
        estadoJuego2.setText("Tiempo partida");
        jLayeredPane1.add(estadoJuego2);
        estadoJuego2.setBounds(480, 320, 190, 50);

        tiempoPartida.setFont(new java.awt.Font("Encino Caps", 1, 18)); // NOI18N
        tiempoPartida.setForeground(new java.awt.Color(51, 255, 0));
        tiempoPartida.setText("nombre");
        jLayeredPane1.add(tiempoPartida);
        tiempoPartida.setBounds(500, 360, 150, 50);

        estadoJuego1.setFont(new java.awt.Font("Encino Caps", 1, 18)); // NOI18N
        estadoJuego1.setForeground(new java.awt.Color(51, 255, 0));
        estadoJuego1.setText("Estado partida");
        jLayeredPane1.add(estadoJuego1);
        estadoJuego1.setBounds(140, 320, 190, 50);

        estadoJuego.setFont(new java.awt.Font("Encino Caps", 1, 18)); // NOI18N
        estadoJuego.setForeground(new java.awt.Color(51, 255, 0));
        estadoJuego.setText("nombre");
        jLayeredPane1.add(estadoJuego);
        estadoJuego.setBounds(70, 360, 240, 50);

        vidaJ1.setFont(new java.awt.Font("Encino Caps", 1, 18)); // NOI18N
        vidaJ1.setForeground(new java.awt.Color(255, 102, 0));
        vidaJ1.setText("nombre");
        jLayeredPane1.add(vidaJ1);
        vidaJ1.setBounds(20, 250, 120, 50);

        nombreJ1.setFont(new java.awt.Font("Encino Caps", 1, 18)); // NOI18N
        nombreJ1.setForeground(new java.awt.Color(0, 204, 102));
        nombreJ1.setText("nombre");
        jLayeredPane1.add(nombreJ1);
        nombreJ1.setBounds(20, 130, 120, 50);

        vidaJ2.setFont(new java.awt.Font("Encino Caps", 1, 18)); // NOI18N
        vidaJ2.setForeground(new java.awt.Color(255, 102, 0));
        vidaJ2.setText("nombre");
        jLayeredPane1.add(vidaJ2);
        vidaJ2.setBounds(630, 240, 120, 50);

        jLabel5.setFont(new java.awt.Font("Encino Caps", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 102, 0));
        jLabel5.setText("Vida");
        jLayeredPane1.add(jLabel5);
        jLabel5.setBounds(630, 180, 120, 50);

        jLabel2.setFont(new java.awt.Font("Encino Caps", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 204, 102));
        jLabel2.setText("Jugador 1");
        jLayeredPane1.add(jLabel2);
        jLabel2.setBounds(20, 70, 120, 50);

        nombreJ2.setFont(new java.awt.Font("Encino Caps", 1, 18)); // NOI18N
        nombreJ2.setForeground(new java.awt.Color(0, 204, 102));
        nombreJ2.setText("nombre");
        jLayeredPane1.add(nombreJ2);
        nombreJ2.setBounds(630, 120, 120, 50);

        jLabel4.setFont(new java.awt.Font("Encino Caps", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 204, 102));
        jLabel4.setText("Jugador 2");
        jLayeredPane1.add(jLabel4);
        jLabel4.setBounds(630, 60, 120, 50);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/home.png"))); // NOI18N
        jButton1.setText("Home");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jLayeredPane1.add(jButton1);
        jButton1.setBounds(320, 460, 160, 50);

        lblPartidaTerminada.setFont(new java.awt.Font("Encino Caps", 1, 24)); // NOI18N
        lblPartidaTerminada.setForeground(new java.awt.Color(255, 255, 255));
        lblPartidaTerminada.setText("PARTIDA Terminada");
        jLayeredPane1.add(lblPartidaTerminada);
        lblPartidaTerminada.setBounds(270, 0, 290, 40);

        ImagenFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/FinalGoku.gif"))); // NOI18N
        jLayeredPane1.add(ImagenFondo);
        ImagenFondo.setBounds(150, 0, 470, 470);

        ColorFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/fondoColorPollo.png"))); // NOI18N
        jLayeredPane1.add(ColorFondo);
        ColorFondo.setBounds(0, 0, 767, 520);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 520, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VentanaPrincipal vp = new VentanaPrincipal(historialJuegos);
        this.dispose();
        crearOtro();
        vp.setVisible(true);
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

        public void crearOtro() {
        String ruta = "Archivo.txt";
        File archivo = new File(ruta);
        PrintWriter pt;

        try {
            if (archivo.exists()) {

                pt = new PrintWriter(new FileWriter(ruta, true));
                pt.println("Jugadores:"+jugadaTerminada.getNombreJugador1()+"y"+jugadaTerminada.getNombreJugador2()+
                        juegoActual.getResultadoPartida()+"Tiempo:"+juegoActual.getTiempoPartida());

            } else {

                pt = new PrintWriter(new FileWriter(ruta));
                pt.println("Jugadores:"+jugadaTerminada.getNombreJugador1()+"y"+jugadaTerminada.getNombreJugador2()+
                        "Ganador:"+juegoActual.getResultadoPartida()+"Tiempo:"+juegoActual.getTiempoPartida());
            }
            pt.close();
        } catch (IOException i) {

          }
    }
      
//    public Vector<ResumenJuego> obtenerPersonas(String archivo) throws FileNotFoundException, IOException {
//        String cadena = "";
//
//        Vector<ResumenJuego> per = new Vector<ResumenJuego>();
//
//        FileReader fr = new FileReader(archivo);
//        BufferedReader br = new BufferedReader(fr);
//        int linea = 0;
//        while ((cadena = br.readLine()) != null && linea < 5) {
//            System.out.println(cadena);
//            String[] cadenap = cadena.split(",");
//            per<linea> = new ResumenJuego(Integer.parseInt(cadenap<1>.trim()), cadenap<0>);
//            linea++;
//        }
//        br.close();
//        return per;
//    }
    
    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(VentanaFinJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaFinJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaFinJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaFinJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaFinJuego(null,null,null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ColorFondo;
    private javax.swing.JLabel ImagenFondo;
    private javax.swing.JLabel estadoJuego;
    private javax.swing.JLabel estadoJuego1;
    private javax.swing.JLabel estadoJuego2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JLabel lblPartidaTerminada;
    private javax.swing.JLabel nombreJ1;
    private javax.swing.JLabel nombreJ2;
    private javax.swing.JLabel tiempoPartida;
    private javax.swing.JLabel vidaJ1;
    private javax.swing.JLabel vidaJ2;
    // End of variables declaration//GEN-END:variables
}
