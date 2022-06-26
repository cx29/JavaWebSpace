package cn.jupitertn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {
    private static String driver;
    private static String url;
    private static String usr;
    private static String pwd;
    private static Connection conn;

    static {
        try {
            driver="com.mysql.cj.jdbc.Driver";
            url="jdbc:mysql://localhost:3306/subject?serverTimezone=UTC";
            usr="root";
            pwd="123456";
            Class.forName(driver);
        }catch (Exception e){

        }
    }

    public static Integer insert(String sql){
        try {
            conn = DriverManager.getConnection(url, usr, pwd);
            Statement statement = conn.createStatement();
            int i = statement.executeUpdate(sql);
            return i;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
