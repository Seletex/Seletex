package co.edu.uco.grades.data.dao;

import co.edu.uco.grades.dto.AttendanceDTO;

public interface AttendanceDAO {
	void create(AttendanceDTO atten);

	void update(AttendanceDTO atten);

	void delete(int id);

	void find(AttendanceDTO atten);

}
