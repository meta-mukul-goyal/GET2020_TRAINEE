package assignment2;

public class AllotedStudents {
	private String name;
	private String course;
	
	public AllotedStudents(String stuName, String stuCourse){
		this.name = stuName;
		this.course = stuCourse;
	}

	public String getName() {
		return name;
	}

	public String getCourse() {
		return course;
	}
}
