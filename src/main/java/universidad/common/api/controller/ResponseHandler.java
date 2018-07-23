package universidad.common.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import universidad.common.application.dto.ErrorDto;
import universidad.common.application.dto.ResponseCommandDto;
import universidad.common.application.dto.ResponseDto;
import universidad.common.application.dto.ResponseErrorDto;
import universidad.common.application.dto.ResponseOkCommandDto;
import universidad.common.application.dto.ResponseQueryDto;

@Component()
public class ResponseHandler {
	public ResponseEntity<Object> getOkCommandResponse(String message) {
		ResponseDto responseDto = new ResponseDto();
		ResponseOkCommandDto responseOkCommandDto = new ResponseOkCommandDto();
		responseOkCommandDto.setHttpStatus(HttpStatus.CREATED.value());
		responseOkCommandDto.setMessage(message);
		responseDto.setResponse(responseOkCommandDto);
		return new ResponseEntity<Object>(responseDto.getResponse(), HttpStatus.CREATED);
    }
	
	public ResponseEntity<Object> getAppCustomErrorResponse(String errorMessages)
    {
		ResponseDto responseDto = new ResponseDto();
		String[] errors = errorMessages.split(",");
		List<ErrorDto> errorsDto = new ArrayList<ErrorDto>();
        for (String error : errors) {
            errorsDto.add(new ErrorDto(error));
        }
        ResponseErrorDto responseErrorDto = new ResponseErrorDto(errorsDto);
        responseErrorDto.setHttpStatus(HttpStatus.BAD_REQUEST.value());
        responseDto.setResponse(responseErrorDto);
        return new ResponseEntity<Object>(responseDto.getResponse(), HttpStatus.BAD_REQUEST);
    }
	
	public ResponseEntity<Object> getAppExceptionResponse()
    {
		ResponseDto responseDto = new ResponseDto();
		List<ErrorDto> errorsDto = new ArrayList<ErrorDto>();
        errorsDto.add(new ErrorDto("Server error"));
        ResponseErrorDto responseErrorDto = new ResponseErrorDto(errorsDto);
        responseErrorDto.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseDto.setResponse(responseErrorDto);
        return new ResponseEntity<Object>(responseDto.getResponse(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	public <T> ResponseEntity<Object> getDataResponse(List<T> data, HttpStatus status) {
		ResponseDto responseDto = new ResponseDto();
		ResponseQueryDto<T> responseQueryDto = new ResponseQueryDto<T>();
		responseQueryDto.setData(data);
		responseDto.setResponse(responseQueryDto);
		return new ResponseEntity<Object>(responseDto.getResponse(), status);
	}
	
	public ResponseEntity<Object> getResponse(Object message, HttpStatus status) {
		ResponseDto responseDto = new ResponseDto();
		ResponseCommandDto responseCommandDto = new ResponseCommandDto();
		responseCommandDto.setResponse(message);
		responseDto.setResponse(responseCommandDto);
		return new ResponseEntity<Object>(responseDto.getResponse(), status);
	}
}
