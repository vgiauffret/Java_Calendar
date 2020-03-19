package com.itii;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

public class ListPanel extends JPanel {
	
	public JPanel ListPanel;
	private JTable table;
	private DefaultTableModel tableModel; 
	
	public ListPanel()
	{
		this.setLayout(null);
		 //super();
    	this.setBounds(0, 0, 800, 450);
    	this.setSize(500, 500);
    	this.setVisible(false);
    	tableModel = new DefaultTableModel();
		String header[] = {"Nom de la tâche", "Date dûe", "Détails"};
		tableModel.setColumnIdentifiers(header);
    	table = new JTable(tableModel);
    	
    	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	table.setBounds(73, 88, 596, 335);
    	this.add(table);
    	
    	JLabel lblListPannel = new JLabel("List Pannel");
    	lblListPannel.setBounds(320, 61, 156, 15);
    	this.add(lblListPannel);
	}
}

