package View;
import java.util.Scanner;

import enum_package.Status;
import Controller.*;
import Facade.Product;

public class Interface {
	
	public static void displayItemList(){
		System.out.println("Product Code\tType\t\tName\t\tPrice ");
		System.out.println("-------------------------------------------------------------");
		for(Product product : ProjectController.displayItemList())
			System.out.println(product.getProductCode()+"\t\t"+product.getType()+"\t\t"+product.getName()+"\t\t"+product.getPrice());
		System.out.println("\nWhich Item You Want You Add:");
	}
	
	public static void displayUserCart(){								// TO DISPLAY THE USER CART
		if ( ProjectController.displayUserCart().isEmpty() )
			System.out.println(Status.CARD_IS_EMPTY);
		else{
			System.out.println("your cart with items:");
			System.out.println("--------------------------------------");
			System.out.println("Item Product Code\tItem quantity ");
			System.out.println("--------------------------------------");
			for ( int ProductCode : ProjectController.displayUserCart().keySet())
				System.out.println(ProductCode + "\t\t\t"+ ProjectController.displayUserCart().get(ProductCode));
		}
	}
	
	 public static void main(String[] args){	
		Scanner ip = new Scanner(System.in);
		while(true){
		System.out.println("\nselect your operation:\n1. Add/update Item\n2. remove Item\n3. Display User Cart\n4. Exit\n");
		System.out.println("enter your operation serial number:");
		try {
			int num = ip.nextInt();
			switch(num){
				case 1: Interface.displayItemList();
						System.out.println("enter the code of item:");
						int productCode = ip.nextInt();
						if ( ProjectController.checkProductCode(productCode) ){
							System.out.println("enter the quantity of item:");
							int item_quantity = ip.nextInt();
							if ( item_quantity > 0 )
								System.out.println(ProjectController.add(productCode,item_quantity));
							else
								System.out.println("--->quantity value greater than 0");
						}
						else
							System.out.println(Status.ITEM_IS_NOT_AVAILABLE);
						break;
				
				case 2: System.out.print("enter the name of item You Want to Remove:\n");
						productCode = ip.nextInt();
						System.out.print("Enter the quantity:");
						int item_quan = ip.nextInt();
						System.out.println(ProjectController.remove(productCode, item_quan));
						break;
						
				case 3: Interface.displayUserCart();
						break;
				
				case 4: System.out.print("Thank You For The Purchasing");
				 		ip.close();
						System.exit(0);
						
				default: System.out.print("--->You Enter Wrong Operation Serial Number ");
						 break;
				}
			} catch (Exception e) {
				System.out.println(Status.INPUT_IS_NOT_VALID);
				ip.nextLine();
			 }
		}	

	 }

	
}
