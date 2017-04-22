import javax.swing.JFrame;


public class YahtzeeTest {
	private static gui currFrame;
	
	public static gui getFrame(){
		return currFrame;
	}
	
	public static void main(String[] args){
		gui frame = new gui();
	    currFrame = frame;
	    frame.setTitle("Yahtzee");
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
		
	}
	
}
