package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.IOException;

public class OperaCreator implements Creator{
    Connection conn = DbAccess.getAccess().conn;	 //get Db istance
    Component opera = null;
	@Override
	public Component createComponent(int ID) {
		try {
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM art_piece where ID_art = " +  ID );
			
	        if(rs.next()) {								//if rs is not empty create opera
	        	opera = new Opera(rs.getInt("ID_art"), 
						rs.getString("Title"), 
						rs.getString("Artist"), 
						rs.getString("Availability"), 
						rs.getString("Type"), 
						rs.getInt("Room"), 
						rs.getString("Art_movement"), 
						rs.getString("Description"),
						rs.getInt("Position"),
						rs.getFloat("Value_Euro")); 
	        } else {
	        	opera = null;
	        }
		}
		catch (Exception e) {
			System.err.println("DB ERROR!");
		}
		
		return opera;
	}
	
	//Overload
	public Component createComponent(String title) {
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM art_piece where Title = " +  title );
			
	        if(rs.next()) {								//if rs is not empty create opera
	        	opera = new Opera(rs.getInt("ID_art"), 
						rs.getString("Title"), 
						rs.getString("Title"), 
						rs.getString("Artist"), 
						rs.getString("Type"), 
						rs.getInt("Room"), 
						rs.getString("Art_movement"), 
						rs.getString("Description"),
						rs.getInt("Position"),
						rs.getFloat("Value_Euro")); 
	        } else {
	        	opera = null;
	        }
		}
		catch (Exception e) {
			System.err.println("DB ERROR!");
		}
		
		return opera;
	}
}
