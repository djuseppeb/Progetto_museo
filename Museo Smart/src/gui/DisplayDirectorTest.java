package gui;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DisplayDirectorTest {

	SimpleDisplayBuilder sdb;
	EnhancedDisplayBuilder edb;
	FormDisplayBuilder fdb;
	DisplayDirector dd;
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	@Test
	void testDisplayDirector() {
		assertNull(sdb);
		sdb = new SimpleDisplayBuilder();
		assertNotNull(sdb);
		assertNull(dd);
		dd = new DisplayDirector(sdb);
		assertNotNull(dd);
	}
	
	
	@Test
	void testChangeBuilder() {
		assertNull(sdb);
		sdb = new SimpleDisplayBuilder();
		assertNotNull(sdb);
		assertNull(dd);
		dd = new DisplayDirector(sdb);
		assertNotNull(dd);
		
		assertNull(edb);
		edb = new EnhancedDisplayBuilder();
		assertNotNull(edb);
		dd.changeBuilder(edb);
		assertNotSame(this.sdb, dd.getDisplayBuilder());
		assertSame(this.edb, dd.getDisplayBuilder());
		
		assertNull(fdb);
		fdb = new FormDisplayBuilder();
		assertNotNull(fdb);
		dd.changeBuilder(fdb);
		assertNotSame(this.sdb, dd.getDisplayBuilder());
		assertNotSame(this.edb, dd.getDisplayBuilder());
		assertSame(this.fdb, dd.getDisplayBuilder());
	}

}
