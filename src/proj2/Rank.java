/**
 * The Rank enum encapsulates each of the 13 ranks of a standard deck
 * of 52 playing cards. Using this enum assures that all code refers
 * to the ranks in the same manner, i.e. Rank.TWO, ..., Rank.QUEEN,
 * Rank.KING, Rank.ACE, with no possibility of conflicting representations.
 * This enum is provided for your use. You must not change it. 
 * 
 * @author Susan M. Mitchell (Created: 10 Nov 2007)
 * @author Daniel J. Hood (Modified: 23 Mar 2011)
 * @author Susan M. Mitchell (Modified: 07 Oct 2012)
 * @author Susan M. Mitchell (Modified: 10 Oct 2012)
 */

package proj2;

public enum Rank {
	
	/**
	 * The rank ACE
	 */
	ACE('a', "Ace"),

	/**
	 * The rank TWO (2)
	 */
	TWO('2', "Two"),
	
	/**
	 * The rank THREE (3)
	 */
	THREE('3', "Three"),
	
	/**
	 * The rank FOUR (4)
	 */
	FOUR('4', "Four"),
	
	/**
	 * The rank FIVE (5)
	 */
	FIVE('5', "Five"),
	
	/**
	 * The rank SIX (6)
	 */
	SIX('6', "Six"),
	
	/**
	 * The rank SEVEN (7)
	 */
	SEVEN('7', "Seven"),
	
	/**
	 * The rank EIGHT (8)
	 */
	EIGHT('8', "Eight"),
	
	/**
	 * The rank NINE (9)
	 */
	NINE('9', "Nine"),
	
	/**
	 * The rank TEN (10)
	 */
	TEN('t', "Ten"),
	
	/**
	 * The rank JACK
	 */
	JACK('j', "Jack"),
	
	/**
	 * The rank QUEEN
	 */
	QUEEN('q', "Queen"),
	
	/**
	 * The rank KING
	 */
	KING('k', "King");
	
	/**
	 * Single character representation of the rank
	 */
	private final char symbol;
	
	/**
	 * String representation of the rank
	 */
	private final String name;

	/**
	 * Internal constructor used to create <code>Rank</code> enums
	 * 
	 * @param symbol
	 *            the character representation of the rank
	 * @param name
	 *            the string representation of the rank
	 */
	private Rank(char symbol, String name) {
		this.symbol = symbol;
		this.name = name;
	}
	
	/**
	 * Returns the symbol for the rank (e.g. ACE is 'a').
	 * 
	 * @return the symbol
	 */
	public char getSymbol() {
		return this.symbol;
	}

	/**
	 * Returns the name for the suit (e.g. ACE is "Ace").
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
}
