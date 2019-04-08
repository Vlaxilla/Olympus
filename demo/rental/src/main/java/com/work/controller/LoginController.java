package com.work.controller;

import com.work.enums.ResultEnum;
import com.work.exception.LoginException;
import com.work.model.Role;
import com.work.model.User;
import com.work.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Controller
@Slf4j
public class LoginController {

    @Resource
    private UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    /**
     * User login
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "/loginUser", method = RequestMethod.POST)
    public ModelAndView loginUser(@RequestParam("username") String username,
                                  @RequestParam("password") String password,
                                  Map<String,Object> map,
                                  HttpSession session){
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try{
            Subject subject = SecurityUtils.getSubject();

            subject.login(token);
            User user = (User) subject.getPrincipal();
            session.setAttribute("user", user);
            Set<Role> roles = user.getRoles();
            for(Role role:roles){
                if("staff".equals(role.getName())){
                    log.info("[LOGIN] SUCCESS,username={},role is {}",user.getUsername(),"staff");
                    return new ModelAndView("/staff/staffIndex");
                }else if("customer".equals(role.getName())){
                    log.info("[LOGIN] SUCCESS,username={},role is {}",user.getUsername(),"customer");
                    return new ModelAndView("/index");
                }
            }
            log.info("[LOGIN] FAILED,username={},unauthorized!",user.getUsername());
            return new ModelAndView("/unauthorized");
        } catch (Exception e) {
            log.info("[LOGIN] FAILED,username={},sign up failed!",username);
            return new ModelAndView("/unauthorized");
        }

    }

    /**
     * Logout
     * @param map
     * @return
     */
    @RequestMapping("/logout")
    public ModelAndView logout(Map<String,Object> map){
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {
            subject.logout();
        }
        map.put("msg", ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url","/login");
        return new ModelAndView("common/success",map);
    }

    /**
     * Unauthorized
     * @return
     */
    @RequestMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

    /**
     * go to Sign up page
     * @return
     */
    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public ModelAndView registerUser(User user,
                                     Map<String,Object> map){
        //1. 判断用户名是否重复,若重复，则返回注册页面
        if(userService.findByUsername(user.getUsername()) != null){
            map.put("msg",ResultEnum.DUPLICATE_USERNAME);
            map.put("url","/register");
            return new ModelAndView("/common/error",map);
        }
        //2. 保存用户信息;注册者均为普通用户
        try{
            Role role = new Role();
            role.setId(2);
            role.setName("customer");

            Set<Role> roles = new HashSet<>();
            roles.add(role);

            user.setId((int)(1+Math.random()*(8-1+1)));
            user.setCredit(80); //默认信用分为80
            user.setRoles(roles);   //角色为 普通顾客
            user.setIsBlasklist(false); //默认正常用户——不在黑名单中

            userService.registerUser(user);

        }catch (Exception e){
            log.info("[SIGNUP]Failed. msg= {}",e.toString());
            map.put("msg",ResultEnum.SIGN_UP_FAILED);
            map.put("url","/register");
            return new ModelAndView("/common/error",map);
        }

        //3. 跳转
        map.put("msg",ResultEnum.SUCCESS);
        map.put("url","/login");
        return new ModelAndView("/common/success",map);
    }

}
