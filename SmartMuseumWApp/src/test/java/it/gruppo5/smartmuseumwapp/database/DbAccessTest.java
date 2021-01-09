package it.gruppo5.smartmuseumwapp.database;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.Connection;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DbAccessTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAccess() {
		DbAccess result = DbAccess.getAccess();
		assertNotNull(result);
	}
	
	@Test
	void testConnect() {
		Connection result = DbAccess.connect("gestione_museo");
		assertNotNull(result);
	}
	
	@Test
    public void connect_shouldThrowException() {

        try {

            // This method is expected to throw a FooException
        	Connection result = DbAccess.connect("blablabla");
            
            // If the exception is not thrown, the test will fail
            fail("Expected exception has not been thrown");

        } catch (Exception e) {

            assertEquals(e.getMessage(), ("** DATABASE CONNECTION FAILED **"));
        }
    }
}
