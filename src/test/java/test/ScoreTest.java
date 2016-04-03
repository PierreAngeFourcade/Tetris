package test;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.Assert.*;

import modele.Score;

public class ScoreTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetters() {
		Score s = new Score("Test", 42);
		assertEquals("Test", s.getName());
	    assertEquals(42, s.getScore());
	}
}