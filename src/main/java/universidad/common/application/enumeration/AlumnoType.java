package universidad.common.application.enumeration;

public enum AlumnoType {
	PREGRADO(1),MAESTRIA(2),DOCTORADO(3);
	int value;
	
	AlumnoType(int p) {
		value = p;
	}
	public int getValue() {
		return value;
	}
}
