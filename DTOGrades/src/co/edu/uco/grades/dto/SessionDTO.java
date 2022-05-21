package co.edu.uco.grades.dto;

import java.sql.Date;



public class SessionDTO {
	private int id;
	private Date date;
	
	
	private SessionDTO(int id, Date date) {
		super();
		this.id = id;
		this.date = date;
	}
	private SessionDTO() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
