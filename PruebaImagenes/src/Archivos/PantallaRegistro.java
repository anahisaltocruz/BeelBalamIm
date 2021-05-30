/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.awt.Graphics;
import java.awt.Image;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Anahi SC
 */
public class PantallaRegistro extends javax.swing.JFrame {
    
    PantallaTarjeta pantallaTarj;
    public static String nUsuario;
    public static String cont;
    public static String numCel;
    public static String correo; 
    
    FondoPantallaReg fondo = new FondoPantallaReg();
    public PantallaRegistro() {
        this.setContentPane(fondo);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoPantallaReg();
        btnAgregarTarjeta = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        txtNumCelular = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtContrasenia = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 255, 0));

        btnAgregarTarjeta.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        btnAgregarTarjeta.setText("AGREGAR DATOS DE TARJETA");
        btnAgregarTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTarjetaActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("REGISTRATE EN BEEL BALAM");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOMBRE DE USUARIO:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CONTRASEÑA:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("NÚMERO DE CELULAR:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CORREO ELECTRÓNICO: ");

        txtNombreUsuario.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        txtNumCelular.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        txtCorreo.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        txtContrasenia.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreUsuario)
                            .addComponent(txtNumCelular)
                            .addComponent(txtCorreo)
                            .addComponent(txtContrasenia, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addComponent(btnAgregarTarjeta)))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombreUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(txtContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNumCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(btnAgregarTarjeta)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTarjetaActionPerformed
        //PARA RECUPERAR LOS DATOS DEL NUEVO USUARIO
        boolean test = false;
        if((txtNombreUsuario.getText().length()>25)||
                txtNombreUsuario.getText().isEmpty()||
                (txtCorreo.getText().length()>35)||
                (txtCorreo.getText().isEmpty())||
                (txtNumCelular.getText().length()>14)||
                (txtNumCelular.getText().isEmpty())||
                (txtContrasenia.getText().length()>17)||
                (txtContrasenia.getText().isEmpty())){
            JOptionPane.showMessageDialog(null, "¡Error! Alguno o varios datos son incorrectos (demasiado largo o vacio)");
            txtNombreUsuario.setText("");
            txtCorreo.setText("");
            txtNumCelular.setText("");
            txtContrasenia.setText("");
            test = true;
        }
        if(test == false){
            nUsuario = txtNombreUsuario.getText();
            cont = txtContrasenia.getText();
            numCel = txtNumCelular.getText();
            correo = txtCorreo.getText();
            //PARA VERIFICAR QUE EL USUARIO NO EXISTA
            try{
                try (Connection miConexion = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-KT6L84G:1433;databaseName=BEEL_BALAM","sa", "2020640576") //2020640576
                ) {
                    CallableStatement resConexion;
                    resConexion = miConexion.prepareCall("{call VERIFICAR_USUARIO(?)}");
                    resConexion.setString(1,nUsuario);
                    ResultSet rs = resConexion.executeQuery();
                    if(rs.next()){
                        System.out.println("Ya existe ese usuario");
                        JOptionPane.showMessageDialog(null, "El usuario que ha ingresado ya existe, por favor intente con uno nuevo");
                        txtNombreUsuario.setText("");
                        txtCorreo.setText("");
                        txtNumCelular.setText("");
                        txtContrasenia.setText("");
                    }else{
                        //System.out.println("No existe ese usuario");
                        //PARA IR AL PANEL DE TARJETA
                      /*  panelTarjeta = new PanelTarjeta();
                        panelTarjeta.setBounds(this.getBounds());
                        this.removeAll();
                        this.add(panelTarjeta);
                        this.updateUI();*/
                        pantallaTarj = new PantallaTarjeta();
                        this.setVisible(false);
                        pantallaTarj.setVisible(true); 
                    }   
                    rs.close();
                    resConexion.close();
                    //JOptionPane.showMessageDialog(null, "Se ha agreago correctamente al usuario");
                }
            }catch(Exception e){
                System.out.println("Ha habido un error al crear al usuario 2 ");
                System.out.println(e);
            }
        }  
    }//GEN-LAST:event_btnAgregarTarjetaActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaRegistro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarTarjeta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtContrasenia;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombreUsuario;
    private javax.swing.JTextField txtNumCelular;
    // End of variables declaration//GEN-END:variables

    class FondoPantallaReg extends JPanel{
       private Image imagen; 
       
       @Override
       public void paint(Graphics g){
           imagen = new ImageIcon(getClass().getResource("/imagenes/registro.jpeg")).getImage();
           g.drawImage(imagen,0,0,getWidth(),getHeight(),this);
           setOpaque(false);
           super.paint(g);
       }
    }

}