/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system;

import java.sql.SQLException;
import system.controllers.ExpensesController;

/**
 *
 * @author Jorge Ernesto Gomez Giraldo
 */
public class System {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here
        ExpensesController data= new ExpensesController();
        data.totalExpenses();
        data.monthsExpenses();
        
    }
    
}
