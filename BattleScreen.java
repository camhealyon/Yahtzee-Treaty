
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;


public class BattleScreen extends JDialog {
	private JPanel buttonPanel;
	//private JPanel scorePanel;
	private JPanel Background;
	ImageIcon Man = new ImageIcon("New Piskel (2).png");
	ImageIcon Back = new ImageIcon("map.jpg");
	ImageIcon Enemy = new ImageIcon("New Piskel (3).png");
	int x = 20, y = 30;
	int eX = 100, eY = 100;
	
	/**
	 * Constructor. Creates a dialog box which displays the
	 * scorecard with their values. 
	 * @param owner : of type JFrame
	 */
	public BattleScreen(JFrame owner) {
		super(owner, "ScoreCard", true);
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
		Background = new JPanel(){
			public void paintComponent(Graphics g){
				g.drawImage(Back.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
				g.drawImage(Man.getImage(), x, y, 80, 80, null);
				g.drawImage(Enemy.getImage(), eX, eY, 80, 80, null);
				eX += 1;
				//repaint();
			}
		};
		Background.setPreferredSize(new Dimension(1200, 800));
		setContentPane(Background);
		addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent ke){
				if(ke.getKeyCode()==ke.VK_RIGHT ) x+=10;
				if(ke.getKeyCode()==ke.VK_LEFT ) x-=10;
				if(ke.getKeyCode()==ke.VK_UP) y-=10;
				if(ke.getKeyCode()==ke.VK_DOWN) y+=10;
				repaint();
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
	
}