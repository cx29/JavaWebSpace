$(function () {
    let date = new Date().getFullYear() + "-" + ((new Date().getMonth() + 1) < 10 ? "0" + (new Date().getMonth() + 1) : (new Date().getMonth() + 1));
    $(".list_out").click(function () {
        localStorage.removeItem("email");
        localStorage.removeItem("time");
        localStorage.removeItem("role");
        location.href = "./Login.html";
    });
    $(".endDate").attr("max", date);
    $(".startDate").attr("disabled", true);
    $(".endDate").blur(function () {
        $(".startDate").attr("disabled", false);
        $(".startDate").attr("max", $(".endDate").val());
    });
    $(".stat").click(function () {
        let start = $(".startDate").val();
        let end = $(".endtDate").val();
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/SunshineAirlines/getTicketStatistics?startDate=" + start + "&endDate=" + end,
            success: function (e) {
                let msg = JSON.parse(e);
                if (msg.flag == "success") {
                    let line = "";
                    for (let i = 0; i < msg.data.length; i++) {
                        line += "<tr class=\"" + (i % 2 == 0 ? "tdcolor1" : "tdcolor") + "\"><td>" + msg.data[i].Month + "</td><td>" + msg.data[i].FlightsAmount + "</td><td>" + msg.data[i].TicketsAmount + "</td><td>" + msg.data[i].TicketsRevenue + "</td>";
                    }
                    $(".resultList").html(line);
                }
            }
        })
    });
})