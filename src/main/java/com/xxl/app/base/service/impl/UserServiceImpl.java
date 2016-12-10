package com.xxl.app.base.service.impl;

import com.xxl.app.base.bean.UserBean;
import com.xxl.app.base.dao.UserDao;
import com.xxl.app.base.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


/**
 * Created by 58 on 2016-12-10.
 */
@Service("userService")
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserDao userDao;

    public UserBean getUserBeanById(long id) {
        UserBean user =  userDao.getUserBeanById(id);
        return user;
    }

    public List<UserBean> getAllUserBean() {
        return userDao.getAllUserBean();
    }
}
