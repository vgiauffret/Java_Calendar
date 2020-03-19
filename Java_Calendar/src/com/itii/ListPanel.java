package com.itii;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ListPanel extends JPanel {
	private JTable table;
	private DefaultTableModel tableModel; 
	
	public ListPanel()
	{
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
    	
    	model.addColumn("Tâche"); 
    	model.addColumn("Date dûe"); 
    	model.addColumn("Détails"); 
    	
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

