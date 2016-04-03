package test;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.Assert.*;

import modele.Piece;

public class PieceTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetters() {
		Piece p = new Piece(1, 41, 42);
	    assertEquals(41, p.getPositionX());
	    assertEquals(42, p.getPositionY());
	}
}