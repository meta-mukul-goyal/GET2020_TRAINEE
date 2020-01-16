package scf3_3;

import java.util.Scanner;

public class AreaInterface {
	public static void main(String []args){
		Area areaObj = new Area();
		Scanner ip = new Scanner(System.in);
		double width, height;
		while(true){
			try {
				System.out.println("Enter Width:");
				width = ip.nextDouble();
				break;
			}
			catch (Exception e) {
				System.out.println("Input is not valid");
				ip.nextLine();
		 	}
		}
		while(true){
			try {
				System.out.println("Enter Height:");
				height = ip.nextDouble();
				break;
			}
			catch (Exception e) {
				System.out.println("Input is not valid");
				ip.nextLine();
		 	}
		}

		while(true){
			System.out.println("\nselect your operation:\n1. Area of Triangle\n2. Area of Rectangle\n3. Area of Square\n4. Area of Circle\n5. Exit\n");
			System.out.println("enter your operation serial number:");
			int num = ip.nextInt();

			switch(num){

				case 1: System.out.println("Area of Triangle: "+ areaObj.triangleArea(width, height));
						break;

				case 2: System.out.println("Area of Rectangle: "+ areaObj.rectangleArea(width, height));
						break;
		
				case 3: System.out.println("Area of Square: "+ areaObj.squareArea(width));
						break;
				
				case 4: System.out.println("Enter Radius:");
						double radius = ip.nextDouble();
						System.out.println("Area of Circle: "+ areaObj.circleArea(radius));
						break;
						
				case 5: System.out.println("All Done");
						System.exit(0);
						ip.close();
						break;
						
				default: System.out.println("--->You Enter Wrong Operation Serial Number: ");
						 break;
			}
		}
	}
}
