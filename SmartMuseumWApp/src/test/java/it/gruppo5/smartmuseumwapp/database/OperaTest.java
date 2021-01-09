package it.gruppo5.smartmuseumwapp.database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperaTest {

	Opera opera = new Opera(1, "Titolo", "Artista", "Stato", "Tipo", 2, "Movimento", "Descrizione", 3, 999.99f, "www.urlprova.it");
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetID() {
		assertEquals(opera.getID(), 1);
	}
	
	@Test
	void testGetTitle() {
		assertEquals(opera.getTitle(), "Titolo");
	}
	
	@Test
	void testGetArtist() {
		assertEquals(opera.getArtist(), "Artista");
	}
	
	@Test
	void testGetStatus() {
		assertEquals(opera.getStatus(), "Stato");
	}
	
	@Test
	void testGetType() {
		assertEquals(opera.getType(), "Tipo");
	}
	
	@Test
	void testGetRoom() {
		assertEquals(opera.getRoom(), 2);
	}
	
	@Test
	void testGetMovement() {
		assertEquals(opera.getMovement(), "Movimento");
	}
	
	@Test
	void testGetDescription() {
		assertEquals(opera.getDescription(), "Descrizione");
	}
	
	@Test
	void testGetPosition() {
		assertEquals(opera.getPosition(), 3);
	}
	
	@Test
	void testGetValue() {
		assertEquals(opera.getValue(), 999.99f);
	}
	@Test
	void testGetImg() {
		assertEquals(opera.getImg(), "www.urlprova.it");
	}
}