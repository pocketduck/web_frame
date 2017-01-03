package com.chexiao.platform.base.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;



/**
 * index action类
 * @author Administrator
 *
 */
@Controller
public class IndexControl {

	@RequestMapping(value="index")
	public String index(Model mode){
//		indexService.doIndex();
		mode.addAttribute("user", "付雷");
		return "index";
	}

}
