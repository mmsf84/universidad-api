package universidad.alumno.domain.entity;

public class Alumno {

	private long codAlumno;
	private String nombreAlumno;
	private int tipoAlumno;
	private boolean isBecado;
	
	public Alumno(long codAlumno, String nombreAlumno, int tipoAlumno, boolean isBecado) {
		super();
		this.codAlumno = codAlumno;
		this.nombreAlumno = nombreAlumno;
		this.tipoAlumno = tipoAlumno;
		this.isBecado = isBecado;
	}

	public long getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(long codAlumno) {
		this.codAlumno = codAlumno;
	}

	public String getNombreAlumno() {
		return nombreAlumno;
	}

	public void setNombreAlumno(String nombreAlumno) {
		this.nombreAlumno = nombreAlumno;
	}

	public int getTipoAlumno() {
		return tipoAlumno;
	}

	public void setTipoAlumno(int tipoAlumno) {
		this.tipoAlumno = tipoAlumno;
	}

	public boolean isBecado() {
		return isBecado;
	}

	public void setBecado(boolean isBecado) {
		this.isBecado = isBecado;
	}
	
	
}
