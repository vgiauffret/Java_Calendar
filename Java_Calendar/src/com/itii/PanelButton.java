package com.itii;

import javax.swing.*;
import java.awt.*;

public class PanelButton extends JPanel {

    private JButton creer,editer,marquer,dupliquer,supprimer;


    PanelButton(){
        creer = new JButton("Créer");
        editer = new JButton("Editer");
        marquer = new JButton("Marquer");
        dupliquer = new JButton("Dupliquer");
        supprimer = new JButton("Supprimer");
        creer.setAlignmentX(Component.LEFT_ALIGNMENT);
        editer.setAlignmentX(Component.LEFT_ALIGNMENT);
        marquer.setAlignmentX(Component.LEFT_ALIGNMENT);
        dupliquer.setAlignmentX(Component.LEFT_ALIGNMENT);
        supprimer.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.add(creer);
        this.add(editer);
        this.add(marquer);
        this.add(dupliquer);
        this.add(supprimer);


    }
}
