package com.db.helper.sqlserver;

import java.sql.*;
import java.util.ArrayList;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class db {
	Connection mConn;

	public db() {
		try {
			this.mConn = this.getConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public String getTestStr() {
		return "hello,world";
	}

	public static void main(String[] args) {
		try {

			db d = new db();
			// d.getConnection();
			System.out.println(d.getCityListStr());
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public Connection getConnection() throws Exception {
		// TODO Auto-generated method stub
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // 加载JDBC驱动

		String dbURL = "jdbc:sqlserver://sql_nmcp:1433; DatabaseName=NMCP核心库v1"; // 连接服务器和数据库sample
		String userName = "super100admin"; // 默认用户名
		String userPwd = "east.com%admin"; // 密码
		@SuppressWarnings("unused")
		// 屏蔽某些编译时的警告信息
		Connection dbConn = null;
		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			mConn = dbConn;
			System.out.println("连接成功！"); // 如果连接成功控制台输出：Connection Successful!

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return dbConn;
	}

	public ArrayList<CityEntity> getCityList() {
		ArrayList<CityEntity> lst = new ArrayList<CityEntity>();
		Statement stmt = null;
		ResultSet rs = null;

		// Create and execute an SQL statement that returns some data.
		String SQL = "select * from T_City";
		try {
			stmt = mConn.createStatement();
			rs = stmt.executeQuery(SQL);

			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				CityEntity mo = new CityEntity();
				mo.setID(rs.getString("id"));
				mo.setCityName(rs.getString("cityName"));
				mo.setCityNo(rs.getString("cityNo"));
				lst.add(mo);
				// System.out.println(rs.getString("id") + " "
				// + rs.getString("cityName"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return lst;
	}

	public String getCityListStr() {
		String reVal = "";
		JSONArray json = JSONArray.fromObject(getCityList());
		reVal = json.toString();
		return reVal;
	}

}
