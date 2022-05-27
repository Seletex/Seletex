package co.edu.uco.businesslogic.business;

import java.util.List;

import co.edu.uco.grades.dto.StudentCourseDTO;

public interface StudentCourseBusiness {
	void create(StudentCourseDTO studentCourse);
	void update(StudentCourseDTO studentCourse);
	void delete(int id);
	List<StudentCourseDTO> find(StudentCourseDTO studentCourse);
}
