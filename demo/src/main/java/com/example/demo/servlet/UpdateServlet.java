package com.example.demo.servlet;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.impl.TicketsDaoImpl;
import com.example.demo.domain.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UpdateServlet", value = "/updateSchedule")
public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String scheduleId = request.getParameter("scheduleId");
        String status = request.getParameter("status");
        TicketsDaoImpl ticketsDao = new TicketsDaoImpl();
        Result modify = ticketsDao.modify(scheduleId, status);
        response.getWriter().write(JSON.toJSONString(modify));
    }
}
