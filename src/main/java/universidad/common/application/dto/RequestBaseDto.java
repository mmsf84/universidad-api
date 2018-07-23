package universidad.common.application.dto;

import universidad.common.application.enumeration.AlumnoType;

public class RequestBaseDto {
	protected AlumnoType requestBodyType;

	public AlumnoType getRequestBodyType() {
		return requestBodyType;
	}

	public void setRequestBodyType(AlumnoType requestBodyType) {
		this.requestBodyType = requestBodyType;
	}
}
