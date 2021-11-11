/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.models;

import java.util.Date;

/**
 *
 * @author Jorge Ernesto Gomez Giraldo
 */
public class Expenses {
    
    int idExpenses;
    int idEmployee;
    Date dateExpenses;
    int totalExpenses;

    public int getIdExpenses() {
        return idExpenses;
    }

    public void setIdExpenses(int idExpenses) {
        this.idExpenses = idExpenses;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Date getDateExpenses() {
        return dateExpenses;
    }

    public void setDateExpenses(Date dateExpenses) {
        this.dateExpenses = dateExpenses;
    }

    public int getTotalExpenses() {
        return totalExpenses;
    }

    public void setTotalExpenses(int totalExpenses) {
        this.totalExpenses = totalExpenses;
    }
    
}
