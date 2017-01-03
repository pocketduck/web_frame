package com.chexiao.platform.base.service.impl;

import com.chexiao.platform.base.bean.User;
import com.chexiao.platform.base.service.IUserService;
import com.chexiao.platform.base.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by 58 on 2016-12-10.
 */
@Service("userService")
public class UserServiceImpl implements IUserService {

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
