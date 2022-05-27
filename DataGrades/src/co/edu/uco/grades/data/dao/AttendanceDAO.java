package co.edu.uco.grades.data.dao;

import java.util.List;

import co.edu.uco.grades.dto.AttendanceDTO;

public interface AttendanceDAO {
	void create(AttendanceDTO atten);

	void update(AttendanceDTO atten);

	void delete(int id);

	List<AttendanceDTO> find(AttendanceDTO atten);

}
