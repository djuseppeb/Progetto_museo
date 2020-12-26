package gui;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainMenuTest {
	
	MainMenuBuilder mmb;
	MenuDirector md;
	MainMenu mm;

	@BeforeEach
	void setUp() throws Exception {
		mmb = new MainMenuBuilder();
		md = new MenuDirector(mmb);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	@Test
	void getTitle() {
		String result;
		
		assertNotNull(mmb);
		assertNotNull(md);
		
		md.make("Home", "Stanza", "Opere");
		mm = mmb.getProduct();
		assertNotNull(mm);
		result = mm.getTitle();
		assertEquals("Home", result);
		
		md.make("Main menu 2", "Stanza", "Opere");
		mm = mmb.getProduct();
		assertNotNull(mm);
		result = mm.getTitle();
		assertEquals("Main menu 2", result);
	}
	
	
	@Test
	void testGetButtons() {
		
		assertNotNull(mmb);
		assertNotNull(md);
		
		md.make("Home", "Stanza", "Opere");
		mm = mmb.getProduct();
		assertNotNull(mm);
		
		assertEquals(3, mm.getButtons().length); 
		assertEquals("Stanza", mm.getButtons()[0].getText());
		assertEquals("Opere", mm.getButtons()[1].getText());
		assertEquals("CHIUDI", mm.getButtons()[2].getText());
		
		md.make("Home", "Stanza", "Opere", "Entrate/Uscite");
		mm = mmb.getProduct();
		assertNotNull(mm);
		assertEquals(4, mm.getButtons().length); 
		assertEquals("Stanza", mm.getButtons()[0].getText());
		assertEquals("Opere", mm.getButtons()[1].getText());
		assertEquals("Entrate/Uscite", mm.getButtons()[2].getText());
		assertEquals("CHIUDI", mm.getButtons()[3].getText());
				
	}

}

