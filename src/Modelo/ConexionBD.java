/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author coromoro
 */
public class ConexionBD {
    
    public static Connection conexion;
            
    private ConexionBD() {
        try {
            String driverBD = "com.mysql.cj.jdbc.Driver";//"com.mysql.jdbc.Driver";
            String urlBD ="jdbc:mysql://localhost/TrabajoTienda";
            String usuarioBD = "root";
            String claveBD ="";
            Class.forName(driverBD);
            conexion = DriverManager.getConnection(urlBD, usuarioBD, claveBD);
        }catch (ClassNotFoundException ex) {
            System.err.println("no encuentro driver"+ex.getMessage());
        }catch (SQLException ex){
            System.err.println("error al conectarme"+ex.getMessage());
        }
    }
    public static void desconectar(){
        try{
            conexion.close();
        }catch (SQLException ex) {
            System.err.println("error al desconectarme :"+ex.getSQLState());
        }
    }
    public static ConexionBD getInstance() {
        return ConexionDBHolder.INSTANCE;
    }
    private static class ConexionDBHolder {

        private static final ConexionBD INSTANCE = new ConexionBD();
    }
}
