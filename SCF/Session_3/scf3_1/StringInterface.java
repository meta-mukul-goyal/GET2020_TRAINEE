package scf3_1;

import java.util.Scanner;

public class StringInterface {
	public static void main(String []args){
		StringOperation soObj = new StringOperation();
		Scanner ip = new Scanner(System.in);
		String s1, s2;
		int num;
		System.out.println("Enter First String: ");			
		s1 = ip.nextLine();
		System.out.println("Enter Second String: ");	
		s2 = ip.nextLine();
		while(true){
			
			System.out.println("\nselect your operation:\n1. Compare Equal\n2. Reverse String\n3. Upper Lower Case\n4. Largest Word of a String\n5. Exit\n");
			System.out.println("enter your operation serial number:");
			try {
				num = ip.nextInt();

				switch(num){

					case 1: System.out.println(soObj.compareEqual(s1, s2));
							break;

					case 2: System.out.println("Reverse String---> " + soObj.reverse(s1));
							break;
				
					case 3: System.out.println("Upper Lower String---> " + soObj.upperLower(s1));
							break;
					
					case 4: System.out.println("Largest Word in a String--->"+ soObj.largestWord(s1));
							break;
							
					case 5: System.out.println("All Done");
							System.exit(0);
							ip.close();
							break;
							
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
