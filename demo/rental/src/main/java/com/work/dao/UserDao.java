package com.work.dao;

import com.work.model.Role;
import com.work.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by 稻草人 on 2019/3/30.
 */
public interface UserDao {

    User findByUsername(@Param("username") String username);

    int addUser(User user);

    int addUserRole(User user,Role role);

    int findIdByUsername(@Param("username") String username);

}
