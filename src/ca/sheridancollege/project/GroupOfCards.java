/**
 * SYST 17796 Project Winter 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * @author dancye
 */
public class GroupOfCards 
{
   
    //The group of cards, stored in an ArrayList
    private ArrayList <Card> cards;
    private ArrayList <Card> usedCards;
    private int size;       //the size of the grouping
    private int aNum=0;     //number of cards used counter
    
    public GroupOfCards(int givenSize)
    {
        size = givenSize;
        cards = new ArrayList<Card>();
        usedCards = new ArrayList<Card>();
    }
    GroupOfCards(){     //a default constructor
        size=60;
        cards = new ArrayList<Card>();
        usedCards = new ArrayList<Card>();
        //shuffle();
    }
    
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */
    public void showCards()
    {
        for(Card c: cards){
            System.out.println(c.getColour() + "  " + c.getValue());
        }
    }
    
    public Card dCard(){
        Card result = null;
        if(aNum <size){
            result = cards.get(0);  //get top card
            usedCards.add(result);
            cards.remove(0);        //remove top card
        }
        else{       //if all the cards in the deck have been used up this will reset the cards and shuffle it.
            aNum=0;                 //reset counter
            cards = usedCards;
            usedCards.clear();      //clear/reset the whole usedCard arraylist
            shuffle();
            
            //get a card
            result = cards.get(0);
            usedCards.add(result);
            cards.remove(0);
        }
        aNum++;
        return result;
    }
    
    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize;
    }
    
    
    public void generateDeck()
        {
                //int countCards = 0;
                Card tempCard;
		for(Card.Colour c: Card.Colour.values())
                {
                    for(Card.Value v: Card.Value.values())
                    {
                        tempCard = (new Card(c,v));
                        //System.out.println(tempCard.getColour()+" + "+tempCard.getValue());       //test to see if cards are being generated
                        cards.add(tempCard);        //add newly generated card to the deck of cards
                        
                    }
                }//end outter for
        }//end method
}//end class
