package com.parameta.pruebatecnicaparameta.presentation.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO<String>> generalException(Exception e){
        return ResponseEntity.internalServerError().body(new ResponseDTO<>(true,e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> validationException(MethodArgumentNotValidException ex){
        List<ValidationDTO> errores = new ArrayList<>();
        BindingResult results = ex.getBindingResult();

        for (FieldError e: results.getFieldErrors()){
            errores.add(new ValidationDTO(e.getField(),e.getDefaultMessage()));
        }

        return ResponseEntity.badRequest().body(new ResponseDTO<>(true,errores));
    }
}
