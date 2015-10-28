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
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // ����JDBC����

		String dbURL = "jdbc:sqlserver://sql_nmcp:1433; DatabaseName=NMCP���Ŀ�v1"; // ���ӷ����������ݿ�sample
		String userName = "super100admin"; // Ĭ���û���
		String userPwd = "east.com%admin"; // ����
		@SuppressWarnings("unused")
		// ����ĳЩ����ʱ�ľ�����Ϣ
		Connection dbConn = null;
		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			mConn = dbConn;
			System.out.println("���ӳɹ���"); // ������ӳɹ�����̨�����Connection Successful!

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
