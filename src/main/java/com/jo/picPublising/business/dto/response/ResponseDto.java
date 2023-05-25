package com.jo.picPublising.business.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@NoArgsConstructor
@Data
public class ResponseDto {
    private Integer code;
    private String message;
    private Object data;
    private Boolean status;
    LocalDateTime date = LocalDateTime.now();

    public ResponseDto(Integer code, String message, Object data, Boolean status){
        this.code = code;
        this.message = message;
        this.data = data;
        this.status = status;
    }



}
