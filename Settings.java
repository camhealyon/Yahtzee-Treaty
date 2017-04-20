/**
 * Reads the yahtzeeConfig.txt file to find the number of sides, 
 * number of dice, and number of rolls that was saved to the file. 
 * It also has a method to ask the user if they want to change the 
 * settings as well as the ability to do so
 * saving the new configuration to the txt file. 
 * 
 *@author: Ernie Tsybulnik
 *@version: 1.2
 *@since: 3/26/2017
*/



import java.util.*;
import java.io.*;

public class Settings {
//attributes
	private static int numSides;
	private static int numDice;
	private static int numRolls;
	private static boolean config;
	private Scanner file;
	
	Scanner in = new Scanner(System.in);
	
//constructor
	/**
	 * Constructor, reads file "yahtzeeConfig.txt" setting 
	 * the private member variable equal to the appropriate 
	 * quantities. An exception is thrown if no such file is 
	 * found or does not include all needed values.
	 * @param none
	 * @throws exception if file "yahtzeeConfig.txt" is not found or is empty
	 */
	Settings(){
		try{
			file = new Scanner(new File("yahtzeeConfig.txt"));
			numSides = file.nextInt();
			numDice = file.nextInt();
			numRolls = file.nextInt();
			config = false;
		}
		catch(Exception e){
			System.out.println("Error: file not found or empty!");
		}
	}
	
//methods
	/**
	 * Gets and returns the number of sides that the dice should have.
	 * @return int numSides
	 */
	public static int getNumSides(){
		return numSides;
	}
	
	/**
	 * Gets and returns the number of dice the user is playing with.
	 * @return int numDice
	 */
	public static int getNumDice(){
		return numDice;
	}
	
	/**
	 * Gets and returns the number of rolls that the user is playing with.
	 * @return int numRolls
	 */
	public static int getNumRolls(){
		return numRolls;
	}
	
	/**
	 * Gets and returns the private member variable "config" a boolean
	 * which holds whether a user wants to change the settings. 
	 * @return boolean config
	 */
	public static boolean getConfig(){
		return config;
	}
	
	/**
	 * Displays the current configuration settings and asks the user whether they
	 * want to change the configuration setting the boolean to the private 
	 * member variable "config". Then calls the private setConfiguration() method
	 */
	public void displayConfiguration(){
		System.out.print("you are playing with " + getNumDice() + " " + getNumSides());
		System.out.println("-sided dice");
		System.out.println("you get " + getNumRolls() + " rolls per hand\n");
		System.out.print("enter 'y' if you would like to change the configuration ");
		String change = in.next();
		if(change.charAt(0) == 'y')
			config = true;
		setConfiguration();
	}
	
	/**
	 * If the getConfig is true, that is the user wants to change configuration,
	 * then gets the new values from the user of number of sides, dice, and rolls.
	 * These are all written to the yahtzeeConfig.txt file. If it is not found
	 * an exception is thrown.
	 * @throws exception is thrown if the yahtzeeConfig.txt file does not exist. 
	 */
	public void setConfiguration(){
		if(getConfig() == true){
			try{
				Writer file = new FileWriter("yahtzeeConfig.txt");
				System.out.print("enter the number of sides on each die ");
				numSides = in.nextInt();
				file.write(numSides + "\n");
				System.out.print("enter the number of dice in play ");
				numDice = in.nextInt();
				file.write(numDice + "\n");
				System.out.print("enter the number of rolls per hand ");
				numRolls = in.nextInt();
				file.write(numRolls + "\n");
				file.close();
			}
			catch(Exception e){
				System.out.println("error in method 'setConfiguration()'");
			}
		}
	}
	
	/**
	 * sets the private member variables numSides and numDice equal
	 * to the passed in values, then writes them to the txt file. 
	 * @param sides : int represents the number of sides on dice.
	 * @param dice : int represents the number of dice in a hand.
	 */
	public void setConfiguration(int sides, int dice){
		try{
			Writer file = new FileWriter("yahtzeeConfig.txt");
			numSides = sides;
			numDice = dice;
			file.write(numSides + "\n");
			file.write(numDice + "\n");
			numRolls = 3;
			file.write(numRolls + "\n");
			file.close();
		}
		catch(Exception e){
			System.out.println("error in method 'setConfiguration()'");
		}
	}
}