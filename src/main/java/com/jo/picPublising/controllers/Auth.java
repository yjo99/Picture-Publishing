package com.jo.picPublising.controllers;

import com.jo.picPublising.business.dto.request.LogInDto;
import com.jo.picPublising.business.dto.request.UserDto;
import com.jo.picPublising.business.dto.response.ResponseDto;
import com.jo.picPublising.business.service.Authentication;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class Auth {

    private final Authentication authentication;

    @PostMapping("/signup")
    public ResponseDto Signup(@RequestBody @Valid UserDto userDto){
        return authentication.SignUp(userDto);
    }

    @PostMapping("/login")
    public ResponseDto Login(@RequestBody @Valid LogInDto loginDto){
        return authentication.Login(loginDto);
    }
}
