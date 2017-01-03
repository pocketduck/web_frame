package com.chexiao.platform.base.control;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.chexiao.platform.base.util.UniqueIDUtils;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

		try {
			long id =  UniqueIDUtils.getUniqueID();
			logger.info("id==" +id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Map<String,Object> map = new HashMap<String, Object>();
		map.put("result", "test Success");
		return JSONObject.fromObject(map).toString();
	}

	@RequestMapping(value = "access_denied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		model.addAttribute("user", getPrincipal());
		return "access_denied";
	}

	@RequestMapping(value = "loginfailed", method = RequestMethod.GET)
	public String loginfailed(ModelMap model) {

		return "login/login_failed";
	}


	@RequestMapping("main")
	public String main(Model mode) {
		UserDetails userDetails =
				(UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		mode.addAttribute("user", userDetails.getUsername());

		return "main";
	}

	@RequestMapping(value = "admin", method = RequestMethod.GET)
	public String admin() {
		return "admin";
	}


	@RequestMapping(value = "db", method = RequestMethod.GET)
	public String db() {
		return "db";
	}

	@RequestMapping(value="logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null){
			new SecurityContextLogoutHandler().logout(request, response, auth);
		}
		return "redirect:logout.jsp";
	}

	private String getPrincipal(){
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails)principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}

}
