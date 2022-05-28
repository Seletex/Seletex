package co.edu.uco.grades.dto;

import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;

public class IdTypeDTO {

	private int id;
	private String name;

	public IdTypeDTO() {
		super();
		setName(UtilText.EMPTY);
	}

	public IdTypeDTO(int id, String name) {
		super();
		setId(id);
		setName(name);
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
		this.name = UtilText.getDefault(name);
	}
	
	public List<String> validateName(List<String> validationMessage){
		validationMessage = UtilObject.getUtilObject().getDefault(validationMessage, new ArrayList<>());
		if(UtilText.isEmpty(getName())) {
			validationMessage.add("Name of id type is required");
		}else if(UtilText.getDefault(name).length() > 50){
			validationMessage.add("Lenght of name of id type must be less o equals to 50 characters");
		}else if(UtilText.getDefault(getName()).matches("^[a-zA-ZÒ—·¡]*$")) {
			validationMessage.add("Name of id type contains invalid characters");
		}
		return null;
	}
}