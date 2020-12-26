package gui;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MenuDirectorTest {

	MainMenuBuilder mmb;
	SubMenuBuilder smb; 
	MenuDirector md;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testMenuDirector() {
		assertNull(mmb);
		mmb = new MainMenuBuilder();
		assertNotNull(mmb);
		assertNull(md);
		md = new MenuDirector(mmb);
		assertNotNull(md);
	}
	
	
	@Test
	void testChangeBuilder() {
		assertNull(mmb);
		mmb = new MainMenuBuilder();
		assertNotNull(mmb);
		assertNull(md);
		md = new MenuDirector(mmb);
		assertNotNull(md);
		
		assertNull(smb);
		smb = new SubMenuBuilder();
		assertNotNull(smb);
		md.changeBuilder(smb);
		assertNotSame(this.mmb, md.getMenuBuilder());
		assertSame(this.smb, md.getMenuBuilder());
	}

}
