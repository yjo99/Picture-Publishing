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
        return ResponseDto.builder().message(ListToString(errors).toString()).data(null).status(false).code(200).build();
    }
    private StringBuilder ListToString(List errors){
        StringBuilder strErrors = new StringBuilder(" ");
        errors.stream().map(x -> strErrors.append((x + ", \n")));
        return strErrors;
    }
    @ExceptionHandler(Exception.class)
    public final ResponseDto handleGeneralExceptions(Exception ex) {
        List<String> errors = Collections.singletonList(ex.getMessage());
        return ResponseDto.builder().code(200).status(false).data(null).message(errors.get(0)).build();
    }

}
