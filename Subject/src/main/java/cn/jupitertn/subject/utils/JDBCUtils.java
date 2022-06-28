package cn.jupitertn.subject.utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JDBCUtils {
    static String drivers;
    static String url;
    static String user;
    static String pwd;
    static Connection con;

    static {
        try {
            drivers = "com.mysql.cj.jdbc.Driver";
            url = "jdbc:mysql://localhost:3306/subject?serverTimezone=UTC";
            user = "subject";
            pwd = "";
            Class.forName(drivers);
        } catch (Exception e) {
        }
    }

    private static Connection getCon() {
        try {
            con = DriverManager.getConnection(url, user, pwd);
        } catch (Exception e) {
        }
        return con;
    }

    private static void close(Connection conn, Statement stat, ResultSet rs) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
        }
        try {
            if (stat != null) {
                stat.close();
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
        Connection con1 = JDBCUtils.getCon();
        List<HashMap<String, String>> list = new ArrayList<>();
        try {
            Statement statement = con1.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            ResultSetMetaData data = resultSet.getMetaData();
            while (resultSet.next()) {
                HashMap<String, String> map = new HashMap<>();
                for (int i = 1; i <= data.getColumnCount(); i++) {
                    String name = data.getColumnLabel(i);
                    map.put(name, resultSet.getString(name));
                }
                list.add(map);
            }
            close(con1, statement, resultSet);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public static Integer update(String sql) {
        Connection con1 = JDBCUtils.getCon();
        int i = 0;
        try {
            Statement statement = con1.createStatement();
            int i1 = statement.executeUpdate(sql);
            close(con1, statement, null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return i;
    }
}
