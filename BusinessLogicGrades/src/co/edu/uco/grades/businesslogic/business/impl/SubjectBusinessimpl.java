package co.edu.uco.grades.businesslogic.business.impl;

import java.util.List;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.grades.businesslogic.business.SubjectBusiness;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.data.factory.DAOFactory;
import co.edu.uco.grades.dto.SubjectDTO;

public class SubjectBusinessimpl implements SubjectBusiness {
	private DAOFactory daoFactory;
	public SubjectBusinessimpl() {
		if(UtilObject.getUtilObject().isNull(daoFactory)) {
			throw GradesException.buildTechnicalBusinessLogicException("It's not possible create a StudentCourseBusinessimpl when the DAOFactory is null");
		}
		
	}
	@Override
	public void create(SubjectDTO subject) {
		daoFactory.getSubjectDAO().create(subject);
		
	}
	@Override
	public void update(SubjectDTO subject) {
		daoFactory.getSubjectDAO().update(subject);
		
	}
	@Override
	public void delete(int id) {
		daoFactory.getSubjectDAO().delete(id);
		
	}
	@Override
	public List<SubjectDTO> find(SubjectDTO subject) {
		return  daoFactory.getSubjectDAO().find(subject);
		
	}
}
