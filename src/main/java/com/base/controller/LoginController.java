package com.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(value ="/",method = RequestMethod.POST)
    public String login(){
        return "main";
    }

    @RequestMapping(value ="/test",method = RequestMethod.POST)
    public void test(){
        System.out.println("111111111");
    }

}
