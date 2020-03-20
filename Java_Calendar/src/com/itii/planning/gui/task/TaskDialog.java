package com.itii.planning.gui.task;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.jdatepicker.JDatePicker;
import org.jdatepicker.UtilDateModel;

import com.itii.db.Connexion;

import javax.swing.JButton;

public class TaskDialog extends JDialog {
	
	private JTextField txtNomTache;
	private JTextField txtDetails;
	private JDatePicker calendar;
	private Connexion databaseConn;

	public TaskDialog() {
		databaseConn = new Connexion();
		databaseConn.connect();
    	this.setTitle("Nouvelle Tâche");
    	this.setBounds(600, 400, 450, 350);
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
		
		txtDetails = new JTextField();
		txtDetails.setBounds(94, 109, 318, 149);
		getContentPane().add(txtDetails);
		txtDetails.setColumns(10);
		
		getContentPane().add(getCalendar());
		
		JButton btnOk = new JButton("Ok");
		btnOk.setBounds(321, 269, 117, 25);
		getContentPane().add(btnOk);
		btnOk.setEnabled(false);
		
		JButton btnAnnuler = new JButton("Annuler");
		btnAnnuler.setBounds(180, 269, 117, 25);
		getContentPane().add(btnAnnuler);
		
		
		txtNomTache.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				btnOk.setEnabled(true);
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		txtDetails.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				btnOk.setEnabled(true);
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					databaseConn.addTask(databaseConn.getnomTache(), databaseConn.getdate(), databaseConn.getdetails(), "false");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
			}
		});
		
		
		
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
				calendar.setBounds(169, 69, 191, 41);
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
