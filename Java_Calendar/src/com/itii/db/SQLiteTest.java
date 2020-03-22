package com.itii.db; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * Classe de test pour la gestion de base de donnée
 * @author malik
 *
 */
public class SQLiteTest
{	
	/**
	 * @throws SQLException 
	 * 
	 */
	public static void main(String[] args) {
		Connexion connexion ;
		connexion = new Connexion();
		connexion.connect();
		connexion.deleteAll();
		
		try {
			connexion.addTask("Faire un footing pendant le confinement", "22-03-2020", "Remplir mon attestation", "false");
			connexion.addTask("Aller à la chicha", "28-03-2020", "Prendre une chicha Pomme-Raisin", "false");
			connexion.addTask("Jour de fin du confinement", "31-03-2020", "Me mettre khapta au bar", "false");
			connexion.addTask("Grattifier ma promotion préférée", "28-03-2020", "Donner l'argent à léa ", "false");
			connexion.addTask("Corriger en étant objectif", "22-03-2020", "Mettre 20/20 au groupe 4", "false");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		connexion.selectAll();
		

	}
	
}
