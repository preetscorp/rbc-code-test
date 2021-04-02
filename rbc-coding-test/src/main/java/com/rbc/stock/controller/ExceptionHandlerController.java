package com.rbc.stock.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.rbc.stock.exception.TickerNotFoundException;
import com.rbc.stock.model.CustomErrorResponse;


@RestControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(value= TickerNotFoundException.class)
	public ResponseEntity<CustomErrorResponse> handleCourseNotFound(TickerNotFoundException ex) {
		CustomErrorResponse error = new CustomErrorResponse(HttpStatus.NOT_FOUND.ordinal(), ex.getMessage());
		error.setStatus(HttpStatus.NOT_FOUND.ordinal()); error.setTimestamp(LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IOException.class)
	public ResponseEntity<CustomErrorResponse> handleIOException(IOException ex,
			WebRequest request) {
		CustomErrorResponse error = new CustomErrorResponse(500,
				ex.getMessage());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.ordinal()); error.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
		
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomErrorResponse> handleAllException(Exception ex, WebRequest request) {
		CustomErrorResponse error = new CustomErrorResponse(500,ex.getMessage());
		error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.ordinal()); error.setTimestamp(LocalDateTime.now());

		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
