package co.edu.uco.grades.data.dao.azuresql;

public class StudentCourseStateAzureSqlDAO extends ConnectionSQL implements StudentCourseStateDAO {

	protected StudentCourseStateAzureSqlDAO(Connection connection) {
		super(connection);
		// TODO Auto-generated constructor stub
	}
	public static StudentCourseStateAzureSqlDAO build(Connection connection) {
		return new StudentCourseStateAzureSqlDAO(connection);
	}

	@Override
	public void create(StudentCourseStateDTO state) {
		String sql = "INSERT INTO StudentCourseState(name) VALUES (?)";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, state.getName());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new StudentCourseStateDTO on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new StudentCourseStateDTO on Azure SQL Server", exception);
		}
		
	}

	@Override
	public void update(StudentCourseStateDTO state) {
		String sql = "UPDATE StudentCourseState SET name = ?";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setString(1, state.getName());
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new StudentCourseState on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new StudentCourseState on Azure SQL Server", exception);
		}
		
	}

	@Override
	public void delete(int id) {
		String sql = "DELETE FROM StudentCourseState WHERE id = ?";

		try (PreparedStatement preparedStatement = getConnection().prepareStatement(sql)) {

			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();

		} catch (SQLException exception) {
			throw GradesException.buildTechnicalDataException(
					"There was a problem trying to create the new StudentCourseState on Azure SQL Server", exception);
		} catch (Exception exception) {
			throw GradesException.buildTechnicalDataException(
					"An unexpected problem has ocurred trying to create the new StudentCourseState on Azure SQL Server", exception);
		}
		
	}

	@Override
	public List<StudentCourseStateDTO> find(StudentCourseStateDTO state) {
		boolean setWhere = true;
		List<Object> parameters = new ArrayList<>();
		List<StudentCourseStateDTO> results = new ArrayList<>();

		StringBuilder sb = new StringBuilder();
		sb.append("SELEC id, name").append(UtilText.SPACE);
		sb.append("FROM IdType").append(UtilText.SPACE);
		if (!UtilObject.getUtilObject().isNull(state)) {
			if (UtilNumeric.getUtilObject().isGreatherThan(state.getId(), 0)) {
				sb.append("WHERE").append(UtilText.SPACE);
				sb.append("id = ? ");
				parameters.add(state.getId());
				setWhere = false;
			}
			if (!UtilText.isEmpty(state.getName())) {
				sb.append(setWhere ? "WHERE " : "AND");
				sb.append("name = ? ");
				parameters.add(UtilText.trim(state.getName()));
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
	private List<StudentCourseStateDTO> assembleResults(ResultSet resultSet) {
		List<StudentCourseStateDTO> results = new ArrayList<>();

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

	private StudentCourseStateDTO assembleDTO(ResultSet resultSet) {
		StudentCourseStateDTO dto = new StudentCourseStateDTO();
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

	private List<StudentCourseStateDTO> executeQuery(PreparedStatement preparedStatement) {
		List<StudentCourseStateDTO> results = new ArrayList<>();

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