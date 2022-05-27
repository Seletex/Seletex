package co.edu.uco.grades.dto;

public class StudentCourseDTO {
	private int id;
	private StudentDTO studen;
	private CourseDTO course;
	private StudentCourseStateDTO state;
	
	
	
	
	public StudentCourseDTO(int id, StudentDTO studen, CourseDTO course, StudentCourseStateDTO state) {
		super();
		setId(id);
		setStuden(studen);
		setCourse(course);
		setState(state);
	}
	public StudentCourseDTO() {
		super();
		setStuden(new StudentDTO());
		setCourse(new CourseDTO());
		setState(new StudentCourseStateDTO());
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id =  id;
	}
	public StudentDTO getStuden() {
		return studen;
	}
	public void setStuden(StudentDTO studen) {
		this.studen = studen;
	}
	public CourseDTO getCourse() {
		return course;
	}
	public void setCourse(CourseDTO course) {
		this.course = course;
	}
	public StudentCourseStateDTO getState() {
		return state;
	}
	public void setState(StudentCourseStateDTO state) {
		this.state = state;
	}
	

}
