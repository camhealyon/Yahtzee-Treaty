


import javax.swing.*;

import java.util.logging.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
import java.util.ArrayList;


/**
 *
 * @author DanielVM
 */
public class gui extends JFrame {

	public JLabel aiHealth;
	//public JTextArea aiHealth;
    public JLabel aiHealth2;
    public JLabel aiScore;
    
    // !Every JLabel 1, 2, ... was changed to jToggleButtons
    private JToggleButton jToggleButton1;
    private JToggleButton jToggleButton2;
    private JToggleButton jToggleButton3;
    private JToggleButton jToggleButton4;
    private JToggleButton jToggleButton5;
    
    
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JScrollPane jScrollPane4;
    private JScrollPane jScrollPane5;
    private JScrollPane jScrollPane6;
    private JScrollPane jScrollPane7;
    public JButton launchBattle;
    
    public JLabel messageCenter;
    public JLabel playerHealth;
    public JButton rollDice;
    private JButton saveGamebutton;
    public JTextArea scoreTobeat;
    
    // new attributes
    private ImageIcon USFlag;
    private ImageIcon YahtzeePartyFlag;
    private ImageIcon KamaFlag;
    private Image USFlag2;
    private ImageIcon map;
    private ImageIcon player;
    private ImageIcon enemy;
    int x = 20;
    int y = 30;
    private Hand hand;
    private DisplayDice dice;
    private BattleScreen battle;
    private Enemy currentE;
    private Player user;
    
    private ArrayList<EnemyRounds> aiList;
    
    /**
     * Creates new form gui
     */
    public gui() {
    	// Implemented above

    	USFlag = new ImageIcon("USA.jpg");
    	Image USFlag3 = USFlag.getImage(); // transform it 
    	Image newimg = USFlag3.getScaledInstance(167, 73,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    	USFlag = new ImageIcon(newimg);

    	YahtzeePartyFlag = new ImageIcon("YahtzeeParty.jpg");
    	Image tempFlag = YahtzeePartyFlag.getImage(); // transform it 
    	Image newimg1 = tempFlag.getScaledInstance(167, 73,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    	YahtzeePartyFlag = new ImageIcon(newimg1);
        
    	KamaFlag = new ImageIcon("KamaYahtzee.jpg");
    	Image tempFlag2 = KamaFlag.getImage(); // transform it 
    	Image newimg2 = tempFlag2.getScaledInstance(167, 73,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
    	KamaFlag = new ImageIcon(newimg2);
    	jScrollPane1 = new JScrollPane();
        playerHealth = new JLabel("", SwingConstants.CENTER);
        playerHealth.setFont(new Font("SansSerif", Font.PLAIN, 22));
        playerHealth.setBackground(Color.CYAN.darker());
        playerHealth.setOpaque(true);
        playerHealth.setPreferredSize(new Dimension(230, 85));
        
        jScrollPane2 = new JScrollPane();
        aiScore = new JLabel("", SwingConstants.CENTER);
        aiScore.setFont(new Font("SansSerif", Font.PLAIN, 22));
        aiScore.setBackground(Color.LIGHT_GRAY);
        aiScore.setOpaque(true);
        aiScore.setPreferredSize(new Dimension(230, 85));
        jScrollPane4 = new JScrollPane();
        aiHealth2 = new JLabel("", SwingConstants.CENTER);
        aiHealth2.setFont(new Font("SansSerif", Font.PLAIN, 22));
        aiHealth2.setBackground(Color.LIGHT_GRAY);
        aiHealth2.setOpaque(true);
        aiHealth2.setPreferredSize(new Dimension(230, 85));
        rollDice = new JButton();
        jScrollPane5 = new JScrollPane();
        
        
        aiHealth = new JLabel("", SwingConstants.CENTER);
        aiHealth.setFont(new Font("SansSerif", Font.PLAIN, 22));
        aiHealth.setForeground(Color.black);
        aiHealth.setBackground(Color.red.darker());
        aiHealth.setOpaque(true);
        aiHealth.setPreferredSize(new Dimension(230, 85));
        //aiHealth = new JTextArea();
        jScrollPane6 = new JScrollPane();
        scoreTobeat = new JTextArea();
        
        /*
        jToggleButton1 = new JToggleButton();
       */
        jToggleButton2 = new JToggleButton();
        jToggleButton3 = new JToggleButton();
        jToggleButton4 = new JToggleButton();
        jToggleButton5 = new JToggleButton();
        
        
        saveGamebutton = new JButton();
        jScrollPane7 = new JScrollPane();
        
        messageCenter = new JLabel("", SwingConstants.CENTER);
        launchBattle = new JButton();
        aiList = new ArrayList<EnemyRounds>();
        user = new Player();
        
        rollDice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if(YahtzeeTest.getCount() >= 2){
            		
            		battle = new BattleScreen(gui.this);
    				battle.setVisible(true);
    				YahtzeeTest.resetCount();
    				YahtzeeTest.incrementRound();
    				newRoundActionPerformed(evt);
    				
            	} else {
            		rollDiceActionPerformed(evt);
            	}
            }
        });
        
        map = new ImageIcon("map.jpg");
    	player = new ImageIcon("New Piskel (3).png");
    	
    	enemy = new ImageIcon("New Piskel (4).png");
        
    	spawnEnemies();
        tempHandCreator();
        
        initComponents();
    }

