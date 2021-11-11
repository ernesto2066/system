/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import system.database.Conexion;

/**
 *
 * @author Jorge Ernesto Gomez Giraldo
 */
public class System {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Conexion conex= new Conexion();
        //conex.getConnection();
        conex.consultExpenses("SELECT * from expenses");
        
    }
    
}
