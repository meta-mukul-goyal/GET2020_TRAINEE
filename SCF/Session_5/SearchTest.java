package scf_5;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchTest {
	Search searchObj = new Search();

	@Test
	public void expression() {
		int result = searchObj.linearSearch(new int[]{1,6,7,3,4,9,4,2}, 3, 0);
		assertEquals(3,result);
	}
	
	@Test
	public void expression1() {
		int result = searchObj.linearSearch(new int[]{1,6,7,3,4,9,4,2}, 2, 0);
		assertEquals(7,result);
	}

	@Test
	public void expression2() {
		int result = searchObj.linearSearch(new int[]{1,6,7,3,4,9,4,2}, 9, 0);
		assertEquals(5,result);
	}
	
	@Test
	public void expression3() {
		int result = searchObj.linearSearch(new int[]{1,6,7,3,4,9,4,2}, 7, 0);
		assertEquals(2,result);
	}
	
	
	@Test
	public void expression4() {
		int result = searchObj.binarySearch(new int[]{1,2,3,4,4,6,7,9}, 3, 0, 7);
		assertEquals(2,result);
	}
	
	@Test
	public void expression5() {
		int result = searchObj.binarySearch(new int[]{1,2,3,4,4,6,7,9}, 2, 0, 7);
		assertEquals(1,result);
	}

	@Test
	public void expression6() {
		int result = searchObj.binarySearch(new int[]{1,2,3,4,4,6,7,9}, 9, 0, 7);
		assertEquals(7,result);
	}
	
	@Test
	public void expression7() {
		int result = searchObj.binarySearch(new int[]{1,2,3,4,4,6,7,9}, 7, 0, 7);
		assertEquals(6,result);
	}

	

}
