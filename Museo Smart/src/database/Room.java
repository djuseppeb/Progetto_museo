package database;

public class Room implements Component {

	private int ID_room;
	private float temp;
	private boolean thermal;
	private int people;
	private float distance;
	private boolean dist_respect;
	private int lights;
	

	public Room(int ID_room, float temp, boolean thermal, int people, float distance, boolean dist_rtespect, int lights) {
		this.ID_room = ID_room;
		this.temp = temp;
		this.thermal = thermal;
		this.people = people;
		this.distance = distance;
		this.dist_respect = dist_rtespect;
		this.lights = lights;
	}
	
	@Override
	public int getID() {
		return this.ID_room;
	}
	public float getTemp() {
		return this.temp;
	}
	public boolean getTermal() {
		return this.thermal;
	}
	public int getPeople() {
		return this.people;
	}
	public float getDistance() {
		return this.distance;
	}
	public boolean isDistanceRespected() {
		return this.dist_respect;
	}
	public int getLights() {
		return this.lights;
	}
}
