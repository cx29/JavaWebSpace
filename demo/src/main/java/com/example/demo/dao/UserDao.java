package com.example.demo.dao;

import com.example.demo.domain.Result;

public interface UserDao {
    Result login(String email, String pwd);
    Result modify(Integer i,String pwd);
    Result selectAll(String start,String name,String role);
    Result insertUser(String email,String fName,String lName,String gender,String date,String phone,String photo,String addr,String role);
}
