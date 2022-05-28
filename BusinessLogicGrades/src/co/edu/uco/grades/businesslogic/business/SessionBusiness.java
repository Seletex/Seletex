package co.edu.uco.grades.businesslogic.business;

import java.util.List;

import co.edu.uco.grades.dto.SessionDTO;

public interface SessionBusiness {
	void start(SessionDTO session);
	public void update(SessionDTO session);
	public List<SessionDTO> find(SessionDTO session);
}
