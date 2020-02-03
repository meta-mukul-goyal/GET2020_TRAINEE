package scf4;

public class ArrOperation {
//	&& count<sbf.length() 	
	
	public String reverse(String firstString){
		String newString="";
		for ( int i=firstString.length()-1; i>=0; i--)
			newString += firstString.charAt(i);
		return newString;
	}
	
	/**
	 * find mirror length of the sequence 
	 * @param arr as a array of int type
	 */
	public int maxMirror(int[] arr){
		if ( arr.length == 0)
			throw new AssertionError();
		
		int i, j, k,t=0,count=0,max=-1;
		String s1="",s2="";
		for ( i=0; i<arr.length; i++ )
			s1+= String.valueOf(arr[i]); 
		for ( i=0; i<s1.length(); i++ ){
			for ( j=i; j<s1.length(); j++ ){
				s2=s1.substring(i,j+1);
				s2=reverse(s2);
				for(k=0; k<s1.length(); k++){
					if(t>=s2.length())
						break;
					if(s2.charAt(t)==s1.charAt(k)){
						count++;
						t++;
						}
					else{
						t=0;
						if(count>max)
							max=count;
						count=0;
					}
				}
				if(count>max)
					max=count;
				t=0;
				count=0;
			}
		}		
		return max;
	}
	
	/**
	 * find the number of clumps means if we get sequence with 2 or more same number than count  sequence in clump
	 * @param arr as a array of int type 
	 * @return count as a number of clumps
	 */
	public int countClumps(int[] arr){
		int i, count=1, clump=0, len=arr.length;
		if ( len == 0)
			throw new AssertionError();
		
		for ( i=0; i<len-1; i++ ){
			if ( arr[i] == arr[i+1] )
				count++;
			else
				if( count>=2 ){
					clump++;
					count=1;
				}
			}
		if ( count >=2 )
			clump++;
		return clump;
	}
	
	/**
	 * find the sequence in a way if x value occur than its next value is y and x index should not change
	 * @param arr as a array of int type 
	 * @param x value that is fixed
	 * @param y value that is fixed
	 */
	public int[] fixXY(int[] arr, int x, int y){
		int i, j, index, k=0, temp, len=arr.length, countX=0, countY=0;
		
		if ( len == 0 || arr[len-1] == x)
			throw new AssertionError();
		
		for ( i=0; i<len; i++){
			if ( (arr[i]==x && arr[i+1]==x) )
				throw new AssertionError();
			if ( arr[i]==x )
				countX++;
			if ( arr[i]==y )
				countY++;
		}
		if ( countX != countY )	
			throw new AssertionError();
		for ( i=0; i<len-1; i++ ){
			if ( arr[i]==x && arr[i+1]!=y ){
				index=i+1;
				for ( j=k; j<len; j++)
					if ( arr[j]==y ){
						temp=arr[j];
						arr[j]=arr[index];
						arr[index]=temp;
						k=index+1;
					}
			}
		}
		for ( i=0;i<len;i++)
			System.out.println(arr[i]);
		return arr;
	}
	
	/**
	 * find the index such that before and after values sum is equal 
	 * @param arr as a array of int type
	 * @return i+1 as a index of split array
	 * @return -1 if we don't get index 
	 */ 
	public int splitArray(int[] arr){
		int sum=0, midValue, total=0, i, len=arr.length;
		if ( len == 0 )
			throw new AssertionError();
		for ( i=0; i<len; i++)
			sum += arr[i];
		if ( sum%2 == 1 )
			return -1;
		midValue=sum/2;
		for ( i=0; i<arr.length; i++){
			total+=arr[i];
			if ( total == midValue)
				return i+1;
			if ( total > midValue)
				return -1;
		}
		return -1;
	}
}
