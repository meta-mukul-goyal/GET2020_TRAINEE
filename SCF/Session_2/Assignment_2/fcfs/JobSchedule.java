package fcfs;

public class JobSchedule {
	
	public void getCompletionTime(int[] at, int[] bt, int[] arr) {
		int ct=at[0],nop = at.length, i;
		for ( i=0; i<nop-1; i++){
			ct += bt[i];
			if ( ct < at[i+1]){
				arr[i] = ct;
				ct += at[i+1]-ct;
			}
			else
				arr[i] = ct;
		}
		arr[i] = ct+bt[i];
	}
	
	public void getWaitingTime(int[] at, int[] ct, int[] wt) {
		int i, nop = at.length;
		wt[0] = 0;
		for ( i=0; i<nop-1; i++){
			if ( ct[i] > at[i+1])
				wt[i+1] = ct[i]-at[i+1];
			else
				wt[i+1] = 0;
		}
	}
	
	public void getTurnAroundTime(int[] at, int[] ct, int[] tat) {
		int i, nop = at.length;
		tat[0] = 0;
		for ( i=0; i<nop-1; i++)
			tat[i] = ct[i]-at[i];
	}
}

	