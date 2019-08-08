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
    
    System.out.println("Enter number of players: ");
    int numPlayers = sc.nextInt();                  //get number of players
    
    //check if there are a minimum of 2 players playing
    if(numPlayers < 2){
        System.out.println("Error minimum of 2 players are needed to start the game.");
        System.exit(0);                             //terminate program
    }
    //Game uno = new Game("uno");
    
    Player players[] = new Player[numPlayers];      //initialize player array
    for(int i=0; i < players.length; i++){
        System.out.printf("Enter player %d name: ",i+1);
        String pName = sc.next();                   //get player's name
        players[i] = new Player(pName);
        
        //System.out.printf("Player %d name: %s \n",i+1,players[i].getPlayerID()); //Test to see if player names are being stored
        //generate cards for each player
        
    }//end of for loop
    
    
    
    //Start game
        
        //check first/top card
        
        
        //let each player play
            //check player's cards
            
            //determine what the player wants to do (Eg. place/pick up card)
            
            //check if player has 0 cards in their hand
                //end game and declare player as winner
            
    
    
    }//end of main method/function
}//end of class
