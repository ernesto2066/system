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
        // Instancia de los metodos del controlador
        ExpensesController data= new ExpensesController();
        data.totalExpenses();//Metodo con los totales de todos los empleados
        data.monthsExpenses();//Metodo con los gastos por meses de cada empleado
        data.suraExpenses();//Metodo con los totales que se deben asumir por sura 
        data.employeeExpenses();//Metodo con los totales que se deben asumir los empleados de sura
        
    }
    
}
