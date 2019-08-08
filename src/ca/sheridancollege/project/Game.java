/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific
 * child of this class and instantiate the methods given.
 * @author dancye, 2018
 */
public class Game 
{
    private final String gameName;//the title of the game
    private ArrayList <Player> players;// the players of the game
    
    public Game(String givenName)
    {
        gameName = givenName;
        players = new ArrayList();
    }

    /**
     * @return the gameName
     */
    public String getGameName() 
    {
        return gameName;
    }
    
     /**
     * @return the players of this game
     */
    public ArrayList <Player> getPlayers() 
    {
        return players;
    }
    
    
    
    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList <Player> players) 
    {
        this.players = players;
    }
    
    public boolean checkCards(Card card,Card pcard){
         /*
        if (this.color == c)
            return true;
        else if (this.value == o.value)
            return true;
        else if (this.color == "none") // Wild cards
            return true;
        return false;      
        */
         if(card.getColour() == pcard.getColour()){
             return true;
         }
         else if(card.getValue() == pcard.getValue()){
             return true;
         }
         else if (pcard.getValue()== Card.Value.WILDCARD){
             return true;
         }
        return false;
        
    }
    
    public Card placeCard(Card card){
       return card;
    }
    
    public Player pickupCard(Card card, Player pdeck){
        pdeck.addPlayerCards(card);
        return pdeck;
    }
    

    /**
     * Play the game. This might be one method or many method calls depending
     * on your game.
     */
    //public abstract void play();
    
    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
    //public abstract void declareWinner();

   
    
}//end class
