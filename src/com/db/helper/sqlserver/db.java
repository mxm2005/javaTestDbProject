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
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; // ����JDBC����

		String dbURL = "jdbc:sqlserver://sql_nmcp:1433; DatabaseName=6666���Ŀ�v1"; // ���ӷ����������ݿ�sample
		String userName = "super100admin"; // Ĭ���û���
		String userPwd = "east.com%admin"; // ����
		@SuppressWarnings("unused")
		// ����ĳЩ����ʱ�ľ�����Ϣ
		Connection dbConn;
		try {
			Class.forName(driverName);
			dbConn = DriverManager.getConnection(dbURL, userName, userPwd);
			mConn = dbConn;
			System.out.println("���ӳɹ���"); // ������ӳɹ�����̨�����Connection Successful!
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
