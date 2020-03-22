package com.itii;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.itii.db.Connexion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private String[] Tasks;

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
		 model.addColumn("Tâche"); 
		 model.addColumn("Date dûe"); 
		 model.addColumn("Détails"); 
		 Tasks = connexion.selectAllTasks();

		 for( int i=0;i<connexion.getNbTache();i++) {
			StringBuilder sb = new StringBuilder(Tasks[i]);
			 String[] splittedTasks = sb.toString().split("\t");
			 model.addRow(new Object[]{splittedTasks[1], splittedTasks[2],splittedTasks[3]});

		 }


	}
}

