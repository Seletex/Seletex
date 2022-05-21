package co.edu.uco.grades.data.dao;


import co.edu.uco.grades.dto.StudentCourseDTO;

public interface StudentCourseDAO {

	void create(StudentCourseDTO studentcourse);

	void update(StudentCourseDTO studentcourse);

	void delete(int id);

	void find(StudentCourseDTO studentcourse);
}
