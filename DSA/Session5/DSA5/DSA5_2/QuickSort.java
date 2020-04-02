package DSA5_2;

public class QuickSort {

	private static Employee partitionLast(Employee start, Employee end) 
	{ 
		if(start == end ||  
				start == null || end == null) 
			return start; 

		Employee pivot_prev = start; 
		Employee curr = start;  
		long pivot = end.getSalary();  

		while(start != end ) 
		{ 
			if(start.getSalary() > pivot) 
			{  
				pivot_prev = curr;  
				long tempSal = curr.getSalary();  
				curr.setSalary(start.getSalary());  
				start.setSalary(tempSal);

				String tempName = curr.getName();
				curr.setName(start.getName());
				start.setName(tempName);

				int tempAge = curr.getAge();
				curr.setAge(start.getAge());
				start.setAge(tempAge);
				curr = curr.getNext();  
			} 
			start = start.getNext();  
		} 
		long tempSal = curr.getSalary();  
		curr.setSalary(pivot);  
		end.setSalary(tempSal); 

		String tempName = curr.getName();
		curr.setName(end.getName());
		end.setName(tempName);

		int tempAge = curr.getAge();
		curr.setAge(end.getAge());
		end.setAge(tempAge);

		curr = curr.getNext();

		return pivot_prev; 
	} 

	static void sort(Employee start, Employee end) 
	{ 
		if(start == end ) 
			return; 

		Employee pivot_prev = partitionLast(start, end); 
		sort(start, pivot_prev); 

		if( pivot_prev != null && pivot_prev == start ) 
			sort(pivot_prev.getNext(), end); 
		else if(pivot_prev != null && pivot_prev.getNext() != null) 
			sort(pivot_prev.getNext().getNext(), end); 
	}

}
