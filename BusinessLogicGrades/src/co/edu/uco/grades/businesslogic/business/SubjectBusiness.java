package co.edu.uco.grades.businesslogic.business;

import java.util.List;
import co.edu.uco.grades.dto.SubjectDTO;

public interface SubjectBusiness {
	void create(SubjectDTO subject);
	void update(SubjectDTO subject);
	void delete(int id);
	List<SubjectDTO> find(SubjectDTO subject);
}
