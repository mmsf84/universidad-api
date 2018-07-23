package universidad.alumno.infrastructure.repository.fake;

import java.util.ArrayList;
import java.util.List;

import universidad.alumno.domain.entity.Alumno;
import universidad.alumno.domain.repository.AlumnoRepository;
import universidad.common.application.enumeration.AlumnoType;

public class AlumnoFakeRepository implements AlumnoRepository {

	List<Alumno> alumnos = new ArrayList<>();
		
	public AlumnoFakeRepository() {
		
		alumnos.add(new Alumno(1, "Mario Santos Francia", 2, false));
		alumnos.add(new Alumno(2, "James Heitfield", 1, false));
		alumnos.add(new Alumno(3, "Lars Ulrich", 1, true));
		alumnos.add(new Alumno(4, "Maynard James Keenan", 3, false));
		alumnos.add(new Alumno(5, "Till Lindeman", 1, false));
		alumnos.add(new Alumno(6, "John Petrucci", 2, true));
		alumnos.add(new Alumno(7, "Robert Plant", 2, false));
		alumnos.add(new Alumno(8, "Josh Homme", 3, false));
		alumnos.add(new Alumno(9, "Kirk Hammet", 3, true));
		alumnos.add(new Alumno(10, "Corey Taylor", 3, false));
		alumnos.add(new Alumno(11, "Eddie Vedder", 2, true));
	}
	
	@Override
	public List<Alumno> getBecados(int tipo) {
		List<Alumno> resul = new ArrayList<>();
		for(Alumno al : alumnos) {
			if((al.getTipoAlumno() == tipo) && al.isBecado()) {
				resul.add(al);
			}
		}
		return resul;
	}
	
	@Override
	public List<Alumno> getListaTipo(int tipo) {
		boolean todos = true;
		for (AlumnoType at : AlumnoType.values() ) {
	        if (at.getValue() == tipo) {
	            todos = false;
	            break;
	        }
	    }
		
		List<Alumno> resul = new ArrayList<>();
		if(todos) {
			resul = alumnos;			
		}else {
			for(Alumno al : alumnos) {
				if(al.getTipoAlumno() == tipo) {
					resul.add(al);
				}
			}
		}
		return resul;
	}
}
