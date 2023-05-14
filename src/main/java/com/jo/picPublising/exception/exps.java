package com.jo.picPublising.exception;

import com.jo.picPublising.business.dto.response.ResponseDto;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class exps {


    @ExceptionHandler(Exception.class)
    public final ResponseDto handleGeneralExceptions(Exception ex) {
        List<String> errors = Collections.singletonList(ex.getMessage());
        return ResponseDto.builder().code(200).status(false).data(null).message(errors.get(0)).build();
    }
}
