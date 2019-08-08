/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sheridancollege.project;

import java.util.*;

/**
 *
 * @author EthoKurza
 */
public class GamePlay {
    
    public static void main(String[] args){
    
    //Declare variables
    Scanner sc = new Scanner(System.in);
    int numPlayers=0;
    while(true){
        System.out.println("Enter number of players: ");
        numPlayers = sc.nextInt();                  //get number of players

        //check if there are a minimum of 2 players playing
        if(numPlayers < 2){
            System.out.println("Error minimum of 2 players are needed to start the game.");
            //System.exit(0);                             //terminate program
        }
        else{
            break;      //break out of loop
        }
    }//end of while loop;
    
    
    //Game uno = new Game("uno");
    
    //generate deck of cards
    GroupOfCards gameDeck = new GroupOfCards();  
    gameDeck.generateDeck();
    //gameDeck.shuffle();
    gameDeck.showCards();
    
    Player players[] = new Player[numPlayers];      //initialize player array
    
    //initialize each player
    for(int i=0; i < players.length; i++){
        System.out.printf("Enter player %d name: ",i+1);
        String pName = sc.next();                   //get player's name
        players[i] = new Player(pName);
        
        //System.out.printf("Player %d name: %s \n",i+1,players[i].getPlayerID()); //Test to see if player names are being stored
        
        //generate cards for each player
        for(int j=0;j<6;j++){                       //give a player 6 cards
           players[i].addPlayerCards(gameDeck.dCard());    
        }
        
        //System.out.println(players[i].getPlayerCards());
       
        
    }//end of for loop
    
    
    
    //Start game
        
        //check first/top card
        Card topCard = gameDeck.dCard();
        System.out.println("Top Card: "+topCard.getColour()+" "+topCard.getValue());
        //let each player play
        for(int i=0;i<numPlayers;i++){
            
            //check player's cards
            System.out.println(players[i].getPlayerID()+" Turn");
            System.out.println(players[i].getPlayerID()+"'s Cards: \n");
            players[i].getPlayerCards();
            
            //determine what the player wants to do (Eg. place/pick up card)
            
            
            
            //check if player has 0 cards in their hand
                //end game and declare player as winner
            
        }//end of if statement
    
    }//end of main method/function
}//end of class
