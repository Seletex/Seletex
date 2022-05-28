package co.edu.uco.grades.businesslogic.business;

import java.util.List;

import co.edu.uco.grades.dto.CourseDTO;

public interface CourseBusiness {
		void open(CourseDTO course);
		List<CourseDTO> find(CourseDTO course);
	
}
