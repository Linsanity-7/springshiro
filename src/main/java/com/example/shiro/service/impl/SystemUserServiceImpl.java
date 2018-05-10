package com.example.shiro.service.impl;

import com.example.shiro.dao.SysUsersMapper;
import com.example.shiro.entities.SysUsers;
import com.example.shiro.exception.ServiceException;
import com.example.shiro.service.SystemUserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

@Service("userService")
@Transactional
public class SystemUserServiceImpl implements SystemUserService {
    @Resource
    private SysUsersMapper userDao;
    @Override
    public void saveUser(SysUsers user) {
        if(user==null){
            throw new SecurityException("保存用户信息对象不能为空");
        }
        //生成随机数
        String saltStr = UUID.randomUUID().toString();
        //将随机数转换成盐值
        ByteSource salt = ByteSource.Util.bytes(saltStr);
        String pwd = new SimpleHash("MD5",user.getPassword(),salt).toString();
        user.setPassword(pwd);
        user.setSalt(saltStr);
        //保存用户信息
        int i = userDao.insert(user);
        if(i==-1)throw new ServiceException("保存用户信息失败");
    }

    @Override
    public SysUsers findObjectByName(String username) {
        SysUsers user=userDao.findObjectByUsername(username);
        if (user==null){
            throw new ServiceException("该用户名不存在！");
        }
        return user;
    }
}
