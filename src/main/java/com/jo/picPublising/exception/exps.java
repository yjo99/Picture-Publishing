package com.jo.picPublising.exception;

import com.jo.picPublising.business.dto.response.ResponseDto;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestControllerAdvice
public class exps {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseDto handleValidationErrors(MethodArgumentNotValidException ex) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());

        return new ResponseDto(200,ListToString(errors).toString(), "Validation",false);    }
    private StringBuilder ListToString(List<String> errors){
        System.out.println(errors);
        StringBuilder strErrors = new StringBuilder(" ");
        for(String x : errors){
            System.out.println(x);
            strErrors.append((x + ", "));
        }

        return strErrors;
    }
    @ExceptionHandler(Exception.class)
    public final ResponseDto handleGeneralExceptions(Exception ex) {
        List<String> errors = Collections.singletonList(ex.getMessage());
        return new ResponseDto(200,errors.get(0),"Exception",false);
    }

}
