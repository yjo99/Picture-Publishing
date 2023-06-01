package com.jo.picPublising.controllers;


import com.jo.picPublising.business.dto.request.UserDto;
import com.jo.picPublising.business.mapping.UserMap;
import com.jo.picPublising.persistance.models.User;
import com.jo.picPublising.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestCont {



    @PostMapping("/user")
    public User UserService(@RequestBody @Valid UserDto userDto) {

        return new User();
    }

    @GetMapping("/admin")
    public String AdminService(){
        return "Hello Admin";
    }
}
