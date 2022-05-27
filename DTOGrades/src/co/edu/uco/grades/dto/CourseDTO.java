package co.edu.uco.grades.dto;

import java.sql.Date;

public class CourseDTO {
	private int id;
	private SubjectDTO subject;
	private ProfessorDTO professor;
	private Date initialDate;
	private Date finalDate;
	private CourseDTO(int id, SubjectDTO subject, ProfessorDTO professor, Date initialDate, Date finalDate) {
		super();
		this.id = id;
		this.subject = subject;
		this.professor = professor;
		this.initialDate = initialDate;
		this.finalDate = finalDate;
	}
	public CourseDTO() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public SubjectDTO getSubject() {
		return subject;
	}
	public void setSubject(SubjectDTO subject) {
		this.subject = subject;
	}
	public ProfessorDTO getProfessor() {
		return professor;
	}
	public void setProfessor(ProfessorDTO professor) {
		this.professor = professor;
	}
	public Date getInitialDate() {
		return initialDate;
	}
	public void setInitialDate(Date initialDate) {
		this.initialDate = initialDate;
	}
	public Date getFinalDate() {
		return finalDate;
	}
	public void setFinalDate(Date finalDate) {
		this.finalDate = finalDate;
	}
	

}
