/**File Header
 * @file Card.java
 * @project CMSC 202 - Fall 2012 - Project 2
 * @author Rachael Birky <rbirky1@umbc.edu>
 * @version 10/08/12
Ê* @section 02
 * */

package proj2;

/** This class represents a single player of the card game
 *  Class Invariants: A Player must be provided a valid String name,
 *  		The number of players must be greater than or equal to one
 *  		(Two for the game of war)
 *  */
public class Player {

	private String name;
	private CardPile playerCards;
	private int numWarsWon;
	private int numCardsWon;
	
	/**
	* @name Player()
	* @description Class Constructor
	* Precondition: name must be a valid, non-zero length String, numPlayers
	* 			must by greater than or equal to one
	* Postcondition: A new Player is created with a name and CardPile
	* 			number of cards and wars won initialized to zero
	* @param name - String representing Player name
	* 		numPlayers - integer representing number of players (used for CardPile)
	* @return none
	*/
	public Player(String name, int numPlayers){
		if(name.length()>0)
			this.name = name;
		else System.out.println("Invalid name.");
		
		this.numWarsWon = 0;
		this.numCardsWon = 0;
		this.playerCards = new CardPile(numPlayers);
	}
	
	/**
	* @name getName()
	* @description Returns current player's name 
	* Precondition: name must have been initialized
	* Postcondition: Immutable String representing player's name is returned
	* @param none
	* @return name - immutable String representing current player's name
	*/
	public String getName(){
		return name;
	}
	
	/**
	* @name getNumWarsWon()
	* @description Returns the number of wars this player has won
	* Precondition: none
	* Postcondition: An integer value representing number of wars won is returned
	* @param none
	* @return numWarsWon - immutable integer representing number of wars won by player
	*/
	public int getNumWarsWon(){
		return numWarsWon;
	}
	
	/**
	* @name getNumCardsWon()
	* @description Returns the number of cards this player has won
	* Precondition: none
	* Postcondition: An integer value representing number of cards won is returned
	* @param none
	* @return numWarsWon - immutable integer representing number of cards won by player
	*/
	public int getNumCardsWon(){
		return numCardsWon;
	}
	
	/**
	* @name addNumWarsWon()
	* @description Adds to the number of wars the player has won
	* Precondition: none
	* Postcondition: The number of wars won by player is incremented by one
	* @param none
	* @return none
	*/
	public void addNumWarsWon(){
		this.numWarsWon++;
	}
	
	/**
	* @name addNumCardsWon()
	* @description Adds to the number of cards the player has won
	* Precondition: numCardsWon is a non-negative integer
	* Postcondition: The number of wars cards by player is incremented by the parameter
	* @param numCardsWon - an integer representing how many cards were won this turn
	* @return none
	*/
	public void addNumCardsWon(int numCardsWon){
		if (numCardsWon>0)
			this.numCardsWon += numCardsWon;
		else System.out.println("Must be a positive integer value.");
	}
	
	/**
	* @name addCard()
	* @description Adds a card to the player's CardPile
	* 			and CardPile addCard()
	* Precondition: Card passed is a valid Card object
	* Postcondition: The card passed is added to the bottom of the player's CardPile
	* @param aCard - a valid card object
	* @return none
	*/
	public void addCard(Card aCard){
		playerCards.addCard(aCard);
	}
	
	/**
	* @name getCard()
	* @description Returns the card at the top of the Player's CardPile; implements
	* 			CardPile getCard()
	* Precondition: none
	* Postcondition: The card at the top of the current player's CardPile is returned
	* @param none
	* @return Card at top of player's CardPile
	*/
	public Card getCard(){
		return playerCards.getCard();
	}
	
	/**
	* @name printCardPile()
	* @description Displays CardPile to console using printCardPile() method of CardPile
	* Precondition: none
	* Postcondition: Each card in the player's CardPile is printed to the screen
	* @param none
	* @return none
	*/
	public void printCardPile(){
		playerCards.printCardPile();
	}
	
	/**
	* @name playerCardPileIsEmpty()
	* @description Checks whether the CardPile is empty of cards;
	* 			implements isEmpty() of CardPile
	* Precondition: none
	* Postcondition: Returns true if all array values are null,
	* 			false if any one array index contains a Card
	* @param none
	* @return true - the deck is all null
	* 			false - there is one or more cards in the deck still
	*/
	public boolean playerCardPileIsEmpty(){
		return playerCards.isEmpty();
	}
	
	//Unit testing
	public static void main(String[] ards){
		//Test Player methods!
		Player testPlayer = new Player("Bob", 2);
		System.out.println(testPlayer.getName());
		Card testCard = new Card(Suit.CLUBS, Rank.ACE); 
		for(int i=0; i<26; i++)
			testPlayer.addCard(testCard);
		//Expecting all Ace of Clubs
		testPlayer.printCardPile();
		
	}
}
