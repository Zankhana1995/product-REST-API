package com.centric.api.product.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * The type Global exception handler.
 *
 * @author Zankhana Patel
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Resource not found exception response entity.
     *
     * @param exception the exception
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(com.centric.api.product.exception.ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(
            com.centric.api.product.exception.ResourceNotFoundException exception, WebRequest request) {
        ErrorResponse errorDetails =
                new ErrorResponse(new Date(), HttpStatus.NOT_FOUND.toString(), exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    /**
     * Globle excpetion handler response entity.
     *
     * @param exception the exception
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception exception, WebRequest request) {
        ErrorResponse errorDetails =
                new ErrorResponse(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString() ,exception.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
