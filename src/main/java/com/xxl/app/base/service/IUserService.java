package com.xxl.app.base.service;

import com.xxl.app.base.bean.User;

import java.util.List;

/**
 * Created by 58 on 2016-12-10.
 */
public interface IUserService {
    User findById(long id);

    User findByUsername(String username);

    List<User> getAllUserBean();

}
