package com.chexiao.platform.base.dao.gpsdata;

import com.chexiao.gpsdata.entity.gps.Position;

import java.util.List;

/**
 * Created by fulei on 2017/1/3.
 */
public interface IPositionDao {

    public Position findByPositionId (long deviceId,long pid)throws Exception;

    public List<Position> getPositionListByDeviceId(long deviceId)throws Exception;

    public List<Position> getPositionPageListByDeviceId(long deviceId, int pageNum)throws Exception;
}
