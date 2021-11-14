/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.controllers;

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
public class ExpensesControllerIT {
    
    public ExpensesControllerIT() {
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
     * Test of totalExpenses method, of class ExpensesController.
     */
    @Test
    public void testTotalExpenses() throws Exception {
        System.out.println("totalExpenses");
        ExpensesController instance = new ExpensesController();
        instance.totalExpenses();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of monthsExpenses method, of class ExpensesController.
     */
    @Test
    public void testMonthsExpenses() throws Exception {
        System.out.println("monthsExpenses");
        ExpensesController instance = new ExpensesController();
        instance.monthsExpenses();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
