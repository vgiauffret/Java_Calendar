package com.itii;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.itii.db.*;
import com.sun.org.apache.xerces.internal.impl.dv.xs.DateDV;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

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
	private JButton button_0,button_1,button_2,button_3,button_4,button_5,button_6,button_7; 



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
		this.setBounds(500, 300, 466, 333);

		this.setVisible(true);
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(12, 62, 448, 229);
		getContentPane().add(panel);
		panel.setLayout(null);

		dateTache = new JLabel();
		dateTache.setBounds(149, 70, 142, 17);
		panel.add(dateTache);


		detailTache = new JLabel();
		detailTache.setBounds(149, 131, 315, 95);
		panel.add(detailTache);

		nomTache = new JLabel();
		nomTache.setBounds(149, 24, 98, 15);
		panel.add(nomTache);
		nomTache.setText("Aucune Tâche");

		details = new JLabel("Détails : ");
		details.setBounds(23, 131, 63, 15);
		panel.add(details);


		date = new JLabel("Date : ");
		date.setBounds(23, 70, 47, 15);
		panel.add(date);

		nom = new JLabel("Nom : ");
		nom.setBounds(23, 24, 44, 15);
		panel.add(nom);

		/*
		int x=0,y=0;
		for(int i=0;i<7;i++)
		{

			JButton 'button_' = new JButton("Tâche " + i);
			button_.setBounds(x, y, 106, 25);
			getContentPane().add(button_0);
			if(i==3)
			{
				x=0;
				y=y+33;
			}
			i=i+118;
		}*/

		button_0 = new JButton("Tâche 1");
		button_0.setBounds(0, 0, 106, 25);
		getContentPane().add(button_0);
		button_0.setVisible(false);

		button_1 = new JButton("Tâche 2");
		button_1.setBounds(118, 0, 106, 25);
		getContentPane().add(button_1);
		button_1.setVisible(false);

		button_2 = new JButton("Tâche 3");
		button_2.setBounds(236, 0, 106, 25);
		getContentPane().add(button_2);
		button_2.setVisible(false);

		button_3 = new JButton("Tâche 4");
		button_3.setBounds(354, 0, 106, 25);
		getContentPane().add(button_3);
		button_3.setVisible(false);

		button_4 = new JButton("Tâche 5");
		button_4.setBounds(0, 33, 106, 25);
		getContentPane().add(button_4);
		button_4.setVisible(false);

		button_5 = new JButton("Tâche 6");
		button_5.setBounds(118, 33, 106, 25);
		getContentPane().add(button_5);
		button_5.setVisible(false);

		button_6 = new JButton("Tâche 7");
		button_6.setBounds(236, 33, 106, 25);
		getContentPane().add(button_6);
		button_6.setVisible(false);

		button_7 = new JButton("Tâche 8");
		button_7.setBounds(354, 33, 106, 25);
		getContentPane().add(button_7);
		button_7.setVisible(false);

		button_0.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				nomTache.setText("");//Le getnomtache de la BD
				dateTache.setText("");//Le getdateDu de la BD
				details.setText("");//Le getdetails de la BD
				
			}
		});

		button_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				nomTache.setText("");//Le getnomtache de la BD
				dateTache.setText("");//Le getdateDu de la BD
				details.setText("");//Le getdetails de la BD
			}
		});

		button_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				nomTache.setText("");//Le getnomtache de la BD
				dateTache.setText("");//Le getdateDu de la BD
				details.setText("");//Le getdetails de la BD
			}
		});

		button_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				nomTache.setText("");//Le getnomtache de la BD
				dateTache.setText("");//Le getdateDu de la BD
				details.setText("");//Le getdetails de la BD
			}
		});

		button_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				nomTache.setText("");//Le getnomtache de la BD
				dateTache.setText("");//Le getdateDu de la BD
				details.setText("");//Le getdetails de la BD
			}
		});

		button_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				nomTache.setText("");//Le getnomtache de la BD
				dateTache.setText("");//Le getdateDu de la BD
				details.setText("");//Le getdetails de la BD
			}
		});

		button_6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				nomTache.setText("");//Le getnomtache de la BD
				dateTache.setText("");//Le getdateDu de la BD
				details.setText("");//Le getdetails de la BD
			}
		});
		
		button_7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				nomTache.setText("");//Le getnomtache de la BD
				dateTache.setText("");//Le getdateDu de la BD
				details.setText("");//Le getdetails de la BD
			}
		});



		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}
