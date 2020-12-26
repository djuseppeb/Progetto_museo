package gui;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.border.TitledBorder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnhancedDisplayBuilderTest {

	EnhancedDisplayBuilder edb;
	ArrayList<String> info;
	
	@BeforeEach
	void setUp() throws Exception {
		edb = new EnhancedDisplayBuilder();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testEnhancedDisplayBuilder() {
		assertNotNull(edb);
	}
	
	@Test
	void testReset() {
		assertNotNull(edb);
		edb.reset();
		assertNull(edb.getC());
		assertNotNull(edb.getTopPanel());
		assertNotNull(edb.getBottomPanel());
		assertNull(edb.getButtons());
		assertNotNull(edb.getTextArea());
		assertNotNull(edb.getTextField());
		assertNotNull(edb.getScrollPane());
		assertNull(edb.getEnhancedDisplay());
	}
	
	
	@Test
	void testCreateWindow() {
		String title;
		
		assertNotNull(edb);
		edb.createWindow("Opere");
		assertNotNull(edb.getEnhancedDisplay());
		title = edb.getEnhancedDisplay().getTitle();
		assertEquals("Opere", title);
		
		edb.createWindow("Mostre");
		assertNotNull(edb.getEnhancedDisplay());
		title = edb.getEnhancedDisplay().getTitle();
		assertEquals("Mostre", title);
		
		assertEquals(JFrame.DISPOSE_ON_CLOSE, edb.getEnhancedDisplay().getDefaultCloseOperation());
		assertEquals(new Dimension(650, 450) , edb.getEnhancedDisplay().getSize());
	}
	
	@Test
	void testCreatePanel() {
		assertNotNull(edb);
		edb.createWindow("Stanza 1");
		info = new ArrayList<>();
		info.add("ID 1 - Gioconda\n");
		info.add("ID 2 - David");
		edb.createPanel(info);
		assertNotNull(edb.getC());
		assertNotNull(edb.getTopPanel());
		assertNotNull(edb.getBottomPanel());
		assertNotNull(edb.getTextArea());
		assertNotNull(edb.getTextField());
		assertNotNull(edb.getScrollPane());
		assertEquals("ID 1 - Gioconda\nID 2 - David", edb.getTextArea().getText());
		assertFalse(edb.getTextArea().isEditable());
		assertEquals("Informazioni", ((TitledBorder)edb.getScrollPane().getBorder()).getTitle());
		assertEquals(1, edb.getTopPanel().getComponentCount());
		assertEquals(1, edb.getBottomPanel().getComponentCount());
		
	}
	
	@Test
	void testCreateButtons() {
		assertNotNull(edb);
		edb.createButtons();
		assertNotNull(edb.getButtons());
		assertEquals(1, edb.getButtons().length);
		assertEquals("TORNA INDIETRO", edb.getButtons()[0].getText());
		assertEquals(new Dimension(200, 50), edb.getButtons()[0].getPreferredSize());
		assertEquals(1, edb.getBottomPanel().getComponentCount());
		
		edb.reset();
		edb.createButtons("Visualizza");
		assertNotNull(edb.getButtons());
		assertEquals(2, edb.getButtons().length);
		assertEquals("Visualizza", edb.getButtons()[0].getText());
		assertEquals("TORNA INDIETRO", edb.getButtons()[1].getText());
		assertEquals(new Dimension(200, 50), edb.getButtons()[1].getPreferredSize());
		assertEquals(2, edb.getBottomPanel().getComponentCount());
	}
	
	@Test
	void testGetProduct() {
		assertNotNull(edb);
		edb.createWindow("Opere");
		info = new ArrayList<>();
		info.add("ID 1 - Gioconda\n");
		info.add("ID 2 - David");
		edb.createPanel(info);
		edb.createButtons("Visualizza");
		assertNotNull(edb.getProduct());
		assertEquals("Opere", edb.getProduct().getTitle());
		assertEquals(2, edb.getProduct().getButtons().length);
		assertEquals("Digita ID", ((TitledBorder)edb.getProduct().getTextField().getBorder()).getTitle());
		assertTrue(edb.getProduct().isVisible());
	}

}
