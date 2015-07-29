/**File Header
 * @file Card.java
 * @project CMSC 202 - Fall 2012 - Project 2
 * @author Rachael Birky <rbirky1@umbc.edu>
 * @version 10/08/12
Ê* @section 02
 * */

package proj2;

import java.util.Random;

/** This class represents a standard 52 card deck
 * Class Invariants: Deck contains Card or null values and a length of 52
 *  */
public class Deck {
	private final int LENGTH = 52;
	private Card[] aDeck = new Card[LENGTH];
	
	/**
	* @name Deck()
	* @description Class constructor 
	* Precondition: none
	* Postcondition: A new Deck object is created as an array of Cards
	* @param none
	* @return none
	*/
	public Deck(){
		int counter = 0;
		//Loop through suits
		for (Suit suit : Suit.values()){
			//For each suit, loop through the ranks
			for (Rank rank : Rank.values()){
				//Add a card with current suit & rank
				aDeck[counter] = new Card(suit, rank);
				counter++;
			}
		}
	}
	
	/**
	* @name getLength()
	* @description Used by CardPile to access immutable number of cards in deck
	* Precondition: Deck must have a positive length instance variable
	* Postcondition: The integer 52 is returned
	* @param none
	* @return this.length - the number of cards in a deck
	*/
	public int getLength(){
		return this.LENGTH;
	}
	
	/**
	* @name shuffle()
	* @description Randomizes the order of cards in the deck using
	* 			an integer a Random generator seed value
	* Precondition: Seed value must be an integer value
	* Postcondition: The order of cards in the deck is "randomized"
	* @param rngSeed - the integer value used to randomize card order
	* @return none
	*/
	public void shuffle(long rngSeed){
		Random generator = new Random(rngSeed);
		int index = this.getLength()-1;
		while(index>=0){
			//Get random card -- inclusive of last item!
			int swapIndex = generator.nextInt(index+1);
			Card temp = new Card(aDeck[index]);
			//Swap with n-1 index
			aDeck[index] = new Card(aDeck[swapIndex]);
			aDeck[swapIndex] = temp;
			//System.out.println("...with "+aDeck[index]);
			index--;
		}
	}
	
	/**
	* @name isEmpty()
	* @description Checks whether the deck is empty of cards 
	* Precondition: none
	* Postcondition: Returns true if all array values are null,
	* 			false if any one array index contains a Card
	* @param none
	* @return true - the deck is all null
	* 			false - there is one or more cards in the deck still
	*/
	public boolean isEmpty(){
		boolean isEmpty = true;
		for (Card card : aDeck){
			if (card!=null)
				isEmpty = false;
		}
		return isEmpty;
	}
	
	
	/**
	* @name getCard()
	* @description Accesses and returns the top card of deck 
	* Precondition: none
	* Postcondition: The top card is returned and it's value in the deck is set to null
	* @param none
	* @return temp - the card at the top of the deck
	*/
	public Card getCard(){
		//Loop through deck (starting from top n-1) until a card is found
		int i = this.getLength()-1;
		while(aDeck[i] == null)
		{i--;}
		Card temp = aDeck[i];
		//"Remove" from deck by setting reference to null
		aDeck[i]=null;
		//Return card
		return temp;
	}
	
	/**
	* @name printDeck()
	* @description Displays deck to console using toString() method of Card
	* Precondition: none
	* Postcondition: Each card in the deck is printed to the screen
	* @param none
	* @return none
	*/
	public void printDeck(){
		for (Card card : aDeck){
			System.out.println(card);
		}
	}
	
	/**
	* @name main()
	* @description Unit Testing
	* @param String[] args
	*/
	public static void main(String[] args){
		Deck testDeck = new Deck();
		
		//Test correct deck initialization
		//Expecting first two cards Ace of Clubs & Two of Clubs
		//Top of deck = last card printed
		System.out.println("Initialized deck:");
		testDeck.printDeck();
		
		//Test getLength(); expecting 52
		System.out.println("\nLength of deck: "+testDeck.getLength()+"\n");
		
		//Test correct shuffling
		//Expecting first two cards Three of Hearts & Three of Spades
		System.out.println("Shuffled deck:");
		testDeck.shuffle(123456);
		testDeck.printDeck();
		
		//Test isEmpty() method; Expecting false
		System.out.println("\nThe deck is empty: "+testDeck.isEmpty());
		
		//Test getCard() method; Expecting to empty Deck
		System.out.println("\nEmptying deck...");
		for (int i=0; i<testDeck.getLength(); i++)
			testDeck.getCard();
		
		//Test isEmpty() method; Expecting true
		System.out.println("The deck is empty: "+testDeck.isEmpty());	
		
	}
	
}
