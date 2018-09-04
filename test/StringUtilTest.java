import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Tests of the StringUtil methods.
 * 
 * @author Pittayoot R.R.Ratanakul
 */
public class StringUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testIndexOf() {
		String[] fruit = { "Apple", "Banana", "Grapes" };
		assertEquals(0, StringUtil.indexOf("Apple", fruit));
	}

	@Test
	public void testIndexOfString() {
		String[] animal = { "Ant", "Bee", "Dog" };
		assertEquals(1, StringUtil.indexOf("Bee", animal));
	}

	@Test
	public void testIndexOfemptyString() {
		String[] empty = {};
		assertEquals(-1, StringUtil.indexOf("Omega lul", empty));

		assertEquals(-1, StringUtil.indexOf("", empty));
	}

	@Test
	public void testIndexOfwrongString() {
		String[] honne = { "Day one", "I might", "You and Me", "Crying over you" };
		assertEquals(-1, StringUtil.indexOf("Justin", honne));
	}

	@Test
	public void testIndexOfsamevalue() {
		String[] animal = { "Eagle", "Mice", "Mice", "Eagle" };
		assertEquals(1, StringUtil.indexOf("Mice", animal));
	}
}
