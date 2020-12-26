package gui;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Dimension;

import javax.swing.JFrame;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SubMenuBuilderTest {

SubMenuBuilder smm;
	
	@BeforeEach
	void setUp() throws Exception {
		smm = new SubMenuBuilder();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testSubMenuBuilder() {
		assertNotNull(smm);
	}
	
	@Test
	void testReset() {
		assertNotNull(smm);
		smm.reset();
		assertNull(smm.getC());
		assertNotNull(smm.getTopPanel());
		assertNotNull(smm.getBottomPanel());
		assertNull(smm.getButtons());
		assertNull(smm.getSubMenu());
	}
	
	
	@Test
	void testCreateWindow() {
		String title;
		
		assertNotNull(smm);
		smm.createWindow("Stanze");
		assertNotNull(smm.getSubMenu());
		title = smm.getSubMenu().getTitle();
		assertEquals("Stanze", title);
		
		smm.createWindow("Entrate/Uscite");
		assertNotNull(smm.getSubMenu());
		title = smm.getSubMenu().getTitle();
		assertEquals("Entrate/Uscite", title);
		
		assertEquals(JFrame.DISPOSE_ON_CLOSE, smm.getSubMenu().getDefaultCloseOperation());
		assertEquals(new Dimension(650, 450) , smm.getSubMenu().getSize());
	}
	
	@Test
	void testCreatePanel() {
		assertNotNull(smm);
		smm.createWindow("Stanze");
		smm.createPanel();
		assertNotNull(smm.getC());
		assertNotNull(smm.getTopPanel());
		assertNotNull(smm.getBottomPanel());
	}
	
	@Test
	void testCreateButtons() {
		assertNotNull(smm);
		smm.createButtons("Stanza 1", "Stanza 2", "Stanza 3");
		assertNotNull(smm.getButtons());
		assertEquals(4, smm.getButtons().length);
		assertEquals("Stanza 1", smm.getButtons()[0].getText());
		assertEquals("Stanza 2", smm.getButtons()[1].getText());
		assertEquals("Stanza 3", smm.getButtons()[2].getText());
		assertEquals("TORNA INDIETRO", smm.getButtons()[3].getText());
		assertEquals(new Dimension(300, 50), smm.getButtons()[3].getPreferredSize());
		
		smm.createButtons("Entrate", "Uscite");
		assertNotNull(smm.getButtons());
		assertEquals(3, smm.getButtons().length);
		assertEquals("Entrate", smm.getButtons()[0].getText());
		assertEquals("Uscite", smm.getButtons()[1].getText());
		assertEquals("TORNA INDIETRO", smm.getButtons()[2].getText());
		assertEquals(new Dimension(300, 50), smm.getButtons()[2].getPreferredSize());
	}
	
	@Test
	void testGetProduct() {
		assertNotNull(smm);
		smm.createWindow("Stanze");
		smm.createPanel();
		smm.createButtons("Stanza 1", "Stanza 2", "Stanza 3");
		assertNotNull(smm.getProduct());
		assertEquals("Stanze", smm.getProduct().getTitle());
		assertEquals(4, smm.getProduct().getButtons().length);
		assertTrue(smm.getProduct().isVisible());
	}
}
