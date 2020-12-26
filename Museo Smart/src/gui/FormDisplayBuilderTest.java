package gui;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.border.TitledBorder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FormDisplayBuilderTest {

	FormDisplayBuilder fdb;
	ArrayList<String> info;
	
	@BeforeEach
	void setUp() throws Exception {
		fdb = new FormDisplayBuilder();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testFormDisplayBuilder() {
		assertNotNull(fdb);
	}
	
	@Test
	void testReset() {
		assertNotNull(fdb);
		fdb.reset();
		assertNull(fdb.getC());
		assertNotNull(fdb.getTopPanel());
		assertNotNull(fdb.getCenterPanel());
		assertNotNull(fdb.getBottomPanel());
		assertNull(fdb.getButtons());
		assertNotNull(fdb.getTextArea());
		assertNotNull(fdb.getTextFields());
		assertNotNull(fdb.getScrollPane());
		assertNull(fdb.getFormDisplay());
	}
	
	
	@Test
	void testCreateWindow() {
		String title;
		
		assertNotNull(fdb);
		fdb.createWindow("Dettagli opera 1");
		assertNotNull(fdb.getFormDisplay());
		title = fdb.getFormDisplay().getTitle();
		assertEquals("Dettagli opera 1", title);
		
		fdb.createWindow("Dettagli opera 2");
		assertNotNull(fdb.getFormDisplay());
		title = fdb.getFormDisplay().getTitle();
		assertEquals("Dettagli opera 2", title);
		
		assertEquals(JFrame.DISPOSE_ON_CLOSE, fdb.getFormDisplay().getDefaultCloseOperation());
		assertEquals(new Dimension(650, 520) , fdb.getFormDisplay().getSize());
	}
	
	@Test
	void testCreatePanel() {
		assertNotNull(fdb);
		fdb.createWindow("Dettagli opera 1");
		info = new ArrayList<>();
		info.add("Opera");
		info.add("1");
		fdb.createPanel(info);
		assertNotNull(fdb.getC());
		assertNotNull(fdb.getTopPanel());
		assertNotNull(fdb.getCenterPanel());
		assertNotNull(fdb.getBottomPanel());
		assertNotNull(fdb.getTextArea());
		assertNotNull(fdb.getTextFields());
		assertNotNull(fdb.getScrollPane());
		assertEquals("ID", ((TitledBorder)fdb.getTextFields().get(0).getBorder()).getTitle());
		assertNotEquals("", fdb.getTextFields().get(0).getText());
		assertFalse(fdb.getTextFields().get(0).isEditable());
		assertEquals("Titolo", ((TitledBorder)fdb.getTextFields().get(1).getBorder()).getTitle());
		assertNotEquals("", fdb.getTextFields().get(1).getText());
		assertTrue(fdb.getTextFields().get(1).isEditable());
		assertEquals("Autore", ((TitledBorder)fdb.getTextFields().get(2).getBorder()).getTitle());
		assertNotEquals("", fdb.getTextFields().get(2).getText());
		assertTrue(fdb.getTextFields().get(2).isEditable());
		assertEquals("Tipo", ((TitledBorder)fdb.getTextFields().get(3).getBorder()).getTitle());
		assertNotEquals("", fdb.getTextFields().get(3).getText());
		assertTrue(fdb.getTextFields().get(3).isEditable());
		assertEquals("Corrente artistica", ((TitledBorder)fdb.getTextFields().get(4).getBorder()).getTitle());
		assertNotEquals("", fdb.getTextFields().get(4).getText());
		assertTrue(fdb.getTextFields().get(4).isEditable());
		assertEquals("Stanza", ((TitledBorder)fdb.getTextFields().get(5).getBorder()).getTitle());
		assertNotEquals("", fdb.getTextFields().get(5).getText());
		assertTrue(fdb.getTextFields().get(5).isEditable());
		assertEquals("Posizione nella stanza", ((TitledBorder)fdb.getTextFields().get(6).getBorder()).getTitle());
		assertNotEquals("", fdb.getTextFields().get(6).getText());
		assertTrue(fdb.getTextFields().get(6).isEditable());
		assertEquals("Descrizione", ((TitledBorder)fdb.getScrollPane().getBorder()).getTitle());
		assertNotEquals("", fdb.getTextArea().getText());
		assertTrue(fdb.getTextArea().isEditable());
		assertEquals(7, fdb.getTopPanel().getComponentCount());
		assertEquals(1, fdb.getCenterPanel().getComponentCount());
		assertEquals(0, fdb.getBottomPanel().getComponentCount());
	}
	
	@Test
	void testCreateButtons() {
		assertNotNull(fdb);
		fdb.createButtons();
		assertNotNull(fdb.getButtons());
		assertEquals(1, fdb.getButtons().length);
		assertEquals("TORNA INDIETRO", fdb.getButtons()[0].getText());
		assertEquals(new Dimension(200, 50), fdb.getButtons()[0].getPreferredSize());
		assertEquals(1, fdb.getBottomPanel().getComponentCount());
		
		fdb.reset();
		fdb.createButtons("Salva modifiche");
		assertNotNull(fdb.getButtons());
		assertEquals(2, fdb.getButtons().length);
		assertEquals("Salva modifiche", fdb.getButtons()[0].getText());
		assertEquals("TORNA INDIETRO", fdb.getButtons()[1].getText());
		assertEquals(new Dimension(200, 50), fdb.getButtons()[1].getPreferredSize());
		assertEquals(2, fdb.getBottomPanel().getComponentCount());
	}
	
	@Test
	void testGetProduct() {
		assertNotNull(fdb);
		fdb.createWindow("Dettagli opera 1");
		info = new ArrayList<>();
		info.add("Opera");
		info.add("1");
		fdb.createPanel(info);
		fdb.createButtons("Salva modifiche");
		assertNotNull(fdb.getProduct());
		assertEquals("Dettagli opera 1", fdb.getProduct().getTitle());
		assertEquals(2, fdb.getProduct().getButtons().length);
		assertEquals(7, fdb.getProduct().getTextFields().size());
		assertEquals("Descrizione", ((TitledBorder)fdb.getProduct().getScrollPane().getBorder()).getTitle());
		assertTrue(fdb.getTextArea().getLineWrap());
		assertTrue(fdb.getProduct().isVisible());
	}
}
