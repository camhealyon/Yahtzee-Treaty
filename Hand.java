/**
 * Creates a new hand which is an ArrayList and has the ability to 
 * add more dice to the hand as well as get statistics about the 
 * hand such as whether there is a full house, the max straight,
 * max of a kind, as well as the total of all of the dice in the 
 * hand
 * 
 *@author: Ernie Tsybulnik
 *@version: 1.4
 *@since: 3/26/2017
*/



import java.util.ArrayList;

//import testing.ToggleButton;


import java.util.*;

public class Hand {
//Attributes
	public ArrayList<Dice> hand;	
	private boolean endTurn;
	private int total;
	private int maxCount;
	private int maxLength;
	private boolean foundFH;
	Settings set;
	
	Scanner in = new Scanner(System.in);
	
//constructor
	public Hand(Settings a){
		set = a;
		hand = new ArrayList<Dice>();
		endTurn = false;
		total = 0;
		maxCount = 0;
		maxLength = 1;
	}
	
//methods
	/**
	 * Takes a parameter dieValue and returns the number of types that
	 * such a dieValue appears in the hand. 
	 * 
	 * @param dieValue : int represents a value on a die.
	 * @return int currentCount : the count of number of times that
	 * the dieValue appears in the hand. 
	 */
	public int numDieValue(int dieValue){
		int currentCount = 0;
		for(int diePosition = 0; diePosition<Settings.getNumDice(); diePosition++){
			Dice curr = hand.get(diePosition);
			if(curr.getSideup() == dieValue)
				currentCount++;
		}
		return currentCount;
	}
	
	/**
	 * returns the value stored in the variable foundFH which 
	 * stores whether a full house was found.
	 * @return int The private variable foundFH
	 */
	public boolean getFullHouseFound(){
		return foundFH;
	}
	
	/**
	 * calculates where there is a full house in the current hand. 
	 * sets variable 'foundFH' to appropriate value of T or F.
	 * Full house is determined as 5 of a kind or 3 of one kind
	 * and 2 of another kind.
	 */
	public void calcFullHouseFound(){
		boolean found3k = false;
		boolean found2k = false;
		foundFH = false;
		int threeKValue = 0;
		int currentCount;
		for(int dieValue = 1; dieValue <= Settings.getNumSides(); dieValue++){
			currentCount = 0;
			for(int diePosition = 0; diePosition < Settings.getNumDice(); diePosition++){
				Dice curr = hand.get(diePosition);
				if(curr.getSideup() == dieValue)
					currentCount++;
				}
				if(currentCount >= 5){
					foundFH = true;
					return;
				}
				if(currentCount >= 3 && found3k == false){
					found3k = true;
					threeKValue = dieValue;
				}
				if(currentCount >= 2 && dieValue != threeKValue)
					found2k = true;
		}
		if(found2k && found3k)
			foundFH = true;
	}
	
	/**
	 * calculates max of a kind found in the hand and sets the private variable 
	 * 'maxCount' to the appropriate corresponding value
	 */
	public void calcMaxOfKind(){
		int currentCount;
		maxCount = 0;
		for(int dieValue = 1; dieValue <=Settings.getNumSides(); dieValue++){
			currentCount = 0;
			for(int diePosition = 0; diePosition < Settings.getNumDice(); diePosition++){
				Dice curr = hand.get(diePosition);
				if(curr.getSideup() == dieValue)
					currentCount++;
			}
			if(currentCount > maxCount)
				maxCount = currentCount;
		}
	}
	
	/**
	 * returns the value stored in the private variable 'maxCount'
	 * @return int maxCount
	 */
	public int getMaxOfKind(){
		return maxCount;
	}
	

	
	/**
	 * returns the value stored in the private variable 'maxLength'
	 * @return int maxLength
	 */
	public int getMaxLength(){
		return maxLength;
	}
	
	/**
	 * calculates the total of all of the dice in the hand and
	 * sets the private variable 'total' to appropriate value.
	 */
	public void calcTotal(){
		total = 0;
		for(Dice curr : hand){
			total = total + curr.getSideup();
		}
	}
	
	/**
	 * gets and returns that value stored in the private variable 'total'
	 * which stores the total of all dice
	 * @return int total
	 */
	public int getTotalAllDice(){
		return total;
	}
	
	/**
	 * sorts the hand of dice from least to greatest using insertion sort. 
	 */
	public void sortHand(){
		int size = hand.size();
		for(int i=1; i<size; i++){
			for(int j=i; j>0; j--) {
				Dice a = hand.get(j);
				Dice b = hand.get(j-1);
				if(a.getSideup() < b.getSideup()){
					Dice temp = hand.get(j);
					hand.set(j, hand.get(j-1));
					hand.set(j-1, temp);
				}
			}
		}
	}
	
	
	/**
	 * adds another die to the hand
	 */
	public void addDie() {
		Dice a = new Dice(set);
		a.roll();
		hand.add(a);
		
	}
	
	
	/**
	 * gets and returns the value stored in the private variable 'endTurn'
	 * @return boolean endTurn
	 */
	public boolean getEndTurn(){
		return endTurn;
	}
	
	/**
	 * gets and returns the instance of the die at a certain specified index.
	 * @param index is an int
	 * @return of type Dice 
	 */
	public int getDieAtIndex(int index){
		Dice curr = hand.get(index);
		int value = curr.getSideup();
		return value;
	}
	
	//added method
	public void keepDice(String keep, Hand handInstance, gui frame) {
		int dieNumber = 1;
		endTurn = true;
		for(Dice a : hand){
			if(keep.charAt(dieNumber-1) != 'y') {
				a.roll(); 
				endTurn = false;
			}
			dieNumber++;
		}
		frame.initComponents();
		//printHand(handInstance, frame);
	}
	
}