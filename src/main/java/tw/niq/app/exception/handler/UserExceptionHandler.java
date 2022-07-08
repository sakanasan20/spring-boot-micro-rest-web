package tw.niq.app.exception.handler;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import tw.niq.app.exception.UserServiceException;
import tw.niq.app.model.response.ErrorMessage;

@ControllerAdvice
public class UserExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<Object> handleAnyException(Exception ex, WebRequest request) {
		
		String message = ex.getLocalizedMessage();
		
		if (message == null) message = ex.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(), message);
		
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {NullPointerException.class})
	public ResponseEntity<Object> handleNullPointerException(Exception ex, WebRequest request) {
		
		String message = ex.getLocalizedMessage();
		
		if (message == null) message = ex.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(), message);
		
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = {UserServiceException.class})
	public ResponseEntity<Object> handleUserServiceException(Exception ex, WebRequest request) {
		
		String message = ex.getLocalizedMessage();
		
		if (message == null) message = ex.toString();
		
		ErrorMessage errorMessage = new ErrorMessage(new Date(), message);
		
		return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
