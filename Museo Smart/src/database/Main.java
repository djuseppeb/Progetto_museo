package database;

public class Main {

	public static void main(String[] args) {
		Creator test = new OperaCreator();
		Opera art2 = (Opera) test.createComponent(1);
		System.out.println(art2.getTitle());
		
		
		Creator test2 = new RoomCreator();
		Room room2 = (Room) test2.createComponent(2);
		System.out.println(room2.getTemp());
		
		
		
	}

}
