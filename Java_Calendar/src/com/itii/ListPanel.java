package com.itii;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import com.itii.db.Connexion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
/**
 * Correspond a la vue sous forme de liste des taches
 * @author Malik et Vincent
 *
 */
public class ListPanel extends JPanel {
	private JTable table;
	private DefaultTableModel model; 
	private Connexion connexion;
	private String[] Tasks;
	private PanelButton panelButton;
	/**
	 * Affecte l'objet panelButton
	 * @param panelbutton
	 */

	public void setPanelButton(PanelButton panelbutton) {
		this.panelButton = panelbutton;

	}

	/**
	 *  Récupère l'objet panelButton
	 * @return  Objet de type PanelButton
	 */
	public PanelButton getPanelButton() {
		return panelButton;

	}


	/**
	 * Constructeur de l'objet ListPanel
	 */
	public ListPanel()
	{
		connexion = new Connexion();
		connexion.connect();
		this.setLayout(null);
		this.setBounds(0, 50, 1190, 637);
		this.setVisible(false);


		model = new DefaultTableModel() {

			private static final long serialVersionUID = 1L;

			public Class getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				default:
					return String.class;
				}
			}};
			table = new JTable(model);
			table.setEnabled(true);
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
			Tasks = connexion.selectAllTasks();

			for( int i=0;i<connexion.getNbTache();i++) {
				StringBuilder sb = new StringBuilder(Tasks[i]);
				String[] splittedTasks = sb.toString().split("\t");
				model.addRow(new Object[]{false,splittedTasks[1], splittedTasks[2],splittedTasks[3]});
			}
			/*this.setPanelButton(panelButton = new PanelButton());
			panelButton.getSupprimerBtn().addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					checkComboBox();

				}
			});*/
	}
	/**
	 * Méthode vérifiant quelles tâche sont coché sur notre fenêtre
	 */
	public void checkComboBox() {

		System.out.println("checkComboBox");
		Boolean a = true;
		for( int i=0;i<connexion.getNbTache();i++) {
			if(table.getValueAt(i, 0) == a) {
				System.out.println("case selectionnée");
			}
		}
	} 


}

