package com.example.demo.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JDBCUtils {
    private static String driver;
    private static String url;
    private static String pwd;
    private static String usr;
    private static Connection con;

    static {
        try {
            url = "jdbc:mysql://localhost:3306/session1?serverTimezone=UTC";
            driver = "com.mysql.cj.jdbc.Driver";
            pwd = "123456";
            usr = "root";
            Class.forName(driver);
        } catch (Exception e) {

        }
    }

    private static Connection getConn() {
        try {
            con = DriverManager.getConnection(url, usr, pwd);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return con;
    }

    private static void close(Connection con, Statement sta, ResultSet rs) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (Exception e) {

        }
        try {
            if (sta != null) {
                sta.close();
            }
        } catch (Exception e) {

        }
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (Exception e) {

        }
    }

    public static List<HashMap<String, String>> query(String sql) {
        Connection conn = JDBCUtils.getConn();
        List<HashMap<String, String>> list = new ArrayList<>();
        try {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData data = resultSet.getMetaData();
            while (resultSet.next()) {
                HashMap<String, String> map = new HashMap<>();
                for (int i = 1; i <= data.getColumnCount(); i++) {
                    /*
                        getColumnLabel获取重命名后的字段名(别名)
                        getColumnName获取重命名前的字段名(本来的名字)
                    */
                    String columnName = data.getColumnLabel(i);
                    map.put(columnName, resultSet.getString(columnName));
                }
                list.add(map);
            }
            close(conn, statement, resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static Integer update(String sql) {
        Connection conn = JDBCUtils.getConn();
        int i = 0;
        try {
            Statement statement = conn.createStatement();
            i = statement.executeUpdate(sql);
            close(conn, statement, null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }
}
