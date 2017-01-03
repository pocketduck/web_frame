package com.chexiao.platform.base.control;

import com.chexiao.platform.base.bean.User;
import com.chexiao.platform.base.service.IUserService;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 登录控制器
 * @author Administrator
 *
 */
@Controller
public class UserControl {
	private static final Logger logger = LoggerFactory.getLogger(UserControl.class);

	@Autowired
	private IUserService userService;


	@RequestMapping("getUser")
	@ResponseBody
	public String getUser(long uid){
		logger.info("getUser uid==" + uid);
		User userBean = userService.findById(uid);
		return JSONObject.fromObject(userBean).toString();
	}

	@RequestMapping("getUserByUsername")
	@ResponseBody
	public String getUserByUsername(String username){
		logger.info("getUserByUsername username==" + username);
		User userBean = userService.findByUsername(username);
		return JSONObject.fromObject(userBean).toString();
	}

	@RequestMapping("getAllUser")
	@ResponseBody
	public String getAllUser(){

		return userService.getAllUserBean().toString();
	}


}
