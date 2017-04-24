import javax.swing.JFrame;


public class YahtzeeTest {
	private static gui currFrame;
	private static int count = 0;
	private static int round = 1;
	private static boolean reset = false;
	
	public static gui getFrame(){
		return currFrame;
	}
	
	public static void setReset(boolean temp){
		reset = temp;
	}
	
	public static boolean getReset(){
		return reset;
	}
	
	/**
	 * increments the private member variable 'count' by 1
	 */
	public static void incrementCount(){
		count++;
	}
	
	/**
	 * resets the private member variable 'count' back to 0.
	 */
	public static void resetCount(){
		count = 0;
	}
	
	/**
	 * sets the private member 'count' to 3.
	 */
	public static void finishCount(){
		count = 3;
	}
	
	/**
	 * returns the value stored in the private member variable 'count'
	 * @return int : variable count.
	 */
	public static int getCount(){
		return count;
	}
	
	public static void incrementRound(){
		round += 1;
	}
	
	public static int getRound(){
		return round;
	}

	public static String getMessageText(Hand hand){
		String text = "";
		if(count == 0){
			text = "Choose your dice wisely!";
		} else {
			text = hand.getScoreType();
		}
		return text;
	}
	
	public static void main(String[] args){
		java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            	gui frame = new gui();
        	    currFrame = frame;
        	    frame.setTitle("Yahtzee");
        	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	    frame.setVisible(true);
            }
        });
		/*
		gui frame = new gui();
	    currFrame = frame;
	    frame.setTitle("Yahtzee");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
		*/
	}
	
}
