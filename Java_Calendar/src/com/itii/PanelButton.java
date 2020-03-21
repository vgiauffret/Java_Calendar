package com.itii;

import javax.swing.*;

import com.itii.planning.gui.task.TaskDialog;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
/**
 * 
 * @author malik
 *
 */
public class PanelButton extends JPanel {

	JLabel lblDateDuJour;
	private JButton btnCreer,btnEditer,btnDupliquer,btnMarquer,btnSupprimer;
	public JButton getCreerBtn()
	{
		return btnCreer;
	}
	public JButton getEditerBtn()
	{
		return btnEditer;
	}
	public JButton getDupliquerBtn()
	{
		return btnDupliquer;
	}
	public JButton getMarquerBtn()
	{
		return btnMarquer;
	}
	public JButton getSupprimerBtn()
	{
		return btnSupprimer;
	}

	/**
	 * 
	 */
	PanelButton(){
		setLayout(null);

		JPanel panel_button = new JPanel();
		panel_button.setBackground(Color.DARK_GRAY);
		panel_button.setBounds(0, 0, 200, 700);
		add(panel_button);
		panel_button.setLayout(null);

		btnCreer = new JButton("Creer");
		btnCreer.setBounds(12, 70, 176, 35);
		panel_button.add(btnCreer);

		btnEditer = new JButton("Editer");
		btnEditer.setBounds(12, 140, 176, 35);
		panel_button.add(btnEditer);

		btnDupliquer = new JButton("Dupliquer");
		btnDupliquer.setBounds(12, 280, 176, 35);
		panel_button.add(btnDupliquer);

		btnMarquer = new JButton("Marquer");
		btnMarquer.setBounds(12, 210, 176, 35);
		panel_button.add(btnMarquer);

		btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(12, 350, 176, 35);
		panel_button.add(btnSupprimer);

		lblDateDuJour = new JLabel();
		lblDateDuJour.setText(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		lblDateDuJour.setForeground(Color.WHITE);
		lblDateDuJour.setBounds(20, 562, 176, 35);
		panel_button.add(lblDateDuJour);


		this.getCreerBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				new TaskDialog();
			}
		});

		this.getEditerBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		this.getDupliquerBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		this.getMarquerBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});

		this.getSupprimerBtn().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

			}
		});


	}
}





