/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Anahi SC
 */
public class ProcEliminarUsuario {
    String nombreBU;
    String tarjetaBU;

    public String getNombreBU() {
        return nombreBU;
    }

    public void setNombreBU(String nombreBU) {
        this.nombreBU = nombreBU;
    }

    public String getTarjetaBU() {
        return tarjetaBU;
    }

    public void setTarjetaBU(String tarjetaBU) {
        this.tarjetaBU = tarjetaBU;
    }
    
    public void hacerConexionBUsuario(){
        try {
            try (Connection miConexionBU = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-KT6L84G:1433;databaseName=BEEL_BALAM","sa", "2020640576")) {
                CallableStatement resConexionBU;
                resConexionBU = miConexionBU.prepareCall("{call ELIMINAR_USUARIO(?,?)}");
                resConexionBU.setString(1,getNombreBU());
                resConexionBU.setString(2,getTarjetaBU());
                resConexionBU.execute();
                JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente al usuario");
                resConexionBU.close();
            }
        } catch (Exception e) {
            System.out.println("Ha habido un error al eliminar al usuario");
            System.out.println(e);
        }
    }
}
