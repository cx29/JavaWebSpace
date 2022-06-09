package com.example.demo.servlet;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.impl.UserDaoImpl;
import com.example.demo.domain.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SerchServlet", value = "/userList")
public class SerchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String roleId = request.getParameter("roleId");
        String name = request.getParameter("name");
        String startPage = request.getParameter("startPage");
        UserDaoImpl userDao = new UserDaoImpl();
        Result result = userDao.selectAll(startPage, name, roleId);
        response.getWriter().write(JSON.toJSONString(result));
    }
}
