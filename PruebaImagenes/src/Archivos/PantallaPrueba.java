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
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Anahi SC
 */
public class PantallaPrueba extends javax.swing.JFrame {
    PantallaVentanas pantallaVent;
    PantallaRegistro pantallaReg;
    Connection conex;
    CallableStatement stm;
    ResultSet rs;
    public static String nUsuarioPI;
    FondoPanel fondo = new FondoPanel();
    
    public PantallaPrueba() {
        
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

        panelP = new FondoPanel();
        btnRegistrate = new javax.swing.JButton();
        btnIniciarS = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        txtContra = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelP.setBackground(new java.awt.Color(255, 0, 255));

        btnRegistrate.setText("¡Registrate!");
        btnRegistrate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrateActionPerformed(evt);
            }
        });

        btnIniciarS.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnIniciarS.setText("INICIAR SESIÓN");
        btnIniciarS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarSActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 2, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BEEL BALAM");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("USUARIO:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CONTRASEÑA:");

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txtContra.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("¿No tienes cuenta?");

        javax.swing.GroupLayout panelPLayout = new javax.swing.GroupLayout(panelP);
        panelP.setLayout(panelPLayout);
        panelPLayout.setHorizontalGroup(
            panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPLayout.createSequentialGroup()
                .addContainerGap(157, Short.MAX_VALUE)
                .addGroup(panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(btnRegistrate))
                    .addGroup(panelPLayout.createSequentialGroup()
                        .addGroup(panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(81, 81, 81)
                        .addGroup(panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addComponent(btnIniciarS)))
                .addGap(89, 89, 89))
            .addGroup(panelPLayout.createSequentialGroup()
                .addGap(276, 276, 276)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelPLayout.setVerticalGroup(
            panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btnIniciarS, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(18, 18, 18)
                .addGroup(panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
                .addGroup(panelPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrate)
                    .addComponent(jLabel4))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrateActionPerformed
/*        panelPrueba = new PanelPrueba();
        panelPrueba.setBounds(panelP.getBounds());
        panelP.removeAll();
        panelP.add(panelPrueba);
        panelP.updateUI();*/
        pantallaReg = new PantallaRegistro();
        this.setVisible(false);
        pantallaReg.setVisible(true);  
    }//GEN-LAST:event_btnRegistrateActionPerformed

    private void btnIniciarSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarSActionPerformed
        String nombre = null;
        String contra = null;
        
        try {
            //Conecta
            conex = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-3A3Q5S9M\\SQLEXPRESS:1433;databaseName=BEEL_BALAM","sa", "ABCpiz12");
            //Busca el usuario
            stm = conex.prepareCall("{call VALIDAR_INICIOSESION(?)}");
            String uIS = this.txtUsuario.getText();
            nUsuarioPI = this.txtUsuario.getText();//posible redundancia
            stm.setString(1, uIS);
            rs = stm.executeQuery();
            if(rs.next()){ //si encuentra el usuario, verifica que la contraseña sea correcta
                contra = rs.getString(1);
                System.out.println(contra);
                if(contra.equals(this.txtContra.getText())){
                    //Cambio de panel
                    //panelWindow = new Window();
                    
                    pantallaVent = new PantallaVentanas();
                    pantallaVent.setUser(this.txtUsuario.getText());
                    this.setVisible(false);
                    pantallaVent.setVisible(true);  
                    
                }else{
                    JOptionPane.showMessageDialog(null, "Contraseña incorrecta! Intente de nuevo");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Usuario no encontrado");
            }
            rs.close();
            stm.close();
            conex.close();
        } catch (SQLException ex) {
            System.out.println("ERROR :c");
        }
        
    }//GEN-LAST:event_btnIniciarSActionPerformed

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
            java.util.logging.Logger.getLogger(PantallaPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaPrueba().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarS;
    private javax.swing.JButton btnRegistrate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel panelP;
    private javax.swing.JPasswordField txtContra;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    class FondoPanel extends JPanel{
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
