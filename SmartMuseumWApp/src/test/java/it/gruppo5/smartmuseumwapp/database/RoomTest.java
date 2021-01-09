package it.gruppo5.smartmuseumwapp.database;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RoomTest {

	Room room = new Room(1, 20.0f, true, 4, 1.0f, false, 0);
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetID() {
		assertEquals(room.getID(), 1);
	}
	@Test
	void testGetTemp() {
		assertEquals(room.getTemp(), 20.0f);
	}
	@Test
	void testGetTermal() {
		assertEquals(room.getTermal(), true);
	}
	@Test
	void testGetPeople() {
		assertEquals(room.getPeople(), 4);
	}
	@Test
	void testGetDistance() {
		assertEquals(room.getDistance(), 1.0f);
	}
	@Test
	void testIsDistanceRespected() {
		assertEquals(room.isDistanceRespected(), false);
	}
	@Test
	void testGetLights() {
		assertEquals(room.getLights(), 0);
	}
}
