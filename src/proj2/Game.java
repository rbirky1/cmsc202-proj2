/**File Header
 * @file Game.java
 * @project CMSC 202 - Fall 2012 - Project 2
 * @author Rachael Birky <rbirky1@umbc.edu>
 * @version 10/08/12
Ê* @section 02
 * */

package proj2;

/** This class plays the game of war
 *  Class Invariants: NUM_PLAYERS must be positive (2 for a game of war)
 *  	player names must be Strings, aDeck and Players must have valid Card[]
 *  */
public class Game {

	private final int NUM_PLAYERS = 2;
	private Player p1;
	private Player p2;
	private Deck aDeck;
	//number of cards compared each turn (and won if there is no war)
	private int numCardsPerTurn=2;
	//number of cards "at risk" every time a war happens
	private final int cardMultiplier=8;
	//number of total wars in the game
	private int numWars=0;
	//number of wars in a row
	int numWarsThisTurn=0;
	//record of whether there is currently a war
	private boolean inWar=false;
	
	/**
	* @name Game
	* @description Constructor 
	* Precondition: 
	* Postcondition: A new game is initialized with two players
	* 			with user-given names, each with their own cardPile
	* 			of the deck's length evenly divided 
	* @param p1Name - user given name of first player
	* 		p2Name - user given name of second player
	* 		NUM_PLAYERS - number of players in war (2) used to
	* 			split the deck into two cardPiles
	* @return none
	*/
	public Game(String p1Name, String p2Name, long rngSeed){
		//Initialize players
		p1 = new Player(p1Name, NUM_PLAYERS);
		p2 = new Player(p2Name, NUM_PLAYERS);
		
		//Initialize deck
		aDeck = new Deck();
		
		//Shuffle deck and deal cards to player's CardPiles
		aDeck.shuffle(rngSeed);
		deal();
	}
	
	/**
	* @name deal()
	* @description Deals cards to two players; alternating receiver
	* Precondition: none
	* Postcondition: Each player will have a cardPile of 26 cards
	* 				beings every other card in the original deck
	* @param none
	* @return none
	*/
	public void deal(){
		//Deal cards; alternating receiving player
		for (int i=0; i<aDeck.getLength(); i++){
			if (i%2==0){
				p1.addCard(aDeck.getCard());}
			else{
				p2.addCard(aDeck.getCard());}
		}
	}
	
	/**
	* @name gameComplete()
	* @description Checks whether the game has ended; returns true or false
	* Precondition: Players must have cardPile instance objects to compare
	* Postcondition: The status of the game is returned
	* @param none
	* @return true if both player cardPiles are empty, indicating the game is over
	* 		false if one player still has cards
	*/
	public boolean gameComplete(){
		if (p1.playerCardPileIsEmpty() && p2.playerCardPileIsEmpty())
			return true;
		else return false;}
	
