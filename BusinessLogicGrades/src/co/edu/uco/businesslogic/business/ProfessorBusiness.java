package co.edu.uco.businesslogic.business;

import java.util.List;

import co.edu.uco.grades.dto.ProfessorDTO;

public interface ProfessorBusiness {
	void create(ProfessorDTO professor);
	void update(ProfessorDTO professor);
	void delete(int id);
	List<ProfessorDTO> find(ProfessorDTO professor);
}
