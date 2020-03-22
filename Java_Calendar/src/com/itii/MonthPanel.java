package com.itii;

import javax.swing.JPanel;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.JDatePanel;
import org.jdatepicker.UtilCalendarModel;

import com.itii.planning.gui.task.TaskDialog;

//import jdk.internal.jline.internal.ShutdownHooks.Task;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollBar;

/**
 * Correspond a la vue du calendrier par mois
 * @author Malik et Vincent
 *
 */
public class MonthPanel extends JDatePanel {


	private static final long serialVersionUID = 1L;

	//Calendar cal; 
	//Locale locale;
	/** Objet de type JDatePanel											*/
	JDatePanel jdp;
	/** Objet de type PopUpTask	qui permet d'appeler la fenêtre de tâche	*/
	PopUpTask popUpTask;
	/** Tableau d'objet String qui contient les differentes tâches			*/
	String[] Tasks;

	static UtilCalendarModel calendarModel = new UtilCalendarModel();


	/**
	 * Constructeur du MonthPanel qui est l'affichage par défaut de notre calendrier
	 */
	public MonthPanel() 
	{
		super(calendarModel);
		jdp = this;
		jdp.setVisible(false);

		this.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				popUpTask  = new PopUpTask();
				popUpTask.setFormatedRetrievedDate(jdp.getModel().getDay(),jdp.getModel().getMonth()+1, jdp.getModel().getYear());
				//popUpTask.getConnexion().selectDate(popUpTask.getRetrievedDate());
				Tasks = popUpTask.getConnexion().selectTask(popUpTask.getRetrievedDate());

				for( int i=0;i<popUpTask.getConnexion().getNbTache();i++) {
					StringBuilder sb = new StringBuilder(Tasks[i]);
					String[] splittedTasks = sb.toString().split("\t");
					
					if(popUpTask.getConnexion().getNbTache()>=1 && i==1)
					{
						popUpTask.getNomTache().setText(splittedTasks[1]);
						popUpTask.getDateTache().setText(splittedTasks[2]);
						popUpTask.getDetailTache().setText(splittedTasks[3]);
					}

					popUpTask.getBtnTasks()[i].setVisible(true);
					popUpTask.getBtnTasks()[i].addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent arg0) {
							popUpTask.getNomTache().setText(splittedTasks[1]);
							popUpTask.getDateTache().setText(splittedTasks[2]);
							popUpTask.getDetailTache().setText(splittedTasks[3]);
						}
					});
				}
			}
		});
	}
}
