package assignment4;

import java.util.HashMap;

public class StringOpertion {
	private static HashMap<String, Integer> calculatedResult = new HashMap<>();
	
	private static int calculateUniqueCharacter(String str) {
		if (calculatedResult.containsKey(str))
			return calculatedResult.get(str);
		else{
			String newString = "";
			newString += str.charAt(0);
			for (int i=1; i<str.length(); i++){
				String temp = "";
				temp += str.charAt(i);
				if (!newString.contains(temp))
					newString += str.charAt(i);
			}
			calculatedResult.put(str, newString.length());
		}	
		return calculatedResult.get(str);
	}

	public static void main(String[] args){
		String str = "hello";
		System.out.println(calculateUniqueCharacter(str));
		System.out.println(calculateUniqueCharacter("hello"));
		System.out.println(calculateUniqueCharacter("mukulgoyal"));
		System.out.println(calculateUniqueCharacter("prakhar"));
		System.out.println(calculateUniqueCharacter("prakhargolania"));	
		System.out.println(calculateUniqueCharacter("prakhargolania"));	
	}
}
