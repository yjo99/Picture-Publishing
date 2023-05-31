package com.jo.picPublising.business.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LogInDto {

    @NotBlank(message = "Invalid Email: Email is empty.")
    @NotNull(message = "Invalid Email: Email is null.")
    @Email(message = "Invalid email.")
    private String email;

    @NotBlank(message = "Invalid Password: Password is empty.")
    @NotNull(message = "Invalid Password: Password is null.")
    @Size(min = 3, max = 30, message = "Invalid Password : Must be of 3-30 character.")
    private String password;
}
