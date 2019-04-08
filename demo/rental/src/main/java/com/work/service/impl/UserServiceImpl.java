package com.work.service.impl;

import com.work.dao.UserDao;
import com.work.dao.UserRoleDao;
import com.work.model.Role;
import com.work.model.User;
import com.work.model.UserRole;
import com.work.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Set;

/**
 * Created by 稻草人 on 2019/3/30.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Resource
    private UserRoleDao userRoleDao;

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Transactional
    @Override
    public void registerUser(User user) {
        userDao.addUser(user);
        Set<Role> roles = user.getRoles();
        for(Role role : roles){
            UserRole userRole = new UserRole();
            userRole.setUid(user.getId());
            userRole.setRid(role.getId());
            userRoleDao.addUserRole(userRole);
        }
    }

}
