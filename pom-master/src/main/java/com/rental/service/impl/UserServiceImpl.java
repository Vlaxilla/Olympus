package com.rental.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.rental.QO.UserForm;
import com.rental.common.PageBean;
import com.rental.common.Result;
import com.rental.entity.User;
import com.rental.mapper.UserMapper;
import com.rental.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.plugins.Page;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * Service implementation class?
 * </p>
 */
@Service

public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public String login(User user, HttpSession session) {
        User target = this.selectOne(new EntityWrapper<User>().eq("username", user.getUsername()));
        if (target == null || !target.getPassword().equals(user.getPassword())) {
            return Result.genResponse(Result.fail("username or password may be wrong"));
        }
        if (target.getType().equals(1)) {
            session.setAttribute("user", target);
        } else {
            session.setAttribute("staff", target);
        }
        return Result.genResponse(Result.ok("login success", target.getType()));
    }

    @Override
    public String register(User user) {
        User target = this.selectOne(new EntityWrapper<User>().eq("username", user.getUsername()));
        if (target != null) {
            return Result.genResponse(Result.fail("username is already exist"));
        }
        user.setType(1);
        user.setIsBlacklist(0);
        user.setCredit(80);
        this.insert(user);
        return Result.genResponse(Result.ok("register success"));
    }

    @Override
    public String findCustomers(UserForm form) {
        Page<User> page = form.getPage();
        if (page == null) {
            page = form.createPage();
        }
        page.setRecords(baseMapper.selectPage(page, form.toWrapper()));
        return Result.genResponse(Result.ok(new PageBean<>(page)));
    }
}

