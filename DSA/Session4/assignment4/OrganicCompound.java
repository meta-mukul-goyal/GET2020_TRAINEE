package assignment4;

public class OrganicCompound {
	private static int nOfC, nOfH, nOfO;
	
	private static void massCalculate(String str, int value) {
		int i=0; 
		while (i < str.length()){
			char ch = str.charAt(i);
			if (ch == '('){
				String subString = "";
				while (str.charAt(++i) != ')')
					subString += str.charAt(i);
				if (Character.isDigit(str.charAt(++i))){
					int value1 = Integer.valueOf(str.charAt(i++))-'0';
					massCalculate(subString, value1);
				}
				else
					massCalculate(subString, value);
				ch = str.charAt(i);
			}
			
			if (ch == 'c'){
				if (Character.isDigit(str.charAt(i+1)) && str.charAt(i+1) != ' ')
					nOfC += (Integer.valueOf(str.charAt(i+1))-'0')*value;
				else
					nOfC += 1*value;
			}
			if (ch == 'o'){
				if (Character.isDigit(str.charAt(i+1)) && str.charAt(i+1) != ' ')
					nOfO += (Integer.valueOf(str.charAt(i+1))-'0')*value;
				else
					nOfO += 1*value;
			}
			if (ch == 'h'){
				if (Character.isDigit(str.charAt(i+1)) && str.charAt(i+1) != ' ')
					nOfH += (Integer.valueOf(str.charAt(i+1))-'0')*value;
				else
					nOfH += 1*value;
			}
			i++;
		}
	}
	
	private static void massFormula() {
		int massOfCarbon=12, massOfHydrogen=1, massOfOxygen=16;
		System.out.println("molecular mass of compound is: "+ (massOfCarbon*nOfC + massOfHydrogen*nOfH + massOfOxygen*nOfO));
	}

	public static void main(String[] args){
		String str = "c2h3(ch3)4c2h4";
		massCalculate(str+" ", 1);
		massFormula();
	}

}
