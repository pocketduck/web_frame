package com.xxl.app.base.control;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录控制器
 * @author Administrator
 *
 */
@Controller
public class LoginControl {

	private static final Logger logger =
			LoggerFactory.getLogger(LoginControl.class);

	@RequestMapping("loginTest")
	@ResponseBody
	public String testLogin(HttpServletRequest request){
		System.out.println("test login");


		Map<String,Object> map = new HashMap<String, Object>();
		map.put("result", "test Success");
		return JSONObject.fromObject(map).toString();
	}

	@RequestMapping("login")

	public String index(Model mode){
		logger.info("come in  login");
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("result", "test Success");
		return "login";
	}


}
