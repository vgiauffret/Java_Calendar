package com.itii;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.JDatePanel;
import org.jdatepicker.UtilCalendarModel;

import com.itii.planning.gui.task.TaskDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

/**
 * Correspond a la vue du calendrier par mois
 * @author Malik && Vincent
 *
 */
public class MonthPanel extends JDatePanel {
	
	
	private static final long serialVersionUID = 1L;

	Calendar cal;
	Locale locale;
	JDatePanel jdp;
	PopUpTask popUpTask;
	
	static UtilCalendarModel calendarModel = new UtilCalendarModel();

	
	/**
	 * Constructeur du MonthPanel qui est l'affichage par défaut de notre calendrier
	 */
	public MonthPanel() 
	{
		super(calendarModel);
		jdp = this;
		jdp.setVisible(false);
		
		/**
		 * Action lier a l'appuie sur une date du calendrier
		 */
		this.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				popUpTask  = new PopUpTask();
				popUpTask.setFormatedRetrievedDate(jdp.getModel().getDay(),jdp.getModel().getMonth()+1, jdp.getModel().getYear());
				//System.out.println(popUpTask.getRetrievedDate());
				popUpTask.getConnexion().selectDate(popUpTask.getRetrievedDate());
				//update les labels correspondant
				
				
			}
		});
    	
	}
}
