package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import solutions.NimGame292;

/**
 * @Author: Nandi Ouyang
 * @Date : Mar 20, 2016
 * @Desc :
 */
public class TestNimGame292 {

	private NimGame292 solution = null;

	@Before
	public void init() {
		solution = new NimGame292();
	}

	@Test
	public void testNegativeAndZero() {
		assertFalse("Negative and zero numer", solution.canWinNim(-1));
		assertFalse("Negative and zero numer", solution.canWinNim(0));
	}

	@Test
	public void testWinNumber() {
		assertTrue("Win number", solution.canWinNim(3));
		assertTrue("Win number", solution.canWinNim(7));
	}

	@Test
	public void testLoseNumber() {
		assertFalse("Lose number", solution.canWinNim(4));
		assertFalse("Lose number", solution.canWinNim(8));
	}
}
