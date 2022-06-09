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

@WebServlet(name = "GetScheduleServlet", value = "/getSchedule")
public class GetScheduleServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String fromCity = request.getParameter("fromCity");
        String toCity = request.getParameter("toCity");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        TicketsDaoImpl ticketsDao = new TicketsDaoImpl();
        Result result = ticketsDao.selectFlight(fromCity, toCity, startDate, endDate);
        response.getWriter().write(JSON.toJSONString(result));
    }
}
