package SCF2;

import java.util.Scanner;

public class HexInterface {
	public static void main(String []args){
		HexCalc obj = new HexCalc();
		Scanner ip = new Scanner(System.in);
		int num1 = 0, num2 = 0;
		System.out.println("Enter the Base of the Number: ");
		int base = ip.nextInt();
		
		while(true){
			System.out.println("Enter First Hexa Decimal Number: ");
			String hex1, hex2;			
			while (true){
				hex1 = ip.next().toUpperCase();
				if ( obj.checkValid( hex1 ) )
					break;
			}
			
			System.out.println("Enter Second Hexa Decimal Number: ");
			while (true){
				hex2 = ip.next().toUpperCase();
				if ( obj.checkValid( hex2 ) )
					break;
			}
			
			System.out.println("\nselect your operation:\n1. Add\n2. Subtact\n3. Multiply\n4. Divide\n5. Decimal to Hexadecimal\n6. Hexadecimal to Decimal\n7. compare Hexadecimal Numbers\n8. Exit\n");
			System.out.println("enter your operation serial number:");
			try {
				int num = ip.nextInt();

				if ( num == 1 || num == 2 || num == 3 || num == 4 || num == 5 || num == 6){
						num1 = obj.hexaToDecimal(hex1, base);
						System.out.println(num1);
						num2 = obj.hexaToDecimal(hex2, base);
						System.out.println(num2);
				}

				switch(num){

					case 1: System.out.println("Addition of two hex: "+ obj.add(num1, num2, base));
							break;

					case 2: System.out.println("Subtract of two hex: "+ obj.subtract(num1, num2, base));
							break;
				
					case 3: System.out.println("Multiply of two hex: "+ obj.multiply(num1, num2, base));
							break;
					
					case 4: System.out.println("Divide of two hex: "+ obj.divide(num1, num2, base));
							break;
							
					case 5: System.out.println("Decimal to Hexadecimal: ");
							System.out.println("First Number: "+ num1); 
							System.out.println("Second Number: "+ num2); 
							break;
							
					case 6: System.out.println("Hexadecimal to Decimal: ");
							System.out.println("First Number: "+ num1); 
							System.out.println("Second Number: "+ num2); 
							break;
							
					case 7: obj.compare(hex1, hex2);
							break;
					
					case 8: System.out.println("All Done");
					 		ip.close();
							System.exit(0);
					
					default: System.out.println("--->You Enter Wrong Operation Serial Number: ");
							 break;
				}
			} catch (Exception e) {
				System.out.println("--->Your Input Is Not Valid");
				ip.nextLine();
				
			}			
		}
	}

}
