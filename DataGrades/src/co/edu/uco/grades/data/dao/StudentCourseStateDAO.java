package co.edu.uco.grades.data.dao;


import java.util.List;

import co.edu.uco.grades.dto.StudentCourseStateDTO;

public interface StudentCourseStateDAO {

	void create(StudentCourseStateDTO studentcoursestate);

	void update(StudentCourseStateDTO studentcoursestate);

	void delete(int id);

	List<StudentCourseStateDTO> find(StudentCourseStateDTO studentcoursestate);
}
