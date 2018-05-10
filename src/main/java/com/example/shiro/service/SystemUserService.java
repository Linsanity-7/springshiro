package com.example.shiro.service;

import com.example.shiro.entities.SysUsers;

public interface SystemUserService {
    void saveUser(SysUsers user);
    SysUsers findObjectByName(String username);
}
