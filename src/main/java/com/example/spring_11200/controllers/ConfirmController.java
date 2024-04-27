package com.example.spring_11200.controllers;

import com.example.spring_11200.services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ConfirmController {

    @Autowired
    private MailService mailService;

    @GetMapping("/confirm/{code}")
    public String confirmUser (@PathVariable("code") String code) {
        return null;
    }
}
