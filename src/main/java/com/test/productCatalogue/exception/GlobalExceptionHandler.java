package com.test.productCatalogue.exception;

import com.test.productCatalogue.helper.ApiResponse;
import com.test.productCatalogue.helper.ResponseHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleException(Exception ex) {
        return ResponseHelper.error(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handleNotFoundException
            (ProductNotFoundException productNotFoundException) {
        return ResponseHelper.error(HttpStatus.NOT_FOUND, productNotFoundException.getMessage());
    }
}
