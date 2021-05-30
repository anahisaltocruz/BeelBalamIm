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
public class ProcCrearUsuario {
    private String nombreU;
    private String contraseniaU;
    private String correoU;
    private String numCelularU; 
    private int ptosAcum;
    
    private int cvcT;
    private String nombreT;
    private String segNombreT;
    private String primerApT;
    private String segApT;
    private int fechaT;
    private String numeroT;

    public String getNombreU() {
        return nombreU;
    }

    public String getContraseniaU() {
        return contraseniaU;
    }

    public String getCorreoU() {
        return correoU;
    }

    public String getNumCelularU() {
        return numCelularU;
    }

    public int getPtosAcum() {
        return ptosAcum;
    }

    public int getCvcT() {
        return cvcT;
    }

    public String getNombreT() {
        return nombreT;
    }

    public String getSegNombreT() {
        return segNombreT;
    }

    public String getPrimerApT() {
        return primerApT;
    }

    public String getSegApT() {
        return segApT;
    }

    public void setNombreU(String nombreU) {
        this.nombreU = nombreU;
    }

    public void setContraseniaU(String contraseniaU) {
        this.contraseniaU = contraseniaU;
    }

    public void setCorreoU(String correoU) {
        this.correoU = correoU;
    }

    public void setNumCelularU(String numCelularU) {
        this.numCelularU = numCelularU;
    }

    public void setPtosAcum(int ptosAcum) {
        this.ptosAcum = ptosAcum;
    }

    public void setCvcT(int cvcT) {
        this.cvcT = cvcT;
    }

    public void setNombreT(String nombreT) {
        this.nombreT = nombreT;
    }

    public void setSegNombreT(String segNombreT) {
        this.segNombreT = segNombreT;
    }

    public void setPrimerApT(String primerApT) {
        this.primerApT = primerApT;
    }

    public void setSegApT(String segApT) {
        this.segApT = segApT;
    }

    public int getFechaT() {
        return fechaT;
    }

    public void setFechaT(int fechaT) {
        this.fechaT = fechaT;
    }

    public String getNumeroT() {
        return numeroT;
    }

    public void setNumeroT(String numeroT) {
        this.numeroT = numeroT;
    }
    
    public void hacerConexion(){
        try {                                               try ( //DESKTOP-KT6L84G
                Connection miConexion = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-KT6L84G:1433;databaseName=BEEL_BALAM","sa", "2020640576") //2020640576
            ) {
            CallableStatement resConexion;
            resConexion = miConexion.prepareCall("{call CREAR_USUARIO(?,?,?,?,?,?,?,?,?,?,?,?)}");
            resConexion.setString(1,this.getNombreU());
            resConexion.setString(2,this.getContraseniaU());
            resConexion.setString(3,this.getCorreoU());
            resConexion.setString(4,this.getNumCelularU());
            resConexion.setInt(5,this.getPtosAcum());
            resConexion.setInt(6,this.getCvcT());
            resConexion.setString(7,this.getNombreT());
            resConexion.setString(8,this.getSegNombreT());
            resConexion.setString(9,this.getPrimerApT());
            resConexion.setString(10,this.getSegApT());
            resConexion.setInt(11,this.getFechaT());
            resConexion.setString(12,this.getNumeroT());
            JOptionPane.showMessageDialog(null, "Se ha agreago correctamente al usuario");
            resConexion.execute();
            resConexion.close();
            }
        } catch (Exception e) {
            System.out.println("Ha habido un error al crear al usuario");
            System.out.println(e);
        }
    }
}
