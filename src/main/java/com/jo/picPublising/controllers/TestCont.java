package com.jo.picPublising.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
