package DSA5_2;

public class EmployeeList {

	private static Employee header;

	static boolean addEmployee(String name, long data, int age){
		Employee newEmployee = new Employee(name, data, age);

		if(header == null){
			header = newEmployee;
		}
		else{
			Employee temp = header;
			while(temp.getNext() != null){
				temp = temp.getNext();
			}
			temp.setNext(newEmployee);
		}
		return true;
	}
	
	static boolean displayList() {
		if(header == null){
			return false;
		}
		Employee temp = header;
		while(temp != null){
			System.out.println("Name: "+ temp.getName() + " Salary: "+ temp.getSalary() + " Age: " + temp.getAge() +" -> ");
			temp = temp.getNext();
		}
		return true;
	}
	
	static void sortList(){
		QuickSort.sort(header, getLastElement());
	}
	
	private static Employee getLastElement(){
		Employee temp = header;
		while(temp.getNext()!=null){
			temp = temp.getNext();
		}
		return temp;
	}
}

