package assignment2;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.File;
import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.*;
import jxl.write.biff.RowsExceededException;
import jxl.CellType;

import java.util.ArrayList;
import java.io.FileNotFoundException;

public class Counseling {

	private static ArrayList<Program> listOfProgram = new ArrayList<>();
	private static ArrayList<AllotedStudents> allocatedStudent = new ArrayList<>();

	static boolean addProgram() throws FileNotFoundException, IOException, BiffException{

		String EXCEL_FILE_LOCATION = "C:\\Users\\Mukul\\workspace\\DSA2\\src\\assignment2\\Program.xls";
		Workbook workbook = null;

		workbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));
		Sheet sheet = workbook.getSheet(0);
		String programName = null;
		int capacity = 0;

		for (int i = 0; i < sheet.getRows(); i++) {
			for (int j = 0; j < sheet.getColumns(); j++) {
				Cell cell = sheet.getCell(j, i);
				CellType type = cell.getType();
				if (type == CellType.LABEL) {
					programName = cell.getContents();
				} else if (type == CellType.NUMBER) {
					capacity = Integer.parseInt(cell.getContents());
				}
			}
			Program p = new Program(programName, capacity);
			listOfProgram.add(p);
		}
		return true;
	}

	
	static boolean addStudent() throws FileNotFoundException, IOException,  BiffException{

		String EXCEL_FILE_LOCATION = "C:\\Users\\Mukul\\workspace\\DSA2\\src\\assignment2\\Student.xls";
		Workbook workbook = null;

		workbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));
		Sheet sheet = workbook.getSheet(0);
		String studentName;
		Student student;
		String[] preference;
		System.out.println(sheet.getRows());
		for (int i = 0; i < sheet.getRows(); i++) {
			preference = new String[5];
			Cell name = sheet.getCell(0, i);
			studentName = name.getContents();
			System.out.println(studentName);
			for (int j = 1; j < sheet.getColumns(); j++) {

				Cell cell = sheet.getCell(j, i);
				CellType type = cell.getType();
				if (type == CellType.LABEL) {
					preference[j - 1] = cell.getContents();		
				}
			}
			student= new Student(studentName, preference);
			Queue.enQueue(student);
		}
		return true;
	}

	
	static boolean allocate() throws IOException {
		boolean isAlloted = false;
		int count = 0;

		while (!Queue.isEmpty()) {
			System.out.println(count);
//			count++;
			Student student =  Queue.deQueue();
			isAlloted = false;

			for (int i = 0; i < student.getPreferedCourses().length; i++) {

				for (int j = 0; j < listOfProgram.size(); j++) {
					if ((student.getPreferedCourses()[i].equals(listOfProgram.get(j).getCourse()) && listOfProgram.get(j).getCapacity() > 0)) {
						allocatedStudent.add(new AllotedStudents(student.getName(),student.getPreferedCourses()[i]));
						listOfProgram.get(j).setCapacity(listOfProgram.get(j).getCapacity() - 1);
						isAlloted = true;
						break;
					}
				}
				if (isAlloted) {
					break;
				}
			}
		}
//		if(count==0)
//			return false;

		return true;
	}

	
	static boolean addToExcel() throws IOException,RowsExceededException,WriteException{
		WritableWorkbook workbook = Workbook.createWorkbook(new File(
				"AllocatedStudents.xls"));

		WritableSheet wSheet = workbook.createSheet("sheet1", 0);

		for (int i = 0; i < allocatedStudent.size(); i++) {
			String name = allocatedStudent.get(i).getName();
			Label labTemp1 = new Label(0, i, name);
			wSheet.addCell(labTemp1);
			System.out.println("Im in addToExcel()" + wSheet.getCell(0, i).getContents());
			String program = allocatedStudent.get(i).getCourse();
			Label labTemp2 = new Label(0, i, program);
			wSheet.addCell(labTemp2);
			System.out.println("Im in addToExcel()" + wSheet.getCell(0, i).getContents());
			workbook.write();
		}
		workbook.close();
		return true;
	}
}
