package database;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class ManagerTest {
	
	@Test
	public void getRoomStringTest(){
		Creator getter = new RoomCreator();
		Room room = (Room) getter.createComponent(1);
		String roomInfo = Manager.getRoomString(room);
		//fail();
		assertEquals(roomInfo, "Temperatura: 16.3\nStato Impianto termico: Acceso\nNumero Persone: 7\nDistanziamento sociale Rispettato\nStato luci: 6");
	}
	
	@Test
	public void getAvilableOperaListTest(){
		ArrayList<Opera> listaOpere = new ArrayList<>();
		listaOpere = (ArrayList<Opera>) Manager.getArtList();
		
		String operaList = Manager.getAvilableOperaString(listaOpere, 1);
		assertEquals (operaList, "\n>Gioconda\n>David");
	}
	
	@Test
	public void getStringOperaTest(){
		Creator getter = new OperaCreator();
		Opera opera = (Opera) getter.createComponent(2);
		String operaString = Manager.getStringOpera(opera);
		assertEquals(operaString, "ID: 2 - Ultima Cena - Leonardo Da Vinci - In restauro");
	}
}
