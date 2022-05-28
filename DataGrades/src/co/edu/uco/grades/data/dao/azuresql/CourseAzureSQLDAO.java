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

import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.CourseDTO;
import co.edu.uco.grades.data.dao.CourseDAO;

public class CourseAzureSQLDAO extends ConnectionSQL implements CourseDAO{

	protected CourseAzureSQLDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	public static CourseAzureSQLDAO build(Connection connection) {
		return new CourseAzureSQLDAO(connection);
	}

	@Override
	public void open(CourseDTO course) {
		String sql = "INSERT INTO Course(subject, professor,initialDate,finalDate) VALUES (?,?,?,?)";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setInt(1, course.getSubject().getId());
			preparedStatement.setInt(1, course.getProfessor().getId());
			preparedStatement.setDate(1, course.getInitialDate());
			preparedStatement.setDate(1, course.getFinalDate());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new Course on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new Course on Azure SQL Server", exception);
		}
		
	}


	@Override
	public List<CourseDTO> find(CourseDTO course) {
		List<CourseDTO> results = new ArrayList<>();
		boolean setWhere = true;
		List<Object> parameters = new ArrayList<>();
		
		StringBuilder sb = new StringBuilder();
		sb.append("SELEC subject,  professor, initialDate, finalDate").append(UtilText.SPACE);
		sb.append("FROM Course").append(UtilText.SPACE);
		if (!UtilObject.getUtilObject().isNull(course)) {
			if (UtilNumeric.getUtilObject().isGreatherThan(course.getId(), 0)) {
				sb.append(" WHERE").append(UtilText.SPACE);
				sb.append("id = ? ");
				parameters.add(course.getId());
				setWhere = false;
			}
			if (!UtilNumeric.getUtilObject().isPositive(course.getSubject().getId())){
				sb.append(setWhere ? "WHERE " : "AND");
				sb.append("subject = ? ");
				parameters.add(course.getSubject().getId());
			}
			if (!UtilNumeric.getUtilObject().isPositive(course.getProfessor().getId())){
				sb.append(setWhere ? "WHERE " : "AND");
				sb.append("professor = ? ");
				parameters.add(course.getProfessor().getId());
			}
			if (!UtilObject.getUtilObject().isNull(course.getInitialDate())){
				sb.append(setWhere ? "WHERE " : "AND");
				sb.append("initialDate = ? ");
				parameters.add(course.getInitialDate());
			}
			if (!UtilObject.getUtilObject().isNull(course.getFinalDate())){
				sb.append(setWhere ? "WHERE " : "AND");
				sb.append("finalDate = ? ");
				parameters.add(course.getFinalDate());
			}
		}

		sb.append("ORDER BY professor ASC").append(UtilText.SPACE);
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
					"There was a problem trying to recover the course on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected has ocurred problem trying to recover the course on Azure SQL Server", exception);
		}
		
		return results;
		
	}
	private List<CourseDTO> assembleResults(ResultSet resultSet) {
		List<CourseDTO> results = new ArrayList<>();

		try {
			while (resultSet.next()) {
				results.add(assembleDTO(resultSet));
			}

		} catch (GradesException exception) {
			throw exception;
		}

		catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to recover the course on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected has ocurred problem trying to recover the course on Azure SQL Server", exception);
		}

		return results;
	}

	private CourseDTO assembleDTO(ResultSet resultSet) {
		CourseDTO dto = new CourseDTO();
		try {
			dto.setId(resultSet.getInt("id"));
			

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to assamble the Course on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected has ocurred problem trying to assamble the Course on Azure SQL Server", exception);
		}

		return dto;
	}

	private List<CourseDTO> executeQuery(PreparedStatement preparedStatement) {
		List<CourseDTO> results = new ArrayList<>();

		try (ResultSet resultset = preparedStatement.executeQuery()) {
			results = assembleResults(resultset);

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to delete the new course on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected has ocurred problem trying to delete the new course on Azure SQL Server", exception);
		}
		return results;

	}

}
