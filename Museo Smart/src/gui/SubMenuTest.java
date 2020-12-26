package gui;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubMenuTest {

	SubMenuBuilder smb;
	MenuDirector md;
	SubMenu sm;
	
	@BeforeEach
	void setUp() throws Exception {
		smb = new SubMenuBuilder();
		md = new MenuDirector(smb);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void getTitle() {
		String result;
		
		assertNotNull(smb);
		assertNotNull(md);
		
		md.make("Stanze", "Stanza 1", "Stanza 2", "Stanza 3");
		sm = smb.getProduct();
		assertNotNull(sm);
		result = sm.getTitle();
		assertEquals("Stanze", result);
		
		md.make("Entrate/Uscite", "Entrate", "Uscite");
		sm = smb.getProduct();
		assertNotNull(sm);
		result = sm.getTitle();
		assertEquals("Entrate/Uscite", result);
	}
	
	
	@Test
	void testGetButtons() {
		
		assertNotNull(smb);
		assertNotNull(md);
		
		md.make("Stanze", "Stanza 1", "Stanza 2", "Stanza 3");
		sm = smb.getProduct();
		assertNotNull(sm);
		
		assertEquals(4, sm.getButtons().length); 
		assertEquals("Stanza 1", sm.getButtons()[0].getText());
		assertEquals("Stanza 2", sm.getButtons()[1].getText());
		assertEquals("Stanza 3", sm.getButtons()[2].getText());
		assertEquals("TORNA INDIETRO", sm.getButtons()[3].getText());
		
		md.make("Entrate/Uscite", "Entrate", "Uscite");
		sm = smb.getProduct();
		assertNotNull(sm);
		assertEquals(3, sm.getButtons().length); 
		assertEquals("Entrate", sm.getButtons()[0].getText());
		assertEquals("Uscite", sm.getButtons()[1].getText());
		assertEquals("TORNA INDIETRO", sm.getButtons()[2].getText());
	}
}