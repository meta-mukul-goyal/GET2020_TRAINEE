package scf3_1;

public class StringOperation {
	
	/**
	 * compare two newStringing 
	 * @param firstString newStringing compare to secondString
	 * @param secondString newStringing compare to firstString	
	 * @return 1 when two newStringing are equal such that firstString = secondString 
	 * @return 0 such that firstString != secondString
	 */
	public int compareEqual(String firstString, String secondString){
		for ( int i=0; i<firstString.length(); i++){
			if ( firstString.charAt(i) != secondString.charAt(i))
				return 0;
		}
		return 1;
	}
	
	/**
	 * reverse the newStringing
	 * @param firstString as a input  
	 * @return newString as a reversed String
	 */
	public String reverse(String firstString){
		String newString="";
		for ( int i=firstString.length()-1; i>=0; i--)
			newString += firstString.charAt(i);
		return newString;
	}
	
	/**
	 * convert lower char to upper char and vice-versa
	 * @param firstString take as a input
	 * @return newString as a converted string
	 */
	public String upperLower(String firstString){
		String newString="";
		for ( int i=0; i<firstString.length(); i++){
			char ch = firstString.charAt(i);
			if ( ch >= 97 && ch <= 122)
				ch-=32;
			else if( ch >= 65 && ch <= 90)
				ch+=32;
			newString += ch;
		}
		return newString;
	}
	
	/**
	 * find a longest word in a newStringing and if two word are of same length return ahead string
	 * @param firstString as a input  
	 * @return newString as a longest string
	 */
	public String largestWord(String firstString){
		int count=0, max=-1, j=0, i, len=firstString.length();
		for ( i=0; i<len; i++ ){
			if( firstString.charAt(i) != ' ' && i!=len-1 )
				count++;
			else{
				if(i==len-1){
					count++;
					i++;
				}
				if( count >= max ){
					max=count;
					j=i-max;
				}
				count=0;
			}
		}
		String newString="";
		for( i=j; i<j+max; i++ )
			newString+=firstString.charAt(i);
		return newString;
	}
}
