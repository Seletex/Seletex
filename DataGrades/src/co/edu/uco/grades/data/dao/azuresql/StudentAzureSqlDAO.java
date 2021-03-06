package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.data.dao.StudentDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.StudentDTO;

public class StudentAzureSqlDAO extends ConnectionSQL implements StudentDAO {

	private StudentAzureSqlDAO(Connection connection) {
		super(connection);
	}

	public static StudentDAO build(Connection connection) {
		return new StudentAzureSqlDAO(connection);
	}

	@Override
	public void create(StudentDTO student) {
		String sql = "INSERT INTO IdType(name, idNumber, idType, email) VALUES (?,?,?,?)";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, student.getName());

			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException("There was a problem trying to create the new IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying to create the new IdType on Azure SQL Server", exception);
		}

	}

	@Override
	public void update(StudentDTO student) {
		String sql ="UPDATE IdType set name =? where name.trim() = ?   ";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, student.getName());

			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException("There was a problem trying to create the new IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying to create the new IdType on Azure SQL Server", exception);
		}

	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM IdType where name.trim() = ?  ";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setLong(1, id);

			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException("There was a problem trying to create the new IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying to create the new IdType on Azure SQL Server", exception);
		}

	}

	@Override
	public void find(StudentDTO student) {
		String sql = "SELECT FROM IdType where name.trim() = ?  ";
		 
		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
			preparedStatement.setString(1, student.getName());

			preparedStatement.executeUpdate();
		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException("There was a problem trying to update the new IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying to update the new IdType on Azure SQL Server", exception);
		}
	}

}
