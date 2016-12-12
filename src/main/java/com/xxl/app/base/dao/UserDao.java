package com.xxl.app.base.dao;

import com.xxl.app.base.bean.User;

import java.util.List;

/**
 * Created by 58 on 2016-12-10.
 */
public interface UserDao{
    User findById(long id);

    User findByUsername(String username);

    List<User> getAllUserBean();
}
