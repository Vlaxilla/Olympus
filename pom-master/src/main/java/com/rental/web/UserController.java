package com.rental.web;

import com.rental.QO.UserForm;
import com.rental.common.Result;
import com.rental.entity.User;
import com.rental.service.IUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    @ResponseBody
    public String login(User user, HttpSession session) {
        if (StringUtils.isBlank(user.getUsername()) || StringUtils.isBlank(user.getPassword())) {
            return Result.genResponse(Result.fail("username and password can't be empty"));
        }
        return userService.login(user, session);
    }

    @PostMapping("/sign-up")
    @ResponseBody
    public String signUp(User user) {
        if (StringUtils.isBlank(user.getIdCard()) ||
                StringUtils.isBlank(user.getUsername()) ||
                StringUtils.isBlank(user.getPassword()) ||
                StringUtils.isBlank(user.getPhone()) ||
                StringUtils.isBlank(user.getAddress())) {
            return Result.genResponse(Result.fail("params wrong"));
        }
        return userService.register(user);
    }

    @RequestMapping("/logout")
    public String logout(int type, HttpSession session) {
        if (type == 1) {
            session.removeAttribute("user");
            return "redirect:/index";
        } else {
            session.removeAttribute("staff");
            return "redirect:/login";
        }

    }
    @PostMapping(value = "/checkLogin")
    @ResponseBody
    public Result checkLogin(HttpSession session) {
        if(session.getAttribute("user") == null) {
            return Result.fail("please login first");
        }else{
            return Result.ok("had login");
        }
    }

    @PostMapping("/updateProfile")
    @ResponseBody
    public Result updateProfile(UserForm user, HttpSession session) {
        if (user.getId() == null) {
            return Result.fail("params wrong");
        }
        User target = userService.selectById(user.getId());
        target = user.toUser(target);
        if(userService.updateById(target)){
            session.setAttribute("user",target);
            return Result.ok("update success");
        }else{
            return Result.fail("update profile fail");

        }
    }
}
