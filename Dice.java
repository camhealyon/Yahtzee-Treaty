/**
 * Creates an instance of a n-sided die with the ability to reroll it and get the current
 * side that is up. The number of sides on the dice is determined by the getNumSides() 
 * method in the Settings class. 
 * 
 *@author: Ernie Tsybulnik
 *@version: 1.2
 *@since: 2/10/2017
*/


import java.util.*;

public class Dice {
//attributes
	private int sideup;
	
//constructors
	public Dice(){
		sideup = 1;
	}
	
//methods
	/**
	 * gets the side that is up on the dice which is stored in the 
	 * private variable 'sideup'
	 * @return integer of side up.
	 */
	public int getSideup() {
		return sideup;
	}
	
	/**
	 * 'rolls' the die by randomly generating a number between 1 and n, where n is the
	 * number of sides on the dice based on the Settings class, and stores it in 
	 * the private member variable 'sideup'.
	 */
	public void roll(){
		Random rand = new Random();
		int x = rand.nextInt(Settings.getNumSides())+1;
		sideup = x;
	}
}
