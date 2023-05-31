package com.jo.picPublising.business.dto.request;

import lombok.Builder;
import lombok.Data;
import org.springframework.stereotype.Component;

import jakarta.validation.constraints.*;

import java.util.Set;


@Data
@Builder
public class UserDto {

    @NotBlank(message = "Invalid User Name: name is empty.")
    @NotNull(message = "Invalid User Name: name is null.")
    @Size(min = 3, max = 30, message = "Invalid User Name : Must be of 3-30 character.")
    private String userName;

    @NotBlank(message = "Invalid Email: Email is empty.")
    @NotNull(message = "Invalid Email: Email is null.")
    @Email(message = "Invalid email.")
    private String email;

    private String address;

    @NotBlank(message = "Invalid Password: Password is empty.")
    @NotNull(message = "Invalid Password: Password is null.")
    @Size(min = 3, max = 30, message = "Invalid Password : Must be of 3-30 character.")
    private String password;

    private Set<String> roles;
}
