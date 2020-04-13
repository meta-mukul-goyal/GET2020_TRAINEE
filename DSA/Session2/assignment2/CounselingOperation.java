package assignment2;

import java.io.IOException;

import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class CounselingOperation {

	public static void main(String[] args) throws IOException, WriteException, BiffException {
		Counseling.addProgram();
		Counseling.addStudent();
		Counseling.allocate();
		Counseling.addToExcel();
	}
}
