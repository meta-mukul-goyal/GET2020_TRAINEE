package scf6;

import static org.junit.Assert.*;

import org.junit.Test;

public class PolyTest {
	Poly obj = new Poly(new int[][]{{2,1},{2,2},{2,0}});

	@Test
	public void when_onefloat_passed() {
		assertEquals(14, obj.evaluate(2.0f));
	}

	@Test
	public void when_onefloat_passed1() {
		assertEquals(6, obj.evaluate(-2f));
	}
	
	@Test
	public void degree_of_polynomial() {
		assertEquals(2, obj.degree());
	}
	
	@Test
	public void when_two_oject_passed() {
		assertEquals( true, obj.addPoly( new Poly(new int[][]{{2,1},{2,2},{2,4}}), new Poly(new int[][]{{2,1},{2,1}})) );
	}
	
	@Test
	public void when_two_oject_passed1() {
		assertEquals( true, obj.multiplyPoly( new Poly(new int[][]{{2,1},{2,2},{2,4}}), new Poly(new int[][]{{2,1},{2,1}})) );
	}
	
	@Test
	public void when_negative_number_ispassed() {
	try {
		assertEquals("size of array is size is zero",1, new Poly(new int[][]{}));
	}
	catch (AssertionError e) {
		System.out.println("size of array is zero");
	}
	}
}
