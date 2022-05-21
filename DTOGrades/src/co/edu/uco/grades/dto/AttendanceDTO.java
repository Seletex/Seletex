package co.edu.uco.grades.dto;

public class AttendanceDTO {
	
	private int id;
	private StudentCourseDTO studentcourse;
	private SessionDTO session;
	private boolean attended;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public StudentCourseDTO getStudentcourse() {
		return studentcourse;
	}
	public void setStudentcourse(StudentCourseDTO studentcourse) {
		this.studentcourse = studentcourse;
	}
	public SessionDTO getSession() {
		return session;
	}
	public void setSession(SessionDTO session) {
		this.session = session;
	}
	public boolean isAttended() {
		return attended;
	}
	public void setAttended(boolean attended) {
		this.attended = attended;
	}
	private AttendanceDTO(int id, StudentCourseDTO studentcourse, SessionDTO session, boolean attended) {
		super();
		this.id = id;
		this.studentcourse = studentcourse;
		this.session = session;
		this.attended = attended;
	}
	private AttendanceDTO() {
		super();
	}
	
	

}
