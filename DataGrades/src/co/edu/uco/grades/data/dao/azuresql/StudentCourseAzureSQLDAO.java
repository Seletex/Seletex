package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.data.dao.StudentCourseDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.StudentCourseDTO;

public class StudentCourseAzureSQLDAO extends ConnectionSQL implements StudentCourseDAO {

	protected StudentCourseAzureSQLDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	public static StudentCourseAzureSQLDAO build(Connection connection) {
		return  new StudentCourseAzureSQLDAO(connection);
	}

	@Override
	public void create(StudentCourseDTO studentCourse) {
		String sql = "INSERT INTO  StudentCourse(student,course, state) VALUES (?,?,?) ";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setInt(1, studentCourse.getStuden().getId());
			preparedStatement.setInt(1, studentCourse.getCourse().getId());
			preparedStatement.setInt(1, studentCourse.getState().getId());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new StudentCourse on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new StudentCourse on Azure SQL Server", exception);
		}
		
	}

	@Override
	public void update(StudentCourseDTO studentCourse) {
		String sql = "UPDATE StudentCourse SET student= ? ,course= ? , state= ? ";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setInt(1, studentCourse.getStuden().getId());
			preparedStatement.setInt(1, studentCourse.getCourse().getId());
			preparedStatement.setInt(1, studentCourse.getState().getId());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new StudentCourse on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new StudentCourse on Azure SQL Server", exception);
		}
		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM StudentCourse WHERE id = ? ";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new StudentCourse on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new StudentCourse on Azure SQL Server", exception);
		}
		
	}

	@Override
	public List<StudentCourseDTO> find(StudentCourseDTO studentCourse) {
		List<StudentCourseDTO> results = new ArrayList<>();
		return results;
	}

}
