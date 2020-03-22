package com.itii;

import javax.swing.*;

import com.itii.planning.gui.task.TaskDialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * Correspond au panel des boutons 
 * Creer, Editer, Dupliquer, Marquer, et Supprimer 
 * @author Malik && Vincent
 *
 */
public class PanelButton extends JPanel {

	JLabel lblDateDuJour;
	private JButton btnCreer,btnEditer,btnDupliquer,btnMarquer,btnSupprimer;
	private ListPanel listPanel;
	/**
	 * 
	 * @param listpanel
	 */
	public void setListPanel(ListPanel listpanel) {
		this.listPanel = listpanel;

	}
	/**
	 * 
	 * @return
	 */
	public ListPanel getListPanel() {
		return listPanel;


	}
	/**
	 * 
	 * @return
	 */
	public JButton getCreerBtn()
	{
		return btnCreer;
	}
	/**
	 * 
	 * @return
	 */
	public JButton getEditerBtn()
	{
		return btnEditer;
	}
	/**
	 * 
	 * @return
	 */
	public JButton getDupliquerBtn()
	{
		return btnDupliquer;
	}
	public JButton getMarquerBtn()
	{
		return btnMarquer;
	}
	public JButton getSupprimerBtn()
	{
		return btnSupprimer;
	}

	/**
	 * Constructeur du PanelButton qui se situe a droite de notre fenetre principale, il contient les bouttons Creer, Editer, Marquer, Dupliquer, et Supprimer
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

		/**
		 * Action lier a l'appuie sur le bouton creer qui lance une fenetre nouvelle tache
		 */
		this.getCreerBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				new TaskDialog();
			}
		});

		/**
		 * Action lier a l'appuie sur le bouton editer qui ouvre la tache sélectionnée et nous permet de la modifier
		 */
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

		/**
		 * Action lier a l'appuie sur le bouton dupliquer qui nous permet d'ajouter la date sélectionner à une date ultérieur
		 */
		this.getDupliquerBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Identifier la tache selectionner
				//Recuperer les données pour préremplir le TaskDialog
				//Posibilité de modifier la date seulement
				//Renvoi a la BD apres boutton OK
			}
		});

		/**
		 * Action lier a l'appuie sur le bouton marquer qui nous permet de déterminer qu'une tache est fini
		 */
		this.getMarquerBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//Identifier la tache selectionner
				//Passer state a true (Tache effectué)
				//Changer couleur cette tache
			}
		});

		/**
		 * Action lier a l'appuie sur le bouton supprimer qui permet de supprimer une tache
		 */
		this.getSupprimerBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				//panelbutton.setListPanel(listpanel);
				//getListPanel().checkComboBox();


			}
		});


	}
}





