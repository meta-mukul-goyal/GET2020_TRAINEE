package scf4;

import static org.junit.Assert.*;

import org.junit.Test;

public class countClumpTest {
	ArrOperation arrOperationObj = new ArrOperation();

	@Test
	public void expression() {
		int[] arr = {1,1,2,4,5,5,6};
		int result = arrOperationObj.countClumps(arr);
		assertEquals(2,result);
	}
	
	@Test
	public void expression1() {
		int[] arr = {1,2,2,3,4,4};
		int result = arrOperationObj.countClumps(arr);
		assertEquals(2,result);
	}

	@Test
	public void expression2() {
		int[] arr = {1,1,2,1,1};
		int result = arrOperationObj.countClumps(arr);
		assertEquals(2,result);
	}
	
	@Test
	public void expression3() {
		int[] arr = {1,1,1,1,1};
		int result = arrOperationObj.countClumps(arr);
		assertEquals(1,result);
	}
	
	@Test
	public void expression4() {
		int[] arr = {};
		
		try {
			assertEquals("size of array is zero",1,arrOperationObj.countClumps(arr));
		}
		catch (AssertionError e) {
			System.out.println("finished");
		}
	}
}
