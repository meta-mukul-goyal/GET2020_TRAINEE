package scf6;

import java.util.ArrayList;

public final class IntSet1 {
	private final int ARR[];
	
	IntSet1(int[] intializingArray){
		if ( intializingArray.length == 0 )
			throw new AssertionError();
		ARR = intializingArray.clone();
	}
	
	/**
	 * get the instance variable of object i.e. polyArray
	 * @return ARR
	 */
	public int[] getARR(){
		return ARR.clone();
	}
	
	/**
	 * find the checkNum is in ARR or not 
	 * @param checkNum as value of int type
	 * @return true if checkNum is found
	 * @return false if checkNum is not found
	 */
	public boolean isMember(int checkNum){
		int len = ARR.length;
		for( int i=0; i<len; i++ ){
			if( ARR[i] == checkNum )
				return true;
		}
		return false;
	}
	
	/**
	 * find the size of array
	 * @return n as size of array
	 */
	public int size(){
		int n = ARR.length;
		return n;
	}
	
	/**
	 * find subset is present or not
	 * @param obj as a object of IntSet type
	 * @return true if subset is found
	 * @return false if subset is not found
	 */
	public boolean isSubSet(IntSet1 obj){
		for( int i=0; i<obj.ARR.length; i++ ){
			if( !this.isMember(obj.ARR[i]) )
				return false;
			}
		return true;
		}
	
	/**
	 * find the complement of array 
	 * @return object as a complement of array
	 */
	public IntSet1 getComplement()
		{
		int a[] = new int[1000-ARR.length], x=0;
		for( int i=1; i<=1000; i++ ){
			if( !isMember(i) ){
				a[x]=i;
				x++;
				}
			}
		return new IntSet1(a);
		}
	
	/**
	 * find the union of the objects
	 * @param obj1 as a object of IntSet type
	 * @param obj2 as a object of IntSet type
	 * @return object as a union of array
	 */
	public IntSet1 union(IntSet1 obj1, IntSet1 obj2){
		int len1 = obj1.ARR.length;
		int len2 = obj2.ARR.length;
		ArrayList<Integer> union= new ArrayList<Integer>();
		
		for(int i=0; i<len1; i++)
			union.add(obj1.ARR[i]);
		
		for(int j=0; j<len2; j++)
			if( !obj1.isMember(obj2.ARR[j]) )
				union.add(obj2.ARR[j]);
		
		int unionArray[] = new int[union.size()];
		for(int i=0; i<union.size(); i++)
			unionArray[i] = union.get(i);
		return new IntSet1(unionArray);
		}
		
//	public static void main(String[] args){
//		IntSet obj = new IntSet(new int[]{1,2,3});
//		obj.ARR;
//	}

}