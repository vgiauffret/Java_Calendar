package com.itii;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.JDatePanel;
import org.jdatepicker.UtilCalendarModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollBar;


public class MonthPanel extends JDatePanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	Calendar cal;
	Locale locale;
	JDatePanel jdp;
	
	static UtilCalendarModel calendarModel = new UtilCalendarModel();

	

	public MonthPanel() 
	{
		super(calendarModel);
		jdp = this;
		jdp.setVisible(false);
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(""+ jdp.getModel().getDay());
			}
		});
		
		
		/*
		this.setLayout(null);
    	this.setBounds(0, 50, 1190, 637);
    	this.setVisible(false);
    	
    	
    	JButton btnNewButton = new JButton("1");
    	btnNewButton.setBounds(247, 47, 100, 100);
    	this.add(btnNewButton);
    	
    	JButton button = new JButton("2");
    	button.setBounds(359, 47, 100, 100);
    	this.add(button);
    	
    	JButton button_1 = new JButton("3");
    	button_1.setBounds(471, 47, 100, 100);
    	this.add(button_1);
    	
    	JButton button_2 = new JButton("4");
    	button_2.setBounds(583, 47, 100, 100);
    	this.add(button_2);
    	
    	JButton button_3 = new JButton("5");
    	button_3.setBounds(695, 47, 100, 100);
    	this.add(button_3);
    	
    	JButton button_4 = new JButton("6");
    	button_4.setBounds(807, 47, 100, 100);
    	this.add(button_4);
    	
    	JButton button_5 = new JButton("7");
    	button_5.setBounds(923, 47, 100, 100);
    	this.add(button_5);
    	
    	JButton button_6 = new JButton("8");
    	button_6.setBounds(247, 159, 100, 100);
    	this.add(button_6);
    	
    	JButton button_7 = new JButton("9");
    	button_7.setBounds(359, 159, 100, 100);
    	this.add(button_7);
    	
    	JButton button_8 = new JButton("10");
    	button_8.setBounds(471, 159, 100, 100);
    	this.add(button_8);
    	
    	JButton button_9 = new JButton("11");
    	button_9.setBounds(583, 159, 100, 100);
    	this.add(button_9);
    	
    	JButton button_10 = new JButton("12");
    	button_10.setBounds(695, 159, 100, 100);
    	this.add(button_10);
    	
    	JButton button_11 = new JButton("13");
    	button_11.setBounds(807, 159, 100, 100);
    	this.add(button_11);
    	
    	JButton button_12 = new JButton("14");
    	button_12.setBounds(923, 159, 100, 100);
    	this.add(button_12);
    	
    	JButton button_13 = new JButton("15");
    	button_13.setBounds(247, 271, 100, 100);
    	this.add(button_13);
    	
    	JButton button_14 = new JButton("16");
    	button_14.setBounds(359, 271, 100, 100);
    	this.add(button_14);
    	
    	JButton button_15 = new JButton("17");
    	button_15.setBounds(471, 271, 100, 100);
    	this.add(button_15);
    	
    	JButton button_16 = new JButton("18");
    	button_16.setBounds(583, 271, 100, 100);
    	this.add(button_16);
    	
    	JButton button_17 = new JButton("19");
    	button_17.setBounds(695, 271, 100, 100);
    	this.add(button_17);
    	
    	JButton button_18 = new JButton("20");
    	button_18.setBounds(807, 271, 100, 100);
    	this.add(button_18);
    	
    	JButton button_19 = new JButton("21");
    	button_19.setBounds(923, 271, 100, 100);
    	this.add(button_19);
    	
    	JButton button_20 = new JButton("22");
    	button_20.setBounds(247, 383, 100, 100);
    	this.add(button_20);
    	
    	JButton button_21 = new JButton("23");
    	button_21.setBounds(359, 383, 100, 100);
    	this.add(button_21);
    	
    	JButton button_22 = new JButton("24");
    	button_22.setBounds(471, 383, 100, 100);
    	this.add(button_22);
    	
    	JButton button_23 = new JButton("25");
    	button_23.setBounds(583, 383, 100, 100);
    	this.add(button_23);
    	
    	JButton button_24 = new JButton("26");
    	button_24.setBounds(695, 383, 100, 100);
    	this.add(button_24);
    	
    	JButton button_25 = new JButton("27");
    	button_25.setBounds(807, 383, 100, 100);
    	this.add(button_25);
    	
    	JButton button_26 = new JButton("28");
    	button_26.setBounds(923, 383, 100, 100);
    	this.add(button_26);
    	
    	JButton button_27 = new JButton("29");
    	button_27.setBounds(247, 495, 100, 100);
    	this.add(button_27);
    	
    	JButton button_28 = new JButton("30");
    	button_28.setBounds(359, 495, 100, 100);
    	this.add(button_28);
    	
    	JButton button_29 = new JButton("31");
    	button_29.setBounds(471, 495, 100, 100);
    	this.add(button_29);
    	
    	JLabel lblMois = new JLabel("%Mois");
    	lblMois.setBounds(247, 12, 70, 15);
    	add(lblMois);
    	*/
  
    	
	}
}
