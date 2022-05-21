package co.edu.uco.grades.dto;

import co.edu.uco.crosscutting.util.text.UtilText;

public class SubjectDTO {
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = (id < 0) ? 0:id;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = UtilText.getDefault(name);
	}

	private SubjectDTO(int id, String name) {
		super();
		setId(id);
		setName(name);
	}

	private SubjectDTO() {
		super();
		setName(UtilText.EMPTY);
	}
	

}
