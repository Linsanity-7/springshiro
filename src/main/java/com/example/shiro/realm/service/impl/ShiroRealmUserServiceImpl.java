package com.example.shiro.realm.service.impl;

import com.example.shiro.dao.SysUsersMapper;
import com.example.shiro.exception.ServiceException;
import com.example.shiro.realm.service.ShiroRealmUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class ShiroRealmUserServiceImpl implements ShiroRealmUserService{

    private static final Logger logger = LoggerFactory.getLogger(ShiroRealmUserServiceImpl.class);

    @Override
    public void login(String username, String password) {
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated())return;
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        try{
            subject.login(token);
        }catch (IncorrectCredentialsException ic){
            throw new ServiceException("用户登录验证-->密码错误！");
        }catch (AuthenticationException ae){
            logger.debug("用户登录验证-->认证失败！");
            throw new ServiceException("认证失败！");
        }

    }
}
