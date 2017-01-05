package com.chexiao.platform.base.control;

import com.chexiao.gpsdata.entity.gps.Position;
import com.chexiao.platform.base.dao.gpsdata.IPositionDao;
import com.chexiao.platform.base.dao.gpsdata.impl.PositionDaoImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fulei on 2017/1/3.
 */
@Controller
@RequestMapping("platform/gpsdata")
public class GpsDataController {
    private static final Logger logger = LoggerFactory.getLogger(GpsDataController.class);
    IPositionDao positionDao = new PositionDaoImpl();
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String positionList(ModelMap model) {
        List<Position> list = null;

        try {
            list = positionDao.getPositionPageListByDeviceId(14261610191l, 1);
        } catch (Exception e) {
            list = new ArrayList<Position>();
        }
        logger.info("gpsdata 数据量==" + list.size());
        model.addAttribute("positionList", list);
        return "gpsdata/data_list";
    }
}
