package com.itii;

import javax.swing.*;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
/**
 * Correspond a la fenetre qui se trouve au centre de la fenetre Mainwindow et qui prend la vue list, month ou week
 * @author Malik et Vincent
 *
 */
public class MainPanel extends JPanel {                  
	/**choix du menu déroulant permattant de sélectionner l'affichage*/
	private String[] choiceList;
	/**Objet contenant les choix de menu pour la vue */
	JComboBox<String> mPanelList;
	/**Objet de type ComboBox */
	private JComboBox comboBox;
	/**Panneau d'affichage sous forme de  liste */
	private ListPanel listpanel;
	/** Panneau d'affichage sous forme de  mois*/
	private MonthPanel monthPanel;
	/**Panneau d'affichage sous forme de  semaine  */
	private WeekPanel weekPanel;
	/**Objet de type JPanel */
	public JPanel panel;

	/**
	 * Récupère l'objet comboBox
	 * @return Objet de type JComboBox
	 */
	public JComboBox getComboBox() {

		return comboBox;
	}
	/**
	 * Constructeur de Mainpanel qui se trouve au centre de la fenetre MainWindow
	 */

	MainPanel(){

		this.setSize(1190, 640);


		choiceList = new String[] {"Month","Week","List"};
		setLayout(null);
		panel = new JPanel();
		panel.setBounds(12, 0, 1166, 628);
		add(panel);
		panel.setLayout(null);
		comboBox = new JComboBox<Object>(choiceList);
		comboBox.setBounds(524, 12, 141, 24);
		panel.add(comboBox);

		listpanel = new ListPanel();
		listpanel.setBounds(0, 30, 1190, 637);
		panel.add(listpanel);
		weekPanel = new WeekPanel();
		weekPanel.setBounds(0, 30, 1190, 637);
		panel.add(weekPanel);
		monthPanel = new MonthPanel();
		monthPanel.setBounds(100, 50, 1000, 600);
		panel.add(monthPanel);
		monthPanel.setVisible(true);



		/**
		 * Action liée au comboBox le choix du menu déroulant rendra visible notre sélection à l'écran
		 */
		ActionListener cbActionListener = new ActionListener() {//add actionlistner to listen for change
			@Override
			public void actionPerformed(ActionEvent e) {

				String s = (String) comboBox.getSelectedItem();//get the selected item

				switch (s) {//check for a match
				case "Month":
					monthPanel.setVisible(true);
					weekPanel.setVisible(false);
					listpanel.setVisible(false); 
					break;
				case "Week":
					monthPanel.setVisible(false);
					weekPanel.setVisible(true);
					listpanel.setVisible(false); 
					break;
				case "List":
					monthPanel.setVisible(false);
					weekPanel.setVisible(false);
					listpanel.setVisible(true);  
					break;
				default:
					System.out.println("No match selected");
					break;
				}
			}

		};
		comboBox.addActionListener(cbActionListener);

	}
}
