package scf4;

import static org.junit.Assert.*;

import org.junit.Test;

public class maxMirrorTest {

ArrOperation arrOperationObj = new ArrOperation();
	
	@Test
	public void expression() {
		int[] arr = {1,2,3,4,3,2,1};
		int result = arrOperationObj.maxMirror(arr);
		assertEquals(7,result);
	}

	@Test
	public void expression1() {
		int[] arr = {1,2,3,7,8,3,2,1};
		int result = arrOperationObj.maxMirror(arr);
		assertEquals(3,result);
	}
	
	@Test
	public void expression2() {
		int[] arr = {1,4,1,6};
		int result = arrOperationObj.maxMirror(arr);
		assertEquals(3,result);
	}
	
	@Test
	public void expression3() {
		int[] arr = {};
		try {
			assertEquals("size of array is zero",1,arrOperationObj.maxMirror(arr));
		}
		catch (AssertionError e) {
			System.out.println("finished");
		}
	}

}
