package com.yma16.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Controller
public class IndexController {
    @GetMapping("index")
    @ResponseBody
    public  String index(){
        return "success";
    }
    @GetMapping("admin")
    @ResponseBody
    public  String admin(){
        return "admin";
    }
}