    public void spawnEnemies(){
    	EnemyRounds currEnemy;
    	for(int count = 1; count<=8; count++){
	    	currEnemy = new EnemyRounds(count);
	    	aiList.add(currEnemy);
    	}
    }
    
    public void enemyHealthButton(){
    	//Enemy currentE;
    	if(YahtzeeTest.getRound() == 1){
    		currentE = new YSoldier();
    		
    	} else {
    		currentE = new StrongYSoldier();
    	}
    	//aiHealth.setText(Integer.toString(currentE.getHealth()));
    }
    
    
    public void tempHandCreator(){
    	Settings tempSet = new Settings(6, 5, 3);
    	this.hand = new Hand(tempSet);
    	for(int i=1; i<6; i++){
    		hand.addDie();
    	}
    }
    
    public void updateHealth(){
    	int damage = hand.getMaxScore()-aiList.get(YahtzeeTest.getRound()-1).getTotalDice();
    	if(damage > 0){
    		aiList.get(YahtzeeTest.getRound()-1).updateEDamage(damage);
    	} else {
    		user.updateDamage(Math.abs(damage));
    	}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    public void initComponents() {
    	getContentPane().removeAll();
		getContentPane().invalidate();
		JPanel topPanel = new JPanel();
	    //topPanel.setLayout(new BorderLayout());
	    getContentPane().add(topPanel);

	    if(user.getpHealth() <= 0){
	    	
			// OK button closes the dialog
			//YahtzeeTest.incrementCount();
			JLabel text = new JLabel("You Lost!",SwingConstants.CENTER);
			text.setPreferredSize(new Dimension(1100, 800));
			
			//JButton ok = new JButton("OK");
			//ok.addActionListener(event -> setVisible(false));
			
			// add OK button to southern border
			JPanel buttonPanel = new JPanel();
			
			buttonPanel.add(text);
			//buttonPanel.add(ok);
			setContentPane(buttonPanel);
			pack();
			repaint();
			
			
			// ScorePanel
			//scorePanel = new JPanel();
			
	    } else {
	    int round = YahtzeeTest.getRound();
		if(round == 1){
			enemy = new ImageIcon("New Piskel (2).png");
		} else if(round == 2) {
			enemy = new ImageIcon("Strong Yahtzee P (1).png");
		} else if(round == 3) {
			enemy = new ImageIcon("Panzer.png");
		} else if(round == 4) {
			enemy = new ImageIcon("Party Leader.png");
		} else if(round == 5) {
			enemy = new ImageIcon("Japan Soldier.png");
		} else if(round == 6) {
			enemy = new ImageIcon("Strong Japan Soldier.png");
		} else if(round == 7) {
			enemy = new ImageIcon("Zero.png");
		} else {
			enemy = new ImageIcon("Emperor.png");
		}
		
		saveGamebutton.setIcon(USFlag);
		if(YahtzeeTest.getRound() <= 4){
			launchBattle.setIcon(YahtzeePartyFlag);
		} else {
			launchBattle.setIcon(KamaFlag);
		}
    	
        jPanel1 = new JPanel(){
        	public void paintComponent(Graphics g){
        		g.drawImage(map.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
        		g.drawImage(player.getImage(), x, y, 160, 160, null);
        		g.drawImage(enemy.getImage(), 300, 50, 160, 160, null);
        	}
        };
    	
    	

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 314, Short.MAX_VALUE)
        );
        
        if(YahtzeeTest.getCount() >= 2){
        	updateHealth();
        	hand.sortHand();
        }
        
        if(aiList.get(YahtzeeTest.getRound()-1).getHealth() <= 0 ){
        	rollDice.setText("Start Battle");
        } else if(YahtzeeTest.getCount() >= 2){
        	YahtzeeTest.setReset(true);
        	
        	rollDice.setText("Start New Hand");
        	//YahtzeeTest.resetCount();
        }
        else{
        	YahtzeeTest.setReset(false);
        	rollDice.setText("Roll Dice");
        }
        

        playerHealth.setText("<html><div style='text-align: center;'>Player Health<br>"+ Integer.toString(user.getpHealth())+ "</div></html");
        //playerHealth.setColumns(20);
        //playerHealth.setRows(5);
        jScrollPane1.setViewportView(playerHealth);

        aiScore.setText("<html><div style='text-align: center;'>Enemy Score<br>"+ Integer.toString(aiList.get(YahtzeeTest.getRound()-1).getTotalDice())+ "</div></html");
        //aiScore.setColumns(20);
        //aiScore.setRows(5);
        jScrollPane2.setViewportView(aiScore);

        aiHealth2.setText("<html><div style='text-align: center;'>Players Score<br>"+ Integer.toString(hand.getMaxScore())+ "</div></html");
        //aiHealth2.setColumns(20);
        //aiHealth2.setRows(5);
        jScrollPane4.setViewportView(aiHealth2);


        //enemyHealthButton();
        //System.out.println("enemy button called");
        
        //aiHealth.setColumns(20);
        //aiHealth.setRows(5);
        aiHealth.setText("<html><div style='text-align: center;'>Enemy Health<br>"+ Integer.toString(aiList.get(YahtzeeTest.getRound()-1).getHealth())+ "</div></html");
        jScrollPane5.setViewportView(aiHealth);

        scoreTobeat.setColumns(20);
        scoreTobeat.setRows(5);
        jScrollPane6.setViewportView(scoreTobeat);
        
        
        
        dice = new DisplayDice(hand);
        ArrayList<JToggleButton> dButtons = dice.getDiceArray();
        
        //for(JToggleButton die : diceButtons):
        
        //JToggleButton tempButton = new JToggleButton("Hello");
        //jToggleButton1 = tempButton;
        jToggleButton1 = dButtons.get(0); 
        
        jToggleButton2 = dButtons.get(1); 
        jToggleButton3 = dButtons.get(2); 
        jToggleButton4 = dButtons.get(3); 
        jToggleButton5 = dButtons.get(4); 
        

        //saveGamebutton.setText("Save Game");

        //messageCenter.setColumns(20);
        //messageCenter.setRows(5);
        messageCenter.setText(YahtzeeTest.getMessageText(hand));
        jScrollPane7.setViewportView(messageCenter);

        //launchBattle.setText("Launch Battle");

        GroupLayout layout = new GroupLayout(getContentPane());
        
        
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane1)
                                    .addComponent(rollDice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jToggleButton1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jToggleButton2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jToggleButton3, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jToggleButton4, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jToggleButton5, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane7))))
                        .addGap(0, 2, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(saveGamebutton, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(launchBattle, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(saveGamebutton, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE)
                            .addComponent(launchBattle, GroupLayout.PREFERRED_SIZE, 73, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane7, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jToggleButton1, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToggleButton2, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToggleButton3, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToggleButton4, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToggleButton5, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(rollDice, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane6))))
                .addGap(6, 6, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        
        if(aiList.get(YahtzeeTest.getRound()-1).getHealth() > 0 && YahtzeeTest.getCount() >= 2){
        	aiList.get(YahtzeeTest.getRound()-1).rollDice();
        	YahtzeeTest.resetCount();
        }

        getContentPane().revalidate();
        pack();
	    }
        
        // new !!
        //setVisible(true);
        //setLocationRelativeTo(null);
    }

    private void rollDiceActionPerformed(ActionEvent evt) {
    	if(YahtzeeTest.getReset()==false){
    		YahtzeeTest.incrementCount();
    	}
		String keep = dice.isSelected();
		if(dice.getNumDiceSelected() == 5)
			YahtzeeTest.finishCount();
		hand.keepDice(keep, hand, YahtzeeTest.getFrame());
		
    }
    
    private void newRoundActionPerformed(ActionEvent evt){
    	//spawnEnemies();
    }

    
    /**
     * @param args the command line arguments
     */
    /*
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //private gui currFrame;
        //gui frame = new gui().setVisible(true);
	    //currFrame = frame;
        
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui().setVisible(true);
            }
        });
    }
*/
}
