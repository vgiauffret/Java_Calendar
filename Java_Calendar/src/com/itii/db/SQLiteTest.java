package com.itii.db; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteTest
{	
	/**
	 * 
	 */
	public static void main(String[] args) {
		String[] a =  new String[5];
		
		Connexion connexion ;
		connexion = new Connexion();
		connexion.connect();
		connexion.deleteAll();
		try {
			connexion.addTask("test", "10-03-2020", "ceci est une tache de test", "false");
			connexion.addTask("test2", "10-03-2020", "ceci est une deuxieme  tache de test", "false");
			connexion.addTask("Tache3", "20-03-2020", "encore un petit test ", "false");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		//System.out.println(connexion.selectTask("10-03-2020")[0]);
		//connexion.selectAll();
		//a = connexion.selectTask("10-03-2020");
		//System.out.println(a[0] + "\t" +a[1] + "\t" + a[2] + "\t" + a[3] + "\t" + a[4] + "\t" );
		
		
		
	}
}
