package com.app.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Error {

    @GetMapping("/Permisos")
    public String errorPermisos() {

        return "Error";
    }

}
