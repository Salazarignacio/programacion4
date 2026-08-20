package com.gestor_pedidos.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleValidationError(MethodArgumentNotValidException ex ){
        List<String> detalles = ex.getBindingResult()
                .getFieldErrors().stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage()).toList();
        ErrorDTO errorDTO = ErrorDTO.of(HttpStatus.BAD_REQUEST.value(), "Error de validacion", detalles);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorDTO> handleConstraintViolation(ConstraintViolationException ex){
    List<String> detalles = ex.getConstraintViolations().stream().map(v -> v.getPropertyPath()+ ": " + v.getMessage()).toList();
    ErrorDTO errorDTO = ErrorDTO.of(HttpStatus.BAD_REQUEST.value(), "Error de validacion", detalles);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDTO);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGeneric(Exception ex){
        ErrorDTO errorDTO = ErrorDTO.simple(HttpStatus.INTERNAL_SERVER_ERROR.value(),  "Error interno del servidor", ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDTO);
    }
}
