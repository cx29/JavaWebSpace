package com.example.demo.dao.impl;

import com.example.demo.dao.TicketsDao;
import com.example.demo.domain.Result;
import com.example.demo.utils.JDBCUtils;

import java.util.HashMap;
import java.util.List;

public class TicketsDaoImpl implements TicketsDao {
    @Override
    public Result selectTickets(String start, String end) {
        String sql = "SELECT\n" +
                "\tCONCAT(year( date ),\"-\",IF(month(date)<10,CONCAT(\"0\",month(date)),month(date))) month,\n" +
                "\tCOUNT( DISTINCT s.ScheduleId) FlightsAmount,\n" +
                "\tCOUNT(f.ReservationId) TicketsAmount,\n" +
                "\tSUM(f.Payment) TicketsRevenue\n" +
                "FROM\n" +
                "\t`schedule` s\n" +
                "\tLEFT JOIN flightreservation f ON s.ScheduleId = f.ScheduleId\n" +
                "\t\n" +
                "WHERE\n" +
                "\ts.`Status` = 'Confirmed' \n" +
                "\tAND ( s.Date >= '" + start + "' AND s.Date <= '" + end + "' ) \n" +
                "GROUP BY\n" +
                "\tyear( date ) ,\n" +
                "\tmonth( date ) \n" +
                "ORDER BY\n" +
                "\tyear( date ) ,\n" +
                "\tmonth( date )  ";
        List<HashMap<String, String>> query = JDBCUtils.query(sql);
        Result result = new Result();
        result.setFlag("fail");
        if (!query.isEmpty()) {
            result.setData(query);
            result.setFlag("success");
        }
        return result;
    }

    @Override
    public Result modify(String id, String status) {
        String sql = "UPDATE `schedule` SET `Status`= '" + status + "' WHERE ScheduleId=" + id;
        Integer update = JDBCUtils.update(sql);
        Result result = new Result();
        result.setFlag("fail");
        result.setData("航班计划不存在");
        if (update == 1) {
            result.setFlag("success");
            result.setData(null);
        }
        return result;
    }

    @Override
    public Result selectFlight(String fCity, String tCity, String start, String end) {
        String sql = "SELECT\n" +
                "\ts.ScheduleId,\n" +
                "\ts.Date,\n" +
                "\ts.Time,\n" +
                "\tr.DepartureAirportIATA,\n" +
                "\tc.CityName DepartCityName,\n" +
                "\tr.ArrivalAirportIATA,\n" +
                "\tc1.CityName ArriveCityName,\n" +
                "\ta.`Name` `Name`,\n" +
                "\ts.EconomyPrice,\n" +
                "\ts.FlightNumber,\n" +
                "\ts.Gate,\n" +
                "\ts.`Status` \n" +
                "FROM\n" +
                "\t`schedule` s\n" +
                "\tLEFT JOIN aircraft a ON a.AircraftId = s.AircraftId\n" +
                "\tLEFT JOIN route r ON r.RouteId = s.RouteId\n" +
                "\tLEFT JOIN city c ON c.CityCode = r.DepartureAirportIATA\n" +
                "\tLEFT JOIN city c1 ON c1.CityCode = r.ArrivalAirportIATA \n" +
                "WHERE\n" +
                "\tc.CityName='"+fCity+"' \n" +
                "\tAND c1.CityName='"+tCity+"'\n" +
                "\tAND ( s.Date BETWEEN '" + start + "' AND '" + end + "' )";
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
