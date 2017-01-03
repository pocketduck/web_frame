package com.chexiao.platform.base.dao;

import com.chexiao.platform.base.bean.User;

import java.util.List;

/**
 * Created by 58 on 2016-12-10.
 */
public interface UserDao{
    User findById(long id);

    User findByUsername(String username);

    List<User> getAllUserBean();
}
