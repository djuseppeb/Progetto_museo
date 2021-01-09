package it.gruppo5.smartmuseumwapp.database;
/*
 * Class OperaCreator use factory pattern and is a concrete product creator that allows to create Opera Object, add news piece of art in db and update existing piece of art
 * @author Albanese and Virruso
 * @version 1.7
 *
 */

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.io.IOException;

public class OperaCreator implements Creator{
    Connection conn = DbAccess.getAccess().conn;	 //get Db istance
    
	@Override
	public Component createComponent(int ID) { //search Opera using ID
	    Component opera = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM art_piece where ID_art = " +  ID);
			
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
						rs.getFloat("Value_Euro"),
						rs.getString("Img_URL"));
	        }
		}
		catch (Exception e) {
			System.err.println("DB ERROR!");
			System.err.println(e.getMessage());
		}
		
		return opera;
	}
	
	//Overload
	public Component createComponent(String title) {	//search Opera using Title
	    Component opera = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM art_piece where Title = '" +  title + "'");
			
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
						rs.getFloat("Value_Euro"),
	        			rs.getString("Img_URL"));
	        }
		}
		catch (Exception e) {
			System.err.println("DB ERROR!");
			System.err.println(e.getMessage());
		}
		
		return opera;
	}
	
	public boolean addComponent(String title, String artist, String status, String type, int room, String movement, String description, int position, float value) {	//function to add opera into DB
		int id_art = this.idGenerator(); //generate ID automatically
	    Connection conn = DbAccess.getAccess().conn;	 //get Db istance

		try {
			Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO art_piece" + " VALUES ( " + id_art + ", '"
            													+ title + "', '" 
            													+ artist + "', '" 
            													+ status + "', '" 
            													+ type + "', " 
            													+ room + ", '" 
            													+ movement + "', '" 
            													+ description + "', " 
            													+ position + ", " 
            													+ value + ")" );
            return true;
            
		}
		catch (Exception e) {
			System.err.println("DB ERROR!");
			System.err.println(e.getMessage());
			return false;
		}
		
	}
	
	int idGenerator() { //generate id to add Opera
		int count = 0;
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT ID_art FROM art_piece");
				
		        while(rs.next()) {		//count next id
		        	count = rs.getInt("ID_art");
		        }
			}
			catch (Exception e) {
				System.err.println("DB ERROR!");
				System.err.println(e.getMessage());
			}
			
			return count + 1;
		
		
	}
	
	
	//**functions to modify Opera fields in DB**
	
	public boolean updateTitle(int ID, String title) {	//function to modify Title
	    Connection conn = DbAccess.getAccess().conn;	 //get Db istance
	    try {
			Statement stmt = conn.createStatement();
            if(stmt.executeUpdate("update art_piece set Title = '" + title + "' where ID_art = " + ID) == 1)
            	return true;
            else
            	return false;
		}
		catch (Exception e) {
			System.err.println("DB ERROR!");
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	public boolean updateArtist(int ID, String artist) { //method to modify Artist
	    Connection conn = DbAccess.getAccess().conn;	 //get Db istance
	    try {
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate("update art_piece set Artist = '" + artist + "' where ID_art = " + ID) == 1)
            	return true;
            else
            	return false;
		}
		catch (Exception e) {
			System.err.println("DB ERROR!");
			System.err.println(e.getMessage());
			return false;
		}
		
	}
	
	public boolean updateDescription(int ID, String descr) { //method to modify Description
	    String formattedDescr = "";
	    for (int i=0; i<descr.length(); i++) {
	    	char c = descr.charAt(i);
	    	if (c == '\'')
	    		formattedDescr+="\\";
	    	formattedDescr+=c;
	    }
	    
	    Connection conn = DbAccess.getAccess().conn;	 //get Db istance
	    try {
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate("update art_piece set Description = '" + formattedDescr + "' where ID_art = " + ID) == 1)
            	return true;
            else
            	return false;
		}
		catch (Exception e) {
			System.err.println("DB ERROR!");
			System.err.println(e.getMessage());
			return false;
		}
		
	}
	
	public boolean updateStatus(int ID, String status) { //method to modify Status
	    Connection conn = DbAccess.getAccess().conn;	 //get Db istance
	    status = status.trim();
	    try {
			Statement stmt = conn.createStatement();
			if(status.equals("Disponibile") || status.equals("In restauro") || status.equals("Venduto")) {
            	stmt.executeUpdate("update art_piece set Availability='" + status + "' where ID_art=" + ID);
            	return true;
			}
			else {
				System.err.println("Status not valid");
				return false;
			}
            
		}
		catch (Exception e) {
			System.err.println("DB ERROR!");
			System.err.println(e.getMessage());
			return false;
		}
		
	}
	
	public boolean updateType(int ID, String type) { //method to modify Type
	    Connection conn = DbAccess.getAccess().conn;	 //get Db istance
	    type = type.trim();
	    try {
			Statement stmt = conn.createStatement();
			if(type.equals("Quadro") || type.equals("Scultura") || type.equals("Mosaico") || type.equals("Manufatto") ) {
	            stmt.executeUpdate("update art_piece set Type='" + type + "' where ID_art=" + ID);
	            return true;
			}
			else {
				System.err.println("Type not valid");
				return false;
			}
            
		}
		catch (Exception e) {
			System.err.println("DB ERROR!");
			System.err.println(e.getMessage());
			return false;
		}
		
	}
	
	public boolean updateRoom(int ID, int room) { //method to modify room
	    Connection conn = DbAccess.getAccess().conn;	 //get Db istance
	    RoomCreator checkroom = new RoomCreator();	//verify if room exist
	    boolean check = checkroom.getRoomExists(room);
	    
	    try {
	    	if(check == false)	return false;
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate("update art_piece set Room = " + room + " where ID_art = " + ID) == 1)
            	return true;
            else
            	return false;
		}
		catch (Exception e) {
			System.err.println("DB ERROR!");
			System.err.println(e.getMessage());
			return false;
		}
	}
	
	public boolean updateMovement(int ID, String mov) { //method to modify art movement
	    Connection conn = DbAccess.getAccess().conn;	 //get Db istance
	    mov = mov.trim();
	    try {
			Statement stmt = conn.createStatement();
			if(mov.equals("Astrattismo") || mov.equals("Cubismo") || mov.equals("Espressionismo") || mov.equals("Futurismo") || mov.equals("Realismo") || mov.equals("Arte rinascimentale") ) {
	            stmt.executeUpdate("update art_piece set Art_movement='" + mov + "' where ID_art=" + ID);
	            return true;
			}
			else {
				System.err.println("Art movement not present");
				return false;
			}
            
		}
		catch (Exception e) {
			System.err.println("DB ERROR!");
			System.err.println(e.getMessage());
			return false;
		}
		
	}
	
	public boolean updatePosition(int ID, int pos) { //method to modify Position
	    Connection conn = DbAccess.getAccess().conn;	 //get Db istance
	    try {
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate("update art_piece set Position = " + pos + " where ID_art = " + ID) == 1)
            	return true;
            else
            	return false;
		}
		catch (Exception e) {
			System.err.println("DB ERROR!");
			System.err.println(e.getMessage());
			return false;
		}
	 
	}
	
	public boolean updateValue(int ID, float val) { //method to modify Description
	    Connection conn = DbAccess.getAccess().conn;	 //get Db istance
	    try {
			Statement stmt = conn.createStatement();
			if(stmt.executeUpdate("update art_piece set Value_Euro = " + val + " where ID_art = " + ID) == 1)
            	return true;
            else
            	return false;
		}
		catch (Exception e) {
			System.err.println("DB ERROR!");
			System.err.println(e.getMessage());
			return false;
		}
	 
	}
}