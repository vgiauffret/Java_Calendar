package com.itii;

import javax.swing.*;

import com.itii.planning.gui.task.TaskDialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelButton extends JPanel {
    private JPanel panel;
    
    private JButton btnCreer;
    public JButton getCreerBtn()
    {
    	return btnCreer;
    }

    PanelButton(){
    	setLayout(null);
    	
    	JPanel panel_button = new JPanel();
    	panel_button.setBackground(Color.DARK_GRAY);
    	panel_button.setBounds(0, 0, 200, 700);
    	add(panel_button);
    	panel_button.setLayout(null);
    	
    	btnCreer = new JButton("Creer");
    	btnCreer.setBounds(12, 70, 176, 35);
    	panel_button.add(btnCreer);
    	
    	JButton btnEditer = new JButton("Editer");
    	btnEditer.setBounds(12, 140, 176, 35);
    	panel_button.add(btnEditer);
    	
    	JButton btnDupliquer = new JButton("Dupliquer");
    	btnDupliquer.setBounds(12, 280, 176, 35);
    	panel_button.add(btnDupliquer);
    	
    	JButton btnMarquer = new JButton("Marquer");
    	btnMarquer.setBounds(12, 210, 176, 35);
    	panel_button.add(btnMarquer);
    	
    	JButton btnSupprimer = new JButton("Supprimer");
    	btnSupprimer.setBounds(12, 350, 176, 35);
    	panel_button.add(btnSupprimer);
    	
    	
    	this.getCreerBtn().addActionListener(new ActionListener() {
    		
    		@Override
    		public void actionPerformed(ActionEvent arg0) {
    			// TODO Auto-generated method stub
    			new TaskDialog();
    		}
    	});
    }

}





