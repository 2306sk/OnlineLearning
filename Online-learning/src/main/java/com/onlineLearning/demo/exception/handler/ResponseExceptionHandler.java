package com.onlineLearning.demo.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import static com.onlineLearning.demo.utils.Constants.COURSE_NOT_FOUND_ERROR_MESSAGE;
import static com.onlineLearning.demo.utils.Constants.COURSE_NOT_FOUND;
import static org.springframework.http.HttpStatus.NOT_FOUND;


import com.onlineLearning.demo.exception.CourseNotFoundException;
import com.onlineLearning.demo.model.ErrorResponse;

@ControllerAdvice
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CourseNotFoundException.class)
	public final ResponseEntity<ErrorResponse> PersonCodeNotFoundException(Exception ex, WebRequest request) {
		return new ResponseEntity<>(getErrorResponse(COURSE_NOT_FOUND, COURSE_NOT_FOUND_ERROR_MESSAGE), NOT_FOUND);
	}
	
	private ErrorResponse getErrorResponse(String errorCode, String errorMessage) {
		return ErrorResponse.builder().errorCode(errorCode).description(errorMessage).build();
	}
}
