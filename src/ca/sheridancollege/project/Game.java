/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Scanner;

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
    
    public boolean cWild(Card card){
        boolean result = false;
        if(card.getValue() == Card.Value.WILDCARD){
            result = true;
        }
        return result;
    }
    public boolean cReverse(Card card,boolean order){         //check reverse
        boolean result = order;
        if((card.getValue() == Card.Value.REVERSE)&&(order==false)){
            result = true;
        }
        else if((card.getValue() == Card.Value.REVERSE)&&(order==true)){
            result = false;
        }
        
        return result;
    }
    public boolean cPlus(Card card){
        boolean result=false;
        if((card.getValue()==Card.Value.DRAW_FOUR)|| (card.getValue()==Card.Value.DRAW_TWO))
            result = true;
        else if(card.getValue() == Card.Value.SKIP){
            result = true;
        }
        return result;    
    }
    
    public Card placeCard(Card card){
       return card;
    }
    
    public Player pickupCard(Card card, Player pdeck){
        pdeck.addPlayerCards(card);
        return pdeck;
    }
    
    public int cNumPlayer(){
        Scanner sc = new Scanner(System.in);
        String numPlayers1="0";
        int numPlayers=0;
        while(true){
            System.out.println("Enter number of players: ");
            numPlayers1 = sc.nextLine();                  //get number of players
            System.out.println("String entered is: "+numPlayers1);
            try {
                numPlayers = Integer.parseInt(numPlayers1);	
                System.out.println("number of players is: "+numPlayers);
                //check if there are a minimum of 2 players playing
                if(numPlayers < 2){
                    System.out.println("Error minimum of 2 players are needed to start the game.");
                    //System.exit(0);                             //terminate program
                }
                else{
                    break;      //break out of loop
                }
            } 
            catch (NumberFormatException | NullPointerException nfe) {
                System.out.println("Error: Enter a number value");
            }
        }//end of while loop
        return numPlayers;
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
