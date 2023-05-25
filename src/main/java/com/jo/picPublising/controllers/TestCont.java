package com.jo.picPublising.controllers;


import com.jo.picPublising.business.dto.request.UserDto;
import com.jo.picPublising.business.mapping.UserMap;
import com.jo.picPublising.persistance.models.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/test")
public class TestCont {


    @PostMapping("/user")
    public String UserService(@RequestBody @Valid UserDto userDto) {
        return "userDto.getUserName()";
    }

    @GetMapping("/admin")
    public String AdminService(){
        return "Hello Admin";
    }
}
