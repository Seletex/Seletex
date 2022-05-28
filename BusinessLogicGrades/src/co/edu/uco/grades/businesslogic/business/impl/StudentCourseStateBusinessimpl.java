package co.edu.uco.grades.businesslogic.business.impl;

import java.util.List;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.grades.businesslogic.business.StudentCourseStateBusiness;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.data.factory.DAOFactory;
import co.edu.uco.grades.dto.StudentCourseStateDTO;
public class StudentCourseStateBusinessimpl implements StudentCourseStateBusiness {
	private DAOFactory daoFactory;
	public StudentCourseStateBusinessimpl() {
		if(UtilObject.getUtilObject().isNull(daoFactory)) {
			throw GradesException.buildTechnicalBusinessLogicException("It's not possible create a StudentBusinessimpl when the DAOFactory is null");
		}
		
	}
	@Override
	public void create(StudentCourseStateDTO state) {
		daoFactory.getStudentCourseStateDAO().create(state);
		
	}
	@Override
	public void update(StudentCourseStateDTO state) {
		daoFactory.getStudentCourseStateDAO().update(state);
		
	}
	@Override
	public void delete(int id) {
		daoFactory.getStudentCourseStateDAO().delete(id);
		
	}
	@Override
	public List<StudentCourseStateDTO> find(StudentCourseStateDTO state) {
		
		return daoFactory.getStudentCourseStateDAO().find(state);
	}
	

}