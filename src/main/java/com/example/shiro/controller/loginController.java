package com.example.shiro.controller;

import com.example.shiro.realm.service.ShiroRealmUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@RequestMapping(value = "/")
@Controller
public class loginController {
    private static final Logger logger = LoggerFactory.getLogger(loginController.class);
    @Autowired
    private ShiroRealmUserService shiroRealmUserService;
    @RequestMapping(value = "/login.do")
    public String login(String username,String password){
        shiroRealmUserService.login(username,password);
        return null;
    }
}
