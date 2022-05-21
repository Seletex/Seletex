package co.edu.uco.grades.dto;

public class StudentCourseDTO {
	private int id;
	private int state;
	private StudentDTO student;
	private CourseDTO course;
	
	private StudentCourseDTO() {
		super();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public StudentDTO getStudent() {
		return student;
	}

	public void setStudent(StudentDTO student) {
		this.student = student;
	}

	public CourseDTO getCourse() {
		return course;
	}

	public void setCourse(CourseDTO course) {
		this.course = course;
	}

	private StudentCourseDTO(int id, int state, StudentDTO student, CourseDTO course) {
		super();
		this.id = id;
		this.state = state;
		this.student = student;
		this.course = course;
	}

}
