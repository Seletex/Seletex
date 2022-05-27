package co.edu.uco.businesslogic.business;

import java.util.List;

import co.edu.uco.grades.dto.StudentCourseStateDTO;

public interface StudentCourseStateBusiness {
	void create(StudentCourseStateDTO state);
	void update(StudentCourseStateDTO state);
	void delete(int id);
	List<StudentCourseStateDTO> find(StudentCourseStateDTO state);
}
