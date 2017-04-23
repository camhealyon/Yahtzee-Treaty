import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

public class EnemyMovement {
	private int xMax = 1100;
	private int xMin = 100;
	private int yMax = 700;
	private int yMin = 90;
	private int x;
	private int y;
	private ImageIcon Enemy;
	Random rn = new Random();

	public EnemyMovement(){
		int round = YahtzeeTest.getRound();
		if(round == 1){
			Enemy = new ImageIcon("New Piskel (2).png");
		}
		
		x = rn.nextInt(xMax - xMin + 1) + xMin;
		y = rn.nextInt(yMax - yMin + 1) + yMin;
	}
	
	public void changeX(int value){
		x += value;
	}
	
	public void changeY(int value){
		y += value;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public Image getEnemyImage(){
		return Enemy.getImage();
	}
	
}
