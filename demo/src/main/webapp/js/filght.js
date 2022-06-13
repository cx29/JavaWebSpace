var fCity = "";
var tCity = "";
var start = "";
var end = "";
function clickThis(e, e1) {
    $.ajax({
        url: "http://localhost:8080/SunshineAirlines/updateSchedule?scheduleId=" + e + "&status=" + e1,
        type: "POST",
        success: function (e) {
            let msg = JSON.parse(e);
            if (msg.flag == "success") {
                search();
            }
        }
    })
}
function search() {
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/SunshineAirlines/getSchedule?fromCity=" + fCity + "&toCity=" + tCity + "&startDate=" + start + "&endDate=" + end,
        success: function (e) {
            let msg = JSON.parse(e);
            if (msg.flag == "success") {
                let line = "";
                for (let i = 0; i < msg.data.length; i++) {
                    let date = msg.data[i].Date.split(" ")[0];
                    let status = msg.data[i].Status == "Confirmed" ? "Canceled" : "Confirmed";
                    line += "<tr class=\"" + (i % 2 == 0 ? "tdcolor" : "tdcolor1") + "\"> <td >" + date + "</td> <td>" + msg.data[i].Time + "</td> <td>" + msg.data[i].DepartCityName + "/" + msg.data[i].DepartureAirportIATA + "</td> <td>" + msg.data[i].ArriveCityName + "/" + msg.data[i].ArrivalAirportIATA + "</td> <td>" + msg.data[i].Name + "</td> <td>" + msg.data[i].EconomyPrice + "</td> <td>" + msg.data[i].FlightNumber + "</td> <td>" + msg.data[i].Gate + "</td> <td>" + msg.data[i].Status + "</td> <td><input type='button' onclick=\"clickThis(" + msg.data[i].ScheduleId + ",'" + status + "')\" value='" + status + "'/></td> </tr>";
                }
                $(".resultList").html(line);
            }
        }
    })
}
$(function () {
    $(".list_out").click(function () {
        localStorage.removeItem("email");
        localStorage.removeItem("time");
        localStorage.removeItem("role");
        location.href = "./Login.html";
    });
    $(".changeicon").click(function () {
        fCity = $(".fromCity").val();
        tCity = $(".toCity").val();
        $(".toCity").val(fCity);
        $(".fromCity").val(tCity);
    });
    $(".searchBtn").click(function () {
        fCity = $(".fromCity").val();
        tCity = $(".toCity").val();
        start = $(".startDate").val();
        end = $(".endDate").val();
        search();
    });
});