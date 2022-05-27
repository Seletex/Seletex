package co.edu.uco.grades.data.factory;

import java.sql.Connection;


import co.edu.uco.grades.data.dao.AttendanceDAO;
import co.edu.uco.grades.data.dao.CourseDAO;
import co.edu.uco.grades.data.dao.IdTypeDAO;
import co.edu.uco.grades.data.dao.ProfessorDAO;
import co.edu.uco.grades.data.dao.SessionDAO;
import co.edu.uco.grades.data.dao.StudentCourseDAO;
import co.edu.uco.grades.data.dao.StudentCourseStateDAO;
import co.edu.uco.grades.data.dao.StudentDAO;
import co.edu.uco.grades.data.dao.SubjectDAO;
import co.edu.uco.grades.data.factory.azuresql.AzureSqlDAOFactory;

public abstract class DAOFactory {

	public static DAOFactory getDaoFactory() {
		return null;
	}
	public static DAOFactory getDaoFactory(String...factory) {
		return AzureSqlDAOFactory.create();
	}


	protected abstract void openConnection();

	protected abstract Connection getConnection();

	public abstract void initTransaction();

	public abstract void closeConnection();

	public abstract void commitTransaction();

	public abstract void rollbackTransaction();

	public abstract StudentDAO getStudentDAO();

	public abstract IdTypeDAO getIdTypeDAO();
	public abstract AttendanceDAO getAttendanceDAO();
	public abstract SubjectDAO getSubjectDAO();
	public abstract SessionDAO getSessionDAO();
	public abstract StudentCourseDAO getStudentCourseDAO();
	public abstract StudentCourseStateDAO getStudentCourseStateDAO();
	public abstract CourseDAO getCourseDAO();
	
	public abstract ProfessorDAO getProfessorDAO();
}
