package universidad.alumno.application.dto;

public class AlumnoDto {

	private String codAlumno;
	private String nombreAlumno;
	private String tipoAlumno;
	private String isBecado;
	private String mtoBeca;
	
	public AlumnoDto() {
		// TODO Auto-generated constructor stub
	}

	public AlumnoDto(String codAlumno, String nombreAlumno, String tipoAlumno, String isBecado, String mtoBeca) {
		super();
		this.codAlumno = codAlumno;
		this.nombreAlumno = nombreAlumno;
		this.tipoAlumno = tipoAlumno;
		this.isBecado = isBecado;
		this.mtoBeca = mtoBeca;
	}

	public String getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(String codAlumno) {
		this.codAlumno = codAlumno;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public String getTipoAlumno() {
		return tipoAlumno;
	}

	public void setTipoAlumno(String tipoAlumno) {
		this.tipoAlumno = tipoAlumno;
	}

	public String getIsBecado() {
		return isBecado;
	}

	public void setIsBecado(String isBecado) {
		this.isBecado = isBecado;
	}

	public String getMtoBeca() {
		return mtoBeca;
	}

	public void setMtoBeca(String mtoBeca) {
		this.mtoBeca = mtoBeca;
	}
	
	
	
}
