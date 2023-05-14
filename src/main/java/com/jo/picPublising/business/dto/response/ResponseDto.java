package com.jo.picPublising.business.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import java.time.LocalDateTime;


@Builder
@Data
public class ResponseDto {
    private Integer code;
    private String message;
    private Object data;
    private Boolean status;
    private LocalDateTime publishedDate = LocalDateTime.now();


}
