package test;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.*;

import modele.Score;

public class ScoreTest {

	@BeforeClass
	public static void setUp() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testGetters() {
		Score s = Mockito.mock(Score.class);
		Mockito.when(s.getScore()).thenReturn(42);
		assertEquals(42, s.getScore());
		Mockito.when(s.getScore()).thenCallRealMethod();
		Mockito.doCallRealMethod().when(s).setScore(Mockito.anyInt());
		s.setScore(24);
	    assertEquals(24, s.getScore());
	}
}