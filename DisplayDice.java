/**
 * Displays the dice by adding them to a JToggleButton and then adding
 * them to a panel.
 * 
 *@author: Ernie Tsybulnik
 *@version: 1.0
 *@since: 3/26/2017
*/


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.ArrayList;

public class DisplayDice{
	private JPanel dicePanel;
	private ArrayList<JToggleButton> buttons;
	private int numDiceSelected;
	
	/**
	 * Adds the appropriate image for the dice to a jToggleButton
	 * and then adds the buttons to an array which adds it to the panel
	 * The buttons also have action listener. 
	 * @param hand : instance of the current Hand.
	 */
	public DisplayDice(Hand hand) {
		numDiceSelected = 0;
		buttons = new ArrayList<JToggleButton>();
		
//not settings! not 2
		for(int i=0; i < Settings.getNumDice(); i++){
			int dieValue = hand.getDieAtIndex(i);
			JToggleButton die;
			Icon image;
			if(dieValue == 1)
				image = new ImageIcon("one.png");
			else if(dieValue == 2)
				image = new ImageIcon("two.png");
			else if (dieValue == 3)
				image = new ImageIcon("three.png");
			else if(dieValue == 4)
				image = new ImageIcon("four.png");
			else if(dieValue == 5)
				image = new ImageIcon("five.png");
			else 
				image = new ImageIcon("six.png");
			
			die = new JToggleButton(image);
			die.setPreferredSize(new Dimension(85,85));
			buttons.add(die);
		}
		
		dicePanel = new JPanel();
		
		for(JToggleButton temp : buttons){
			dicePanel.add(temp);
		}
		
		//add(dicePanel);

		//create button actions
		BorderAction bAction = new BorderAction();
		
		//associate actions with buttons. 
		for(JToggleButton curr : buttons){
			curr.addActionListener(bAction);
		}
	}
	
	
	private class BorderAction implements ActionListener{
		private final Color sBorderColor = Color.RED;
		private final Color notSBorderColor = Color.BLACK;
		
		/**
		 * Creates a red border on the buttons that are selected and
		 * increments numDiceSelected if they are. 
		 */
		public void actionPerformed(ActionEvent event){
			Object source = event.getSource();
			JToggleButton button = (JToggleButton) source;
			if(button.isSelected()){
				numDiceSelected++;
				button.setBorder(BorderFactory.createLineBorder(sBorderColor, 4));
			} else {
				numDiceSelected--;
				button.setBorder(BorderFactory.createLineBorder(notSBorderColor, 1));
			}
		}
	}
	
	public ArrayList<JToggleButton> getDiceArray(){
		return buttons;
	}
	
	/**
	 * returns the int stored in the private member variable
	 * numDiceSelected.
	 * @return int : numDiceSelected.
	 */
	public int getNumDiceSelected(){
		return numDiceSelected;
	}
	
	/**
	 * loops through the buttons checking if they are selected creating
	 * a string of 'y' and 'n' accordingly. Returns the 'selected' string.
	 * @return String : selected. String which represents which dice are selected.
	 */
	public String isSelected(){
		String selected = "";
		for(JToggleButton curr : buttons){
			if(curr.isSelected())
				selected = selected + "y";
			else
				selected = selected + "n";
		}
		return selected;
	}
}
