package com.awais.wallet.Exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Map<String, String>> handleDataIntegrationViolationException(DataIntegrityViolationException ex) {
        return ResponseEntity.status(409).body(Map.of("message", ex.getMessage()));
    }


    @ExceptionHandler(HttpMessageConversionException.class)
    public ResponseEntity<Map<String, String>> handleHttpMessageNotReadableException(HttpMessageConversionException ex) {
        return ResponseEntity.status(400).body(Map.of("message", ex.getMessage()));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotFoundException(NotFoundException ex) {
        return ResponseEntity.status(404).body(Map.of("message", ex.getMessage()));
    }

    @ExceptionHandler(AuthorizationException.class)
    public ResponseEntity<Map<String, String>> handleAuthorizationException(Exception ex) {
        return ResponseEntity.status(401).body(Map.of("message", ex.getMessage()));
    }
}