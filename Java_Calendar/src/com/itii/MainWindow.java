package com.itii;

import javax.swing.*;

import com.itii.planning.gui.task.TaskDialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private static MainWindow mWindow;
    private MainPanel mMainPanel;
    private JMenuBar mainMenuBar = new JMenuBar();
    private JMenuItem creer, editer , marquer, dupliquer , supprimer;
    private JMenu fichier,edition,vue,aide ;
    private PanelButton panelbutton;
    private JMenuItem Month,Week,List;
    private ListPanel listPanel;
    private MainWindow() {
    initialize();

    }


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
        listPanel = new ListPanel();
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
        
        creer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new TaskDialog();
			}
		});
        
        editer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
        marquer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
        dupliquer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
        supprimer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
        Month.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
        Week.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
        
        List.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//Add ListPanel
				getContentPane().validate();
				getContentPane().repaint();
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



    public static MainWindow getInstance() {
        if (mWindow == null) {
            mWindow = new MainWindow();
        }
        return mWindow;
    }
}
