package com.itii.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 * <ul>Classe permettant de se connecter et de manipuler la base de donnée : 
 * <li>Ajouter une tâche</li>
 * <li>Modifier une tâche</li>
 * <li>Supprimer une tâche</li>
 * </ul>
 * @author Malik && Vincent
 *
 */
public class Connexion {
	private static final String TABLE_NAME = "Tasks";
	private static final String FIELD_ID = "id";
	private static final String FIELD_NAME = "name";
	private static final String FIELD_DATE = "date";
	private static final String FIELD_DETAILS = "details";
	private static final String FIELD_STATE = "state";
	private static final String FILE_NAME = "planning.db";
	private static final int FIELD_NUMBER = 5;
	private static final String URL = "jdbc:sqlite:database/"+FILE_NAME;
	private Connection connection = null;
	Statement statement = null;
	private String nomTache;
	private String details;
	private String dateDue;
	private int nbTask;

	/**
	 * 
	 */
	public Connexion() {

	}
	/**
	 * 
	 * @return
	 */
	public String getnomTache() {
		return this.nomTache;
	}
	/**
	 * 
	 * @return
	 */
	public String getdetails() {
		return this.details;
	}


	public int getNbTache() {
		return this.nbTask;

	}
	/**
	 * 
	 * @return
	 */
	public String getdate() {
		return this.dateDue;

	}
	/**
	 * 
	 * @param nomtache
	 */
	public void setnomTache(String nomtache) {
		this.nomTache = nomtache;
	}
	/**
	 * 
	 * @param detail
	 */
	public void setdetails(String detail) {
		this.details = detail;
	}
	/**
	 * 
	 * @param date
	 */
	public void setDate(String date) {
		this.dateDue = date;
	}
	/**
	 * 
	 */
	public void createDatabase() {

		String url = URL;

		try {  
			Connection conn = DriverManager.getConnection(url);  
			if (conn != null) {  
				DatabaseMetaData meta = conn.getMetaData();  
				System.out.println("The driver name is " + meta.getDriverName());  
				System.out.println("A new database has been created.");  
			}  

		} catch (SQLException e) {  
			System.out.println(e.getMessage());  
		}  
	}  


	/**
	 * 
	 * @return objet connection permettant de se connecter à la base
	 */

