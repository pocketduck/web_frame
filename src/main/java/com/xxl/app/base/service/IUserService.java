package com.xxl.app.base.service;

import com.xxl.app.base.bean.UserBean;

import java.util.List;

/**
 * Created by 58 on 2016-12-10.
 */
public interface IUserService {

    UserBean getUserBeanById(long id);

    List<UserBean> getAllUserBean();

}
