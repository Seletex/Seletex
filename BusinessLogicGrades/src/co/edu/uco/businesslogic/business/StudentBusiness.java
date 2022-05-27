package co.edu.uco.businesslogic.business;

import java.util.List;

import co.edu.uco.grades.dto.StudentDTO;

public interface StudentBusiness {
	void create(StudentDTO student);
	void update(StudentDTO student);
	void delete(int id);
	List<StudentDTO> find(StudentDTO student);
}
