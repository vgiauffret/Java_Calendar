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
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
/**
 * Correspond à la fenetre pour afficher les tâches du jour
 * @author Malik et Vincent
 *
 */
public class PopUpTask extends JDialog {

	/** ID unique*/
	private static final long serialVersionUID = 1L;
	/** Objet de type connexion pour la connexion à la base de donnée	*/
	private Connexion connexion;
	/** Objet de type JLabel											*/
	private JLabel nom;
	/** Objet de type JLabel											*/
	private JLabel date;
	/** Objet de type JLabel											*/
	private JLabel details;
	/** Objet de type JLabel qui contient le nom de la tâche			*/
	private JLabel nomTache;
	/** Objet de type JLabel qui contient les détails de la tâches		*/
	private JTextArea detailTache;
	/** Objet de type JLabel qui contient la date dûe de la tâche		*/
	private JLabel dateTache;
	/** Objet de type String qui contient la date						*/
	private String retrievedDate;
	/** Objet de type tableau de Jbutton qui contient les butons pour les tâches */
	private JButton [] btnTasks = new JButton[8];



	/**
	 * Récupère tous les boutons pour les différentes tâches
	 * @return Objet de type tableau de JButton
	 */
	public JButton[] getBtnTasks() {
		return this.btnTasks;
	}

	/**
	 * Récupère le nom de la tâche
	 * @return Objet de type JLabel
	 */
	public JLabel getNomTache() {
		return this.nomTache;
	}
	
	/**
	 * Récupère les détails de la tâche
	 * @return Objet de type JLabel
	 */
	public JTextArea getDetailTache() {
		return this.detailTache;
	}
		
	/**
	 * Récupère la date de la tâche
	 * @return Objet de type JLabel
	 */
	public JLabel getDateTache() {
		return this.dateTache;
	}

	/**
	 * Récupère l'objet connexion
	 * @return Un objet de type Connexion
	 */
	public Connexion getConnexion() {
		return connexion;
	}

	/**
	 * Affecte une date 
	 * @param date : Objet de type String
	 */
	public void setRetrievedDate(String date) {
		this.retrievedDate = date;
	}
	
	/**
	 * Récupère la date
	 * @return Un objet de type String
	 */
	public String getRetrievedDate() {
		return this.retrievedDate;
	}
	
	/**
	 * Méthode pour mettre les chiffres sur 2digits
	 * @param un objet de type String
	 * @return Un objet de type String
	 */
	private String twoDigits(String chaine) {

		String parsedString = chaine;
		if(chaine.length() == 1) {
			parsedString = "0"+ chaine;
		}
		return parsedString ;	
	}


	/**
	 * Méthode pour mettre la date au bon format
	 * @param day : Objet de type int qui correspond au jour
	 * @param month : Objet de type int qui correspond au mois
	 * @param year : Objet de type int qui correspond à l'année
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
		dateTache.setVerticalAlignment(SwingConstants.TOP);
		dateTache.setHorizontalAlignment(SwingConstants.LEFT);
		dateTache.setBounds(121, 68, 142, 17);
		panel.add(dateTache);

		detailTache = new JTextArea();
		detailTache.setLineWrap(true);
		detailTache.setEditable(false);
		detailTache.setBounds(121, 131, 315, 86);
		panel.add(detailTache);

		nomTache = new JLabel();
		nomTache.setHorizontalAlignment(SwingConstants.LEFT);
		nomTache.setVerticalAlignment(SwingConstants.TOP);
		nomTache.setBounds(121, 24, 315, 15);
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

		int x=0,y = 0;
		for(int i = 0; i < btnTasks.length; i++) {
			btnTasks[i]= new JButton ("Tâche "+(i+1));
			btnTasks[i].setName("button_" + (i+1));
			btnTasks[i].setBounds(x, y, 106, 25);
			getContentPane().add(btnTasks[i]);
			x+=118;
			if(i ==3) {
				x= 0;
				y +=33;
			} 
			btnTasks[i].setVisible(false);
		}
		

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
}
