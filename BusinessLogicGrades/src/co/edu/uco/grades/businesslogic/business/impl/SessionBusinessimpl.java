package co.edu.uco.grades.businesslogic.business.impl;

import java.util.List;

import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.grades.businesslogic.business.SessionBusiness;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.data.factory.DAOFactory;
import co.edu.uco.grades.dto.SessionDTO;

public class SessionBusinessimpl implements SessionBusiness {
	private DAOFactory daoFactory;

	public SessionBusinessimpl() {
		if(UtilObject.getUtilObject().isNull(daoFactory)) {
			throw GradesException.buildTechnicalBusinessLogicException("It's not possible create a SessionBusinessimpl when the DAOFactory is null");
		}
		
	}

	@Override
	public void start(SessionDTO session) {
		daoFactory.getSessionDAO().start(session);
		
	}

	@Override
	public void update(SessionDTO session) {
		daoFactory.getSessionDAO().update(session);
		
	}

	@Override
	public List<SessionDTO> find(SessionDTO session) {
		return daoFactory.getSessionDAO().find(session);
	}
	
}
