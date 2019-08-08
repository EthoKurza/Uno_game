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
    
    
    Game uno = new Game("uno");
    
    //generate deck of cards
    GroupOfCards gameDeck = new GroupOfCards();  
    gameDeck.generateDeck();
    gameDeck.shuffle();
    //gameDeck.showCards();
    
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
        Card topCard = gameDeck.dCard();    //set default top card
        while(true){    
            
            //let each player play
            for(int i=0;i<numPlayers;i++){
                //get top card
                System.out.println("Top Card: "+topCard.getColour()+" "+topCard.getValue());
                
                //check player's cards
                System.out.println("-----------------------------------");
                System.out.println(players[i].getPlayerID()+" Turn");
                System.out.println(players[i].getPlayerID()+"'s Cards: \n");
                players[i].getPlayerCards();

                //determine what the player wants to do (Eg. place/pick up card)
                System.out.println("-----------");
                System.out.println("(1) Place Card \n(2) Pickup Card \n");
                int decide = 0;
                decide = sc.nextInt();
                switch(decide){
                    case 1:
                        boolean quit = false;
                        while(!quit==true){   
                            System.out.println("What card do you want to place?");
                            int cPlace = sc.nextInt();
                            cPlace--;
                            if(uno.checkCards(topCard,players[i].getPlayerCard(cPlace))){
                                topCard = uno.placeCard(players[i].getPlayerCard(cPlace));
                                players[i].removePlayerCards(cPlace);                       //remove card from player's hand
                                quit=true;
                            }
                            else{
                                System.out.println("Card is invalid, please pick another one");
                                System.out.println("Quit Placing Cards and pick up a card? \n(1)Yes \n(2)No");
                                int qPlacing = sc.nextInt();
                                if(qPlacing == 1){
                                    players[i].addPlayerCards(gameDeck.dCard());
                                    quit=true;
                                }
                            }
                           
                            
                        }//end of while loop    
                        break;
                        
                    case 2:

                        players[i].addPlayerCards(gameDeck.dCard());
                        break;

                    default:
                        System.out.println("Error, that is not a valid option");
                        break;

                }
                //check if player has 0 cards in their hand
                    //end game and declare player as winner
                if(players[i].numPlayerCards()==0){
                    System.out.println(players[i].getPlayerID()+" is the Winner!!!!!");
                    System.out.println("Program shutting down....");
                    System.exit(0);
                }//end of if statment
                else if(players[i].numPlayerCards()==1){
                    System.out.println("***********************");
                    System.out.println(players[i].getPlayerID()+" is on UNO!!");
                    System.out.println("***********************");
                }

                
            }//end of for loop
        }//end of while loop
        
        
        
    }//end of main method/function
}//end of class
