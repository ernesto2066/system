/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.controllers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import system.database.Conexion;
import system.models.Expenses;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author Jorge Ernesto Gomez Giraldo
 */
public class ExpensesController{
    
    private final Connection conexion;
    private static final String get_total = "SELECT SUM(totalExpenses) AS total FROM expenses";
    private static final String get_months = "SELECT name, totalExpenses, dateExpenses FROM expenses NATURAL JOIN employee ORDER BY name ASC";
    private static final String get_expenses_sura = """
                                                    SELECT name, totalExpenses, dateExpenses  FROM expenses NATURAL JOIN employee 
                                                    WHERE totalExpenses >= 1000000
                                                    ORDER BY name ASC""";
    private static final String get_expenses_employee = """
                                                        SELECT name, totalExpenses, dateExpenses  FROM expenses NATURAL JOIN employee
                                                        WHERE totalExpenses < 1000000
                                                        ORDER BY name ASC""";
    
    
    public ExpensesController() throws SQLException{
        Conexion con= new Conexion();
        this.conexion = con.getConnection();
    
    }
    // SELECT - metodo que retorna el total de los gastos en viajes de todos los empleados.
    public void totalExpenses() throws SQLException{
        
       // String sql = "SELECT SUM(totalExpenses) AS total FROM expenses";
        Statement stmt = this.conexion.createStatement();
        // Recibe el resultado de la consulta SQL
        ResultSet rs = stmt.executeQuery(get_total);
        // Mientras que existasn registros de la consulta imprime el total calculado.
        while(rs.next()) {
            //System.out.println ("Total gastos de viaje por todos los empleados :  $ "+rs.getBigDecimal(1));  
            JOptionPane.showMessageDialog(null,"$ "+rs.getBigDecimal(1),"Total gastos viaje todos los empleados",JOptionPane.INFORMATION_MESSAGE );
            
        }
        // Cierra la conexión a la BD
        rs.close();
        stmt.close();
    }
    // SELECT - metodo que muestra los totales por empleados en cada mes.
    public void monthsExpenses() throws SQLException{
        
        try (Statement stmt = this.conexion.createStatement();
            // Recibe el resultado de la consulta SQL
            ResultSet rs = stmt.executeQuery(get_months)) {
            //Procesar resultado de la consulta
            StringBuilder results = new StringBuilder();
            ResultSetMetaData metaDatos = rs.getMetaData();
            int numberColumns = metaDatos.getColumnCount();

            for (int i = 1; i <=  numberColumns ; i++){
                results.append(metaDatos.getColumnName(i)).append("\t");
            }
            results.append("\n");
            
            while (rs.next()) {
                for (int i = 1; i <= numberColumns; i++) {   
                    results.append(rs.getObject(i)).append("\t");
                }             
                results.append("\n"); 
            }
           //Mostrar información de la consulta en una tabla ordenada alfabeticamente
           JTextArea output=new JTextArea();
           output.append(results.toString());
           JOptionPane.showMessageDialog(null,output,"Tabla de gastos por mes",JOptionPane.INFORMATION_MESSAGE );
           // Cierra la conexión a la BD
           rs.close();
           stmt.close();   
        }          
    }
    // SELECT - metodo que muestra los totales que debe asumir sura para cada empleado acorde a la regla de negocio.
    public void suraExpenses() throws SQLException{
        
        try (Statement stmt = this.conexion.createStatement();
       
            // Recibe el resultado de la consulta SQL
            ResultSet rs = stmt.executeQuery(get_expenses_sura)) {
            //Procesar resultado de la consulta
            StringBuilder results = new StringBuilder();
            ResultSetMetaData metaDatos = rs.getMetaData();
            int numberColumns = metaDatos.getColumnCount();

            for (int i = 1; i <=  numberColumns ; i++){
                results.append(metaDatos.getColumnName(i)).append("\t");
            }
            results.append("\n");
            
            while (rs.next()) {
                for (int i = 1; i <= numberColumns; i++) {   
                    results.append(rs.getObject(i)).append("\t");
                }             
                results.append("\n"); 
            }
           //Mostrar información de la consulta en una tabla ordenada alfabeticamente
           JTextArea output=new JTextArea();
           output.append(results.toString());
           JOptionPane.showMessageDialog(null,output,"Tabla de gastos por mes asumido por sura",JOptionPane.INFORMATION_MESSAGE );
           // Cierra la conexión a la BD
           rs.close();
           stmt.close();   
        }          
    }
    // SELECT - metodo que muestra los totales que debe asumir cada empleado acorde a la regla de negocio.
    public void employeeExpenses() throws SQLException{
        
        try (Statement stmt = this.conexion.createStatement();
            // Recibe el resultado de la consulta SQL
            ResultSet rs = stmt.executeQuery(get_expenses_employee)) {
            //Procesar resultado de la consulta
            StringBuilder results = new StringBuilder();
            ResultSetMetaData metaDatos = rs.getMetaData();
            int numberColumns = metaDatos.getColumnCount();

            for (int i = 1; i <=  numberColumns ; i++){
                results.append(metaDatos.getColumnName(i)).append("\t");
            }
            results.append("\n");
            
            while (rs.next()) {
                for (int i = 1; i <= numberColumns; i++) {   
                    results.append(rs.getObject(i)).append("\t");
                }             
                results.append("\n"); 
            }
           //Mostrar informacion de la consulta en una tabla ordenada alfabeticamente
           JTextArea output=new JTextArea();
           output.append(results.toString());
           JOptionPane.showMessageDialog(null,output,"Tabla de gastos por mes asumido por el empleado",JOptionPane.INFORMATION_MESSAGE );
           // Cierra la conexión a la BD
           rs.close();
           stmt.close();   
        }          
    }
    
}
