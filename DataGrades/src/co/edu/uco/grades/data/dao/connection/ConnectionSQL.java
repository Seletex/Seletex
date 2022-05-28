package co.edu.uco.grades.data.dao.connection;

import java.sql.Connection;
import java.util.List;

import co.edu.uco.crosscutting.util.sql.UtilConnection;
import co.edu.uco.grades.crosscutting.exception.GradesException;
import co.edu.uco.grades.dto.StudentCourseDTO;
import co.edu.uco.grades.dto.StudentCourseStateDTO;

public class ConnectionSQL {
	private Connection connection;
	
	protected ConnectionSQL(Connection connection) {
		if(UtilConnection.isClosed(connection)) {
			throw GradesException.buildTechnicalDataException(
					"it's not possible to create the specific DAO because connection is closed");
		}
		setConnection(connection);
	}

	protected Connection getConnection() {
		return connection;
	}

	private void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void update(StudentCourseDTO studentCourse) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	public List<StudentCourseDTO> find(StudentCourseDTO studentCourse) {
		// TODO Auto-generated method stub
		return null;
	}

	public void create(StudentCourseDTO studentCourse) {
		// TODO Auto-generated method stub
		
	}

	public void create(StudentCourseStateDTO state) {
		// TODO Auto-generated method stub
		
	}

	public void update(StudentCourseStateDTO state) {
		// TODO Auto-generated method stub
		
	}

}
