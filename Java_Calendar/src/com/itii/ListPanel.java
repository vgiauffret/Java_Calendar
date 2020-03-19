package com.itii;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

public class ListPanel extends JPanel {
	
	public 	JPanel ListPanel;
	private JTable table;
	private DefaultTableModel tableModel; 
	
	public ListPanel()
	{
		this.setLayout(null);
    	this.setBounds(0, 50, 1190, 637);
    	this.setVisible(false);
    	tableModel = new DefaultTableModel();
		String header[] = {"Nom de la tâche", "Date dûe", "Détails"};
		tableModel.setColumnIdentifiers(header);
    	table = new JTable(tableModel);
    	
    	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	table.setBounds(50, 20, 1100, 550);
    	this.add(table);
    	
    	JScrollBar scrollBar = new JScrollBar();
    	scrollBar.setBounds(30, 20, 17, 550);
    	add(scrollBar);
    	
    	JScrollBar scrollBar_1 = new JScrollBar();
    	scrollBar_1.setOrientation(JScrollBar.HORIZONTAL);
    	scrollBar_1.setBounds(50, 571, 1100, 17);
    	add(scrollBar_1);
    	
    	
	}
}

