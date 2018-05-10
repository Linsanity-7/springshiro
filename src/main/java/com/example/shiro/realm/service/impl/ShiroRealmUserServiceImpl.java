package com.example.shiro.realm.service.impl;

import com.example.shiro.dao.SysUsersMapper;
import com.example.shiro.realm.service.ShiroRealmUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShiroRealmUserServiceImpl implements ShiroRealmUserService{
    @Resource
    private SysUsersMapper userDao;

}