	public Connection connect() {
		// SQLite connection string

		//Connection conn = null;
		try {
			connection = DriverManager.getConnection(URL);
			//System.out.println("Connected to database");     
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return connection;


	}


	/**
	 * 
	 * @param taskName : nom de la tache à ajouter
	 * @param date : date due de la tache
	 * @param description : description détaillé de la tâche
	 * @param state : false si la tâche n'est pas achevé, vrai sinon.
	 * @throws SQLException
	 */
	public void addTask(String taskName, String date, String description,String state ) throws SQLException {

		connection = this.connect();
		PreparedStatement stmt = connection.prepareStatement(
				"INSERT INTO " + TABLE_NAME + " ( " + FIELD_NAME + ","
						+ FIELD_DATE + "," + FIELD_DETAILS + ","
						+ FIELD_STATE + " ) " + "VALUES ( ?, ?, ?, ?) ");
		stmt.setString(1, taskName);
		stmt.setString(2, date);
		stmt.setString(3, description);

		stmt.setString(4, state);
		stmt.executeUpdate();


	}

	/**
	 * 
	 * @throws SQLException exception jetée si il y a un problème de requête ou de connexion avec la base
	 */
	private void createTable() throws SQLException {

		String sql =
				"CREATE TABLE IF NOT EXISTS " + TABLE_NAME + " "+
						"(" + FIELD_ID + " INTEGER PRIMARY KEY AUTOINCREMENT , "
						+ FIELD_NAME + " STRING, "
						+ FIELD_DATE + " TEXT, "
						+ FIELD_DETAILS + " TEXT, "
						+ FIELD_STATE + " STRING " +")";

		if(statement != null)
		{
			statement.executeUpdate(sql);
		}
		else
		{
			throw new SQLException();
		}
	}

	/**
	 * Lecture de la table créée
	 */
	public void readDatabase() {

		try{

			ResultSet rs = statement.executeQuery("select * from " + TABLE_NAME);
			while (rs.next()){
				System.out.print("lecture d'une donnée [");
				System.out.print(" id = " + rs.getString(FIELD_ID));
				System.out.print(" ; name = " + rs.getString(FIELD_NAME));
				System.out.print(" ; date = " + rs.getString(FIELD_DATE));
				System.out.print(" ; details = " + rs.getString(FIELD_DETAILS));
				System.out.println( " ; etat = " + rs.getString(FIELD_STATE) + "]");
			}
		} 
		catch (SQLException e){
			System.out.println("erreur à la lecture de la table");
		} 
		finally{
			try{
				if(connection != null){
					connection.close();
					System.out.println("fermeture de la connection à la base de données");
				}

			} 
			catch (SQLException e){
				System.out.println("erreur lors de la fermeture de la connection");
			}
		}	
	}

	/**
	 *  Affiche toutes les tâche dans la console(méthode de debug)
	 */
	public void selectAll(){
		String sql = "SELECT id, name, date, details, state FROM Tasks";
		nbTask = 0;
		try (Connection conn = this.connect();
				Statement stmt  = conn.createStatement();
				ResultSet rs    = stmt.executeQuery(sql)){



			// loop through the result set
			while (rs.next()) {
				System.out.println(rs.getInt("id") +  "\t" + 
						rs.getString("name") + "\t" +
						rs.getString("date") + "\t" +
						rs.getString("details") + "\t" +
						rs.getString("state") 
						);
				nbTask++ ;
			}


		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * @param date
	 */
	public void selectDate(String date) {
		String sql = "SELECT * FROM Tasks WHERE date = ?" ;

		try {
			Connection conn = this.connect();
			PreparedStatement prdstmt = conn.prepareStatement(sql);
			prdstmt.setString(1,date);	

			ResultSet rs = prdstmt.executeQuery();


			while (rs.next() ) {

				System.out.println(rs.getInt(FIELD_ID) +  "\t" + 
						rs.getString(FIELD_NAME) + "\t" +
						rs.getString(FIELD_DATE) + "\t" +
						rs.getString(FIELD_DETAILS) + "\t" +
						rs.getString(FIELD_STATE) 
						);
			}



		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * 
	 * @param date
	 * @return
	 */
	public String[] selectTasks(String date) {
		String sql = "SELECT * FROM Tasks WHERE date = ?" ;
		String[] tasks = new  String[FIELD_NUMBER]; 
		nbTask =0;
		try {
			Connection conn = this.connect();
			PreparedStatement prdstmt = conn.prepareStatement(sql);
			prdstmt.setString(1,date);	
			ResultSet rs = prdstmt.executeQuery();

			while (rs.next() ) {
				tasks[0] = String.valueOf(rs.getInt(FIELD_ID)); 
				tasks[1] = String.valueOf(rs.getString(FIELD_NAME));
				tasks[2] =String.valueOf(rs.getString(FIELD_DATE));
				tasks[3] =String.valueOf(rs.getString(FIELD_DETAILS));
				tasks[4] =String.valueOf(rs.getString(FIELD_STATE)); 
				nbTask++;

			}

		}catch(SQLException e) {


		}

		return tasks;

	}
	public String[] selectTask(String date) {
		String sql = "SELECT * FROM Tasks WHERE date = ?" ;
		String[] tasks = new  String[10]; 
		nbTask =0;
		try {
			Connection conn = this.connect();
			PreparedStatement prdstmt = conn.prepareStatement(sql);
			prdstmt.setString(1,date);	
			ResultSet rs = prdstmt.executeQuery();

			while (rs.next() ) {

				tasks[nbTask] = String.valueOf(rs.getInt(FIELD_ID) + "\t"
						+ rs.getString(FIELD_NAME) + "\t"
						+ rs.getString(FIELD_DATE) + "\t" 
						+ rs.getString(FIELD_DETAILS) + "\t"
						+ rs.getString(FIELD_STATE));
				nbTask++;

			}

		}catch(SQLException e) {


		}

		return tasks;

	}


	/**
	 * 
	 * @param id
	 */
	public void delete(int id) {

		String sql = "DELETE FROM Tasks WHERE id = ?";

		try (Connection conn = this.connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// set the corresponding param
			pstmt.setInt(1, id);
			// execute the delete statement
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

/**
 * 
 * @param nom
 * @param date
 * @param details
 */
	public void deleteTask(String nom,String date, String details) {
		String sql = "DELETE FROM Tasks WHERE id = ? , name = ? , date = ? , details = ?";
		try (Connection conn = this.connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			// set the corresponding param
			pstmt.setString(1, nom);
			pstmt.setString(2,date);
			pstmt.setString(3, details);
			// execute the delete statement
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}



	}
	/**
	 * 
	 */
	public void deleteAll() {

		String sql = "DELETE FROM Tasks";

		try (Connection conn = this.connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {  
			// execute the delete statement
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}


	}
	/**
	 * 
	 * @return
	 */
	public String[] selectAllTasks() {
		String sql = "SELECT id, name, date, details, state FROM Tasks";
		nbTask = 0;
		String[] tasks = new String[10];
		try (Connection conn = this.connect();
				Statement stmt  = conn.createStatement();
				ResultSet rs    = stmt.executeQuery(sql)){



			// loop through the result set
			while (rs.next()) {
				tasks[nbTask] = String.valueOf(rs.getInt(FIELD_ID))+"\t"+
						rs.getString(FIELD_NAME)+"\t"+
						rs.getString(FIELD_DATE)+ "\t"+
						rs.getString(FIELD_DETAILS)+"\t"+
						rs.getString(FIELD_STATE);

				nbTask++ ;
			}


		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return tasks;
	}

/**
 * 
 * @param nom
 * @param date
 * @param details
 */
	public void updateTask(String nom,String date, String details) {
		String sql = "UPDATE Tasks SET state = 'true' WHERE name = ? , date = ? , details = ?";
		try (Connection conn = this.connect();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, nom);
			pstmt.setString(2,date);
			pstmt.setString(3, details);
			// execute the update statement
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}		
	}
}
