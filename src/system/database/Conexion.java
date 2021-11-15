/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

/**
 *
 * @author Jorge Ernesto Gomez Giraldo
 */
public class Conexion {
    
    String strConexionDB="jdbc:sqlite:C:/Users/Acer/Documents/NetBeansProjects/system/Database/system.s3db";
    Connection conn = null;
    
    public Conexion(){
        
        try {
            //Referencia para manipular la conexion a la base de datos
            Class.forName("org.sqlite.JDBC");
            conn= DriverManager.getConnection(strConexionDB);
            
            System.out.println("Conexión a la base de datos exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            
            System.err.println("Error de conexión a la base de datos" +e);
        }
        
    }
    public Connection getConnection(){
        return conn;
    }
    //Metodo para devolver información de la base de datos
    public ResultSet consultExpenses(String strSentenceSQL){
        try {
            
            PreparedStatement pstm = conn.prepareStatement(strSentenceSQL);
            ResultSet response = pstm.executeQuery();
            return response;
            
            
        } catch (Exception e) {
            
            System.err.println("Error de conexión a la base de datos" +e);
            return null;
        }
        
    }
    
}
