package com.ssafy.edu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ssafy.edu.utils.ApiUtils;

import lombok.extern.slf4j.Slf4j;

import static com.ssafy.edu.utils.ApiUtils.error;

// 모든 예외를 한곳에서 처리
@Slf4j
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
	public ResponseEntity<ApiUtils.ApiResult<?>> handleUnAuthorizedException(UnAuthorizedException e){
		return errorResponse(e.getMessage(), HttpStatus.UNAUTHORIZED); // 401
	}
	
	@ExceptionHandler(TokenExpiredException.class)
	public ResponseEntity<ApiUtils.ApiResult<?>> handleTokenExpiredException(TokenExpiredException e){
		return errorResponse(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler(TokenInvalidException.class)
	public ResponseEntity<ApiUtils.ApiResult<?>> handleTokenInvalidException(TokenInvalidException e){
		return errorResponse(e.getMessage(), HttpStatus.UNAUTHORIZED); // 401
	}
	
	@ExceptionHandler(MemberException.class)
	public ResponseEntity<ApiUtils.ApiResult<?>> handleMemberException(MemberException e){
		return errorResponse(e.getMessage(), HttpStatus.NO_CONTENT); // 204
	}
	
	@ExceptionHandler(InternalServerErrorException.class)
	public ResponseEntity<ApiUtils.ApiResult<?>> handleInternalServerErrorException(InternalServerErrorException e){
		return errorResponse(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR); // 500
	}
}
