/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Jorge Ernesto Gomez Giraldo
 */
public class ConexionIT {
    
    public ConexionIT() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getConnection method, of class Conexion.
     */
    @Test
    public void testGetConnection() throws SQLException {
        System.out.println("getConnection");
        String sql = "SELECT * FROM expenses";
        Conexion instance = new Conexion();
        Connection expResult;
        expResult = instance.getConnection();
        // Recibe el resultado de la consulta SQL
        try (Statement stmt = expResult.createStatement(); 
                ResultSet rs = stmt.executeQuery(sql)) {
            while(rs.next()) {
                System.out.println ("Consulta de prueba : "+rs); 
            }
            // Cierra la conexión a la BD
            rs.close();
            stmt.close();
        }
    }

    /**
     * Test of consultExpenses method, of class Conexion.
     */
    @Test
    public void testConsultExpenses() {
        System.out.println("consultExpenses");
        String strSentenceSQL = "";
        Conexion instance = new Conexion();
        ResultSet expResult = null;
        ResultSet result = instance.consultExpenses(strSentenceSQL);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
