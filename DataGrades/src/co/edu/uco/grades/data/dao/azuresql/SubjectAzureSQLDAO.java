package co.edu.uco.grades.data.dao.azuresql;

public class SubjectAzureSqlDAO extends ConnectionSQL implements SubjectDAO {

	protected SubjectAzureSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	public static SubjectAzureSqlDAO build(Connection connection) {
		return new SubjectAzureSqlDAO(connection);
	}

	@Override
	public void create(SubjectDTO subject) {
		String sql = "INSERT INTO Subjec(name) VALUES (?)";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, subject.getName());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new Subjec on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new Subjec on Azure SQL Server", exception);
		}
		
	}

	@Override
	public void update(SubjectDTO subject) {
		String sql = "UPDATE Subjec SET name = ?";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, subject.getName());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new Subjec on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new IdType on Azure SQL Server", exception);
		}
		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM Subjec WHERE id = ?";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new Subjec on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new Subjec on Azure SQL Server", exception);
		}
		
	}

	@Override
	public List<SubjectDTO> find(SubjectDTO subject) {
		boolean setWhere = true;
		List<Object> parameters = new ArrayList<>();
		List<SubjectDTO> results = new ArrayList<>();

		StringBuilder sb = new StringBuilder();
		sb.append("SELEC id, name").append(UtilText.SPACE);
		sb.append("FROM IdType").append(UtilText.SPACE);
		if (!UtilObject.getUtilObject().isNull(subject)) {
			if (UtilNumeric.getUtilObject().isGreatherThan(subject.getId(), 0)) {
				sb.append("WHERE").append(UtilText.SPACE);
				sb.append("id = ? ");
				parameters.add(subject.getId());
				setWhere = false;
			}
			if (!UtilText.isEmpty(subject.getName())) {
				sb.append(setWhere ? "WHERE " : "AND");
				sb.append("name = ? ");
				parameters.add(UtilText.trim(subject.getName()));
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

	private List<SubjectDTO> assembleResults(ResultSet resultSet) {
		List<SubjectDTO> results = new ArrayList<>();

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

	private SubjectDTO assembleDTO(ResultSet resultSet) {
		SubjectDTO dto = new SubjectDTO();
		try {
			dto.setId(resultSet.getInt("id"));
			dto.setName(resultSet.getString("name"));

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to assamble the IdType on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected has ocurred problem trying to assamble the IdType on Azure SQL Server", exception);
		}

		return dto;
	}

	private List<SubjectDTO> executeQuery(PreparedStatement preparedStatement) {
		List<SubjectDTO> results = new ArrayList<>();

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
	
}