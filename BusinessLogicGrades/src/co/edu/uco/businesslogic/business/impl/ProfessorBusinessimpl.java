package co.edu.uco.businesslogic.business.impl;

import java.util.List;

import co.edu.uco.businesslogic.business.ProfessorBusiness;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.data.factory.DAOFactory;
import co.edu.uco.grades.dto.ProfessorDTO;

public class ProfessorBusinessimpl implements ProfessorBusiness {
	private DAOFactory daoFactory;

	public ProfessorBusinessimpl() {
		if (UtilObject.getUtilObject().isNull(daoFactory)) {
			throw GradesException.buildTechnicalBusinessLogicException(
					"It's not possible create a ProfessorBusinessimpl when the DAOFactory is null");
		}

	}

	@Override
	public void create(ProfessorDTO professor) {
		daoFactory.getProfessorDAO().create(professor);

	}

	@Override
	public void update(ProfessorDTO professor) {
		daoFactory.getProfessorDAO().update(professor);

	}

	@Override
	public void delete(int id) {
		daoFactory.getProfessorDAO().delete(id);

	}

	@Override
	public List<ProfessorDTO> find(ProfessorDTO professor) {
		return daoFactory.getProfessorDAO().find(professor);
	}

}

