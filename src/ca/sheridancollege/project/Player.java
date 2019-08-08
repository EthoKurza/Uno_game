/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 * @author dancye, 2018
 */
public class Player
{
    private String playerID; //the unique ID for this player
    private ArrayList<Card> pCards = new ArrayList<Card>(); //card list array
    
    /**
     * A constructor that allows you to set the player's unique ID
     * @param name the unique ID to assign to this player.
     */
    public Player(String name)
    {
        playerID= name;
    }
    
    /**
     * @return the playerID
     */
    public String getPlayerID() 
    {
        return playerID;
    }

    /**
     * Ensure that the playerID is unique
     * @param givenID the playerID to set
     */
    public void setPlayerID(String givenID) 
    {
        playerID = givenID;
    }
    
    //add cards to player's hand
    public void addPlayerCards(Card pCard){
        pCards.add(pCard);
    }
    
    //get player's cards
    public void getPlayerCards(){
        int i=1;
        for(Card c: pCards){
            System.out.println("("+i+")"+c.getColour() + "  " + c.getValue());
            i++;
        }
        //return pCards;
    }
    
    public Card getPlayerCard(int cPlace){
        Card tempCard = pCards.get(cPlace);
        
        return tempCard;
    }
    
    public int numPlayerCards(){
        return pCards.size();
    }
    /**
     * The method to be instantiated when you subclass the Player class
     * with your specific type of Player and filled in with logic to play your game.
     */
    //public abstract void play();
    
}
