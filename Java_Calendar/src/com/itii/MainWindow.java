package com.itii;

import javax.swing.*;

import com.itii.planning.gui.task.TaskDialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
/**
 * Fenêtre principal du calendrier implémentant la pattern Singleton : Un seul objet MainWindow instancié dans tout le programme
 * @author Malik & Vincent
 *
 */
public class MainWindow extends JFrame {
	/**Objet static de type MainWindow */
	private static MainWindow mWindow;
	/**Panneau d'affichage principale */
	private MainPanel mMainPanel;
	/** Barre de menu*/
	private JMenuBar mainMenuBar = new JMenuBar();
	/** Sous-menu créer */
	private JMenuItem creer;
	/** Sous-menu editer */
	private JMenuItem  editer;
	/** Sous-menu marquer*/
	private JMenuItem marquer;
	/**  Sous-menu Duppliquer*/
	private JMenuItem dupliquer;
	/** Sous-menu Supprimer*/
	private JMenuItem supprimer;
	/** Menu placé sur la barre de menu : Fichier ,Edition , Vue , Aide */
	private JMenu fichier,edition,vue,aide ;
	/** Panneau de bouton   latérale */
	private PanelButton panelbutton;
	/**Menu permettant de choisir l'affichage du calendrier   */
	private JMenuItem Month,Week,List;
	/** Panneau affichant le calendrier sous forme de liste */
	private ListPanel listpanel;
	/** Panneau affichant le calendrier en mois*/
	private MonthPanel monthPanel;
	/**   Panneau affichant le calendrier en semaine*/
	private WeekPanel weekPanel;

	/**
	 * Constructeur privé (Singleton)
	 */
	private MainWindow() {
		initialize();

	}

	/**
	 * 
	 * Initialise l'objet MainWindow et positionne les panels, boutons et menus dans la fenêtre.
	 */
	private void initialize() {

		this.setTitle("Mon calendrier");
		this.setSize(1400, 700);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		mMainPanel = new MainPanel();
		mMainPanel.setBounds(0, 0, 1190, 637);
		panelbutton = new PanelButton();
		panelbutton.setBounds(1188, 0, 200, 637);

		fichier = new JMenu("Fichier");
		edition = new JMenu("Edition");
		creer = new JMenuItem("Créer");
		editer = new JMenuItem("Editer");
		marquer = new JMenuItem("Marquer");
		dupliquer= new JMenuItem("Dupliquer");
		supprimer= new JMenuItem("Supprimer");
		edition.add(creer);edition.add(editer);edition.add(marquer);edition.add(dupliquer);edition.add(supprimer);
		vue = new JMenu("Vue");
		aide = new JMenu("Aide");
		mainMenuBar.add(fichier);
		mainMenuBar.add(edition);
		mainMenuBar.add(vue);

		Month = new JMenuItem("Month");
		Week = new JMenuItem("Week");
		List = new JMenuItem("List");
		vue.add(Month);vue.add(Week);vue.add(List);

		listpanel = new ListPanel();


		listpanel.setBounds(0, 30, 1190, 637);
		this.add(listpanel);
		weekPanel = new WeekPanel();
		weekPanel.setBounds(0, 30, 1190, 637);
		this.add(weekPanel);
		monthPanel = new MonthPanel();
		monthPanel.setBounds(0, 30, 1190, 637);
		this.add(monthPanel);
		listpanel.setPanelButton(panelbutton);
		panelbutton.setListPanel(listpanel);

		/**
		 * Action liée a l'appuie sur le bouton créer
		 */
		creer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new TaskDialog();
			}
		});

		/**
		 * Action liée a l'appuie sur le bouton editer
		 */
		editer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		/**
		 * Action liée a l'appuie sur le bouton marquer
		 */
		marquer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		/**
		 * Action lier a l'appuie sur le bouton dupliquer
		 */
		dupliquer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		/**
		 * Action liée a l'appuie sur le bouton supprimer
		 */
		supprimer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//panelbutton.setListPanel(listpanel);
				//listpanel.checkComboBox();


			}
		});

		/**
		 * Action liée a l'appuie sur le bouton month dans la MainBar
		 */
		Month.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				mMainPanel.getComboBox().setSelectedItem("Month");

			}
		});

		/**
		 * Action liée a l'appuie sur le bouton week dans la MainBar
		 */
		Week.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				mMainPanel.getComboBox().setSelectedItem("Week"); 				
			}
		});

		/**
		 * Action liée a l'appuie sur le bouton list dans la MainBar
		 */
		List.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				mMainPanel.getComboBox().setSelectedItem("List");                
			}
		});




		mainMenuBar.add(aide);

		this.setJMenuBar(mainMenuBar);
		getContentPane().setLayout(null);
		getContentPane().add(mMainPanel);
		getContentPane().add(panelbutton);


		this.validate();
		this.repaint();
	}


	/**
	 * Méthode d'instanciation de la classe MainWindow: si  un objet MainWindow existe déjà, c'est ce même objet qui est retourné.
	 * @return Objet MainWindow
	 */
	public static MainWindow getInstance() {
		if (mWindow == null) {
			mWindow = new MainWindow();
		}
		return mWindow;
	}
}
