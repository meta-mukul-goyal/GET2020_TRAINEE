package fcfs;

import java.util.Scanner;

public class JobInterface {
	public static void main(String []args){
		JobSchedule jsObj = new JobSchedule();
		Scanner ip = new Scanner(System.in);
		int numOfProcess, i;
		while (true){
			System.out.println("Enter the Number of Process:");
			numOfProcess = ip.nextInt();
			if ( numOfProcess > 0  )
				break;
			System.out.println("Input is not Valid");
		}
		float totalWaitingTime=0;
		int arrivalTime[] = new int[numOfProcess];
		int burstTime[] = new int[numOfProcess];
		int completeTime[] = new int[numOfProcess];
		int waitingTime[] = new int[numOfProcess];
		int turnAroundTime[] = new int[numOfProcess];
		for ( i=0 ; i<numOfProcess; i++){
			System.out.println("Enter the Arrival Time:");
			arrivalTime[i] = ip.nextInt();
			System.out.println("Enter the Burst Time:");
			burstTime[i] = ip.nextInt();
		}
		
		jsObj.getCompletionTime(arrivalTime, burstTime, completeTime);
		jsObj.getWaitingTime(arrivalTime, completeTime, waitingTime);
		jsObj.getTurnAroundTime(arrivalTime, completeTime, turnAroundTime);
		System.out.println("\nProcess\t\tCompletion Time\t\tWaiting Time\t\tTurn Around Time");
		for( i=0 ; i<numOfProcess; i++){
			System.out.println("P" + (i+1)+ "\t\t\t" + completeTime[i] + "\t\t\t"+ waitingTime[i] + "\t\t\t"+ turnAroundTime[i]);
		}
		int max=-1;
		for( i=0 ; i<numOfProcess; i++){
			if ( waitingTime[i] > max )
				max = waitingTime[i];
			totalWaitingTime +=  waitingTime[i];
		}
		System.out.println("\nAverage Waiting Time: " + (totalWaitingTime/numOfProcess));
		
		System.out.println("\nMaximum waiting time period: " + max);
		ip.close();
		}
}
