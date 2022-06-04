package com.example.demo.dao;

import com.example.demo.domain.Result;

public interface TicketsDao {
    Result selectTickets(String start,String end);
    Result modify(String id,String status);
    Result selectFlight(String fCity,String tCity,String start,String end);
}
