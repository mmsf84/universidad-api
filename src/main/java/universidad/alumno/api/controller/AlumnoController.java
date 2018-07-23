package universidad.alumno.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import universidad.alumno.application.AlumnoApplicationService;
import universidad.alumno.application.dto.ListadoAlumnoDto;
import universidad.alumno.application.dto.RequestTipoDto;
import universidad.common.api.controller.ResponseHandler;

@RestController
@RequestMapping("api/alumno")
public class AlumnoController {
	
	@Autowired
	AlumnoApplicationService alumnoApplicationService;
	
	@Autowired
	ResponseHandler responseHandler;
	
	//@RequestMapping(method = RequestMethod.GET, path = "beca", consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
	//public ResponseEntity<Object> getBecaByAlumnoType(@RequestBody RequestTipoDto requestTipoDto) throws Exception {
	//}
	
	@GetMapping(value = "/beca/{tipoAlumno}")
	public ResponseEntity<Object> getBecaByAlumnoType(@PathVariable("tipoAlumno") String tipoAlumno) {	
		try {
			ListadoAlumnoDto listadoAlumnoDto = alumnoApplicationService.listaBecado(tipoAlumno);
			if (listadoAlumnoDto != null && listadoAlumnoDto.getCntEncontrado()>0) {
				return new ResponseEntity<Object>(listadoAlumnoDto, HttpStatus.OK);
			}else {				
				return this.responseHandler.getResponse("No se encontraron datos", HttpStatus.NOT_FOUND);
			}			
		} catch(IllegalArgumentException ex) {
			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());
		} catch(Exception ex) {
			return this.responseHandler.getAppExceptionResponse();
		}
	}
	
	//@RequestMapping(method = RequestMethod.GET, path = "lista", consumes = "application/json; charset=UTF-8", produces = "application/json; charset=UTF-8")
	//public ResponseEntity<Object> getListadoAlumnoType(@RequestBody RequestTipoDto requestTipoDto) throws Exception {
	
	@GetMapping(value = "/lista/{tipoAlumno}")
	public ResponseEntity<Object> getListadoAlumnoType(@PathVariable("tipoAlumno") String tipoAlumno) {	
	
		try {
			ListadoAlumnoDto listadoAlumnoDto = alumnoApplicationService.listaTipo(tipoAlumno);
			if (listadoAlumnoDto != null && listadoAlumnoDto.getCntEncontrado()>0) {
				return new ResponseEntity<Object>(listadoAlumnoDto, HttpStatus.OK);
			}else {				
				return this.responseHandler.getResponse("No se encontraron datos", HttpStatus.NOT_FOUND);
			}			
		} catch(IllegalArgumentException ex) {
			return this.responseHandler.getAppCustomErrorResponse(ex.getMessage());
		} catch(Exception ex) {
			return this.responseHandler.getAppExceptionResponse();
		}
	}

}
