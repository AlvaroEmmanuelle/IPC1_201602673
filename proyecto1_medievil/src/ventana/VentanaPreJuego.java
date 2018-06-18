package ventana;

import java.util.Vector;
import javax.swing.JOptionPane;
import pojo.Guerrero;
import pojo.Partida;
import pojo.Mago;
import pojo.Personaje;
import pojo.Princesa;
import pojo.ResumenJuego;
import utilidades.Constante;

public class VentanaPreJuego extends javax.swing.JFrame {
    Vector<ResumenJuego> historialJuegos;
    int dimensiones;

    public VentanaPreJuego(Vector<ResumenJuego> historialJuegos) {
        initComponents();
        this.historialJuegos=historialJuegos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        nombreJ1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cb_J1_p3 = new javax.swing.JComboBox<>();
        cb_J1_p1 = new javax.swing.JComboBox<>();
        cb_J1_p2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        dim = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        nombreJ2 = new javax.swing.JTextField();
        cb_J2_p3 = new javax.swing.JComboBox<>();
        cb_J2_p1 = new javax.swing.JComboBox<>();
        cb_J2_p2 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(657, 383));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreJ1.setText("J1");
        jPanel1.add(nombreJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 37, 97, -1));

        jLabel3.setText("Tercer turno");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        jLabel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nombre Jugador 1", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 8, 290, 70));

        cb_J1_p3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guerrero", "Princesa", "Mago" }));
        cb_J1_p3.setSelectedIndex(2);
        jPanel1.add(cb_J1_p3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 121, -1));

        cb_J1_p1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guerrero", "Princesa", "Mago" }));
        jPanel1.add(cb_J1_p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 121, -1));

        cb_J1_p2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guerrero", "Princesa", "Mago" }));
        cb_J1_p2.setSelectedIndex(1);
        jPanel1.add(cb_J1_p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 121, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Orden Personajes", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 290, 160));

        jLabel4.setText("Primer turno");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jLabel5.setText("Segundo turno");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/volver64.png"))); // NOI18N
        jButton1.setText("Regresar");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 140, 59));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/play64_v2.png"))); // NOI18N
        jButton2.setText("Jugar");
        jButton2.setBorder(null);
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, 160, 59));

        jLabel13.setText("Dimensiones");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, -1, -1));

        dim.setText("8");
        jPanel1.add(dim, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 70, -1));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 670, 360);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombreJ2.setText("J2");
        jPanel2.add(nombreJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 37, 97, -1));

        cb_J2_p3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guerrero", "Princesa", "Mago" }));
        cb_J2_p3.setSelectedIndex(2);
        jPanel2.add(cb_J2_p3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 121, -1));

        cb_J2_p1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guerrero", "Princesa", "Mago" }));
        jPanel2.add(cb_J2_p1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 121, -1));

        cb_J2_p2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guerrero", "Princesa", "Mago" }));
        cb_J2_p2.setSelectedIndex(1);
        jPanel2.add(cb_J2_p2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 121, -1));

        jLabel6.setText("Tercer turno");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        jLabel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Nombre Jugador 2"));
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 8, 290, 70));

        jLabel8.setBorder(javax.swing.BorderFactory.createTitledBorder("Orden Personajes"));
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 290, 160));

        jLabel9.setText("Primer turno");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, -1, -1));

        jLabel10.setText("Segundo turno");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, -1));

        getContentPane().add(jPanel2);
        jPanel2.setBounds(315, 0, 350, 250);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/escogerGoku2.gif"))); // NOI18N
        getContentPane().add(jLabel11);
        jLabel11.setBounds(40, 0, 530, 560);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/gatoJugando fondo.png"))); // NOI18N
        jLabel12.setText("\\");
            getContentPane().add(jLabel12);
            jLabel12.setBounds(-2, -4, 700, 390);

            pack();
            setLocationRelativeTo(null);
        }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        VentanaPrincipal vp = new VentanaPrincipal(this.historialJuegos);
        vp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(!nombreJ1.getText().isEmpty() && !nombreJ2.getText().isEmpty()){
            if(!cb_J1_p1.getSelectedItem().toString().equals(cb_J1_p2.getSelectedItem().toString()) &&
                    !cb_J1_p1.getSelectedItem().toString().equals(cb_J1_p3.getSelectedItem().toString()) &&
                    !cb_J1_p2.getSelectedItem().toString().equals(cb_J1_p3.getSelectedItem().toString()) ){
                if(!cb_J2_p1.getSelectedItem().toString().equals(cb_J2_p2.getSelectedItem().toString()) &&
                    !cb_J2_p1.getSelectedItem().toString().equals(cb_J2_p3.getSelectedItem().toString()) &&
                    !cb_J2_p2.getSelectedItem().toString().equals(cb_J2_p3.getSelectedItem().toString())){
                    
                    if(!dim.getText().isEmpty()){
                        
                        boolean esEntero = true;
                        try{ 
                            dimensiones = Integer.parseInt(dim.getText()); 
                        }catch(Exception e){ 
                            esEntero = false; 
                        }
                        
                        if(esEntero){
                            if(dimensiones>=8 && dimensiones<=18){
                                Partida jugadorNuevo = new Partida(nombreJ1.getText().toString(), nombreJ2.getText().toString());

                                Personaje p1_j1, p2_j1, p3_j1, p1_j2, p2_j2, p3_j2;

                                Vector<Personaje> listaPersonajesJ1 = new Vector<>();
                                Vector<Personaje> listaPersonajesJ2 = new Vector<>();

                                //Personajes Jugador 1
                                if(cb_J1_p1.getSelectedItem().toString().equals(Constante.GUE)){
                                    p1_j1 = new Guerrero();
                                }else if(cb_J1_p1.getSelectedItem().toString().equals(Constante.PRI)){
                                    p1_j1 = new Princesa();
                                }else{
                                    p1_j1 = new Mago();
                                }
                                listaPersonajesJ1.add(p1_j1);

                                if(cb_J1_p2.getSelectedItem().toString().equals(Constante.GUE)){
                                    p2_j1 = new Guerrero();
                                }else if(cb_J1_p2.getSelectedItem().toString().equals(Constante.PRI)){
                                    p2_j1 = new Princesa();
                                }else{
                                    p2_j1 = new Mago();
                                }
                                listaPersonajesJ1.add(p2_j1);

                                if(cb_J1_p3.getSelectedItem().toString().equals(Constante.GUE)){
                                    p3_j1 = new Guerrero();
                                }else if(cb_J1_p3.getSelectedItem().toString().equals(Constante.PRI)){
                                    p3_j1 = new Princesa();
                                }else{
                                    p3_j1 = new Mago();
                                }
                                listaPersonajesJ1.add(p3_j1);

                                //Personajes Jugador 2
                                if(cb_J2_p1.getSelectedItem().toString().equals(Constante.GUE)){
                                    p1_j2 = new Guerrero();
                                }else if(cb_J2_p1.getSelectedItem().toString().equals(Constante.PRI)){
                                    p1_j2 = new Princesa();
                                }else{
                                    p1_j2 = new Mago();
                                }
                                listaPersonajesJ2.add(p1_j2);

                                if(cb_J2_p2.getSelectedItem().toString().equals(Constante.GUE)){
                                    p2_j2 = new Guerrero();
                                }else if(cb_J2_p2.getSelectedItem().toString().equals(Constante.PRI)){
                                    p2_j2 = new Princesa();
                                }else{
                                    p2_j2 = new Mago();
                                }
                                listaPersonajesJ2.add(p2_j2);

                                if(cb_J2_p3.getSelectedItem().toString().equals(Constante.GUE)){
                                    p3_j2 = new Guerrero();
                                }else if(cb_J2_p3.getSelectedItem().toString().equals(Constante.PRI)){
                                    p3_j2 = new Princesa();
                                }else{
                                    p3_j2 = new Mago();
                                }
                                listaPersonajesJ2.add(p3_j2);

                                jugadorNuevo.setListaPersonajesJ1(listaPersonajesJ1);
                                jugadorNuevo.setListaPersonajesJ2(listaPersonajesJ2);

                                VentanaJuego vj = new VentanaJuego(jugadorNuevo, historialJuegos, Integer.parseInt(dim.getText())); 
                                vj.setVisible(true);
                                this.dispose();
                            }else{
                                mensajeAdvertencia("Debe ingresar una dimension entre 8 - 18 para el tablero","Establecer dimensiones");
                            }
                        }else{
                            mensajeAdvertencia("Debe ingresar un entero para el tablero","Establecer dimensiones");
                        }
                    }else{
                        mensajeAdvertencia("Debe ingresar una dimension para el tablero","Establecer dimensiones");
                    }
                }else{
                    mensajeAdvertencia("Debe seleccionar los 3 personajes distintos para el turno de Jugador 2","Seleccionar Personajes");
                }               
            }else{
                mensajeAdvertencia("Debe seleccionar los 3 personajes distintos para el turno de Jugador 1","Seleccionar Personajes");
            }
        }else{
            mensajeAdvertencia("Debe escribir dos nombres de jugadores","Llenar campos");
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    public void mensajeAdvertencia (String textoMostrar, String tituloMensaje){
        JOptionPane.showMessageDialog(null, textoMostrar,tituloMensaje, JOptionPane.WARNING_MESSAGE);
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
            java.util.logging.Logger.getLogger(VentanaPreJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPreJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPreJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPreJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPreJuego(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_J1_p1;
    private javax.swing.JComboBox<String> cb_J1_p2;
    private javax.swing.JComboBox<String> cb_J1_p3;
    private javax.swing.JComboBox<String> cb_J2_p1;
    private javax.swing.JComboBox<String> cb_J2_p2;
    private javax.swing.JComboBox<String> cb_J2_p3;
    private javax.swing.JTextField dim;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField nombreJ1;
    private javax.swing.JTextField nombreJ2;
    // End of variables declaration//GEN-END:variables
}
