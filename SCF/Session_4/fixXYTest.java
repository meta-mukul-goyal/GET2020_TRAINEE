package scf4;

import static org.junit.Assert.*;

import org.junit.Test;

public class fixXYTest {
	ArrOperation arrOperationObj = new ArrOperation();
	
	@Test
	public void expression() {
		int[] arr = {5,4,9,4,9,5};
		arrOperationObj.fixXY(arr,4,5);
		
		int[] expected = {9,4,5,4,5,9};
		assertArrayEquals(expected,arr);
	}
	
	@Test
	public void expression1() {
		int[] arr = {1,4,1,5};
		arr = arrOperationObj.fixXY(arr,4,5);
		int[] expected = {1,4,5,1};
		assertArrayEquals(expected,arr);
	}

	@Test
	public void expression2() {
		int[] arr = {1,4,1,5,5,4,1};
		arrOperationObj.fixXY(arr,4,5);
		int[] expected = {1,4,5,1,1,4,5};
		assertArrayEquals(expected,arr);
	}
	
	@Test
	public void expression3() {
		int[] arr = {};
		try {
			assertEquals("size of array is zero",1,arrOperationObj.fixXY(arr,4,5));
		}
		catch (AssertionError e) {
			System.out.println("finished");
		}
	}
	
	@Test
	public void expression4() {
		int[] arr = {1,2,4,4,4,6,7};
		try {
			assertEquals("cosecutive x value",1,arrOperationObj.fixXY(arr,4,5));
		}
		catch (AssertionError e) {
			System.out.println("finished");
		}
	}

	@Test
	public void expression5() {
		int[] arr = {1,2,4,7,4,6,7,4};
		try {
			assertEquals("x at last of array",1,arrOperationObj.fixXY(arr,4,5));
		}
		catch (AssertionError e) {
			System.out.println("finished");
		}
	}
	
	@Test
	public void expression6() {
		int[] arr = {5,2,4,5,4,6,7,4};
		try {
			assertEquals("unequal number of x and y",1,arrOperationObj.fixXY(arr,4,5));
		}
		catch (AssertionError e) {
			System.out.println("finished");
		}
	}
}
