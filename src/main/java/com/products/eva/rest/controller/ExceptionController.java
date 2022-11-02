package com.products.eva.rest.controller;

import com.products.eva.exception.NotImplementedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    public ResponseEntity<String> checkNotImplementedException(NotImplementedException notImplementedException) {
        log.error("Error message - {}", notImplementedException.getMessage(), notImplementedException);

        return new ResponseEntity<>(notImplementedException.getMessage(), HttpStatus.NOT_IMPLEMENTED);
    }
}
