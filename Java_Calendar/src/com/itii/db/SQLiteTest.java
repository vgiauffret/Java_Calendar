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
			connexion.addTask("Projet JAVA", "21-02-2020", "rendre le projet avant 17h", "false");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		connexion.selectAll();
		//a = connexion.selectTask("10-03-2020");
		//System.out.println(a[0] + "\t" +a[1] + "\t" + a[2] + "\t" + a[3] + "\t" + a[4] + "\t" );
		
		
		
	}
}
