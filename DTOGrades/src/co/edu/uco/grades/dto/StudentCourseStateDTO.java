package co.edu.uco.grades.dto;

public class StudentCourseStateDTO {
	
	private int id;
	private String name;
	private StudentCourseStateDTO(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	private StudentCourseStateDTO() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	

}
