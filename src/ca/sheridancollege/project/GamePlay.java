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
    Scanner sc = new Scanner(System.in);
    //Declare variables
    int numPlayers = 0;
    
    
    Game uno = new Game("uno");
    numPlayers = uno.cNumPlayer();
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
        boolean plusPickup = false, cWild= false,reverse = false;
        while(true){    
            if(reverse ==false){


                //let each player play
                for(int i=0;i<numPlayers;i++){
                    //get top card
                    System.out.println("Top Card: "+topCard.getColour()+" "+topCard.getValue());

                    //check player's cards
                    System.out.println("-----------------------------------");
                    System.out.println(players[i].getPlayerID()+" Turn");
                    System.out.println(players[i].getPlayerID()+"'s Cards: \n");
                    players[i].getPlayerCards();


                    int decide = 0;

                    //check for skip,draw 4,draw 2 on top card
                    if((topCard.getValue() == Card.Value.DRAW_TWO) && (plusPickup == true)){            //next player draws 2 and turn is skipped
                       System.out.println(players[i].getPlayerID()+" Picks up 2 cards");
                        for(int j=0;j<2;j++) 
                            players[i].addPlayerCards(gameDeck.dCard());
                        plusPickup=false;
                    }
                    else if((topCard.getValue() == Card.Value.DRAW_FOUR) && (plusPickup == true)){      //next player draw 4 and turn is skipped
                        System.out.println(players[i].getPlayerID()+" Picks up 4 cards");
                        for(int j=0;j<4;j++) 
                            players[i].addPlayerCards(gameDeck.dCard());
                        plusPickup=false;
                    }
                    else if((topCard.getValue() == Card.Value.SKIP)&&(plusPickup == true)){
                        System.out.println(players[i].getPlayerID()+" has been skipped!");
                        plusPickup=false;
                    }
                    else{
                        //determine what the player wants to do (Eg. place/pick up card)
                        try{
                            System.out.println("-----------");
                            System.out.println("(1) Place Card \n(2) Pickup Card \n");
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
                                            plusPickup = uno.cPlus(topCard);                            //checks if top card has a plus4/plus2
                                            cWild = uno.cWild(topCard);
                                            if(cWild == true){
                                                int nColour;
                                                boolean cExit = false;
                                                while(cExit == false){
                                                    System.out.println("What colour would you like to change to: ");
                                                    System.out.println("\n(1)RED \n (2)YELLOW \n (3)BLUE \n (4)GREEN \n Choose New Color: ");
                                                    nColour = sc.nextInt();
                                                    if(nColour == 1){
                                                        topCard = new Card(Card.Colour.RED,Card.Value.WILDCARD);
                                                        cExit = true;
                                                    }
                                                    else if(nColour == 2){
                                                        topCard = new Card(Card.Colour.YELLOW,Card.Value.WILDCARD);
                                                        cExit = true;
                                                    }
                                                    else if(nColour == 3){
                                                        topCard = new Card(Card.Colour.BLUE,Card.Value.WILDCARD);
                                                        cExit = true;
                                                    }
                                                    else if(nColour == 4){
                                                        topCard = new Card(Card.Colour.GREEN,Card.Value.WILDCARD);
                                                        cExit = true;
                                                    }
                                                    else{
                                                        System.out.println("Error Invalid input");
                                                    }
                                                }//end of while loop
                                            }
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

                            }//end if switch case
                        }catch(Exception e){
                            System.out.println("You've entered an incorrect input");
                            System.out.println("Game shutting down");
                            System.exit(0);
                        }//end of try catch
                    }//end of if statement


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
            }//end of if statement for reverse
            else{
                for(int i=numPlayers;i >=0;i--){
                    //get top card
                    System.out.println("Top Card: "+topCard.getColour()+" "+topCard.getValue());

                    //check player's cards
                    System.out.println("-----------------------------------");
                    System.out.println(players[i].getPlayerID()+" Turn");
                    System.out.println(players[i].getPlayerID()+"'s Cards: \n");
                    players[i].getPlayerCards();


                    int decide = 0;

                    //check for skip,draw 4,draw 2 on top card
                    if((topCard.getValue() == Card.Value.DRAW_TWO) && (plusPickup == true)){            //next player draws 2 and turn is skipped
                       System.out.println(players[i].getPlayerID()+" Picks up 2 cards");
                        for(int j=0;j<2;j++) 
                            players[i].addPlayerCards(gameDeck.dCard());
                        plusPickup=false;
                    }
                    else if((topCard.getValue() == Card.Value.DRAW_FOUR) && (plusPickup == true)){      //next player draw 4 and turn is skipped
                        System.out.println(players[i].getPlayerID()+" Picks up 4 cards");
                        for(int j=0;j<4;j++) 
                            players[i].addPlayerCards(gameDeck.dCard());
                        plusPickup=false;
                    }
                    else if(topCard.getValue() == Card.Value.SKIP){
                        System.out.println(players[i].getPlayerID()+" has been skipped!");
                    }
                    else{
                        //determine what the player wants to do (Eg. place/pick up card)
                        try{
                            System.out.println("-----------");
                            System.out.println("(1) Place Card \n(2) Pickup Card \n");
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
                                            plusPickup = uno.cPlus(topCard);                            //checks if top card has a plus4/plus2
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

                            }//end if switch case
                        }catch(Exception e){
                            System.out.println("You've entered an incorrect input");
                            System.out.println("Game shutting down");
                            System.exit(0);
                        }//end of try catch
                    }//end of if statement


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
            }//end of else for reverse
        }//end of while loop
        
        
        
    }//end of main method/function
}//end of class
