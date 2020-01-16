package scf3_2;

public class Marksheet {
	
	/**
	 * find average of given marks
	 * @param grade array of int type and to get mark
	 * @param numberOfStudent number of student of int type
	 * @return averge of marks of float type variable
	 */
	public float average(float[] grade, int numberOfStudent){
		float total=0;
		for (int i=0; i<numberOfStudent; i++){
			total += grade[i];
		}
		return total/numberOfStudent;
	}
	
	/**
	 * find maximum in a grade
	 * @param grade array of marks
	 * @param numberOfStudent number of student of int type
	 * @return maximun mark of float type variable
	 */
	public float max(float[] grade, int numberOfStudent){
		float max=0;
		for (int i=0; i<numberOfStudent; i++){
			if ( grade[i] > max )
				max = grade[i];
		}
		return max;
	}
	
	/**
	 * find minimum mark in a grade
	 * @param grade array of marks of float type array
	 * @param numberOfStudent number of student of int type
	 * @return minimum mark of float type variable
	 */
	public float min(float[] grade, int numberOfStudent){
		float min=101;
		for (int i=0; i<numberOfStudent; i++){
			if ( grade[i] < min )
				min = grade[i];
		}
		return min;
	}
	
	/**
	 * find student passed the exam
	 * @param grade array of marks of float type array
	 * @param numberOfStudent number of student of int type
	 * @return percentage of passed students of float type variable
	 */
	public float passed(float[] grade, int numberOfStudent){
		float num=0;
		for (int i=0; i<numberOfStudent; i++){
			if ( grade[i] > 40  )
				num+=1;
		}
		return (num/numberOfStudent)*100;
	}
	
}
