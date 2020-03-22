package com.itii;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.itii.db.Connexion;

import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
/**
 * Correspond a la vue sous forme de liste des taches
 * @author Malik && Vincent
 *
 */
public class ListPanel extends JPanel {
	private JTable table;
	private DefaultTableModel tableModel; 
	private Connexion connexion;
	
	/**
	 * Constructeur de l'affichage liste
	 */
	public ListPanel()
	{
		connexion = new Connexion();
		connexion.connect();
		this.setLayout(null);
    	this.setBounds(0, 50, 1190, 637);
    	this.setVisible(false);
    	
    	DefaultTableModel model = new DefaultTableModel(); 
    	table = new JTable(model);
    	table.setBounds(88, 96, 953, 529);
    	add(table);
    	
    	JScrollPane scrollBar = new JScrollPane(table);
    	scrollBar.setVisible(true);
    	scrollBar.setBounds(51, 49, 1107, 529);
    	add(scrollBar);
    	
    	/**
		 * Ajout des colonnes
		 */
    	model.addColumn("Sélectionner"); 
    	model.addColumn("Tâche"); 
    	model.addColumn("Date dûe"); 
    	model.addColumn("Détails"); 
    	
    	/**
		 * Ajout des lignes pour remplir le tableau avec les taches de la base de données
		 */
    	model.addRow(new Object[]{"", "",""});
    	model.addRow(new Object[]{"", "",""});
    	model.addRow(new Object[]{"", "",""});
    	model.addRow(new Object[]{"", "",""});
    	model.addRow(new Object[]{"", "",""});
    	model.addRow(new Object[]{"", "",""});
    	model.addRow(new Object[]{"", "",""});
    	model.addRow(new Object[]{"", "",""});
    	model.addRow(new Object[]{"", "",""});
    	model.addRow(new Object[]{"", "",""});	


	}
}

