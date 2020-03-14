package com.itii;

import javax.swing.*;
import java.awt.*;

public class PanelButton extends JPanel {
    private JPanel panel;


    PanelButton(){
    	setLayout(null);
    	
    	JPanel panel_1 = new JPanel();
    	panel_1.setBackground(Color.DARK_GRAY);
    	panel_1.setBounds(0, 0, 200, 700);
    	add(panel_1);
    	panel_1.setLayout(null);
    	
    	JButton btnCreer = new JButton("Creer");
    	btnCreer.setBounds(12, 70, 176, 35);
    	panel_1.add(btnCreer);
    	
    	JButton btnEditer = new JButton("Editer");
    	btnEditer.setBounds(12, 140, 176, 35);
    	panel_1.add(btnEditer);
    	
    	JButton btnDupliquer = new JButton("Dupliquer");
    	btnDupliquer.setBounds(12, 280, 176, 35);
    	panel_1.add(btnDupliquer);
    	
    	JButton btnMarquer = new JButton("Marquer");
    	btnMarquer.setBounds(12, 210, 176, 35);
    	panel_1.add(btnMarquer);
    	
    	JButton btnSupprimer = new JButton("Supprimer");
    	btnSupprimer.setBounds(12, 350, 176, 35);
    	panel_1.add(btnSupprimer);


    }
}
