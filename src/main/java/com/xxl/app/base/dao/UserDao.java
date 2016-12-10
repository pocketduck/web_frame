package com.xxl.app.base.dao;

import com.xxl.app.base.bean.UserBean;

import java.util.List;

/**
 * Created by 58 on 2016-12-10.
 */
public interface UserDao{
    UserBean getUserBeanById(long id);

    List<UserBean> getAllUserBean();
}
