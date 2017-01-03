package com.chexiao.platform.base.dao.gpsdata.impl;

import com.chexiao.gpsdata.entity.gps.Position;
import com.chexiao.platform.base.dao.gpsdata.IPositionDao;
import com.chexiao.platform.base.dao.helper.GpsDataDBHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by fulei on 2017/1/3.
 */
public class PositionDaoImpl implements IPositionDao {
    private static final Logger logger =  LoggerFactory.getLogger(PositionDaoImpl.class);
    @Override
    public Position findByPositionId(long deviceId, long pid) throws Exception {
        GpsDataDBHelper.getDAOHelperByDeviceId(deviceId).get(Position.class,pid);
        return null;
    }

    @Override
    public List<Position> getPositionListByDeviceId(long deviceId) throws Exception {
        String condition = "device_id = " + deviceId;
        String orderby = "position_id desc ";
        return (List<Position>)GpsDataDBHelper.getDAOHelperByDeviceId(deviceId).getListByCustom(Position.class,"*",condition,orderby);
    }

    @Override
    public List<Position> getPositionPageListByDeviceId(long deviceId, int pageNum) throws Exception {
        String condition = "device_id = " + deviceId;
        String orderby = "position_id desc ";
        return (List<Position>)GpsDataDBHelper.getDAOHelperByDeviceId(deviceId).getListByPage(Position.class,condition,"*",pageNum,10,orderby);
    }
}
