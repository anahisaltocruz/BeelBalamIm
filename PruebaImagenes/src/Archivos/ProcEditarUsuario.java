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
public class ProcEditarUsuario {
    String nombreEU;
    String newNombreEU;
    String newContraseñaEU;
    String newCorreoEU;
    String newCelEU;
    
    String newNumTarjetaEU;
    int cvcEU;
    String nombreTEU;
    String segNombreTEU;
    String primerApTEU;
    String segundoApTEU;
    int fechaVEU;

    public String getNombreEU() {
        return nombreEU;
    }

    public void setNombreEU(String nombreEU) {
        this.nombreEU = nombreEU;
    }

    public String getNewNombreEU() {
        return newNombreEU;
    }

    public void setNewNombreEU(String newNombreEU) {
        this.newNombreEU = newNombreEU;
    }

    public String getNewContraseñaEU() {
        return newContraseñaEU;
    }

    public void setNewContraseñaEU(String newContraseñaEU) {
        this.newContraseñaEU = newContraseñaEU;
    }

    public String getNewCorreoEU() {
        return newCorreoEU;
    }

    public void setNewCorreoEU(String newCorreoEU) {
        this.newCorreoEU = newCorreoEU;
    }

    public String getNewCelEU() {
        return newCelEU;
    }

    public void setNewCelEU(String newCelEU) {
        this.newCelEU = newCelEU;
    }

    public String getNewNumTarjetaEU() {
        return newNumTarjetaEU;
    }

    public void setNewNumTarjetaEU(String newNumTarjetaEU) {
        this.newNumTarjetaEU = newNumTarjetaEU;
    }

    public int getCvcEU() {
        return cvcEU;
    }

    public void setCvcEU(int cvcEU) {
        this.cvcEU = cvcEU;
    }

    public String getNombreTEU() {
        return nombreTEU;
    }

    public void setNombreTEU(String nombreTEU) {
        this.nombreTEU = nombreTEU;
    }

    public String getSegNombreTEU() {
        return segNombreTEU;
    }

    public void setSegNombreTEU(String segNombreTEU) {
        this.segNombreTEU = segNombreTEU;
    }

    public String getPrimerApTEU() {
        return primerApTEU;
    }

    public void setPrimerApTEU(String primerApTEU) {
        this.primerApTEU = primerApTEU;
    }

    public String getSegundoApTEU() {
        return segundoApTEU;
    }

    public void setSegundoApTEU(String segundoApTEU) {
        this.segundoApTEU = segundoApTEU;
    }

    public int getFechaVEU() {
        return fechaVEU;
    }

    public void setFechaVEU(int fechaVEU) {
        this.fechaVEU = fechaVEU;
    }
    
    public void hacerConexionEditUsuario(){
        try {
            try (Connection miConexionEdit = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-KT6L84G:1433;databaseName=BEEL_BALAM","sa", "2020640576")) {
                CallableStatement resConexionBU;
                resConexionBU = miConexionEdit.prepareCall("{call EDITAR_USUARIO(?,?,?,?,?,?,?,?,?,?,?,?)}");
                resConexionBU.setString(1,this.getNombreEU());
                resConexionBU.setString(2,this.getNewNombreEU());
                resConexionBU.setString(3,this.getNewContraseñaEU());
                resConexionBU.setString(4,this.getNewCorreoEU());
                resConexionBU.setString(5,this.getNewCelEU());
                resConexionBU.setString(6,this.getNewNumTarjetaEU());
                resConexionBU.setInt(7,this.getCvcEU());
                resConexionBU.setString(8,this.getNombreTEU());
                resConexionBU.setString(9,this.getSegNombreTEU());
                resConexionBU.setString(10,this.getPrimerApTEU());
                resConexionBU.setString(11,this.getSegundoApTEU());
                resConexionBU.setInt(12,this.getFechaVEU());
                resConexionBU.execute();
                JOptionPane.showMessageDialog(null, "Se han editado correctamente los datos del usuario");
                resConexionBU.close();
            }
        } catch (Exception e) {
            System.out.println("Ha habido un error al editar los datos del usuario");
            System.out.println(e);
        }
    }
}
