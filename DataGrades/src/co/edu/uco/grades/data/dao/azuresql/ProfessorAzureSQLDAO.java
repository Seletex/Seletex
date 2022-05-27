package co.edu.uco.grades.data.dao.azuresql;

public class ProfessorAzureSqlDAO extends ConnectionSQL implements ProfessorDAO {

	protected ProfessorAzureSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}

	public static ProfessorAzureSqlDAO build(Connection connection) {
		return new ProfessorAzureSqlDAO(connection);
	}

	@Override
	public void create(ProfessorDTO professor) {
		String sql = "INSERT INTO Professor(idNumber,idType,name,email) VALUES (?,?,?,?)";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, professor.getIdNumber());
			preparedStatement.setInt(1, professor.getIdType().getId());
			preparedStatement.setString(1, professor.getName());
			preparedStatement.setString(1, professor.getEmail());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new professor on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new professor on Azure SQL Server",
					exception);
		}

	}

	@Override
	public void update(ProfessorDTO professor) {
		String sql = "UPDATE Professor SET idNumber=?, idType=?, name = ?, email=?";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, professor.getIdNumber());
			preparedStatement.setInt(1, professor.getIdType().getId());
			preparedStatement.setString(1, professor.getName());
			preparedStatement.setString(1, professor.getEmail());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to update the professor on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to update the professor on Azure SQL Server", exception);
		}
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM Professor WHERE id = ?";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to delete the professor on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to delete the professor on Azure SQL Server", exception);
		}

	}

	@Override
	public List<ProfessorDTO> find(ProfessorDTO professor) {
		boolean setWhere = true;
		List<Object> parameters = new ArrayList<>();
		List<ProfessorDTO> results = new ArrayList<>();

		StringBuilder sb = new StringBuilder();
		sb.append("SELEC id, name").append(UtilText.SPACE);
		sb.append("FROM IdType").append(UtilText.SPACE);
		if (!UtilObject.getUtilObject().isNull(professor)) {
			if (UtilNumeric.getUtilObject().isGreatherThan(professor.getId(), 0)) {
				sb.append("WHERE").append(UtilText.SPACE);
				sb.append("id = ? ");
				parameters.add(professor.getId());
				setWhere = false;
			}
			if (!UtilText.isEmpty(professor.getName())) {
				sb.append(setWhere ? "WHERE " : "AND");
				sb.append("name = ? ");
				parameters.add(UtilText.trim(professor.getName()));
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
					"There was a problem trying to recover the professor on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected has ocurred problem trying to recover the professor on Azure SQL Server", exception);
		}

		return results;

	}

	private List<ProfessorDTO> assembleResults(ResultSet resultSet) {
		List<ProfessorDTO> results = new ArrayList<>();

		try {
			while (resultSet.next()) {
				results.add(assembleDTO(resultSet));
			}

		} catch (GradesException exception) {
			throw exception;
		}

		catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to recover the professor on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected has ocurred problem trying to recover the professor on Azure SQL Server", exception);
		}

		return results;
	}

	private ProfessorDTO assembleDTO(ResultSet resultSet) {
		ProfessorDTO dto = new ProfessorDTO();
		try {
			dto.setId(resultSet.getInt("id"));
			dto.setName(resultSet.getString("name"));

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to assamble the professor on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected has ocurred problem trying to assamble the professor on Azure SQL Server", exception);
		}

		return dto;
	}

	private List<ProfessorDTO> executeQuery(PreparedStatement preparedStatement) {
		List<ProfessorDTO> results = new ArrayList<>();

		try (ResultSet resultset = preparedStatement.executeQuery()) {
			results = assembleResults(resultset);

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to execute a query on table Professor on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected has ocurred problem trying to execute a query on table Professor on Azure SQL Server",
					exception);
		}
		return results;

	}

}
