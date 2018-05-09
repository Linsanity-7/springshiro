import com.example.shiro.dao.SysUsersMapper;
import com.example.shiro.entities.SysUsers;
import com.example.shiro.service.SystemUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Assert;
import org.apache.shiro.util.Factory;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;

public class Testshiro extends BaseTest{
    @Resource
    private SystemUserService userService;
    @Resource
    private SysUsersMapper userDao;
    @Test
    public void testHelloworld(){
        //1、获取SecurityManager工厂，此处使用ini配置文件初始化SecurityManager
        Factory<org.apache.shiro.mgt.SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        //3、得到Subject以及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang","123");

        try {
            //4、登陆验证身份
            subject.login(token);
        }catch (AuthenticationException e){
            //5、登陆身份验证失败
            System.out.println("登陆失败");
        }
        Assert.state(subject.isAuthenticated());
        //6、退出
        subject.logout();
    }
    @Test
    public void testSaveUser(){
        SysUsers user = new SysUsers();
        user.setUsername("admin");
        user.setPassword("123");
        user.setCreatedtime(new Date());
        user.setEmail("409506800@qq.com");
        user.setModifiedtime(new Date());
        user.setMobile("13245698741");
        user.setValid(1);
        userService.saveUser(user);
    }
    @Test
    public void testFindUserByName(){
        SysUsers user=userDao.findObjectByUsername("admin");
        System.out.println(user.toString());
    }
}
