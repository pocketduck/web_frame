package com.xxl.app.base.control;

import com.xxl.app.base.bean.UserBean;
import com.xxl.app.base.service.IIndexService;
import com.xxl.app.base.service.IUserService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录控制器
 * @author Administrator
 *
 */
@Controller
public class UserControl {

	private static final Logger logger =
			LoggerFactory.getLogger(UserControl.class);

	@Autowired
	private IUserService userService;
	@RequestMapping("getUser")
	@ResponseBody
	public String getUser(long uid){
		logger.info("getUser uid==" + uid);
		UserBean userBean = userService.getUserBeanById(uid);
		return JSONObject.fromObject(userBean).toString();
	}

	@RequestMapping("getAllUser")
	@ResponseBody
	public String getAllUser(){

		return userService.getAllUserBean().toString();
	}


}
