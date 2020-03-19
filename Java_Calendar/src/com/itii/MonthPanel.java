package com.itii;


import javax.swing.JButton;
import javax.swing.JPanel;


public class MonthPanel {
	
	public MonthPanel() {
		// TODO Auto-generated constructor stub
 	
    	JPanel Monthpanel = new JPanel();
    	Monthpanel.setBounds(0, 0, 800, 450);
    	Monthpanel.setLayout(null);
    	
    	JButton btnNewButton = new JButton("New button");
    	btnNewButton.setBounds(12, 64, 100, 100);
    	Monthpanel.add(btnNewButton);
    	
    	JButton button = new JButton("New button");
    	button.setBounds(124, 64, 100, 100);
    	Monthpanel.add(button);
    	
    	JButton button_1 = new JButton("New button");
    	button_1.setBounds(236, 64, 100, 100);
    	Monthpanel.add(button_1);
    	
    	JButton button_3 = new JButton("New button");
    	button_3.setBounds(458, 64, 100, 100);
    	Monthpanel.add(button_3);
    	
    	JButton button_2 = new JButton("New button");
    	button_2.setBounds(346, 64, 100, 100);
    	Monthpanel.add(button_2);
    	
    	JButton button_4 = new JButton("New button");
    	button_4.setBounds(570, 64, 100, 100);
    	Monthpanel.add(button_4);
    	
    	JButton button_5 = new JButton("New button");
    	button_5.setBounds(682, 64, 100, 100);
    	Monthpanel.add(button_5);
    	
	}
}
