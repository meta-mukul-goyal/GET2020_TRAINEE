package scf8;

import static org.junit.Assert.*;

import org.junit.Test;



public class SparseMatrixTest {
	SparseMatrix obj = new SparseMatrix( new int[][]{{1,1,1},{1,0,0},{0,0,0}} );
	
	@Test
	public void transpose_matrix() {
		assertArrayEquals( new int[][]{{0,0,1},{1,0,1},{2,0,1},{0,1,1}}, obj.transpose());
	}
	
	@Test
	public void check_symmetric() {
		assertEquals(false, obj.symmetric());
	}
	
	@Test
	public void check_symmetric1() {
		SparseMatrix obj1 = new SparseMatrix( new int[][]{{0,1,0},{1,0,5},{0,5,0}});
		assertEquals(true, obj1.symmetric());
	}
	
	@Test
	public void when_oneobject_passed() {
		SparseMatrix obj1 = new SparseMatrix( new int[][]{{1,1,0},{0,7,0},{0,0,9}} );
		assertArrayEquals( new int[][]{{0,0,2},{0,1,2},{0,2,1},{1,0,1},{1,1,7},{2,2,9},{0,0,0},{0,0,0}}, obj.additionSparse(obj1));
	}
	
	@Test
	public void when_twoobject_passed() {
		SparseMatrix obj1 = new SparseMatrix( new int[][]{{1,1,0},{0,7,0},{0,0,9}} );
		SparseMatrix obj2 = new SparseMatrix( new int[][]{{1,1,0},{0,7,0},{0,0,9}} );
		assertArrayEquals( new int[][]{{1,8,0},{0,49,0},{0,0,81}}, obj.multiplySparse(obj1, obj2));
	}
	
	@Test
	public void when_size_zero_passed() {
	try {
		assertEquals("",1, new SparseMatrix(new int[][]{}));
	}
	catch (AssertionError e) {
		System.out.println("size of array is zero");
	}
	}
	
	@Test
	public void when_two_object_array_length_not_same() {
		SparseMatrix obj1 = new SparseMatrix( new int[][]{{1,1,0},{0,7,0},{0,0,9},{1,0,0}} );
	try {
		assertEquals("",1, obj.additionSparse(obj1));
	}
	catch (AssertionError e) {
		System.out.println("both are not of same size");
	}
	}
	
	@Test
	public void when_nonzero_are_greater_than_zero() {
	try {
		assertEquals("",1, new SparseMatrix(new int[][]{{1,1,1},{1,0,0},{1,1,1}}));
	}
	catch (AssertionError e) {
		System.out.println("non zero are greater than zero");
	}
	}
}
