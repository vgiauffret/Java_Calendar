package com.itii;

import javax.swing.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainPanel extends JPanel {                  

    private String[] choiceList;
    JComboBox<String> mPanelList;
    private JComboBox comboBox;
    private Component listPanel;
    
    MainPanel(){
    	setLayout(null);
    	this.setSize(1190, 640);
        choiceList = new String[] {"Month","Week","List"};
    	
    	
    	JPanel panel = new JPanel();
    	panel.setBounds(12, 0, 1190, 640);
    	add(panel);
    	panel.setLayout(null);
    	comboBox = new JComboBox<Object>(choiceList);
    	comboBox.setBounds(522, 22, 141, 24);
    	panel.add(comboBox);
    	
    	JPanel panelView = new JPanel();
    	panelView.setBounds(0, 58, 1178, 570);
    	panel.add(panelView);
    	

    	ActionListener cbActionListener = new ActionListener() {//add actionlistner to listen for change
            @Override
            public void actionPerformed(ActionEvent e) {

                String s = (String) comboBox.getSelectedItem();//get the selected item

                switch (s) {//check for a match
                    case "Month":
                        System.out.println("Month selected");
                        //Affiche Pannel Month
                        break;
                    case "Week":
                        System.out.println("Week selected");
                        //Affiche Pannel Week
                        break;
                    case "List":
                        System.out.println("List selected");
                        //Affiche Pannel List
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
