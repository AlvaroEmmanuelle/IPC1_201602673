package ventana;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import pojo.ResumenJuego;

public class VentanaRecord extends javax.swing.JFrame {
    Vector<ResumenJuego> historialJuegos;

    public VentanaRecord(Vector<ResumenJuego> historialJuegos) {
        initComponents();
        this.historialJuegos = historialJuegos;
        
        for (int i=0; i<historialJuegos.size(); i++){
            String a = txtRercord.getText();
            txtRercord.setText(a+"\n"+"Jugadores: "+
                    historialJuegos.get(i).getPartidaJugada().getNombreJugador1()+" y "+historialJuegos.get(i).getPartidaJugada().getNombreJugador2()+
                    " Resultado: "+historialJuegos.get(i).getResultadoPartida()+" Tiempo: "+historialJuegos.get(i).getTiempoPartida());
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtRercord = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        lblPartidaTerminada = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(719, 334));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRercord.setColumns(20);
        txtRercord.setRows(10);
        txtRercord.setBorder(null);
        txtRercord.setEnabled(false);
        jScrollPane1.setViewportView(txtRercord);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 430, 240));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/home.png"))); // NOI18N
        jButton1.setText("Volver");
        jButton1.setBorder(null);
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 210, 160, 50));

        lblPartidaTerminada.setFont(new java.awt.Font("Encino Caps", 1, 24)); // NOI18N
        lblPartidaTerminada.setForeground(new java.awt.Color(0, 102, 102));
        lblPartidaTerminada.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPartidaTerminada.setText("Mejores tiempos");
        getContentPane().add(lblPartidaTerminada, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 430, 40));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/gokurecord.gif"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 390, 200));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -20, 730, 360));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VentanaPrincipal vp = new VentanaPrincipal(historialJuegos);
        vp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed
    
        public void crearOtro() {
        String ruta = "Archivo.txt";
        File archivo = new File(ruta);
        PrintWriter pt;

        try {
            if (archivo.exists()) {
                pt = new PrintWriter(new FileWriter(ruta, true));
                pt.println("Jugadores:");

            } else {

                pt = new PrintWriter(new FileWriter(ruta));
                pt.println("Alvaro,7 ");
            }
            pt.close();
        } catch (IOException i) {

          }
    }
    
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
            java.util.logging.Logger.getLogger(VentanaRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaRecord.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaRecord(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPartidaTerminada;
    private javax.swing.JTextArea txtRercord;
    // End of variables declaration//GEN-END:variables
}
