package com.example.projeto;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api")
public class PagController {
    @GetMapping("/ola")
    public String ola(){
        return "Hello World!";
    }
}