package com.itii;

import javax.swing.*;
import java.awt.*;

public class PanelButton extends JPanel {
    private JPanel panel;


    PanelButton(){
    	setLayout(null);
    	
    	JPanel panel_button = new JPanel();
    	panel_button.setBackground(Color.DARK_GRAY);
    	panel_button.setBounds(0, 0, 200, 700);
    	add(panel_button);
    	panel_button.setLayout(null);
    	
    	JButton btnCreer = new JButton("Creer");
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


    }
}
