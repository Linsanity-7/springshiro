package com.example.shiro.realm;

import com.example.shiro.dao.SysUsersMapper;
import com.example.shiro.entities.SysUsers;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;


public class ShiroRealm extends AuthorizingRealm{
    @Resource
    private SysUsersMapper userDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //1. 把 AuthenticationToken 转换为 UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) authenticationToken;
        //2. 从 UsernamePasswordToken 中来获取 username
        String username = upToken.getUsername();
        //判断用户名是否存在，若存在，返回user对象
        SysUsers user =userDao.findObjectByUsername(username);
        //盐值.
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getSalt());
        //自动完成密码比对   - 密码的比对:
        //通过 AuthenticatingRealm 的 credentialsMatcher 属性来进行的密码的比对!
        SimpleAuthenticationInfo info =
                new SimpleAuthenticationInfo(
                        username, user.getPassword(),credentialsSalt,getName());
        SecurityUtils.getSubject().getSession()
                .setAttribute("currentUser",user);
        return info;
    }
}
