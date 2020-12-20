package database;
/*
 * Class RoomCreator use factory pattern and is a concrete product creator that allows to create Room Object
 * @author Albanese and Virruso
 * @version 1.1
 *
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class RoomCreator implements Creator{
    Connection conn = DbAccess.getAccess().conn; //get Db istance
 
    
	@Override
	public Component createComponent(int ID) {	//search room using ID
		   Component room = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM room where ID_room = " +  ID );
	        if(rs.next()) {						//if rs is not empty create room
	        	room = new Room(rs.getInt("ID_room"), 
	        			rs.getFloat("Temperature"), 
	        			rs.getBoolean("Status_thermal_system"), 
	        			rs.getInt("N_people"), 
	        			rs.getFloat("Average_distance"), 
	        			rs.getBoolean("Social_distancing"), 
	        			rs.getInt("lights_intensity"));
	        }
		}
		catch (Exception e) {
			System.err.println("DB ERROR!");
			System.err.println(e.getMessage());
		}
		
		return room;
	}
	
	public boolean getRoomExists(int room) { //verify if room exist
		boolean check = false;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT ID_room FROM room");
			
	        while(rs.next()) {		//control next id
	        	if(room == rs.getInt("ID_room")) check = true;
	        }
		}
		catch (Exception e) {
			System.err.println("DB ERROR!");
			System.err.println(e.getMessage());
		}
		return check;
	}
}
	