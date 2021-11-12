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
/**
 *
 * @author Jorge Ernesto Gomez Giraldo
 */
public class ExpensesController {
    
    private Connection conexion;
    private static final String get_total = "SELECT SUM(totalExpenses) AS total FROM expenses";
    
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
            System.out.println ("Total gastos de viaje por todos los empleados :  $ "+rs.getBigDecimal(1));       
        }
        // Cierra la conexión a la BD
        rs.close();
        stmt.close();
    }
     
     
}
