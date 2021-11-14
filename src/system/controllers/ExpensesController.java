/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import system.database.Conexion;
import system.models.Expenses;
import java.sql.*;
import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Jorge Ernesto Gomez Giraldo
 */
public class ExpensesController {
    
    private final Connection conexion;
    private static final String get_total = "SELECT SUM(totalExpenses) AS total FROM expenses";
    private static final String get_months = "SELECT name, totalExpenses, dateExpenses FROM expenses NATURAL JOIN employee ORDER BY name ASC";
    
    public ExpensesController() throws SQLException{
        Conexion con= new Conexion();
        this.conexion = con.getConnection();
        //conex.consultExpenses("SELECT * from expenses");
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
            JOptionPane.showMessageDialog(null,rs.getBigDecimal(1),"Total gastos viaje todos los empleados",JOptionPane.INFORMATION_MESSAGE );
            
        }
        // Cierra la conexión a la BD
        rs.close();
        stmt.close();
    }
    // SELECT - metodo que devuelve una lista con el resultado de la consulta.
    public void monthsExpenses() throws SQLException{
        
        List<Expenses> lista;
        // Recibe el resultado de la consulta SQL
        try (Statement stmt = this.conexion.createStatement();
        //stmt.setString(1, titulo);
        // Recibe el resultado de la consulta SQL
                ResultSet rs = stmt.executeQuery(get_months)) {
            //Procesar resultado de la consulta
            StringBuilder results = new StringBuilder();
            ResultSetMetaData metaDatos = rs.getMetaData();
            int numberColumns = metaDatos.getColumnCount();

            for (int i = 1; i <=  numberColumns ; i++)
                results.append(metaDatos.getColumnName(i)).append("\t");
            results.append("\n");
            
            while (rs.next()) {
                for (int i = 1; i <= numberColumns; i++) {   
                    results.append(rs.getObject(i)).append("\t");
                 results.append("\n"); 
                }             
            }
            
            JTextArea output=new JTextArea(results.toString());
            //output.append(results.toString());
            JOptionPane.showMessageDialog(null,output,"Gastos Con Mes",JOptionPane.INFORMATION_MESSAGE );
             // Cierra la conexión a la BD
            rs.close();
            stmt.close();
            //lista = new ArrayList<>();
            //lista.add(results);
            //Configuracion del resultado en una ventana grafica
            //System.out.println ("Prueba Salida :  $ "+results.toString());
            
            
            
            /*
            JTextArea textArea = new JTextArea(results.toString());
            Container content = getContentPane();
            
            content.add(new JScrollPane(textArea));
            
            output.setSize (320 , 130);
            output.setVisible(true);
            */
            /*
            lista = new ArrayList<>();
            // Siempre que haya registros, tome los valores del ReultSet y agréguelos a la lista
            while(rs.next()) {
                //  En cada bucle, cree una instancia de un nuevo objeto, para que sirva como puente en el envío de registros a la lista.
                Expenses l = new Expenses();
                
                // "l" -> Nuevo registro - .setName recibe el campo de banco de cadenas "titulo"
                l.setIdLibros(Integer.valueOf(rs.getString("idLibro")));
                l.setIdAutores(Integer.valueOf(rs.getString("idAutor")));
                l.setIdUsuarios(Integer.valueOf(rs.getString("idUsuarios")));
                l.setIdCopias(Integer.valueOf(rs.getString("idCopias")));
                l.setTitulos(rs.getString("titulo"));
                l.setTipos(rs.getString("tipo"));
                l.setEditoriales(rs.getString("editorial"));
                l.setAños(rs.getString("año"));
                l.setEdiciones(rs.getString("edicion"));
                
                // Agrega el registro a la lista
                lista.add(l);
            }   // Cierra la conexión a la BD
            */
        }
        
        // Devuelve la lista de registros generada por la consulta.
               
    }
}