	/**
	* @name nextTurn()
	* @description Executes one turn of the game war
	* 			Gets and compares the top card of each player's cardPile
	* 			If one card is greater, that player wins both cards
	* 			If the cards are of the same rank, war() is called
	* 				the wars counter is incremented and (if currently in war/
	* 				there is more than one war in a row) the numWarsThisTurn is
	* 				incremented
	* 			The appropriate number of cards is added to the winner's numCardsWon
	* 				If there has been a war, there are 10 cards at stake, otherwise only 2
	* Precondition: p1 and p2 must have non-null cardPiles
	* Postcondition: A turn is executed, there is a war or a player wins cards and/or a war
	* @param none
	* @return A formatted string with the number of cards the player won or that there is a war
	* 			or the result of a (series of) wars
	*/
	public String nextTurn(){
		
		Card p1CurrentCard = p1.getCard();
		Card p2CurrentCard = p2.getCard();
		int numCardsThisTurn = numCardsPerTurn;
		
		if (p1CurrentCard.ordVal()>p2CurrentCard.ordVal()){
			
			if (inWar) {numCardsThisTurn+=(numWarsThisTurn*cardMultiplier); p1.addNumWarsWon(); p1.addNumCardsWon(numCardsThisTurn);}
			else {p1.addNumCardsWon(numCardsThisTurn);}
			inWar=false;
			numWarsThisTurn=0;
			//int tempNumCardsPerTurn=numCardsPerTurn;
			//numCardsPerTurn=2;
			return p1.getName()+" shows "+p1CurrentCard
					+"\n"+p2.getName()+" shows "+p2CurrentCard
					+"\n"+p1.getName()+" wins "+numCardsThisTurn+" cards.";
		}
		else if (p1CurrentCard.ordVal()<p2CurrentCard.ordVal()){
			if (inWar) {numCardsThisTurn+=(numWarsThisTurn*cardMultiplier); p2.addNumWarsWon(); p2.addNumCardsWon(numCardsThisTurn);}
			else {p2.addNumCardsWon(numCardsThisTurn);}
			inWar=false;
			numWarsThisTurn=0;
			return p1.getName()+" shows "+p1CurrentCard
					+"\n"+p2.getName()+" shows "+p2CurrentCard
					+"\n"+p2.getName()+" wins "+numCardsThisTurn+" cards.";
		}
		else {numWarsThisTurn++; inWar=true; return war(p1CurrentCard, p2CurrentCard);}
		
	}
	
	/**
	* @name war
	* @description 
	* Precondition: p1CurrentCard, p2CurrentCard be valid non-null card objects
	* Postcondition: The appropriate number of cards is removed from each player's cardPile
	* 		and the string "WAR!!" is returned, ending the war and nextTurn functions
	* @param p1CurrentCard, p2CurrentCard -- used to print to the console
	* @return "WAR!!"
	*/
	public String war(Card p1CurrentCard, Card p2CurrentCard){
		System.out.println(p1.getName()+" shows "+p1CurrentCard
				+"\n"+p2.getName()+" shows "+p2CurrentCard);
		
		//Increment Wars counter
		numWars++;
		
		//Remove appropriate cards for next turn
		for (int i=0; i<3; i++) p1.getCard();
		for (int i=0; i<3; i++) p2.getCard();
		
		return "WAR!!";
	}
	
	/**
	* @name gameResult()
	* @description Prints the results of the game to the console
	* Precondition: none
	* Postcondition: The number of wars, number of cards and wars each player won,
	* 			and the winner's name are printed to the console
	* @param none
	* @return A formatted string with the number of wars, number of cards and wars
	* 		each player won, and the winner's name
	*/
	public String gameResult(){
		Player winner;
		if (p1.getNumCardsWon()>p2.getNumCardsWon()) {winner=p1;
		return "\nThere were "+numWars+" wars. \n"
			+p1.getName()+" won "+p1.getNumCardsWon()+" cards and "+p1.getNumWarsWon()+" war(s).\n"
			+p2.getName()+" won "+p2.getNumCardsWon()+" cards and "+p2.getNumWarsWon()+" war(s).\n"
			+"Winner: "+winner.getName();}
		else if (p2.getNumCardsWon()<p2.getNumCardsWon()) {winner=p2;
			return "\nThere were "+numWars+" wars. \n"
			+p1.getName()+" won "+p1.getNumCardsWon()+" cards and "+p1.getNumWarsWon()+" war(s).\n"
			+p2.getName()+" won "+p2.getNumCardsWon()+" cards and "+p2.getNumWarsWon()+" war(s).\n"
			+"Winner: "+winner.getName();}
		else {return "\nThere were "+numWars+" wars. \n"
			+p1.getName()+" won "+p1.getNumCardsWon()+" cards and "+p1.getNumWarsWon()+" war(s).\n"
			+p2.getName()+" won "+p2.getNumCardsWon()+" cards and "+p2.getNumWarsWon()+" war(s).\n"
			+"Winner: TIE!!";}
		
	}
	
}
