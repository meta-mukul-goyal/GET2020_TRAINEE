package SCF9;

import java.util.*;

public class PerimeterComparator implements Comparator<Shape> {
	public int compare(Shape s1,Shape s2){  
		if(s1.getPerimeter()==s2.getPerimeter())  
			return 0;  
		else if(s1.getPerimeter()>s2.getPerimeter())  
			return 1;  
		else  
			return -1;  
	}
}
