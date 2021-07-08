package br.com.course.resources.exceptions;

import br.com.course.services.exceptions.DataBaseException;
import br.com.course.services.exceptions.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler{

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
    var errorMessage = "Resource not found";
    HttpStatus status = HttpStatus.NOT_FOUND;
    var error = new StandardError(
        Instant.now(),
        status.value(),
        errorMessage,
        e.getMessage(),
        request.getRequestURI());
    return ResponseEntity.status(status).body(error);
  }

  @ExceptionHandler(DataBaseException.class)
  public ResponseEntity<StandardError> dataBase(ResourceNotFoundException e, HttpServletRequest request){
    var errorMessage = "Database error";
    HttpStatus status = HttpStatus.BAD_REQUEST;
    var error = new StandardError(
        Instant.now(),
        status.value(),
        errorMessage,
        e.getMessage(),
        request.getRequestURI());
    return ResponseEntity.status(status).body(error);
  }
}
