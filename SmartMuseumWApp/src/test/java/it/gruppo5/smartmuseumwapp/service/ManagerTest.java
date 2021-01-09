package it.gruppo5.smartmuseumwapp.service;


import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import it.gruppo5.smartmuseumwapp.database.*;

public class ManagerTest {
	
	
	
	@Test
	public void getRoomStringTest(){
		Manager manager = new Manager();
		Creator getter = new RoomCreator();
		Room room = (Room) getter.createComponent(1);
		String roomInfo = manager.getRoomString(room);
		//fail();
		assertEquals(roomInfo, "Temperatura: 16.3\nStato Impianto termico: Acceso\nNumero Persone: 7\nDistanziamento sociale Rispettato\nStato luci: 6");
	}
	
	@Test
	public void getAvilableOperaListTest(){
		Manager manager = new Manager();
		ArrayList<Opera> listaOpere = new ArrayList<>();
		listaOpere = (ArrayList<Opera>) manager.getArtList();
		
		String operaList = manager.getAvilableOperaString(listaOpere, 1);
		assertEquals (operaList, "\n>Gioconda\n>David");
	}
	
	@Test
	public void getStringOperaTest(){
		Manager manager = new Manager();
		Creator getter = new OperaCreator();
		Opera opera = (Opera) getter.createComponent(2);
		String operaString = manager.getStringOpera(opera);
		assertEquals(operaString, "ID: 2 - Ultima Cena - Leonardo Da Vinci - In restauro");
	}
	
	@Test
	public void getSortedArtListTest()
	{
		Manager manager = new Manager();
		int checker = 0; 
		
		ArrayList<Opera> listA = new ArrayList<>();
		listA = (ArrayList<Opera>) manager.getSortedArtList(1);  //Ascending order (by title) art list
		
		for(Opera opera : listA)
		{
            if(opera.getID() == 6) //Checking if the first artpiece in the sorted list has ID 6 (Arrangiamento in grigio e nero, ritratto n. 1)
            {
            	checker++;
            }
            
            break; //No need to check anything else in the sorted list
        }
		
		ArrayList<Opera> listB = new ArrayList<>();
		listB = (ArrayList<Opera>) manager.getSortedArtList(-1); //Descending order (by title) art list
		
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
		Manager manager = new Manager();
		Integer n1 = 0;
		Integer	n2 = 0;
		List<Room> rooms = manager.getRoomList();
		for(int i = 0; i < rooms.size(); i++)	n1 = n1 + rooms.get(i).getPeople();
		n2 = manager.getNumOfVisitors();
		assertNotNull(n1);
		assertEquals(n1, n2);
		}
	
	@Test
	public void getIncomingOperaTest()
	{
		Manager manager = new Manager();
		ArrayList<Opera> listArt = new ArrayList<>();
		listArt = (ArrayList<Opera>) manager.getIncomingOpera();
		ArrayList<Integer> listID = new ArrayList<>();
		listID.add(6);
		listID.add(10);
		listID.add(14);
		int i = 0;
		for(Opera opera : listArt)
		{
			assertEquals((Integer)opera.getID(), listID.get(i) );
			i++;
		}
	}
	
	
}