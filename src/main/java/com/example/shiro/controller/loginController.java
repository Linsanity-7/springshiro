package com.example.shiro.controller;

import com.example.shiro.entities.SysUsers;
import com.example.shiro.service.SystemUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@RequestMapping(value = "/")
@Controller
public class loginController {
    private static final Logger logger = LoggerFactory.getLogger(loginController.class);
    @Resource
    private SystemUserService userService;
    @RequestMapping(value = "/login.do")
    public String login(@RequestParam String username,@RequestParam String password){
        SysUsers user = userService.findObjectByName(username);

        return null;
    }
}
