package com.example.demo.dao;

import com.example.demo.domain.Result;
import com.example.demo.domain.Results;

public interface UserDao {
    Result login(String email, String pwd);

    Result modify(String i, String pwd);

    Results selectAll(String start, String name, String role);

    Result insertUser(String email, String fName, String lName, String gender, String date, String phone, String photo, String addr, String role);

    Result searchUsr(String email);
}
