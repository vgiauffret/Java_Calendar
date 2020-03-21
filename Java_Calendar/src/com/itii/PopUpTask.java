package com.itii;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.itii.db.*;

public class PopUpTask extends JDialog {

	private static final long serialVersionUID = 1L;
	private Connexion connexion;
	private JLabel nom;
	private JLabel date;
	private JLabel details;
	private JLabel nomTache;
	private JLabel detailTache;
	private JLabel dateTache;
	private String retrievedDate;


	
	public Connexion getConnexion() {
		return connexion;
	}


	public void setRetrievedDate(String date) {
		this.retrievedDate = date;
	}

	public String getRetrievedDate() {
		return this.retrievedDate;
	}

	
	public String twoDigits(String chaine) {
		
		String parsedString = chaine;
		if(chaine.length() == 1) {
			parsedString = "0"+ chaine;
				}
	return parsedString ;	
	}
	
	public void setFormatedRetrievedDate(int day,int month,int year) {
		String jour = String.valueOf(day);
		jour = twoDigits(jour);
		
		String mois = String.valueOf(month);
		mois = twoDigits(mois);
		
		String annee = String.valueOf(year);
		annee = twoDigits(annee);
		
		this.retrievedDate =jour +"-" + mois +"-" + annee ;
	}
	
	
	public void updateLabels() {
		
	}
	

	public PopUpTask() {
		connexion = new Connexion();
		connexion.connect();
		this.setTitle("Tâche");
		this.setBounds(500, 300, 350, 250);

		this.setVisible(true);
		getContentPane().setLayout(null);

		nom = new JLabel("Nom : ");
		nom.setBounds(12, 30, 150, 15);
		getContentPane().add(nom);


		date = new JLabel("Date : ");
		date.setBounds(12, 60, 150, 15);
		getContentPane().add(date);

		details = new JLabel("Détails : ");
		details.setBounds(12, 90, 150, 15);
		getContentPane().add(details);

		nomTache = new JLabel();
		nomTache.setBounds(160, 29, 243, 19);
		getContentPane().add(nomTache);


		detailTache = new JLabel();
		detailTache.setBounds(94, 109, 318, 149);
		getContentPane().add(detailTache);



		dateTache = new JLabel();
		dateTache.setBounds(169, 69, 191, 41);
		getContentPane().add(dateTache);


		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}



}