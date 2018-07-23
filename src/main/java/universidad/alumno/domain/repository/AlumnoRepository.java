package universidad.alumno.domain.repository;

import java.util.List;

import universidad.alumno.domain.entity.Alumno;

public interface AlumnoRepository {

	public List<Alumno> getBecados(int tipo);	
	public List<Alumno> getListaTipo(int tipo);
}
