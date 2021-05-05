package com.capintani.customerregistration.handler;

import com.capintani.customerregistration.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomerHandle extends ResponseEntityExceptionHandler {


    @ExceptionHandler(CepNotFoudException.class)
    protected ResponseEntity<String> handleCepNotFoundException(CepNotFoudException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(CpfOREmailDuplicateException.class)
    protected ResponseEntity<String> handleCpfOrEmailDuplicateException(CpfOREmailDuplicateException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

     @ExceptionHandler(CpfInvalidException.class)
    protected ResponseEntity<String> handleCpfInvalidException(CpfInvalidException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(CepInvalidException.class)
    protected ResponseEntity<String> handleCepInvalidException(CepInvalidException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(EmailNotRegisteredException.class)
    protected ResponseEntity<String> handleEmailNotRegisteredException(EmailNotRegisteredException exception) {
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
