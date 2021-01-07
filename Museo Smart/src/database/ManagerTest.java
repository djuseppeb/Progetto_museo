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
	
	@Test
	public void getSortedArtListTest()
	{
		int checker = 0; 
		
		List<Opera> listA = Manager.getSortedArtList(1); //Ascending order (by title) art list
		
		for(Opera opera : listA)
		{
            if(opera.getID() == 6) //Checking if the first artpiece in the sorted list has ID 6 (Arrangiamento in grigio e nero, ritratto n. 1)
            {
            	checker++;
            }
            
            break; //No need to check anything else in the sorted list
        }
		
		List<Opera> listB = Manager.getSortedArtList(-1); //Descending order (by title) art list
		
		for(Opera opera : listB) 
		{
            if(opera.getID() == 2) //Checking if the first artpiece in the sorted list has ID 2 (Ultima Cena)
            {
            	checker++;
            }
            
            break; //No need to check anything else in the sorted list
        }
		
		assertEquals(2, checker);
	}
	@Test
	public void getNumOfVisitorsTest() {
		Integer n1 = 0;
		Integer	n2 = 0;
		List<Room> rooms = manager.getRoomList();
		for(int i = 0; i < rooms.size(); i++)	n1 = n1 + rooms.get(i).getPeople();
		n2 = manager.numOfPeople();
		assertNotNull(n1);
		assertEquals(n1, n2);
		}
}
