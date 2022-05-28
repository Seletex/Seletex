package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.data.dao.AttendanceDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.AttendanceDTO;

public class AttendanceAzureSQLDAO extends ConnectionSQL implements AttendanceDAO {

	protected AttendanceAzureSQLDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	
	public static AttendanceAzureSQLDAO build(Connection connection) {
		return new AttendanceAzureSQLDAO(connection);
	}
	
	@Override
	public void create(AttendanceDTO attendance) {
		String sql = "INSERT INTO Attendace(studentCourse,session,attended) VALUES (?,?,?)";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setObject(1, attendance.getStudenCourseDTO());
			preparedStatement.setObject(1, attendance.getSessionDTO());
			preparedStatement.setByte(1, attendance.getAttended());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new Attendace on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new Attendace on Azure SQL Server", exception);
		}
		
	}

	@Override
	public void update(AttendanceDTO attendance) {
		String sql = "UPDATE Attendace SET studentCourse = ? ,  session= ? , attended= ?";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setInt(1, attendance.getStudenCourseDTO().getId());
			preparedStatement.setInt(1, attendance.getSessionDTO().getId());
			preparedStatement.setByte(1, attendance.getAttended());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new Attendeance on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new Attendeance on Azure SQL Server", exception);
		}
		
	}
	@Override
	public void delete(int id) {
		String sql = "DELETE FROM Attendace WHERE id = ?";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new Attendace on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new Attendace on Azure SQL Server", exception);
		}
	}

	@Override
	public List<AttendanceDTO> find(AttendanceDTO attendance) {
		List<AttendanceDTO> results = new ArrayList<>();
		return results;
	}




}
