package it.gruppo5.smartmuseumwapp.database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoomCreatorTest {

	RoomCreator roomCreator = new RoomCreator();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCreateComponent() {
		Component compA = roomCreator.createComponent(1);
		assertNotNull(compA);
		Component compB = roomCreator.createComponent(999);
		assertNull(compB);
	}
	
	@Test
	void testGetRoomExists() {
		assertTrue(roomCreator.getRoomExists(1));
		assertTrue(roomCreator.getRoomExists(4));
		assertFalse(roomCreator.getRoomExists(0));
		assertFalse(roomCreator.getRoomExists(30));
	}

}
