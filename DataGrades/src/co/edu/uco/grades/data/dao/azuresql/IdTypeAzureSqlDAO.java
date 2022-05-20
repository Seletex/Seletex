package co.edu.uco.grades.data.dao.azuresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.data.dao.IdTypeDAO;
import co.edu.uco.grades.data.dao.connection.ConnectionSQL;
import co.edu.uco.grades.dto.IdTypeDTO;

public class IdTypeAzureSqlDAO extends ConnectionSQL implements IdTypeDAO {

	private IdTypeAzureSqlDAO(Connection connection) {
		super(connection);
	}

	public static IdTypeDAO build(Connection connection) {
		return new IdTypeAzureSqlDAO(connection);
	}

	@Override
	public void create(IdTypeDTO idType) {
		String sql = "INSERT INTO IdType(name) VALUES (?)";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, idType.getName());

			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException("There was a problem trying to create the new IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying to create the new IdType on Azure SQL Server", exception);
		}
	}

	@Override
	public void update(IdTypeDTO idType) {
		String sql = "UPDATE IdType set name =? where name.trim() = ?   ";
		 
		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
			preparedStatement.setString(1, idType.getName());

			preparedStatement.executeUpdate();
		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException("There was a problem trying to update the new IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying to update the new IdType on Azure SQL Server", exception);
		}
		
		

	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM IdType where name.trim() = ?  ";
		 
		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
			preparedStatement.setInt(id, id);

			preparedStatement.executeUpdate();
		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException("There was a problem trying to delete the new IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying to delete the new IdType on Azure SQL Server", exception);
		}

	}

	@Override
	public void find(IdTypeDTO idType) {
		String sql = "SELECT FROM IdType where name.trim() = ?  ";
		 
		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)){
			preparedStatement.setString(1, idType.getName());

			preparedStatement.executeUpdate();
		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException("There was a problem trying to update the new IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException("An unexpected problem has ocurred trying to update the new IdType on Azure SQL Server", exception);
		}
	}
}
