package com.api.client.handler;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.api.client.model.DetailsErro;
import com.api.client.service.exceptions.CityExistingException;
import com.api.client.service.exceptions.CityNotFoundException;
import com.api.client.service.exceptions.ClientExistingException;
import com.api.client.service.exceptions.ClientNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(ClientNotFoundException.class)
	public ResponseEntity<DetailsErro> handlerClientNotFoundException(ClientNotFoundException e,
			HttpServletRequest request) {

		DetailsErro erro = new DetailsErro();
		erro.setStatus(404l);
		erro.setTitle("Client not found");
		erro.setMessageDeveloper("http://XXXXXXXXXXX.com/404");
		erro.setTimeStamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(ClientExistingException.class)
	public ResponseEntity<DetailsErro> handlerClientExistingException(ClientExistingException e,
			HttpServletRequest request) {

		DetailsErro erro = new DetailsErro();
		erro.setStatus(409l);
		erro.setTitle("Client already existing");
		erro.setMessageDeveloper("http://xxxxxx.com/409");
		erro.setTimeStamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}

	@ExceptionHandler(CityNotFoundException.class)
	public ResponseEntity<DetailsErro> handlerCityNotFoundException(CityNotFoundException e,
			HttpServletRequest request) {

		DetailsErro erro = new DetailsErro();
		erro.setStatus(404l);
		erro.setTitle("City not found");
		erro.setMessageDeveloper("http://XXXXXXXXXXX.com/404");
		erro.setTimeStamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(CityExistingException.class)
	public ResponseEntity<DetailsErro> handlerCityExistingException(CityExistingException e,
			HttpServletRequest request) {

		DetailsErro erro = new DetailsErro();
		erro.setStatus(409l);
		erro.setTitle("City already existing");
		erro.setMessageDeveloper("http://xxxxxx.com/409");
		erro.setTimeStamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetailsErro> handleDataIntegrityViolationException(DataIntegrityViolationException e,
			HttpServletRequest request) {

		DetailsErro erro = new DetailsErro();
		erro.setStatus(400l);
		erro.setTitle("Invalid request");
		erro.setMessageDeveloper("http://xxxxxx.com/400");
		erro.setTimeStamp(System.currentTimeMillis());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);

	}
}
