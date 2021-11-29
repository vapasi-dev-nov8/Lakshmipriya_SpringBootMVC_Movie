package com.vapasi.springboot.movie.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/welcome")
public class HelloController {
    @GetMapping("/")
    public String sayHello()
    {
        return "Hello, Priya!!";
    }
}
