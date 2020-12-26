package gui;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import javax.swing.border.TitledBorder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FormDisplayTest {

	FormDisplayBuilder fdb;
	DisplayDirector dd;
	FormDisplay fd;
	ArrayList<String> info1 = new ArrayList<>();
	ArrayList<String> info2 = new ArrayList<>();
	
	
	@BeforeEach
	void setUp() throws Exception {
		fdb = new FormDisplayBuilder();
		dd = new DisplayDirector(fdb);
		info1.add("Opera");
		info1.add("1");
		info2.add("Opera");
		info2.add("2");
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void getTitle() {
		String result;
		
		assertNotNull(fdb);
		assertNotNull(dd);
		
		dd.make("Dettagli opera 1", info1, "Salva modifiche");
		fd = fdb.getProduct();
		assertNotNull(fd);
		result = fd.getTitle();
		assertEquals("Dettagli opera 1", result);
		
		dd.make("Dettagli opera 2", info2);
		fd = fdb.getProduct();
		assertNotNull(fd);
		result = fd.getTitle();
		assertEquals("Dettagli opera 2", result);
	}
	
	
	@Test
	void testGetButtons() {
		
		assertNotNull(fdb);
		assertNotNull(dd);
		
		dd.make("Dettagli opera 1", info1, "Salva modifiche");
		fd = fdb.getProduct();
		assertNotNull(fd);
		assertEquals(2, fd.getButtons().length);
		assertEquals("Salva modifiche", fd.getButtons()[0].getText());
		assertEquals("TORNA INDIETRO", fd.getButtons()[1].getText());
		
		dd.make("Dettagli opera 2", info2);
		fd = fdb.getProduct();
		assertNotNull(fd);
		assertEquals(1, fd.getButtons().length); 
		assertEquals("TORNA INDIETRO", fd.getButtons()[0].getText());
		
	}
	
	@Test
	void testGetTextFields() {
		
		assertNotNull(fdb);
		assertNotNull(dd);
		
		dd.make("Dettagli opera 1", info1, "Salva modifiche");
		fd = fdb.getProduct();
		assertNotNull(fd);
		assertEquals("ID", ((TitledBorder)fd.getTextFields().get(0).getBorder()).getTitle());
		assertEquals("Titolo", ((TitledBorder)fd.getTextFields().get(1).getBorder()).getTitle());
		assertEquals("Autore", ((TitledBorder)fd.getTextFields().get(2).getBorder()).getTitle());
		assertEquals("Tipo", ((TitledBorder)fd.getTextFields().get(3).getBorder()).getTitle());
		assertEquals("Corrente artistica", ((TitledBorder)fd.getTextFields().get(4).getBorder()).getTitle());
		assertEquals("Stanza", ((TitledBorder)fd.getTextFields().get(5).getBorder()).getTitle());
		assertEquals("Posizione nella stanza", ((TitledBorder)fd.getTextFields().get(6).getBorder()).getTitle());
	}
	
	@Test
	void testGetScrollPane() {
		
		assertNotNull(fdb);
		assertNotNull(dd);
		
		dd.make("Dettagli opera 1", info1, "Salva modifiche");
		fd = fdb.getProduct();
		assertNotNull(fd);
		assertEquals("Descrizione", ((TitledBorder)fd.getScrollPane().getBorder()).getTitle());
	}
	
	@Test
	void testGetTextArea() {
		
		assertNotNull(fdb);
		assertNotNull(dd);
		
		dd.make("Dettagli opera 1", info1, "Salva modifiche");
		fd = fdb.getProduct();
		assertNotNull(fd);
		assertTrue(fd.getTextArea().getLineWrap());
		assertNotEquals("", fd.getTextArea().getText());
	}

}
