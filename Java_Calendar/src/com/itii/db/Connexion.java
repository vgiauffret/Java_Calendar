package com.itii.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Connexion {
	private static final String TABLE_NAME = "Tasks";
	private static final String FIELD_ID = "id";
	private static final String FIELD_NAME = "name";
	private static final String FIELD_DATE = "date";
	private static final String FIELD_DETAILS = "details";
	private static final String FIELD_STATE = "state";
	private static final String FILE_NAME = "planning.db";
	private static final String URL = "jdbc:sqlite:database/planning.db";
    private Connection connection = null;
	Statement statement = null;
	private String nomTache;
	private String details;
	
	
	public Connexion() {
		//this.createTable();
	}
	
	public String getnomTache() {
		return this.nomTache;
	}
	
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
		System.out.println("insertion d'une nouvelle entrée dans la table");
		
		
	}
		
		
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
	
	public void selectAll(){
        String sql = "SELECT id, name, date, details, state FROM Tasks";
        
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
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	
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
	
	

}
