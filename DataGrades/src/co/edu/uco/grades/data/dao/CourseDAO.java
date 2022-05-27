package co.edu.uco.grades.data.dao;

import java.util.List;

import co.edu.uco.grades.dto.CourseDTO;

public interface CourseDAO {

	void open(CourseDTO course);

	List<CourseDTO> find(CourseDTO course);

}
