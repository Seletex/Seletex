package co.edu.uco.grades.api.validators;

import java.util.List;

public interface Validator <D>{
	List<String> validate(D dto);

}
