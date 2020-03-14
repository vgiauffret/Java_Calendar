package com.itii;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    private static MainWindow mWindow;
    private MainPanel mMainPanel;
    private JMenuBar mainMenuBar = new JMenuBar();
    private JMenuItem creer, editer , marquer, dupliquer , supprimer;
    private JMenu fichier,edition,vue,aide ;
    private PanelButton panelbutton;
    private MainWindow() {
        initialize();

    }


    private void initialize() {
        this.setSize(1000, 1000);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(2,1));
        mMainPanel = new MainPanel();
        panelbutton = new PanelButton();
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
        mainMenuBar.add(aide);

        this.setJMenuBar(mainMenuBar);
        this.add(mMainPanel);

        this.add(panelbutton);


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
