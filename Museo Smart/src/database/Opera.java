package database;
/*
 * Class Opera use factory pattern and is a concrete product that contain data from art_piece table in db.
 * @author Albanese and Virruso
 * @version 1.1
 *
 */

public class Opera implements Component {
	
	private int ID_art;
	private String title;
	private String artist;
	private String status;
	private String type;
	private int room;
	private String movement;
	private String description;
	private int position;
	private float value;
	private String img;
	
	public Opera(int ID_art, String title, String artist, String status, String type, int room, String movement, String description, int position, float value, String img) {
		this.ID_art = ID_art;
		this.title = title;
		this.artist = artist;
		this.status = status;
		this.type = type;
		this.room = room;
		this.movement = movement;
		this.description = description;
		this.position = position;
		this.value = value;
		this.img = img;
	}
	
	//get methods to get private values
	@Override
	public int getID() {
		return this.ID_art;
	}
	
	public String getTitle() {
		return this.title;
	}
	public String getArtist() {
		return this.artist;
	}
	public String getStatus() {
		return this.status;
	}
	public String getType() {
		return this.type;
	}
	public int getRoom() {
		return this.room;
	}
	public String getMovement() {
		return this.movement;
	}
	public String getDescription() {
		return this.description;
	}
	public int getPosition() {
		return this.position;
	}
	public float getValue() {
		return this.value;
	}
	public String getImg() {
		return this.img;
	}
			
}
