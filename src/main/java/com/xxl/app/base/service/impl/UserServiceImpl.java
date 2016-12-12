package com.xxl.app.base.service.impl;

import com.xxl.app.base.bean.User;
import com.xxl.app.base.dao.UserDao;
import com.xxl.app.base.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by 58 on 2016-12-10.
 */
@Service("userService")
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserDao userDao;

    public User findById(long id) {
        User user =  userDao.findById(id);
        return user;
    }

    public User findByUsername(String username) {
        User user =  userDao.findByUsername(username);
        return user;
    }

    public List<User> getAllUserBean() {
        return userDao.getAllUserBean();
    }
}
