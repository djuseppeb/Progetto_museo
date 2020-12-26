package gui;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class MainMenuBuilderTest {

	MainMenuBuilder mmb;
	
	@BeforeEach
	void setUp() throws Exception {
		mmb = new MainMenuBuilder();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testMainMenuBuilder() {
		assertNotNull(mmb);
	}
	
	@Test
	void testReset() {
		assertNotNull(mmb);
		mmb.reset();
		assertNull(mmb.getC());
		assertNotNull(mmb.getTopPanel());
		assertNotNull(mmb.getBottomPanel());
		assertNull(mmb.getButtons());
		assertNull(mmb.getMainMenu());
	}
	
	
	@Test
	void testCreateWindow() {
		String title;
		
		assertNotNull(mmb);
		mmb.createWindow("Home");
		assertNotNull(mmb.getMainMenu());
		title = mmb.getMainMenu().getTitle();
		assertEquals("Home", title);
		
		mmb.createWindow("Main Menu 2");
		assertNotNull(mmb.getMainMenu());
		title = mmb.getMainMenu().getTitle();
		assertEquals("Main Menu 2", title);
		
		assertEquals(JFrame.EXIT_ON_CLOSE, mmb.getMainMenu().getDefaultCloseOperation());
		assertEquals(new Dimension(650, 450) , mmb.getMainMenu().getSize());
	}
	
	@Test
	void testCreatePanel() {
		assertNotNull(mmb);
		mmb.createWindow("Home");
		mmb.createPanel();
		assertNotNull(mmb.getC());
		assertNotNull(mmb.getTopPanel());
		assertNotNull(mmb.getBottomPanel());
	}
	
	@Test
	void testCreateButtons() {
		assertNotNull(mmb);
		mmb.createButtons("Stanze", "Opere");
		assertNotNull(mmb.getButtons());
		assertEquals(3, mmb.getButtons().length);
		assertEquals("Stanze", mmb.getButtons()[0].getText());
		assertEquals("Opere", mmb.getButtons()[1].getText());
		assertEquals("CHIUDI", mmb.getButtons()[2].getText());
		assertEquals(new Dimension(300, 50), mmb.getButtons()[2].getPreferredSize());
		
		mmb.createButtons("Stanze", "Opere", "Entrate/Uscite");
		assertNotNull(mmb.getButtons());
		assertEquals(4, mmb.getButtons().length);
		assertEquals("Stanze", mmb.getButtons()[0].getText());
		assertEquals("Opere", mmb.getButtons()[1].getText());
		assertEquals("Entrate/Uscite", mmb.getButtons()[2].getText());
		assertEquals("CHIUDI", mmb.getButtons()[3].getText());
		assertEquals(new Dimension(300, 50), mmb.getButtons()[3].getPreferredSize());
	}
	
	@Test
	void testGetProduct() {
		assertNotNull(mmb);
		mmb.createWindow("Home");
		mmb.createPanel();
		mmb.createButtons("Stanze", "Opere");
		assertNotNull(mmb.getProduct());
		assertEquals("Home", mmb.getProduct().getTitle());
		assertEquals(3, mmb.getProduct().getButtons().length);
		assertTrue(mmb.getProduct().isVisible());
	}
}
