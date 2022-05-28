package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uco.crosscutting.util.numeric.UtilNumeric;
import co.edu.uco.crosscutting.util.object.UtilObject;
import co.edu.uco.crosscutting.util.text.UtilText;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.data.dao.SessionDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.SessionDTO;

public class SessionAzureSQLDAO extends ConnectionSQL implements SessionDAO {

	protected SessionAzureSQLDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	public static SessionAzureSQLDAO build(Connection connection) {
		return new SessionAzureSQLDAO(connection);
	}

	@Override
	public void start(SessionDTO session) {
		String sql = "INSERT INTO Session(course,date) VALUES (?,?)";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setInt(1, session.getCourseDTO().getId());
			preparedStatement.setDate(1, session.getDate());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new session on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new session on Azure SQL Server", exception);
		}
		
	}

	@Override
	public void update(SessionDTO session) {
		String sql = "UPDATE Session SET course= ? ,date= ? ";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setInt(1, session.getCourseDTO().getId());
			preparedStatement.setDate(1, session.getDate());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new Session on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new Session on Azure SQL Server", exception);
		}
		
	}

	@Override
	public List<SessionDTO> find(SessionDTO session) {
		
		boolean setWhere = true;
		List<Object> parameters = new ArrayList<>();
		List<SessionDTO> results = new ArrayList<>();

		StringBuilder sb = new StringBuilder();
		sb.append("SELEC id, name").append(UtilText.SPACE);
		sb.append("FROM IdType").append(UtilText.SPACE);
		if (!UtilObject.getUtilObject().isNull(session)) {
			if (!UtilNumeric.getUtilObject().isGreatherThan(session.getId(), 0)) {
				sb.append("WHERE").append(UtilText.SPACE);
				sb.append("id = ? ");
				parameters.add(session.getId());
				setWhere = false;
			}
			if (!UtilNumeric.getUtilObject().isGreatherThan(session.getCourseDTO().getId(),0)) {
				sb.append(setWhere ? "WHERE " : "AND");
				sb.append("course = ? ");
				parameters.add(UtilObject.getUtilObject().isNull(session.getCourseDTO().getId()));
				setWhere = false;
			}
			if (!UtilObject.getUtilObject().isNull(session.getDate())) {
				sb.append(setWhere ? "WHERE " : "AND");
				sb.append("date = ? ");
				parameters.add(UtilObject.getUtilObject().isNull(session.getDate()));
			}
		}

		sb.append("ORDER BY name ASC").append(UtilText.SPACE);
		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sb.toString())) {
			for (int index = 0; index < parameters.size(); index++) {
				preparedStatement.setObject(index + 1, parameters.get(index));
			}
			results = executeQuery(preparedStatement);

		} catch (GradesException exception) {
			throw exception;
		}

		catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to recover the IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected has ocurred problem trying to recover the IdType on Azure SQL Server", exception);
		}

		return results;

	}

	private List<SessionDTO> assembleResults(ResultSet resultSet) {
		List<SessionDTO> results = new ArrayList<>();

		try {
			while (resultSet.next()) {
				results.add(assembleDTO(resultSet));
			}

		} catch (GradesException exception) {
			throw exception;
		}

		catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to recover the IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected has ocurred problem trying to recover the IdType on Azure SQL Server", exception);
		}

		return results;
	}

	private SessionDTO assembleDTO(ResultSet resultSet) {
		SessionDTO dto = new SessionDTO();
		try {
			dto.setId(resultSet.getInt("id"));
			dto.setDate(resultSet.getDate("date"));
			//dto.setCourseDTO(CourseAzureSqlDAO.find(resultSet.getInt("course")));

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to assamble the IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected has ocurred problem trying to assamble the IdType on Azure SQL Server", exception);
		}

		return dto;
	}

	private List<SessionDTO> executeQuery(PreparedStatement preparedStatement) {
		List<SessionDTO> results = new ArrayList<>();

		try (ResultSet resultset = preparedStatement.executeQuery()) {
			results = assembleResults(resultset);

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to delete the new IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected has ocurred problem trying to delete the new IdType on Azure SQL Server", exception);
		}
		return results;

	}
	@Override
	public void create(SessionDTO session) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}


}
