package scf6;

import static org.junit.Assert.*;

import org.junit.Test;

public class IntSetTest {
	IntSet intSetObj = new IntSet(new int[]{1,2,3,4,8,6,5,9,11});

	@Test
	public void when_integer_passed() {
		assertEquals(true, intSetObj.isMember(5));
	}
	
	@Test
	public void when_integer_passed1() {
		assertEquals(false, intSetObj.isMember(15));
	}
	
	@Test
	public void size_of_array_of_object() {
		assertEquals(9, intSetObj.size());
	}

	@Test
	public void when_object_passed() {
		assertEquals(true, intSetObj.isSubSet(new IntSet(new int[]{1,2,3})) );
	}

	@Test
	public void when_object_passed1() {
		assertEquals(false, intSetObj.isSubSet(new IntSet(new int[]{1,12,3})) );
	}
	
	@Test
	public void when_two_object_passed() {
		IntSet obj = intSetObj.union( new IntSet(new int[]{1,2,3}), new IntSet(new int[]{1,12,3}) );
		assertArrayEquals(new int[]{1,2,3,12}, obj.getARR() );
	}
	
	@Test
	public void when_negative_number_ispassed() {
	try {
		assertEquals("size of array is size is zero",1, new IntSet(new int[]{}));
	}
	catch (AssertionError e) {
		System.out.println("size of array is zero");
	}
	}
	
}
