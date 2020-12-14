package database;

import java.util.ArrayList;
import java.util.List;

public class Manager {
	
	//Questo metodo restituisce una lista di oggetti di tipo Opera
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
	
	//Questo metodo restituisce una lista di oggetti di tipo Stanza
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
}
