/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javax.swing.*;

import java.util.logging.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
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
    public JTextArea messageCenter;
    public JLabel playerHealth;
    public JButton rollDice;
    private JButton saveGamebutton;
    public JTextArea scoreTobeat;
    
    // new attributes
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
        //jPanel1 = new JPanel();
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
        messageCenter = new JTextArea();
        launchBattle = new JButton();
        aiList = new ArrayList<EnemyRounds>();
        user = new Player();
        
        rollDice.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
            	if(YahtzeeTest.getCount() >= 2){
            		//hand.sortHand();
            		battle = new BattleScreen(gui.this);
    				battle.setVisible(true);
    				//hand.sortHand();
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
    	if(YahtzeeTest.getRound() == 1){
    		currEnemy = new EnemyRounds();
    	}
    	currEnemy = new EnemyRounds();
    	aiList.add(currEnemy);
    }
    
    public void enemyHealthButton(){
    	System.out.println("enemy button");
    	//Enemy currentE;
    	System.out.println("enemy created");
    	if(YahtzeeTest.getRound() == 1){
    		currentE = new YSoldier();
    		
    	} else {
    		currentE = new StrongYSoldier();
    	}
    	System.out.println("enemy finished");
    	//aiHealth.setText(Integer.toString(currentE.getHealth()));
    }
    
    public void rollButton(){
    	
    }
    
    public void tempHandCreator(){
    	Settings tempSet = new Settings(6, 5, 3);
    	this.hand = new Hand(tempSet);
    	for(int i=1; i<6; i++){
    		hand.addDie();
    	}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
   // @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    public void initComponents() {
    	getContentPane().removeAll();
		getContentPane().invalidate();
		JPanel topPanel = new JPanel();
	    //topPanel.setLayout(new BorderLayout());
	    getContentPane().add(topPanel);

    	
        jPanel1 = new JPanel(){
        	public void paintComponent(Graphics g){
        		g.drawImage(map.getImage(), 0, 0, this.getWidth(), this.getHeight(), null);
        		g.drawImage(player.getImage(), x, y, 80, 80, null);
        		g.drawImage(enemy.getImage(), 400, 200, 80, 80, null);
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

        playerHealth.setText("<html><div style='text-align: center;'>Player Health<br>"+ Integer.toString(user.getpHealth())+ "</div></html");
        //playerHealth.setColumns(20);
        //playerHealth.setRows(5);
        jScrollPane1.setViewportView(playerHealth);

        aiScore.setText("<html><div style='text-align: center;'>Enemy Score<br>"+ Integer.toString(10)+ "</div></html");
        //aiScore.setColumns(20);
        //aiScore.setRows(5);
        jScrollPane2.setViewportView(aiScore);

        aiHealth2.setText("<html><div style='text-align: center;'>Players Score<br>"+ Integer.toString(10)+ "</div></html");
        //aiHealth2.setColumns(20);
        //aiHealth2.setRows(5);
        jScrollPane4.setViewportView(aiHealth2);

        if(YahtzeeTest.getCount() >= 2){
        	hand.sortHand();
        	rollDice.setText("Start Battle");
        }
        else{
        	rollDice.setText("Roll Dice");
        }

        //enemyHealthButton();
        //System.out.println("enemy button called");
        
        //aiHealth.setColumns(20);
        //aiHealth.setRows(5);
        aiHealth.setText("<html><div style='text-align: center;'>Enemy Health<br>"+ Integer.toString(aiList.get(0).getHealth())+ "</div></html");
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
        

        saveGamebutton.setText("Save Game");

        messageCenter.setColumns(20);
        messageCenter.setRows(5);
        jScrollPane7.setViewportView(messageCenter);

        launchBattle.setText("Launch Battle");

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

        getContentPane().revalidate();
        pack();
        
        // new !!
        //setVisible(true);
        //setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void rollDiceActionPerformed(ActionEvent evt) {//GEN-FIRST:event_rollDiceActionPerformed
    	YahtzeeTest.incrementCount();
		String keep = dice.isSelected();
		if(dice.getNumDiceSelected() == 5)
			YahtzeeTest.finishCount();
		System.out.println(keep);
		hand.keepDice(keep, hand, YahtzeeTest.getFrame());
		
    }//GEN-LAST:event_rollDiceActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
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
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gui().setVisible(true);
            }
        });
    }

}
