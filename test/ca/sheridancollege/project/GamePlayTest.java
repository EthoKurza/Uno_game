/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author EthoKurza
 */
public class GamePlayTest {
    
    public GamePlayTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of main method, of class GamePlay.
     */
    @Test
    public void testNumPlayerGood() {
        System.out.println("NumPlayer Good");
        int numP = 3;
        Game uno = new Game("Uno");
        boolean expResult = true; //expected result must be true for good
        int result = uno.cNumPlayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testNumPlayerBad() {
        System.out.println("NumPlayer Bad");
        
        String numP = "3";
        Game uno = new Game("Uno");
        boolean expResult = true; //expected result must be true for good
        int result = uno.cNumPlayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testNumPlayerBoundary() {
        System.out.println("NumPlayer Boundary");
        String numP = "%";
        Game uno = new Game("Uno");
        boolean expResult = true; //expected result must be true for good
        int result = uno.cNumPlayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
