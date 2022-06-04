package com.example.control;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.impl.TicketsDaoImpl;
import com.example.demo.dao.impl.UserDaoImpl;
import com.example.demo.domain.Result;
import org.junit.Test;

public class Control {
//    登录
    @Test
    public void test1(){
        UserDaoImpl dao = new UserDaoImpl();
        Result login = dao.login("behappy@vip.sina.com", "123456");
        System.out.println(JSON.toJSONString(login));
    }
//    修改密码
    @Test
    public void test2(){
        UserDaoImpl userDao = new UserDaoImpl();
        Result modify = userDao.modify(1, "123");
        System.out.println(JSON.toJSONString(modify));
    }
//    用户管理
    @Test
    public void test3(){
        UserDaoImpl dao = new UserDaoImpl();
        Result result = dao.selectAll("2","","0");
        System.out.println(JSON.toJSONString(result));
    }
//    添加用户
    @Test
    public void test4(){
        UserDaoImpl dao = new UserDaoImpl();
        Result m = dao.insertUser("2136@qq.com", "2", "2", "M", "", "", "", "", "1");
        System.out.println(JSON.toJSONString(m));
    }
//    机票查询
    @Test
    public void test5(){
        TicketsDaoImpl dao = new TicketsDaoImpl();
        Result result = dao.selectTickets("2019-08", "2019-09");
        System.out.println(JSON.toJSONString(result));
    }
//    航班状态修改
    @Test
    public void test6(){
        TicketsDaoImpl ticketsDao = new TicketsDaoImpl();
        Result confirmed = ticketsDao.modify("1", "Confirmed");
        System.out.println(JSON.toJSONString(confirmed));
    }
//    查询航班
    @Test
    public void test7(){
        TicketsDaoImpl ticketsDao = new TicketsDaoImpl();
        Result result = ticketsDao.selectFlight("Beijing", "Hong Kong", "2019-08-06", "2019-09-06");
        System.out.println(JSON.toJSONString(result));
    }
}
