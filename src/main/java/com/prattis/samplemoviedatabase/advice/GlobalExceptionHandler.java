package com.prattis.samplemoviedatabase.advice;

import com.prattis.samplemoviedatabase.controller.error.ControllerErrorResponse;
import org.apache.logging.log4j.core.config.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
@Order(-1)
public class GlobalExceptionHandler {
    
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<ControllerErrorResponse> handleException(Exception e) {
        // Create a ControllerErrorResponse object
        ControllerErrorResponse controllerErrorResponse = ControllerErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST.value())
                .message(e.getMessage())
                .timestamp(LocalDateTime.now().toString())
                .build();
        return new ResponseEntity<>(controllerErrorResponse,HttpStatus.BAD_REQUEST);
    }
}
