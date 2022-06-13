package com.example.demo.dao.impl;

import com.example.demo.dao.UserDao;
import com.example.demo.domain.Result;
import com.example.demo.domain.Results;
import com.example.demo.utils.JDBCUtils;

import java.util.HashMap;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public Result login(String email, String pwd) {
        String sql = "SELECT * FROM users WHERE Email='" + email + "'";
        List<HashMap<String, String>> query = JDBCUtils.query(sql);
        Result result = new Result();
        result.setFlag("fail");
        result.setData("邮箱不存在");
        if (!query.isEmpty()) {
            for (int i = 0; i < query.size(); i++) {
                String password = query.get(i).get("Password");
                if (pwd.equals(password)) {
                    result.setFlag("success");
                    result.setData(query.get(i));
                } else {
                    result.setData("密码错误");
                }
            }
        }
        return result;
    }

    @Override
    public Result modify(String i, String pwd) {
        String sql = "UPDATE users SET Password='" + pwd + "' WHERE UserId=" + i + "";
        Integer update = JDBCUtils.update(sql);
        Result result = new Result();
        result.setFlag("fail");
        if (update == 1) {
            result.setFlag("success");
        }
        return result;
    }

    public List<HashMap<String, String>> page(String sql, String start) {
        List<HashMap<String, String>> total = JDBCUtils.query(sql);
        HashMap<String, String> map = new HashMap<>();
        map.put("pageSize", "10");
        map.put("startPage", start);
        total.add(map);
        return total;
    }

    @Override
    public Results selectAll(String start, String name, String role) {
        int startPage = (Integer.parseInt(start) - 1) * 10;
        String sql = " ";
        String sql0 = " ";
        List<HashMap<String, String>> total = null;
        if (role.equals("0")) {
            if (startPage == 0) {
                sql0 = "SELECT COUNT(*) total FROM users WHERE (FirstName like '%" + name + "%' or LastName like '%" + name + "%')";
                total = page(sql0, start);
            }
            sql = "SELECT * FROM users WHERE (FirstName like '%" + name + "%' or LastName like '%" + name + "%') limit " + startPage + ",10";
        } else {
            if (startPage == 0) {
                sql0 = "SELECT COUNT(*) total FROM users WHERE roleId=" + role + " AND (FirstName like '%" + name + "%' or LastName like '%" + name + "%')";
                total = page(sql0, start);
            }
            sql = "SELECT * FROM users WHERE roleId=" + role + " AND (FirstName like '%" + name + "%' or LastName like '%" + name + "%') limit " + startPage + ",10";
        }
        List<HashMap<String, String>> query = JDBCUtils.query(sql);
        Results result = new Results();
        result.setFlag("fail");
        if (!query.isEmpty()) {
            result.setFlag("success");
            result.setData(query);
            result.setPages(total);
        }
        return result;
    }

    @Override
    public Result insertUser(String email, String fName, String lName, String gender, String date, String phone, String photo, String addr, String role) {
        String[] split = email.split("@");
        String pwd = "";
        Integer length = split[0].split("").length > 6 ? 6 : split[0].split("").length;
        for (int i = 0; i < length; i++) {
            pwd += split[0].split("")[i];
        }
        String sql = "INSERT INTO users VALUES(null," + "'" + email + "','" + fName + "','" + lName + "','" + pwd + "','" + gender + "','" + date + "','" + phone + "','" + photo + "','" + addr + "'," + role + ")";
        Integer update = JDBCUtils.update(sql);
        Result result = new Result();
        result.setFlag("fail");
        if (update == 1) {
            result.setFlag("success");
        }
        return result;
    }

    @Override
    public Result searchUsr(String email) {
        String sql = "SELECT * FROM users WHERE Email='" + email + "'";
        List<HashMap<String, String>> query = JDBCUtils.query(sql);
        Result result = new Result();
        result.setFlag("fail");
        if (!query.isEmpty()) {
            result.setFlag("success");
            result.setData(query);
        }
        return result;
    }


}
