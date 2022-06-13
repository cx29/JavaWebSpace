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

@WebServlet(name = "AddUserServlet", value = "/addUser")
public class AddUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String phone = request.getParameter("phone");
        String photo = request.getParameter("photo");
        String address = request.getParameter("address");
        System.out.println(photo);
        String roleId = request.getParameter("roleId");
        UserDaoImpl userDao = new UserDaoImpl();
        Result result1 = userDao.searchUsr(email);
        Result result = new Result();
        result.setData("邮箱重复了！");
        result.setFlag("fail");
        if (result1.getFlag().equals("fail"))
            result = userDao.insertUser(email, firstName, lastName, gender, dateOfBirth, phone, photo, address, roleId);
        response.getWriter().write(JSON.toJSONString(result));
    }
}
