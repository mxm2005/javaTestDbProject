package com.db.helper.sqlserver;

import java.sql.*;

public class db {
	Connection mConn;

	public db() {

	}

	public String getTestStr() {
		return "hello,world";
	}

	public static void main(String[] args) {
		try {

			db d = new db();
			d.getConnection();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void getConnection() throws Exception {
		// TODO Auto-generated method stub
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // 加载JDBC驱动

		String dbURL = "jdbc:sqlserver://sql_nmcp:1433; DatabaseName=6666核心库v1"; // 连接服务器和数据库sample
		String userName = "super100admin"; // 默认用户名
		String userPwd = "east.com%admin"; // 密码
		@SuppressWarnings("unused")
		// 屏蔽某些编译时的警告信息
		Connection dbConn;
		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			mConn = dbConn;
			System.out.println("连接成功！"); // 如果连接成功控制台输出：Connection Successful!
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
