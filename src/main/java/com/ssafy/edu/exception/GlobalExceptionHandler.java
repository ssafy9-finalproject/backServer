package com.ssafy.edu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ssafy.edu.utils.ApiUtils;
import static com.ssafy.edu.utils.ApiUtils.error;

// 모든 예외를 한곳에서 처리
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	public ResponseEntity<ApiUtils.ApiResult<?>> errorResponse(String message, HttpStatus status) {	
		return new ResponseEntity<>(error(message,status), status);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiUtils.ApiResult<?>> badRequestException(MethodArgumentNotValidException e) {
		return errorResponse(e.getBindingResult().getAllErrors().get(0).getDefaultMessage(), HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ApiUtils.ApiResult<?>> notFoundException(NotFoundException e) {
		return errorResponse(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(UnAuthorizedException.class)
	public ResponseEntity<ErrorResponse> handleUnAuthorizedException(UnAuthorizedException e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
		.body(ErrorResponse.builder()
				.errorCode(e.getErrorCode().toString())
				.message(e.getErrorMessage())
				.build());
	}
	
	@ExceptionHandler(TokenExpiredException.class)
	public ResponseEntity<ErrorResponse> handleTokenExpiredException(TokenExpiredException e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ErrorResponse.builder()
						.errorCode(e.getErrorCode().toString())
						.message(e.getErrorMessage())
						.build());
	}
	
	@ExceptionHandler(TokenInvalidException.class)
	public ResponseEntity<ErrorResponse> handleTokenInvalidException(TokenInvalidException e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(ErrorResponse.builder()
						.errorCode(e.getErrorCode().toString())
						.message(e.getErrorMessage())
						.build());
	}
}
