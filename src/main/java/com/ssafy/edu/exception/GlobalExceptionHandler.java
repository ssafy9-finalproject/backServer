package com.ssafy.edu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ssafy.edu.utils.ApiUtils;
import com.ssafy.edu.utils.ApiUtils.ApiResult;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ApiResult IllegalException(IllegalArgumentException e) {
		return ApiUtils.error("123", HttpStatus.ACCEPTED);
	}
}
