package assignment2;

public class Program {

	private String course;
	private int capacity;

	public Program(String course, int capacity) {
		this.course = course;
		this.capacity = capacity;
	}

	public String getCourse() {
		return course;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getCapacity() {
		return capacity;
	}
}
