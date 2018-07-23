package universidad.alumno.application.dto;

import java.util.List;

public class ListadoAlumnoDto {
	
	private int cntEncontrado;	
	private List<AlumnoDto> resul;
	
	public int getCntEncontrado() {
		return cntEncontrado;
	}
	public void setCntEncontrado(int cntEncontrado) {
		this.cntEncontrado = cntEncontrado;
	}
	public List<AlumnoDto> getResul() {
		return resul;
	}
	public void setResul(List<AlumnoDto> resul) {
		this.resul = resul;
	}
	
	
}
