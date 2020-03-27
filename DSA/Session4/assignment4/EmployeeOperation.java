package assignment4;

import java.util.ArrayList;
import java.util.Collections;

public class EmployeeOperation {
	private static ArrayList<EmployeeDetail> employeeList = new ArrayList<>();
	
	private static String addEmployee(int id, String EmployeeName, String address) {
		for (int i=0; i<employeeList.size(); i++)
			if (employeeList.get(i).employeeId == id)
				return "Employee Exist";
		EmployeeDetail newEmployee = new EmployeeDetail(id, EmployeeName, address);
		employeeList.add(newEmployee);
		return "Added Successfully";
	}
	
	private static void display() {			
		for (EmployeeDetail employee : employeeList)
			System.out.println("Id: " + employee.employeeId + ", Employee Name: "+employee.name + ", Address: "+ employee.address);
	}
	
	private static void sortEmployeeById() {
		 Collections.sort(employeeList, new SortById());
		 display();
	}
	
	private static void sortEmployeeByName() {
		Collections.sort(employeeList, new SortByName());
		display();
	}
	
	public static void main(String[] args){
		System.out.println(addEmployee(2,"prakhar","kota"));
		System.out.println(addEmployee(6,"mridul","bilwara"));
		System.out.println(addEmployee(1,"mukul","dholpur"));
		System.out.println(addEmployee(4,"pradeep","jaipur"));
		System.out.println(addEmployee(3,"martand","jaipur"));
		System.out.println(addEmployee(3,"nishant","patna"));
		System.out.println(addEmployee(1,"monit","muzzafpur"));
		System.out.println(addEmployee(5,"tushar","dholpur"));
		System.out.println(addEmployee(7,"abhinav","devli"));
		System.out.println("Employee List:");
		display();
		System.out.println("Sorted by Employee ID:");
		sortEmployeeById();
		System.out.println("Sorted by Employee Name:");
		sortEmployeeByName();
	}

}
