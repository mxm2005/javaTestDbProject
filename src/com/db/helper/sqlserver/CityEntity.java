package com.db.helper.sqlserver;

/**
 * 城市实体类
 * 
 * @author mxm
 * 
 */
public class CityEntity {

	String ID;
	String CityName;
	String CityNo;

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getCityName() {
		return CityName;
	}

	public void setCityName(String cityName) {
		CityName = cityName;
	}

	public String getCityNo() {
		return CityNo;
	}

	public void setCityNo(String cityNo) {
		CityNo = cityNo;
	}
}
