package com.jo.picPublising.business.dto.request;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
public class UserDto {

    @NotBlank(message = "Invalid User Name: name is empty.")
    @NotNull(message = "Invalid User Name: name is null.")
    @Size(min = 3, max = 30, message = "Invalid User Name : Must be of 3-30 character.")
    private String userName;

    @Email(message = "Invalid email.")
    private String email;


    private String address;

    @NotBlank(message = "Invalid Password: Password is empty.")
    @NotNull(message = "Invalid Password: Password is null.")
    @Size(min = 3, max = 30, message = "Invalid Password : Must be of 3-30 character.")
    private String password;

}
