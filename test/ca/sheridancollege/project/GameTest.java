/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
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
public class GameTest {
    
    public GameTest() {
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
    //---------------------------------------------------------------//
    
    /**
     * Test of checkCards method, of class Game.
     */
    @Test
    public void testCheckCards() {
        System.out.println("CheckCards Good");
        Card card = new Card(Card.Colour.RED, Card.Value.FIVE);
        Card tCard = new Card(Card.Colour.RED, Card.Value.TWO);
        Game uno = new Game("Uno");
        boolean expResult = true; //expected result must be true for good
        boolean result = uno.checkCards(card, tCard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testCheckCardsBad() {
        System.out.println("CheckCards Bad");

        Card card = new Card(Card.Colour.BLUE, Card.Value.FIVE);
        Card tCard = new Card(Card.Colour.RED, Card.Value.TWO);
        Game uno = new Game("Uno");
        boolean expResult = false; //expected result must be true for good
        boolean result = uno.checkCards(card, tCard);
        assertEquals(expResult, result); 
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testCheckCardsBoundary() {
        System.out.println("CheckCards Boundary");
        Card card = new Card(Card.Colour.BLUE, Card.Value.FIVE);
        Card tCard = new Card(Card.Colour.RED, Card.Value.WILDCARD);
        Game uno = new Game("Uno");
        boolean expResult = true; //expected result must be true for good
        boolean result = uno.checkCards(card, tCard);
        assertEquals(expResult, result); 
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    

    /**
     * Test of cWild method, of class Game.
     */
    @Test
    public void testCWildGood() {
        System.out.println("cWild Good");
        Card card = new Card(Card.Colour.RED, Card.Value.WILDCARD);
        Game instance = new Game("uno");
        boolean expResult = true;
        boolean result = instance.cWild(card);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    public void testCWildBad() {
        System.out.println("cWild Bad");
        Card card = new Card(Card.Colour.BLUE, Card.Value.FIVE);
        Game instance = new Game("uno");
        boolean expResult = false;
        boolean result = instance.cWild(card);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    public void testCWildBoundary() {
        System.out.println("cWild Boundary");
        Card card = new Card(Card.Colour.BLUE, Card.Value.WILDCARD);
        Game instance = new Game("uno");
        boolean expResult = true;
        boolean result = instance.cWild(card);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of cReverse method, of class Game.
     */
    @Test
    public void testCReverseGood() {
        System.out.println("cReverse Good");
        Card card = new Card(Card.Colour.BLUE, Card.Value.REVERSE);
        boolean order = false;
        Game instance = new Game("uno");
        boolean expResult = true;
        boolean result = instance.cReverse(card, order);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testCReverseBad() {
        System.out.println("cReverse Bad");
        Card card = new Card(Card.Colour.GREEN, Card.Value.ZERO);
        boolean order = false;
        Game instance = new Game("uno");
        boolean expResult = false;
        boolean result = instance.cReverse(card, order);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testCReverseBoundary() {
        System.out.println("cReverse Boundary");
        Card card = new Card(Card.Colour.RED, Card.Value.REVERSE);
        boolean order = false;
        Game instance = new Game("uno");
        boolean expResult = true;
        boolean result = instance.cReverse(card, order);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of cPlus method, of class Game.
     */
    @Test
    public void testCPlusGood() {
        System.out.println("cPlus Good");
        Card card = new Card(Card.Colour.BLUE, Card.Value.DRAW_FOUR);
        Game instance = new Game("uno");
        boolean expResult = true;
        boolean result = instance.cPlus(card);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testCPlusBad() {
        System.out.println("cPlus Bad");
        Card card = new Card(Card.Colour.YELLOW, Card.Value.WILDCARD);
        Game instance = new Game("uno");
        boolean expResult = false;
        boolean result = instance.cPlus(card);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    @Test
    public void testCPlusBoundary() {
        System.out.println("cPlus Boundary");
        Card card = new Card(Card.Colour.GREEN, Card.Value.SKIP);
        Game instance = new Game("uno");
        boolean expResult = true;
        boolean result = instance.cPlus(card);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    

    
    

    
    
}
