/**File Header
 * @file Card.java
 * @project CMSC 202 - Fall 2012 - Project 2
 * @author Rachael Birky <rbirky1@umbc.edu>
 * @version 10/08/12
Ê* @section 02
 * */

package proj2;

import static proj2.Suit.*;
import static proj2.Rank.*;


/** This class represents a single card in a deck
 *  Class Invariants: Cards must contain Suit and Rank enum values
 *  */
public class Card {

	private final Suit suit;
	private final Rank rank;
	
	/**
	* @name Card()
	* @description Class constructor  
	* Precondition: none
	* Postcondition: A new Card object is created with a suit and rank
	* @param Suit, Rank - enum values
	* @return none
	*/
	public Card(Suit suit, Rank rank){
		this.suit = suit;
		this.rank = rank;
	}
	
	/**
	* @name Card()
	* @description Class copy constructor used to prevent privacy leaks
	* Precondition: none
	* Postcondition: A new Card object is created with the same suit and rank
	* 			as the Card object passed
	* @param aCard - a valid Card object
	* @return none
	*/
	public Card(Card aCard){
		this(aCard.getSuit(), aCard.getRank());
	}
	
	/**
	* @name getSuit()
	* @description Returns the current card's immutable suit enum value
	* Precondition: Card must have a suit value
	* Postcondition: An enum value is returned representing the card suit
	* @param none
	* @return this.suit - The current card's suit
	*/
	public Suit getSuit(){
		return this.suit;
	}
	
	/**
	* @name getRank()
	* @description Returns the current card's rank enum value
	* Precondition: Card must have a rank value
	* Postcondition: An enum value is returned representing the card rank
	* @param none
	* @return this.rank - The current card's rank
	*/
	public Rank getRank(){
		return this.rank;
	}
	
	/**
	* @name toString()
	* @description Overrides the toString() method
	* 		Returns a conventionally formatted card String
	* 		eg "Ace of Diamonds"
	* Precondition: Card must have a suit and rank value
	* Postcondition: An formatted String representing a card is returned
	* @param none
	* @return A formatted String containing the card's rank and suit
	*/
	public String toString(){
		return ""+this.rank.getName()+" of "+this.suit.getName()+"";
	}
	
	/**
	* @name ordVal()
	* @description Assigns numerical values to the card
	* 			in the ascending order 2-10, Jack, Queen, 
	* 			King, Ace for comparison
	* 	Implements .ordinal() method of enums
	* Precondition: Card must have a rank value
	* Postcondition: An integer representing the actual rank
	* 			of a card is returned
	* @param none
	* @return int 14 for Ace (highest possible) or .ordnial() or rank
	*/
	public int ordVal(){
		if (this.getRank() == Rank.ACE)
			return 14;
		else
			return this.getRank().ordinal();
	}
	
	//Unit Testing
	public static void main(String[] args){
		Card testCard = new Card(DIAMONDS, THREE);
		Card testCard2 = new Card(HEARTS, ACE);
		System.out.println(testCard.getRank().ordinal());
		System.out.println(testCard2.getRank().ordinal());
		System.out.println(testCard.ordVal());
		System.out.println(testCard2.ordVal());
	}
	
}
