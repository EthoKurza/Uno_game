/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the code 
 * should remember to add themselves as a modifier.
 * @author dancye, 2018
 */
public abstract class Card 
{
    //default modifier for child classes
    
    /**
     * Students should implement this method for their specific children classes 
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    
        public enum Colour {RED,YELLOW,GREEN,BLUE};
        public enum Value{ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, REVERSE, SKIP, DRAW_TWO, DRAW_FOUR, WILDCARD };
        private final Colour colour;
        private final Value value;
        
        //Constructor
        public Card(Colour c, Value v){
            this.colour = c;
            this.value = v;
        }
        
    @Override
    public abstract String toString();

	public Colour getColour() {
		return this.colour;
	}

	/**
	 * 
	 * @param colour
	 */


	public Value getValue() {
		return this.value;
	}

	/**
	 * 
	 * @param value
	 */

}
