package scf6;

import java.util.ArrayList;

public final class IntSet {
	private final int ARR[];
	
	IntSet(int[] intializingArray){
		if ( intializingArray.length == 0 )
			throw new AssertionError();
		ARR = intializingArray.clone();
	}
	
	public int[] getARR(){
		return ARR.clone();
	}
	
	public boolean isMember(int checkNum){
		int len = ARR.length;
		for( int i=0; i<len; i++ ){
			if( ARR[i] == checkNum )
				return true;
		}
		return false;
	}
	
	public int size(){
		int n = ARR.length;
		return n;
	}
	
	public boolean isSubSet(IntSet obj){
		for( int i=0; i<obj.ARR.length; i++ ){
			if( !this.isMember(obj.ARR[i]) )
				return false;
			}
		return true;
		}
	
	public IntSet getComplement()
		{
		int a[] = new int[1000-ARR.length], x=0;
		for( int i=1; i<=1000; i++ ){
			if( !isMember(i) ){
				a[x]=i;
				x++;
				}
			}
		return new IntSet(a);
		}
	
	public IntSet union(IntSet obj1, IntSet obj2){
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
		return new IntSet(unionArray);
		}
		
//	public static void main(String[] args){
//		IntSet obj = new IntSet(new int[]{1,2,3});
//		obj.ARR;
//	}

}