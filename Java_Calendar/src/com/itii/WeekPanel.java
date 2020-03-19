package com.itii;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class WeekPanel extends JPanel{
	private JTable table;
	
	
	public WeekPanel()
	{
		this.setLayout(null);
    	this.setBounds(0, 50, 1190, 637);
    	this.setVisible(false);

    	
    	DefaultTableModel model = new DefaultTableModel(); 
    	table = new JTable(model);
    	table.setBounds(88, 96, 953, 529);
    	add(table);
    	
    	JLabel lblSemained = new JLabel("Semaine %d");
    	lblSemained.setBounds(206, 12, 112, 25);
    	add(lblSemained);
    	
    	JButton btnSemained = new JButton("Semaine %d");
    	btnSemained.setBounds(51, 12, 130, 25);
    	add(btnSemained);
    	
    	JButton button = new JButton("Semaine %d");
    	button.setBounds(324, 12, 130, 25);
    	add(button);
    	
    	JScrollPane scrollBar = new JScrollPane(table);
    	scrollBar.setVisible(true);
    	scrollBar.setBounds(51, 49, 1107, 529);
    	add(scrollBar);

    	model.addColumn("Heure"); 
    	model.addColumn("Lundi"); 
    	model.addColumn("Mardi"); 
    	model.addColumn("Mercredi"); 
    	model.addColumn("Jeudi"); 
    	model.addColumn("Vendredi"); 
    	model.addColumn("Samedi"); 
    	model.addColumn("Dimanche"); 

    	model.addRow(new Object[]{"6:00","", "","","","","",""});
    	model.addRow(new Object[]{"6:30","", "","","","","",""});
    	model.addRow(new Object[]{"7:00","", "","","","","",""});
    	model.addRow(new Object[]{"7:30","", "","","","","",""});
    	model.addRow(new Object[]{"8:00","", "","","","","",""});
    	model.addRow(new Object[]{"8:30","", "","","","","",""});
    	model.addRow(new Object[]{"9:00","", "","","","","",""});
    	model.addRow(new Object[]{"9:30","", "","","","","",""});
    	model.addRow(new Object[]{"10:00","", "","","","","",""});
    	model.addRow(new Object[]{"10:30","", "","","","","",""});
    	model.addRow(new Object[]{"11:00","", "","","","","",""});
    	model.addRow(new Object[]{"11:30","", "","","","","",""});
    	model.addRow(new Object[]{"12:00","", "","","","","",""});
    	model.addRow(new Object[]{"12:30","", "","","","","",""});
    	model.addRow(new Object[]{"13:00","", "","","","","",""});
    	model.addRow(new Object[]{"13:30","", "","","","","",""});
    	model.addRow(new Object[]{"14:00","", "","","","","",""});
    	model.addRow(new Object[]{"14:30","", "","","","","",""});
    	model.addRow(new Object[]{"15:00","", "","","","","",""});
    	model.addRow(new Object[]{"15:30","", "","","","","",""});
    	model.addRow(new Object[]{"16:00","", "","","","","",""});
    	model.addRow(new Object[]{"16:30","", "","","","","",""});
    	model.addRow(new Object[]{"17:00","", "","","","","",""});
    	model.addRow(new Object[]{"17:30","", "","","","","",""});
    	model.addRow(new Object[]{"18:00","", "","","","","",""});
    	model.addRow(new Object[]{"18:30","", "","","","","",""});
    	model.addRow(new Object[]{"19:00","", "","","","","",""});
    	model.addRow(new Object[]{"19:30","", "","","","","",""});
    	model.addRow(new Object[]{"20:00","", "","","","","",""});
    	model.addRow(new Object[]{"20:30","", "","","","","",""});
    	model.addRow(new Object[]{"21:00","", "","","","","",""});
    	model.addRow(new Object[]{"21:30","", "","","","","",""});
    	model.addRow(new Object[]{"22:00","", "","","","","",""});
    	model.addRow(new Object[]{"22:30","", "","","","","",""});
    	model.addRow(new Object[]{"23:00","", "","","","","",""});
    	model.addRow(new Object[]{"23:30","", "","","","","",""});
    	
	}
}
