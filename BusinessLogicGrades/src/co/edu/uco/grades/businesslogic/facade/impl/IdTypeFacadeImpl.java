package co.edu.uco.grades.businesslogic.facade.impl;

import java.util.List;

import co.edu.uco.grades.businesslogic.business.IdTypeBusiness;
import co.edu.uco.grades.businesslogic.business.impl.IdTypeBusinessImpl;
import co.edu.uco.grades.businesslogic.facade.IdTypeFacade;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.data.factory.DAOFactory;
import co.edu.uco.grades.dto.IdTypeDTO;

public class IdTypeFacadeImpl implements IdTypeFacade {
	
	private DAOFactory daoFactory = DAOFactory.getDaoFactory();;
	
	
	@Override
	public void create(IdTypeDTO dto) {
		
		
		
		try {
			
			
			daoFactory.initTransaction();
			
			IdTypeBusiness idTypeBusiness = new IdTypeBusinessImpl(daoFactory);
			idTypeBusiness.create(dto);
			daoFactory.commitTransaction();
		}catch(GradesException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		}catch (Exception exception){
			daoFactory.rollbackTransaction();
			String message = "There was a problem tryng to create the new IdType  on create methood in IdTypeFacadeImpl";
			throw GradesException.buildTechnicalBusinessLogicException(message);
		}
		finally {
			daoFactory.closeConnection();
		}
		
	}

	@Override
	public void update(IdTypeDTO dto) {
		
try {
			
			
			daoFactory.initTransaction();
			
			IdTypeBusiness idTypeBusiness = new IdTypeBusinessImpl(daoFactory);
			idTypeBusiness.update(dto);
			daoFactory.commitTransaction();
		}catch(GradesException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		}catch (Exception exception){
			daoFactory.rollbackTransaction();
			String message = "There was a problem tryng to update the IdType  on update methood in IdTypeFacadeImpl";
			throw GradesException.buildTechnicalBusinessLogicException(message);
		}
		finally {
			daoFactory.closeConnection();
		}
		
		
	}

	@Override
	public void delete(int id) {
		
try {
			
			
			daoFactory.initTransaction();
			
			IdTypeBusiness idTypeBusiness = new IdTypeBusinessImpl(daoFactory);
			idTypeBusiness.delete(id);
			daoFactory.commitTransaction();
		}catch(GradesException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		}catch (Exception exception){
			daoFactory.rollbackTransaction();
			String message = "There was a problem tryng to delete the IdType  on delete methood in IdTypeFacadeImpl";
			throw GradesException.buildTechnicalBusinessLogicException(message);
		}
		finally {
			daoFactory.closeConnection();
		}
		
		
	}

	@Override
	public List<IdTypeDTO> find(IdTypeDTO dto) {
		
		try {							
			IdTypeBusiness idTypeBusiness = new IdTypeBusinessImpl(daoFactory);
			return idTypeBusiness.find(dto);
			
		}catch(GradesException exception) {
			daoFactory.rollbackTransaction();
			throw exception;
		}catch (Exception exception){
			daoFactory.rollbackTransaction();
			String message = "There was a problem tryng to find the new IdType  on find methood in IdTypeFacadeImpl";
			throw GradesException.buildTechnicalBusinessLogicException(message);
		}
		finally {
			daoFactory.closeConnection();
		}
		
		
	}

}
