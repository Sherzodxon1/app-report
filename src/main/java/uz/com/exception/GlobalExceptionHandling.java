package com.example.restdemoapp.exception;

import com.example.restdemoapp.dto.BaseResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGenericException(final Exception e) {
        return new ResponseEntity<>(new BaseResponse<>(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleRuntimeException(final RuntimeException e) {
        return new ResponseEntity<>(new BaseResponse<>(e.getMessage()), HttpStatus.BAD_GATEWAY);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {
        ObjectError errorObject = ex.getBindingResult().getAllErrors().get(0);
        String message = errorObject.getDefaultMessage();

        Map<String, String> errors = new HashMap<>();

        errors.put("data", null);
        errors.put("errorMessage", message);
        errors.put("timestamp", String.valueOf(System.currentTimeMillis()));

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}

