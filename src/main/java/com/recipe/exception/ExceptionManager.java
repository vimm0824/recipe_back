package com.recipe.exception;

import java.sql.SQLException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.recipe.exception.enums.Response;

@RestControllerAdvice
public class ExceptionManager {

	@ExceptionHandler(CustomException.class)
	public ResponseEntity<?> customExceptionHandler(CustomException e) {
		return ResponseEntity.status(e.getErrorCode().getStatus()).body(Response.error(e));
	}

	// SQLException 발생 시 CustomException으로 변경 후 return
	@ExceptionHandler(SQLException.class)
	public ResponseEntity<?> sqlExceptionHandler(SQLException e) {
		return ResponseEntity.status(ErrorCode.INVALID_TOKEN.getStatus())
				.body(Response.error(new CustomException(ErrorCode.DATABASE_ERROR)));
	}
}
