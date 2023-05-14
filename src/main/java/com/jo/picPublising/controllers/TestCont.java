package com.jo.picPublising.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestCont {

    @GetMapping("/user")
    public String UserService() throws Exception {
        throw new Exception("User Exception");
//        return "Hello User";
    }

    @GetMapping("/admin")
    public String AdminService(){
        return "Hello Admin";
    }
}
