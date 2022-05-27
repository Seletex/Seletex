package co.edu.uco.grades.dto;

import java.sql.Date;



public class SessionDTO {
	private int id;
	private CourseDTO courseDTO;
	private Date date;
	
	public SessionDTO(int id, CourseDTO courseDTO, Date date) {
		super();
		setId(id);
		setCourseDTO(courseDTO);
		setDate(date);
	}
	public SessionDTO() {
		super();
		setCourseDTO(new CourseDTO());
		setDate(new Date(0));
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CourseDTO getCourseDTO() {
		return courseDTO;
	}
	public void setCourseDTO(CourseDTO courseDTO) {
		this.courseDTO = courseDTO;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
