package co.edu.uco.businesslogic.business.impl;

import java.util.List;

import co.edu.uco.businesslogic.business.AttendanceBusiness;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.data.factory.DAOFactory;
import co.edu.uco.grades.dto.AttendanceDTO;

public class AttendanceBusinessImpl implements AttendanceBusiness {

	private DAOFactory daoFactory;
	
	public void AttendanceBusinessimpl() {
		if(UtilObject.getUtilObject().isNull(daoFactory)) {
			throw GradesException.buildTechnicalBusinessLogicException("It's not possible create a AttendanceBusinessimpl when the DAOFactory is null");
		}
		
	}
	@Override
	public void create(AttendanceDTO attendance) {
		daoFactory.getAttendanceDAO().create(attendance);
		
	}

	@Override
	public void update(AttendanceDTO attendance) {
		daoFactory.getAttendanceDAO().update(attendance);
		
	}

	@Override
	public void delete(int id) {
		daoFactory.getAttendanceDAO().delete(id);
		
	}

	@Override
	public List<AttendanceDTO> find(AttendanceDTO attendance) {
		return daoFactory.getAttendanceDAO().find(attendance);
	}
}
