package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;
import org.junit.Assert.*;

import modele.ListeScore;
import modele.Score;

public class ListeScoreTest{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetters() {
		List<Score> liste = new ArrayList<Score>(); 
		liste.add(new Score("Test", 42));
		liste.add(new Score("Test", 42));
		liste.add(new Score("Test", 42));
		liste.add(new Score("Test", 42));
		liste.add(new Score("Test", 42));
		ListeScore ls = new ListeScore(liste);
		assertTrue(ls.isHighScore(liste, 10));
	}
}