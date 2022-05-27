package co.edu.uco.grades.dto;

import co.edu.uco.crosscutting.util.numeric.UtilNumeric;

public class AttendanceDTO {
	
	private int id;
	private StudentCourseDTO studenCourseDTO;
	private SessionDTO sessionDTO;
	private byte attended;
	
	
	public AttendanceDTO(int id, StudentCourseDTO studenCourseDTO, SessionDTO sessionDTO, byte attended) {
		super();
		setId(id);
		setStudenCourseDTO(studenCourseDTO);
		setSessionDTO(sessionDTO);
		setAttended(attended);
	}
	public AttendanceDTO() {
		super();
		setStudenCourseDTO(new StudentCourseDTO());
		setSessionDTO(new SessionDTO());
		setAttended(UtilNumeric.ZERO);
	}
	
	public int getId() {
		return id;
	}
	public StudentCourseDTO getStudenCourseDTO() {
		return studenCourseDTO;
	}
	public SessionDTO getSessionDTO() {
		return sessionDTO;
	}
	public byte getAttended() {
		return attended;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setStudenCourseDTO(StudentCourseDTO studenCourseDTO) {
		this.studenCourseDTO =studenCourseDTO;
	}
	public void setSessionDTO(SessionDTO sessionDTO) {
		this.sessionDTO = sessionDTO;
	}
	public void setAttended(byte attended) {
		this.attended = attended;
	}
	

}
