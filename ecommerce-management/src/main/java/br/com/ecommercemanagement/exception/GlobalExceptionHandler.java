package br.com.ecommercemanagement.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> handleBusinessException(BusinessException businessException){
        var error = ErrorDTO
                .builder()
                .error(businessException.getMessage())
                .code(String.valueOf(businessException.getHttpStatus()))
                .build();

        return new ResponseEntity<>(error, businessException.getHttpStatus());
    }


}
