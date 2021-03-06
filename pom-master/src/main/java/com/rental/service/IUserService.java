package com.rental.service;


import com.baomidou.mybatisplus.service.IService;
import com.rental.QO.UserForm;
import com.rental.entity.User;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * Service class?
 * </p>
 */
public interface IUserService extends IService<User> {
    String login(User user, HttpSession session);

    String register(User user);

    String findCustomers(UserForm form);
}
