/**
 * The Suit enum encapsulates each of the 4 suits of a standard deck
 * of 52 playing cards. Using this enum assures that all code refers
 * to the suits in the same manner, i.e. Suit.CLUBS, Suit.DIAMONDS,
 * Suit.HEARTS, and Suit.SPADES with no possibility of conflicting
 * representations.
 * 
 * This enum is provided for your use. You must not change it. 
 * 
 * @author Susan M. Mitchell (Created: 10 Nov 2007)
 * @author Daniel J. Hood (Modified: 23 Mar 2011)
 * @author Susan M. Mitchell (Modified: 07 Dec 2012)
 */

package proj2;

public enum Suit {

	/**
	 * The suit CLUBS
	 */
	CLUBS('c', "Clubs"),
	
	/**
	 * The suit DIAMONDS
	 */
	DIAMONDS('d', "Diamonds"),
	
	/**
	 * The suit HEARTS
	 */
	HEARTS('h', "Hearts"),
	
	/**
	 * The suit SPADES
	 */
	SPADES('s', "Spades");

	/**
	 * Single character representation of the suit
	 */
	private final char symbol;
	
	/**
	 * String representation of the suit
	 */
	private final String name;

	/**
	 * Internal constructor used to create <code>Suit</code> enums
	 * 
	 * @param symbol
	 *            the character representation of the suit
	 * @param name
	 *            the string representation of the suit
	 */
	private Suit(char symbol, String name) {
		this.symbol = symbol;
		this.name = name;
	}
	
	/**
	 * Returns the symbol for the suit (e.g. SPADES &rarr; 's').
	 * 
	 * @return the symbol
	 */
	public char getSymbol() {
		return this.symbol;
	}

	/**
	 * Returns the name for the suit (e.g. SPADES &rarr; "Spades").
	 * 
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
}