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
		} else if(round == 2) {
			Enemy = new ImageIcon("Strong Yahtzee P (1).png");
		} else if(round == 3) {
			Enemy = new ImageIcon("Panzer.png");
		} else if(round == 4) {
			Enemy = new ImageIcon("Party Leader.png");
		} else if(round == 5) {
			Enemy = new ImageIcon("Japan Soldier.png");
		} else if(round == 6) {
			Enemy = new ImageIcon("Strong Japan Soldier.png");
		} else if(round == 7) {
			Enemy = new ImageIcon("Zero.png");
		} else {
			Enemy = new ImageIcon("Emperor.png");
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
