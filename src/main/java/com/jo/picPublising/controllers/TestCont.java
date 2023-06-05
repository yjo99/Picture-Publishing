package com.jo.picPublising.controllers;


import com.jo.picPublising.business.dto.request.UserDto;
import com.jo.picPublising.business.mapping.UserMap;
import com.jo.picPublising.persistance.models.User;
import com.jo.picPublising.security.jwt.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestCont {



    @PostMapping("/user")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public String UserService() {

        return "Hello User";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    public String AdminService(){
        return "Hello Admin";
    }
}
