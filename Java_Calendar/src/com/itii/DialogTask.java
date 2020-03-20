package com.itii;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.itii.db.*;

public class DialogTask extends JDialog {
	
	private Connexion connexion;
	private JLabel nom;
	private JLabel date;
	private JLabel details;
	
	public DialogTask() {
		connexion = new Connexion();
		//this.setSize(50,50);
		this.setBounds(600, 400, 450, 350);
        this.setVisible(true);
		getContentPane().setLayout(null);
		nom = new JLabel("Nom");
		nom.setBounds(12, 31, 150, 15);
		getContentPane().add(nom);
		date = new JLabel("Date");
		date.setBounds(12, 69, 150, 15);
		getContentPane().add(date);
		details = new JLabel("Détails");
		details.setBounds(12, 80, 150, 15);
		getContentPane().add(details);
		this.setTitle("Mon calendrier");
        this.setSize(1400, 700);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        connexion.connect();
	}
	
	

}
