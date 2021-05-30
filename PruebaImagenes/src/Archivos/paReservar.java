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
public class paReservar {
    //ATRIBUTOS 
    private String pNombre;
    private String sNombre;
    private String pApellido;
    private String sApellido;
    private int edad;
    private String ncd;
    private String matTren;
    private int dateR;
    private String nombreUs;
    private String nombreTr;  
    //METODOS

    public String getpNombre() {
        return pNombre;
    }

    public void setpNombre(String pNombre) {
        this.pNombre = pNombre;
    }

    public String getsNombre() {
        return sNombre;
    }

    public void setsNombre(String sNombre) {
        this.sNombre = sNombre;
    }

    public String getpApellido() {
        return pApellido;
    }

    public void setpApellido(String pApellido) {
        this.pApellido = pApellido;
    }

    public String getsApellido() {
        return sApellido;
    }

    public void setsApellido(String sApellido) {
        this.sApellido = sApellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNcd() {
        return ncd;
    }

    public void setNcd(String ncd) {
        this.ncd = ncd;
    }

    public String getMatTren() {
        return matTren;
    }

    public void setMatTren(String matTren) {
        this.matTren = matTren;
    }

    public int getDateR() {
        return dateR;
    }

    public void setDateR(int dateR) {
        this.dateR = dateR;
    }

    public String getNombreUs() {
        return nombreUs;
    }

    public void setNombreUs(String nombreUs) {
        this.nombreUs = nombreUs;
    }

    public String getNombreTr() {
        return nombreTr;
    }

    public void setNombreTr(String nombreTr) {
        this.nombreTr = nombreTr;
    }
    
    public void hacerConexionrRe(){
        try {                                               try ( //DESKTOP-KT6L84G
                Connection miConexion = DriverManager.getConnection(
                        "jdbc:sqlserver://DESKTOP-KT6L84G:1433;databaseName=BEEL_BALAM", "sa", "2020640576") //2020640576
            ) {
            CallableStatement resConexion;
            resConexion = miConexion.prepareCall("{call COMPRA_BOLETOS(?,?,?,?,?,?,?,?,?,?)}");
            resConexion.setString(1,this.getpNombre());
            resConexion.setString(2,this.getsNombre());
            resConexion.setString(3,this.getpApellido());
            resConexion.setString(4,this.getsApellido());
            resConexion.setInt(5,this.getEdad());
            resConexion.setString(6,this.getNcd());
            resConexion.setString(7,this.getMatTren());
            resConexion.setInt(8,this.getDateR());
            resConexion.setString(9,this.getNombreUs());
            resConexion.setString(10,this.getNombreTr());
            JOptionPane.showMessageDialog(null, "Se ha generado correctamente la reserva");
            resConexion.close();
            }
        } catch (Exception e) {
            System.out.println("Ha habido un error al generar la reserva");
            System.out.println(e);
        }
    }
}
