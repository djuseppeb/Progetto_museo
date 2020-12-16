package database;

import java.util.ArrayList;
import java.util.List;

public class Manager {
	
	//Return ArrayList with Opera objects
	public static List<Opera> getArtList(){
		ArrayList<Opera> lista = new ArrayList<>();
		int i = 1;
		Creator getter = new OperaCreator();
		Opera opera = (Opera) getter.createComponent(i);
		while(opera != null){
			lista.add(opera);
			i++;
			opera = (Opera) getter.createComponent(i);
		}
		return lista;
	}
	
	//Return ArrayList with Room objects
	public static List<Room> getRoomList(){
		ArrayList<Room> lista = new ArrayList<>();
		int i = 1;
		Creator getter = new RoomCreator();
		Room room = (Room) getter.createComponent(i);
		while(room != null){
			lista.add(room);
			i++;
			room = (Room) getter.createComponent(i);
		}
		return lista;
	}

	//Return String with room info
	public static String getRoomString(Room room){
		String roomInfo = "";
		roomInfo = "Stanza "+ room.getID()+
				"\nTemperatura: "+room.getTemp()+
				"\nStato Impianto termico: "+room.getTermal()+
				"\nNumero Persone: "+room.getPeople()+
				"\nDistanziamento sociale "+room.getDistance()+
				"\nStato luci: "+room.getLights();
		
		return roomInfo;
	}

	//Return Art pieces aviailable in a room
	public static String getAvilableOpera(Opera art, int room){
		if((art.getStatus().equals("Disponibile"))&&(art.getRoom()==room)){
			return "\n"+art.getTitle();
		} else
			return "";
		
	}
}
