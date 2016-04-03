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
		Piece p = new Piece(null, 8, 6);
	    assertEquals(8, p.getPositionX());
	    assertEquals(6, p.getPositionY());
	}
}