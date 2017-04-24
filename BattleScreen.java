
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math.*;

import javax.swing.*;


public class BattleScreen extends JDialog {
	private JPanel buttonPanel;
	//private JPanel scorePanel;
	private JPanel Background;
	ImageIcon Man = new ImageIcon("New Piskel (3).png");
	ImageIcon Back = new ImageIcon("map.jpg");
	//ImageIcon Enemy = new ImageIcon("New Piskel (2).png");
	int x = 20, y = 30;
	int eX = 1100, eY = 700;
	private ArrayList<EnemyMovement> army;
	Random rn = new Random();
	private boolean collided;
	
	/**
	 * Constructor. Creates a dialog box which displays the
	 * scorecard with their values. 
	 * @param owner : of type JFrame
	 */
	public BattleScreen(JFrame owner) {
		super(owner, "ScoreCard", true);
		collided = false;
		/*
		// OK button closes the dialog
		JButton ok = new JButton("OK");
		ok.addActionListener(event -> setVisible(false));
		
		// add OK button to southern border
		buttonPanel = new JPanel();
		
		buttonPanel.add(ok);
		add(buttonPanel, BorderLayout.SOUTH);
		
		// ScorePanel
		//scorePanel = new JPanel();
		*/
		army = new ArrayList<EnemyMovement>();
		
		int numEnemies = 0;
		if(YahtzeeTest.getRound() == 1){
			numEnemies = 5;
		} else {
			numEnemies = 1;
		}
		
		for(int i=0; i<numEnemies; i++){
			EnemyMovement soldier = new EnemyMovement();
			army.add(soldier);
		}
		
		
		Background = new JPanel(){
			public void paintComponent(Graphics g){
				g.drawImage(Back.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
				g.drawImage(Man.getImage(), x, y, 80, 80, null);
				for(EnemyMovement enemy : army){
					g.drawImage(enemy.getEnemyImage(), enemy.getX(), enemy.getY(), 80, 80, null);
				}
				//eX += 1;
				//repaint();
			}
		};
		Background.setPreferredSize(new Dimension(1200, 800));
		setContentPane(Background);
		addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke){
				if(ke.getKeyCode()==ke.VK_RIGHT && x<Background.getWidth()-60) x+=10;
				if(ke.getKeyCode()==ke.VK_LEFT && x>0) x-=10;
				if(ke.getKeyCode()==ke.VK_UP && y>10) y-=10;
				if(ke.getKeyCode()==ke.VK_DOWN && y<Background.getHeight()-80) y+=10;
				
				for(EnemyMovement enemy : army){
					int step = rn.nextInt(4 - 3 + 1) + 3 + rn.nextInt(4-2+1)+2;
					if(x-enemy.getX() < 0)
						enemy.changeX(-step);
					else
						enemy.changeX(step);
					if(y-enemy.getY() < 0)
						enemy.changeY(-step);
					else
						enemy.changeY(step);
					isCollided(enemy);
						
				}
				repaint();
				if(collided == true){
					// OK button closes the dialog
					JLabel text = new JLabel("You Collided!");
					JButton ok = new JButton("OK");
					ok.addActionListener(event -> setVisible(false));
					
					// add OK button to southern border
					buttonPanel = new JPanel();
					
					buttonPanel.add(text);
					buttonPanel.add(ok);
					setContentPane(buttonPanel);
					pack();
					repaint();
					
					System.out.println("You collided");
					
					// ScorePanel
					//scorePanel = new JPanel();
				}
			}
		});
		/*
		addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
				
				x = e.getX()-40;
				y = e.getY()-40;
				
			}
		});
		*/
		//add(Background,BorderLayout.NORTH);
		pack();
		//setVisible(true);
		//setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		
		//pack();
	}
	
	public void isCollided(EnemyMovement enemy){
		if(Math.abs(x-enemy.getX())<40 && Math.abs(y-enemy.getY())<40){
			System.out.println("isCollided true");
			collided = true;
		}
	}
}