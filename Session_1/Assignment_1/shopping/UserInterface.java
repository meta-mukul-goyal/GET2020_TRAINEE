package shopping;

import java.util.Scanner;

public class UserInterface {
	 public static void main(String[] args){
	    	UserCart item = new UserCart();
	    	Scanner ip = new Scanner(System.in);
	    	System.out.println("------Welcome-------");
	    	
	    	while(true){
	    	System.out.println("\nselect your operation:\n1. Add/update Item\n2. remove Item\n3. display item\n4. generate the bill:\n5. Exit\n");
	    	System.out.println("enter your operation serial number:");
	    	try {
	    		int num = ip.nextInt();
				switch(num){
				
					case 1: 
							item.show();
							System.out.println("enter the name of item:");
							String item_name = ip.next().toUpperCase();
							
							if ( item.checkName(item_name) ){
								System.out.println("enter the quantity of item:");
								int item_quantity = ip.nextInt();
								if ( item_quantity > 0 )
									item.add(item_name,item_quantity);
								else
									System.out.println("--->quantity value greater than 0");
							}
							else{
								System.out.println("--->Item Is Not Available");
							}
							break;
					
					case 2: System.out.print("enter the name of item You Want to Remove:\n");
							item_name = ip.next().toUpperCase();
							System.out.print("Enter the quantity:");
							int item_quan = ip.nextInt();
							item.remove(item_name, item_quan);
							break;
							
					case 3: item.display();
							break;
							
					case 4: item.bill();
							break;
					
					case 5: System.out.print("Thank You For The Purchasing");
							System.exit(0);
							break;
					
					default: System.out.print("--->You Enter Wrong Operation Serial Number: ");
							ip.close();
							break;
				}
			} catch (Exception e) {
				System.out.println("--->Your Input Is Not Valid");
				ip.nextLine();
			}
	    	}
	    }


}
