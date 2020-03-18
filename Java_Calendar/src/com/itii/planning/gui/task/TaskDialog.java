package com.itii.planning.gui.task;


import java.util.Calendar;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.UtilDateModel;

public class TaskDialog extends JDialog {
	
	private JTextField txtNomTache;
	private JTextField txtDate;
	private JTextField txtDetails;
	private JDatePicker calendar;

	public TaskDialog() {
    	this.setTitle("Nouvelle Tâche");
		this.setSize(600, 600);
        this.setVisible(true);
		getContentPane().setLayout(null);

		
		JLabel lblTache = new JLabel("Nom de la tâche : ");
		lblTache.setBounds(12, 31, 150, 15);
		getContentPane().add(lblTache);
		
		JLabel lblDate = new JLabel("Date dûe :");
		lblDate.setBounds(12, 69, 150, 15);
		getContentPane().add(lblDate);
		
		JLabel lblDetails = new JLabel("Details :");
		lblDetails.setBounds(12, 124, 150, 15);
		getContentPane().add(lblDetails);
		
		txtNomTache = new JTextField();
		txtNomTache.setBounds(169, 29, 243, 19);
		getContentPane().add(txtNomTache);
		txtNomTache.setColumns(10);
		
		txtDate = new JTextField();
		txtDate.setBounds(169, 67, 114, 19);
		getContentPane().add(txtDate);
		txtDate.setColumns(10);
		
		txtDetails = new JTextField();
		txtDetails.setBounds(94, 109, 189, 149);
		getContentPane().add(txtDetails);
		txtDetails.setColumns(10);
		
		getContentPane().add(getCalendar());
		
	}
	
	// Accesseur mettant à jour la date affichée
	public  JDatePicker getCalendar()
	{
		if (calendar == null)
		{
				UtilDateModel model = new UtilDateModel();
				Calendar cal = Calendar.getInstance();
				model.setDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH),
				cal.get(Calendar.DAY_OF_WEEK));
				String datePattern = "dd-MM-yyyy";
				calendar = new JDatePicker(model, datePattern);
				calendar.setBounds(326, 69, 86, 41);
		}
		return calendar;
	}
	
	public void setDate(String date)
	{
		getCalendar().getFormattedTextField().setText(date);
	}
	// Accesseur récupérant la date actuellement affichée
	public String getDate()
	{
		return getCalendar().getFormattedTextField().getText();
	}
	
	
}
