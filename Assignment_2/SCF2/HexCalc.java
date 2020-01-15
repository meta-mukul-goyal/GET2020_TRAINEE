package SCF2;

public class HexCalc {
	
	String str = "0123456789ABCDEF";
	
	public boolean checkValid( String hex1 ){
		char ch;
		for ( int i=0; i<hex1.length(); i++ ){
			ch = hex1.charAt(i);
			if ( !( (ch>48 && ch<=57) || (ch>=65 && ch<=70) ) )
			{
				System.out.println("*****Enter the Valid Number*****");
				 return false;
			}
		}
		return true;
	}
	
	public int hexaToDecimal(String hex1, int base){			// CONVERT HEXADECIMAL TO DECIMAL
		int num = 0, t=1;
		char ch;
		for ( int i = hex1.length()-1; i >=0 ; i--)
		{
			ch = hex1.charAt(i);
			num += str.indexOf(ch)*t;
			t=t*base;		
		}
		return num;
	}

	public String decimalToHexa(int hex1, int base){			// CONVERT DECIMAL TO HEXADECIMAL 
		String s = "";
		int rem;
		while ( hex1 > 0){
			rem = hex1 % base;
			s = str.charAt(rem) + s;
			hex1 = hex1/ base;
		}
		return s;
	}

	public String add(int num1, int num2, int base ){			// ADD TWO HEXADECIMAL
		return decimalToHexa(num1 + num2, base );
	}

	public String subtract(int num1, int num2, int base){		// SUBTRACT TWO HEXADECIMAL		
		return decimalToHexa(Math.abs(num1 - num2), base);
	}

	public String multiply(int num1, int num2, int base){		// MULTIPLY TWO HEXADECIMAL
		return decimalToHexa(num1 * num2, base);
	}
	
	public String divide(int num1, int num2, int base){		// DIVIDE TWO HEXADECIMAL
		return decimalToHexa(num1 / num2, base);
	}
	
	public void compare(String hex1, String hex2){
		int len1 = hex1.length()-1;
		int len2 = hex2.length()-1;
		if ( len1 > len2 )
			System.out.println(hex1+ " is greater than "+ hex2);
		else if( len1 < len2)
			System.out.println(hex1+ " is less than "+ hex2);
		else if( hex1.equals(hex2))
			System.out.println(hex1+ " is equal to "+ hex2);
		else if ( len1 == len2){
			for ( int i=0; i < len1; i++){
				if ( hex1.charAt(i) == hex2.charAt(i) )
					continue;
				if ( hex1.charAt(i) > hex2.charAt(i)){
					System.out.println(hex1+ " is greater than "+ hex2);
					break;
				}
				else{
					System.out.println(hex1+ " is less than "+ hex2);
					break;
				}
			}
			
		}
	}
}

