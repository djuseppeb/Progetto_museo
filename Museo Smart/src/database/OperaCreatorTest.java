package database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OperaCreatorTest {

	Opera operaA = new Opera(16, "Titolo", "Artista", "Disponibile", "Quadro", 2, "Cubismo", "Descrizione", 3, 999.99f);
	//Opera operaB = new Opera(16, "Titolo", "Artista", "Venduto", "Quadro", 2, "Cubismo", "Descrizione", 3, 999.99f);
	Opera operaC = new Opera(17, "Titolo", "Artista", "Stato sbagliato", "Quadro", 2, "Cubismo", "Descrizione", 3, 999.99f);
	Opera operaD = new Opera(18, "Titolo", "Artista", "In restauro", "Tipo sbagliato", 2, "Realismo", "Descrizione", 3, 999.99f);
	Opera operaE = new Opera(19, "Titolo", "Artista", "Disponibile", "Quadro", 2, "Movimento sbagliato", "Descrizione", 3, 999.99f);
	OperaCreator operaCreator = new OperaCreator();
	int newId = 16;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreateComponentID() {
		Creator test = new OperaCreator();
		Component compA = test.createComponent(1);
		assertNotNull(compA);
		Component compB = test.createComponent(99);
		assertNull(compB);
	}
	
	@Test
	void testCreateComponentTitle() {
		Component compA = operaCreator.createComponent("Il pensatore");
		assertNotNull(compA);
		Component compB = operaCreator.createComponent("Titolo sbagliato");
		assertNull(compB);
	}

	@Test
	void testAddComponent() {
		assertTrue(operaCreator.addComponent(operaA.getTitle(), operaA.getArtist(), operaA.getStatus(), operaA.getType(), operaA.getRoom(), operaA.getMovement(), operaA.getDescription(), operaA.getPosition(), operaA.getValue()));
		//assertFalse(operaCreator.addComponent(operaB.getTitle(), operaB.getArtist(), operaB.getStatus(), operaB.getType(), operaB.getRoom(), operaB.getMovement(), operaB.getDescription(), operaB.getPosition(), operaB.getValue()));
		assertFalse(operaCreator.addComponent(operaC.getTitle(), operaC.getArtist(), operaC.getStatus(), operaC.getType(), operaC.getRoom(), operaC.getMovement(), operaC.getDescription(), operaC.getPosition(), operaC.getValue()));
		assertFalse(operaCreator.addComponent(operaD.getTitle(), operaD.getArtist(), operaD.getStatus(), operaD.getType(), operaD.getRoom(), operaD.getMovement(), operaD.getDescription(), operaD.getPosition(), operaD.getValue()));
		assertFalse(operaCreator.addComponent(operaE.getTitle(), operaE.getArtist(), operaE.getStatus(), operaE.getType(), operaE.getRoom(), operaE.getMovement(), operaE.getDescription(), operaE.getPosition(), operaE.getValue()));
	}
	
	@Test
	void testIdGenerator() {
		assertEquals(operaCreator.idGenerator(), newId);
		assertNotEquals(operaCreator.idGenerator(), newId + 1);
		assertNotEquals(operaCreator.idGenerator(), newId - 1);
	}
	
	@Test
	void testUpdateTitle() {
		assertTrue(operaCreator.updateTitle(1, "Gioconda"));
		assertFalse(operaCreator.updateTitle(99, "Gioconda"));
	}
	
	@Test
	void testUpdateArtist() {
		assertTrue(operaCreator.updateArtist(1, "Da Vinci"));
		assertFalse(operaCreator.updateArtist(99, "Da Vinci"));
	}
	
	@Test
	void testUpdateStatus() {
		assertTrue(operaCreator.updateStatus(1, "Venduto"));
		assertFalse(operaCreator.updateStatus(1, "Stato sbagliato"));
	}
	
	@Test
	void testUpdateType() {
		assertTrue(operaCreator.updateType(1, "Manufatto"));
		assertFalse(operaCreator.updateType(1, "Tipo sbagliato"));
	}
	
	@Test
	void testUpdateRoom() {
		assertTrue(operaCreator.updateRoom(1, 4));
		assertFalse(operaCreator.updateRoom(99, 4));
	}
	
	@Test
	void testUpdateMovement() {
		assertTrue(operaCreator.updateMovement(1, "Espressionismo"));
		assertFalse(operaCreator.updateMovement(1, "Movimento sbagliato"));
	}
	
	@Test
	void testUpdatePosition() {
		assertTrue(operaCreator.updatePosition(1, 3));
		assertFalse(operaCreator.updatePosition(99, 3));
	}
	
	@Test
	void testUpdateValue() {
		assertTrue(operaCreator.updateValue(1, 100.0f));
		assertFalse(operaCreator.updateValue(99, 100.0f));
	}
	
}
