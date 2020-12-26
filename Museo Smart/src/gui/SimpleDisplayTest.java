package gui;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleDisplayTest {

	SimpleDisplayBuilder sdb;
	DisplayDirector dd;
	SimpleDisplay sd;
	ArrayList<String> info1 = new ArrayList<>();
	ArrayList<String> info2 = new ArrayList<>();
	
	
	@BeforeEach
	void setUp() throws Exception {
		sdb = new SimpleDisplayBuilder();
		dd = new DisplayDirector(sdb);
		info1.add("Temperatura: 20");
		info1.add("Opere Disponibili");
		info1.add("Gioconda");
		info2.add("Temperatura: 23");
		info2.add("Opere Disponibili");
		info2.add("David");	
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void getTitle() {
		String result;
		
		assertNotNull(sdb);
		assertNotNull(dd);
		
		dd.make("Stanza 1", info1);
		sd = sdb.getProduct();
		assertNotNull(sd);
		result = sd.getTitle();
		assertEquals("Stanza 1", result);
		
		dd.make("Stanza 2", info2);
		sd = sdb.getProduct();
		assertNotNull(sd);
		result = sd.getTitle();
		assertEquals("Stanza 2", result);
	}
	
	
	@Test
	void testGetButtons() {
		
		assertNotNull(sdb);
		assertNotNull(dd);
		
		dd.make("Stanza 1", info1);
		sd = sdb.getProduct();
		assertNotNull(sd);
		assertEquals(1, sd.getButtons().length); 
		assertEquals("TORNA INDIETRO", sd.getButtons()[0].getText());
		
		dd.make("Stanza 1", info2, "Bottone");
		sd = sdb.getProduct();
		assertNotNull(sd);
		assertEquals(2, sd.getButtons().length); 
		assertEquals("Bottone", sd.getButtons()[0].getText());
		assertEquals("TORNA INDIETRO", sd.getButtons()[1].getText());
		
	}

}
