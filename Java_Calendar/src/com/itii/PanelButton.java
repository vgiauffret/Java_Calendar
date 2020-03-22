package com.itii;

import javax.swing.*;

import com.itii.planning.gui.task.TaskDialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * Correspond au panel des boutons a droite de l'application Calendrier
 * Creer, Editer, Dupliquer, Marquer, et Supprimer 
 * @author Malik et Vincent
 *
 */
public class PanelButton extends JPanel {

	/** Objet de type JLabel qui correspond à la date du jour		*/
	JLabel lblDateDuJour; 
	/** Objet de type JButton qui correspond au bouton "Creer"		*/
	private JButton btnCreer; 
	/** Objet de type JButton qui correspond au bouton "Editer"		*/
	private JButton btnEditer;
	/** Objet de type JButton qui correspond au bouton "Dupliquer"	*/
	private JButton btnDupliquer;
	/** Objet de type JButton qui correspond au bouton "Marquer"	*/
	private JButton btnMarquer;
	/** Objet de type JButton qui correspond au bouton "Supprimer"	*/
	private JButton btnSupprimer;
	/** Objet de type ListPanel										*/
	private ListPanel listPanel;
	
	/**
	 * Affecte l'objet listPanel 
	 * @param listpanel : Objet De type ListPanel
	 */
	public void setListPanel(ListPanel listpanel) {
			this.listPanel = listpanel;	
	}
	
	/**
	 * Récupère l'objet listPanel
	 * @return Objet de type ListPanel
	 */
	public ListPanel getListPanel() {
		return listPanel;		
	}
	
	/**
	 * Récupère l'objet bouton "Creer3
	 * @return Objet de type JButton
	 */
	public JButton getCreerBtn()
	{
		return btnCreer;
	}
	/**
	 * Récupère l'objet bouton "Editer"
	 * @return Objet de type JButton
	 */
	public JButton getEditerBtn()
	{
		return btnEditer;
	}
	/**
	 * Récupère l'objet bouton "Dupliquer"
	 * @return Objet de type JButton
	 */
	public JButton getDupliquerBtn()
	{
		return btnDupliquer;
	}
	/**
	 * Récupère l'objet bouton "Marquer"
	 * @return Objet de type JButton
	 */
	public JButton getMarquerBtn()
	{
		return btnMarquer;
	}
	/**
	 * Récupère l'objet bouton "Supprimer"
	 * @return Objet de type JButton
	 */
	public JButton getSupprimerBtn()
	{
		return btnSupprimer;
	}

	/**
	 * Constructeur du PanelButton qui contient les bouttons Creer, Editer, Marquer, Dupliquer, et Supprimer
	 */
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

		btnEditer = new JButton("Editer");
		btnEditer.setBounds(12, 140, 176, 35);
		panel_button.add(btnEditer);

		btnDupliquer = new JButton("Dupliquer");
		btnDupliquer.setBounds(12, 280, 176, 35);
		panel_button.add(btnDupliquer);

		btnMarquer = new JButton("Marquer");
		btnMarquer.setBounds(12, 210, 176, 35);
		panel_button.add(btnMarquer);

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(12, 350, 176, 35);
		panel_button.add(btnSupprimer);

		lblDateDuJour = new JLabel();
		lblDateDuJour.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		lblDateDuJour.setForeground(Color.WHITE);
		lblDateDuJour.setBounds(20, 562, 176, 35);
		panel_button.add(lblDateDuJour);

		this.getCreerBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new TaskDialog();
			}
		});

		this.getEditerBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new TaskDialog();
				//Identifier la tache selectionner
				//Recuperer les données pour préremplir le TaskDialog
				//Utilisateur modife le task
				//Remplacer l'ancienne tache par la nouvelle dans la BD
			}
		});

		this.getDupliquerBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Identifier la tache selectionner
				//Recuperer les données pour préremplir le TaskDialog
				//Posibilité de modifier la date seulement
				//Renvoi a la BD apres boutton OK
			}
		});

		this.getMarquerBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Identifier la tache selectionner
				//Passer state a true (Tache effectué)
				//Changer couleur cette tache
			}
		});

		this.getSupprimerBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//panelbutton.setListPanel(listpanel);
				//getListPanel().checkComboBox();


			}
		});
	}
}