/**File Header
 * @file Card.java
 * @project CMSC 202 - Fall 2012 - Project 2
 * @author Rachael Birky <rbirky1@umbc.edu>
 * @version 10/08/12
Ê* @section 02
 * */

package proj2;

/** This class represents a single player's card deck
 * Class Invariants: This class must have a deckLength of 52,
 * 		and a positive numPlayers passed
 * */
public class CardPile {
	
	private final int DECK_LENGTH = 52;
	private int length;
	private Card[] cards;
	private int pileIndex=0;
	
	/**
	* @name CardPile()
	* @description Class constructor; creates an array of cards with appropriate length
	* 			for the current game by dividing deck evenly
	* Precondition: numPlayers must be an integer value and factor of 52
	* Postcondition: A new CardPile object is created as an array of Cards
	* @param numPlayers - and integer value and a factor of 52
	* @return none
	*/
	public CardPile(int numPlayers){
		if(numPlayers<1)
			throw new RuntimeException("Invalid number of players");
		else this.length = DECK_LENGTH / numPlayers;
		cards = new Card[length];
	}

	/**
	* @name addCard()
	* @description Adds a card to the Player's CardPile
	* Precondition: aCard must be a valid Card object
	* Postcondition: A new card is added to the bottom of the CardPile
	* @param aCard - a valid card object
	* @return none
	*/
	public void addCard(Card aCard){
		//Game.java uses this method to add cards from deck to player's card piles
		cards[pileIndex] = new Card(aCard);
		pileIndex++;
	}
	
	/**
	* @name getCard()
	* @description Returns the card at the top of the CardPile by looping
	* 			until a non-null object is found in the array, then sets its value
	* 			in the array to null
	* Precondition: CardPile must contain cards
	* Postcondition: The next appropriate card object is returned 
	* @param none
	* @return temp - the card at the top of the CardPile
	*/
	public Card getCard(){
		//Loop through CardPile (starting at top) until a card is found
		int i = length-1;
		while(cards[i] == null && i>0)
		{
			i--;
		}
		Card temp = cards[i];
		//"Remove" from CardPile by setting reference to null
		cards[i]=null;
		//Return card
		return temp;
	}
	
	/**
	* @name isEmpty()
	* @description Checks whether the CardPile is empty of cards 
	* Precondition: none
	* Postcondition: Returns true if all array values are null,
	* 			false if any one array index contains a Card
	* @param none
	* @return true - the deck is all null
	* 			false - there is one or more cards in the deck still
	*/
	public boolean isEmpty(){
		boolean isEmpty = true;
		for (Card card : cards){
			if (card!=null)
				isEmpty = false;
		}
		return isEmpty;
	}
	
	/**
	* @name printCardPile()
	* @description Displays CardPile to console using toString() method of Card
	* Precondition: none
	* Postcondition: Each card in the CardPile is printed to the screen
	* @param none
	* @return none
	*/
	public void printCardPile(){
		for (Card card : cards)
			System.out.println(card);
	}
	
	/**
	* @name getLength()
	* @description Returns the length of the CardPile
	* Precondition: none
	* Postcondition: An integer value representing the CardPile length is returned
	* @param none
	* @return this.length - the length of the current CardPile
	*/
	public int getLength(){
		return this.length;
	}
	
	//Unit testing
	public static void main(String[] args){
		CardPile p1Pile = new CardPile(2);
		//Test constructor; Expecting 26
		System.out.println(p1Pile.length);
		
		//Test addCard() method; Expecting first card (at bottom of pile) to be Ace of Hearts
		// rest to be null
		p1Pile.addCard(new Card(Suit.HEARTS, Rank.ACE));
		p1Pile.printCardPile();
		
	}
}
