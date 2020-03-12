package SCF9;

import java.util.Comparator;


public class TimeStampComparator implements Comparator<Shape> {
	public int compare(Shape s1,Shape s2){  
		if(s1.getTimeStamp()==s2.getTimeStamp())
			return 0;  
		else if(s1.getTimeStamp().after(s2.getTimeStamp()))  
			return 1;  
		else
			return -1;  
	}
}
