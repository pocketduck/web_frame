package com.chexiao.platform.base.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by fulei on 2017/1/3.
 */
@Controller
@RequestMapping("platform/device")
public class DeviceController {
    private static final Logger logger = LoggerFactory.getLogger(DeviceController.class);

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String deviceList(ModelMap model) {

        return "device/device_list";
    }
}
