package com.itii;

import javax.swing.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainPanel extends JPanel {                  

    private String[] choiceList;
    JComboBox<String> mPanelList;
    public JComboBox comboBox;
    private ListPanel listpanel;
    private MonthPanel monthPanel;
    private WeekPanel weekPanel;
    public JPanel panel;
    
    MainPanel(){
    	
    	this.setSize(1190, 640);
    	

        choiceList = new String[] {"Month","Week","List"};
    	setLayout(null);
    	panel = new JPanel();
    	panel.setBounds(12, 0, 1166, 628);
    	add(panel);
    	panel.setLayout(null);
    	comboBox = new JComboBox<Object>(choiceList);
    	comboBox.setBounds(524, 12, 141, 24);
    	panel.add(comboBox);
    	
    	listpanel = new ListPanel();
    	listpanel.setBounds(0, 30, 1190, 637);
    	panel.add(listpanel);
    	weekPanel = new WeekPanel();
    	weekPanel.setBounds(0, 30, 1190, 637);
    	panel.add(weekPanel);
    	monthPanel = new MonthPanel();
    	monthPanel.setBounds(100, 50, 1000, 600);
    	panel.add(monthPanel);
    	monthPanel.setVisible(true);
    	
    	
    	    	

    	ActionListener cbActionListener = new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {

                String s = (String) comboBox.getSelectedItem();//get the selected item

                switch (s) {//check for a match
                    case "Month":
                    	monthPanel.setVisible(true);
                        weekPanel.setVisible(false);
                        listpanel.setVisible(false); 
                        break;
                    case "Week":
                        monthPanel.setVisible(false);
                        weekPanel.setVisible(true);
                        listpanel.setVisible(false); 
                        break;
                    case "List":
                        monthPanel.setVisible(false);
                        weekPanel.setVisible(false);
                        listpanel.setVisible(true);  
                        break;
                    default:
                        System.out.println("No match selected");
                        break;
                }
            }

        };
    	comboBox.addActionListener(cbActionListener);
        
    }
}
