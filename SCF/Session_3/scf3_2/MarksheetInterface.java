package scf3_2;

import java.util.Scanner;

public class MarksheetInterface {
	public static void main(String []args){
		Marksheet msObj = new Marksheet();
		Scanner ip = new Scanner(System.in);
		int nos=0;
		while(true){
		try {
			System.out.println("Enter Number of Student:");
			nos = ip.nextInt();
			break;
		}
		catch (Exception e) {
			System.out.println("Input is not valid");
			ip.nextLine();
	 	}
	}
		float grade[] = new float[nos];
		for ( int i=0; i<nos; i++){
			System.out.println("Enter Grade of Student " +(i+1) +":");
			grade[i] = ip.nextFloat();
		} 
		System.out.println("Average Marks: " + String.format("%,.2f",msObj.average(grade, nos)));
		System.out.println("Maximum Mark: " + String.format("%,.2f",msObj.max(grade, nos)));
		System.out.println("Minimum Mark: " + String.format("%,.2f",msObj.min(grade, nos)));
		System.out.println("Student Passed: " + String.format("%,.2f",msObj.passed(grade, nos)));
		ip.close();
	}
}
