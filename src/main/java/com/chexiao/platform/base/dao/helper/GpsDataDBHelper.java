package com.chexiao.platform.base.dao.helper;


import com.chexiao.base.dao.DAOOperator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


public class GpsDataDBHelper {
	private static final Log logger = LogFactory.getLog(GpsDataDBHelper.class);

	public static DAOOperator[] daoHelperArr = null;


	static {
		try {
			daoHelperArr = new DAOOperator[2];


			String path1 = Thread.currentThread().getContextClassLoader().getResource("db/gpsdb_0.properties").getPath();
			String path2 = Thread.currentThread().getContextClassLoader().getResource("db/gpsdb_1.properties").getPath();
			daoHelperArr[0] = new DAOOperator(path1);
			daoHelperArr[1] = new DAOOperator(path2);

			logger.info("gpsdb初始化ok");
		} catch (Exception ex) {
			logger.error("初始化gpsdb Error  ", ex);
		}
	}

	/**
	 * 根据用户设备iid返回 数据库
	 * @param deviceId
	 * @return DAOOperator
	 */
	public static DAOOperator getDAOHelperByDeviceId(long deviceId) {
		if (null == daoHelperArr || deviceId < 0) {
			throw new IllegalArgumentException("getDAOHelper error ");
		}
		DAOOperator operator = daoHelperArr[mod(deviceId, daoHelperArr.length)];
		return operator;
	}


	public static DAOOperator[] getAllDAOHelper() {
		return daoHelperArr;
	}


	/**
	 * 根据id取模
	 * @param id
	 * @param len
	 * @return
	 */
	public static int mod(long id, int len) {
		return Math.abs((Long.valueOf(id).hashCode()) % len);
	}

}
