package universidad.alumno.application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import universidad.alumno.application.dto.AlumnoDto;
import universidad.alumno.application.dto.ListadoAlumnoDto;
import universidad.alumno.application.dto.RequestTipoDto;
import universidad.alumno.domain.entity.Alumno;
import universidad.alumno.domain.repository.AlumnoRepository;
import universidad.alumno.infrastructure.repository.fake.AlumnoFakeRepository;
import universidad.common.application.enumeration.AlumnoType;


@Service()
public class AlumnoApplicationService {
	
	private AlumnoRepository alumnoRepository;

	public AlumnoApplicationService() {		
		alumnoRepository = new AlumnoFakeRepository();
	}
	
	public ListadoAlumnoDto listaBecado(String dtoInput) {
		int tipoAlumno = 0;
		try {
			tipoAlumno = Integer.parseInt(dtoInput);
		}catch(Exception e) {
			tipoAlumno = 0;
		}
		
		ListadoAlumnoDto respuesta = new ListadoAlumnoDto(); 
		List<Alumno> rsp = alumnoRepository.getBecados(tipoAlumno);
		if(rsp.size()<=0) {
			respuesta.setCntEncontrado(0);
		}else {
			respuesta.setCntEncontrado(rsp.size());
			respuesta.setResul(this.builderAlumnosDto(rsp));
		}
		return respuesta;
	}
	
	public ListadoAlumnoDto listaTipo(String dtoInput) {
		int tipoAlumno = 0;
		try {
			tipoAlumno = Integer.parseInt(dtoInput);
		}catch(Exception e) {
			tipoAlumno = 0;
		}
		
		ListadoAlumnoDto respuesta = new ListadoAlumnoDto(); 
		List<Alumno> rsp = alumnoRepository.getListaTipo(tipoAlumno);
		if(rsp.size()<=0) {
			respuesta.setCntEncontrado(0);
		}else {
			respuesta.setCntEncontrado(rsp.size());
			respuesta.setResul(this.builderAlumnosDto(rsp));
		}
		return respuesta;
	}

	private List<AlumnoDto> builderAlumnosDto(List<Alumno> entities){
		
		List<AlumnoDto> alumnosDto = new ArrayList<>();
		for (Alumno al : entities) {
			AlumnoDto adto = new AlumnoDto();
			adto.setCodAlumno(String.valueOf(al.getCodAlumno()));
			adto.setNombreAlumno(al.getNombreAlumno());
			adto.setTipoAlumno(this.decodeTipoAlumno(al.getTipoAlumno()));			
			adto.setIsBecado((al.isBecado()?"BECADO":"SIN BECA"));
			adto.setMtoBeca((al.isBecado()?this.decodeMtoBecaAlumno(al.getTipoAlumno()):"0.0"));
			alumnosDto.add(adto);
		}
		return alumnosDto;
	}
	
	private String decodeTipoAlumno(int tipo) {
		String nameTipo = null;
		for (AlumnoType at : AlumnoType.values()) {
	        if (at.getValue() == tipo) {
	        	nameTipo = at.name().toString();
	        	break;
	        }
	    }
		return nameTipo;
	}
	
	private String decodeMtoBecaAlumno(int tipo) {
		double mto =0;
		String mtoBeca = null;
		mto = tipo*1000;
		return ""+mto;
	}
		
}
