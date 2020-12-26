package gui;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.border.TitledBorder;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SimpleDisplayBuilderTest {

	SimpleDisplayBuilder sdb;
	ArrayList<String> info;
	
	@BeforeEach
	void setUp() throws Exception {
		sdb = new SimpleDisplayBuilder();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSimpleDisplayBuilder() {
		assertNotNull(sdb);
	}
	
	@Test
	void testReset() {
		assertNotNull(sdb);
		sdb.reset();
		assertNull(sdb.getC());
		assertNotNull(sdb.getTopPanel());
		assertNotNull(sdb.getBottomPanel());
		assertNull(sdb.getButtons());
		assertNotNull(sdb.getTextArea());
		assertNotNull(sdb.getScrollPane());
		assertNull(sdb.getSimpleDisplay());
	}
	
	
	@Test
	void testCreateWindow() {
		String title;
		
		assertNotNull(sdb);
		sdb.createWindow("Stanza 1");
		assertNotNull(sdb.getSimpleDisplay());
		title = sdb.getSimpleDisplay().getTitle();
		assertEquals("Stanza 1", title);
		
		sdb.createWindow("Stanza 2");
		assertNotNull(sdb.getSimpleDisplay());
		title = sdb.getSimpleDisplay().getTitle();
		assertEquals("Stanza 2", title);
		
		assertEquals(JFrame.DISPOSE_ON_CLOSE, sdb.getSimpleDisplay().getDefaultCloseOperation());
		assertEquals(new Dimension(650, 450) , sdb.getSimpleDisplay().getSize());
	}
	
	@Test
	void testCreatePanel() {
		assertNotNull(sdb);
		sdb.createWindow("Stanza 1");
		info = new ArrayList<>();
		info.add("Temperatura: 20\n");
		info.add("Opere Disponibili\n");
		info.add("Gioconda");
		sdb.createPanel(info);
		assertNotNull(sdb.getC());
		assertNotNull(sdb.getTopPanel());
		assertNotNull(sdb.getBottomPanel());
		assertNotNull(sdb.getTextArea());
		assertNotNull(sdb.getScrollPane());
		assertEquals(sdb.getTextArea().getText(), "Temperatura: 20\nOpere Disponibili\nGioconda");
		assertFalse(sdb.getTextArea().isEditable());
		assertEquals("Informazioni", ((TitledBorder)sdb.getScrollPane().getBorder()).getTitle());
		assertEquals(1, sdb.getTopPanel().getComponentCount());
		assertEquals(0, sdb.getBottomPanel().getComponentCount());
		
	}
	
	@Test
	void testCreateButtons() {
		assertNotNull(sdb);
		sdb.createButtons();
		assertNotNull(sdb.getButtons());
		assertEquals(1, sdb.getButtons().length);
		assertEquals("TORNA INDIETRO", sdb.getButtons()[0].getText());
		assertEquals(new Dimension(200, 50), sdb.getButtons()[0].getPreferredSize());
		assertEquals(1, sdb.getBottomPanel().getComponentCount());
		
		sdb.reset();
		sdb.createButtons("Bottone");
		assertNotNull(sdb.getButtons());
		assertEquals(2, sdb.getButtons().length);
		assertEquals("Bottone", sdb.getButtons()[0].getText());
		assertEquals("TORNA INDIETRO", sdb.getButtons()[1].getText());
		assertEquals(new Dimension(200, 50), sdb.getButtons()[1].getPreferredSize());
		assertEquals(2, sdb.getBottomPanel().getComponentCount());
	}
	
	@Test
	void testGetProduct() {
		assertNotNull(sdb);
		sdb.createWindow("Stanza 1");
		info = new ArrayList<>();
		info.add("Temperatura: 20\n");
		info.add("Opere Disponibili\n");
		info.add("Gioconda");
		sdb.createPanel(info);
		sdb.createButtons("Bottone");
		assertNotNull(sdb.getProduct());
		assertEquals("Stanza 1", sdb.getProduct().getTitle());
		assertEquals(2, sdb.getProduct().getButtons().length);
		assertTrue(sdb.getProduct().isVisible());
	}

}
