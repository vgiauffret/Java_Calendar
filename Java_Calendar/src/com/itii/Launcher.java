package com.itii;
import java.sql.SQLException;

import javax.swing.*;
import com.itii.db.*;

/**
 * Classe de lancement du Calendrier (point de départ de l'application)
 * @author Malik et Vincent
 *
 */

public class Launcher {

	public static void main(String[] args) throws SQLException {

		MainWindow.getInstance(); 	 

	}
}
