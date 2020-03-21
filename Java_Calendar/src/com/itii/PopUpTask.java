package com.itii;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.itii.db.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
/**
 * Correspond a la fenetre pour afficher les tâches du jour
 * @author Malik && Vincent
 *
 */
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


	/**
	 * 
	 * @return
	 */
	public Connexion getConnexion() {
		return connexion;
	}

	/**
	 * 
	 * @param date
	 */
	public void setRetrievedDate(String date) {
		this.retrievedDate = date;
	}
	/**
	 * 
	 * @return
	 */
	public String getRetrievedDate() {
		return this.retrievedDate;
	}
	/**
	 * 
	 * @param chaine
	 * @return
	 */

	private String twoDigits(String chaine) {

		String parsedString = chaine;
		if(chaine.length() == 1) {
			parsedString = "0"+ chaine;
		}
		return parsedString ;	
	}
	

	/**
	 * 
	 */
	public void setFormatedRetrievedDate(int day,int month,int year) {
		String jour = String.valueOf(day);
		jour = twoDigits(jour);

		String mois = String.valueOf(month);
		mois = twoDigits(mois);

		String annee = String.valueOf(year);
		annee = twoDigits(annee);

		this.retrievedDate =jour +"-" + mois +"-" + annee ;
	}


	/**
	 * 
	 */
	public void updateLabels() {

	}


	/**
	 *  Constructeur de la fenetre tache qui nous permet de connaitre toutes les tâches associés au jour sélétionné
	 */
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


		JButton [] btnTasks = new JButton[8];
		int x=0,y = 0;
		for(int i = 0; i < btnTasks.length; i++) { //TODO : remplacer btnTaks par getNBTache
			btnTasks[i]= new JButton ("Tâche "+(i+1));
			btnTasks[i].setName("button_" + (i+1));
			btnTasks[i].setBounds(x, y, 106, 25);
			this.add(btnTasks[i]);
			x+=118;
			if(i ==3) {
				x= 0;
				y +=33;
			} 

			/**
			 * Action lier a l'appuie des boutons correspondant a chaque task
			 */
			btnTasks[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//nomTache.setText();//Le getnomtache de la BD
					//dateTache.setText("");//Le getdateDu de la BD
					//details.setText("");//Le getdetails de la BD
					JButton b = (JButton)e.getSource();
					System.out.println(b.getName());
				}});
		}

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}
