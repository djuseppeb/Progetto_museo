package gui;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import javax.swing.border.TitledBorder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnhancedDisplayTest {

	EnhancedDisplayBuilder edb;
	DisplayDirector dd;
	EnhancedDisplay ed;
	ArrayList<String> info1 = new ArrayList<>();
	ArrayList<String> info2 = new ArrayList<>();
	
	
	@BeforeEach
	void setUp() throws Exception {
		edb = new EnhancedDisplayBuilder();
		dd = new DisplayDirector(edb);
		info1.add("ID 1 - Gioconda\n");
		info1.add("ID 2 - David");
		info2.add("Mostra di arte moderna\n");
		info2.add("Mostra di arte classica");	
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void getTitle() {
		String result;
		
		assertNotNull(edb);
		assertNotNull(dd);
		
		dd.make("Opere", info1);
		ed = edb.getProduct();
		assertNotNull(ed);
		result = ed.getTitle();
		assertEquals("Opere", result);
		
		dd.make("Mostre", info2);
		ed = edb.getProduct();
		assertNotNull(ed);
		result = ed.getTitle();
		assertEquals("Mostre", result);
	}
	
	
	@Test
	void testGetButtons() {
		
		assertNotNull(edb);
		assertNotNull(dd);
		
		dd.make("Opere", info1, "Visualizza Opera");
		ed = edb.getProduct();
		assertNotNull(ed);
		assertEquals(2, ed.getButtons().length);
		assertEquals("Visualizza Opera", ed.getButtons()[0].getText());
		assertEquals("TORNA INDIETRO", ed.getButtons()[1].getText());
		
		dd.make("Mostre", info2);
		ed = edb.getProduct();
		assertNotNull(ed);
		assertEquals(1, ed.getButtons().length); 
		assertEquals("TORNA INDIETRO", ed.getButtons()[0].getText());
		
	}
	
	@Test
	void testGetTextField() {
		
		assertNotNull(edb);
		assertNotNull(dd);
		
		dd.make("Opere", info1, "Visualizza Opera");
		ed = edb.getProduct();
		assertNotNull(ed);
		assertEquals("Digita ID", ((TitledBorder)ed.getTextField().getBorder()).getTitle());
		assertEquals("", ed.getTextField().getText());
	}

}
