package com.centric.api.product.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Global exception handler.
 *
 * @author Zankhana Patel
 */
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * MethodArgumentNotValidException response entity.
     *
     * @param ex the exception
     * @param headers the headers
     * @param request the request
     * @return the response entity
     */
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(x -> x.getDefaultMessage())
                .collect(Collectors.toList());

        ErrorResponse errorDetails =
                new ErrorResponse(new Date(), HttpStatus.BAD_REQUEST.toString(), "Validation Failed",request.getDescription(false),errors);
        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }

    /**
     * Resource not found exception response entity.
     *
     * @param exception the exception
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundException(
            ResourceNotFoundException exception, WebRequest request) {
        ErrorResponse errorDetails =
                new ErrorResponse(new Date(), HttpStatus.NOT_FOUND.toString(), exception.getMessage(), request.getDescription(false),new ArrayList<>());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    /**
     * Globle exception handler response entity.
     *
     * @param exception the exception
     * @param request the request
     * @return the response entity
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> globleExcpetionHandler(Exception exception, WebRequest request) {
        ErrorResponse errorDetails =
                new ErrorResponse(new Date(), HttpStatus.INTERNAL_SERVER_ERROR.toString() ,exception.getMessage(), request.getDescription(false),new ArrayList<>());
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
