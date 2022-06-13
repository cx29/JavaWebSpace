var startPage = 1;
var total = 0;
var totalPage = 0;

function search(roleId, name, startPage) {
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/SunshineAirlines/userList?roleId=" + roleId + "&name=" + name + "&startPage=" + startPage + "&pageSize=10",
        success: function (e) {
            let line = "";
            let msg = JSON.parse(e);
            if (msg.flag == "success") {
                for (let i = 0; i < msg.data.length; i++) {
                    line += "<tr class=\"" + (i % 2 == 0 ? "tdcolor" : "tdcolor1") + "\"><td>" + msg.data[i].Email + "</td><td>" + msg.data[i].FirstName + " " + msg.data[i].LastName + "</td><td>" + (msg.data[i].Gender == "M" ? "Male" : "Female") + "</td><td>" + (msg.data[i].DateOfBirth ? msg.data[i].DateOfBirth : "") + "</td><td>" + (msg.data[i].Phone ? msg.data[i].Phone : "") + "</td><td>" + (msg.data[i].RoleId == "1" ? "Office User" : "Administrator") + "</td><td><input class='editUser' style='width: 80px;  font-size: 16px;' type='button' value='Edit'/></td></tr>";
                }
                $(".resultList").html(line);
                if (msg.pages) {
                    total = msg.pages[0].total;
                    totalPage = parseInt(total / 10) + 1;
                }
                let lines = "<span>Total Pages：</span><span class=\"pages pageNum\">" + totalPage + "</span><span>Total Records:</span><span class=\"totals\">" + total + "</span>";
                $(".totalpage").html(lines);
                let target = "";
                for (let i = 1; i <= totalPage; i++) {
                    target += "<option  value=" + i + ">" + i + "</option>";
                }
                $(".pageSelect").html(target);
                $(".pageSelect").val(startPage);
            }
        }
    })
}

function pageTurn(operatNum) {
    let roleId = $('.roleId').val();
    let name = $(".userName").val();
    switch (operatNum) {
        case 1: {
            startPage = 1;
            search(roleId, name, startPage);
        }
            break;
        case 2: {
            startPage -= 1;
            if (startPage == 0) {
                alert("已经是第一页了！");
            } else {
                search(roleId, name, startPage);
            }
        }
            break;
        case 3: {
            startPage += 1;
            if (startPage > totalPage) {
                alert("已经是最后一页了！");
            } else {
                search(roleId, name, startPage);
            }
        }
            break;
        case 4: {
            startPage = totalPage;
            search(roleId, name, startPage);
        }
    }
}
$(function () {
    let roleId = 0;
    let name = "";
    search(roleId, name, startPage);
    $(".list_out").click(function () {
        localStorage.removeItem("email");
        localStorage.removeItem("time");
        localStorage.removeItem("role");
        location.href = "./Login.html";
    });
    $(".searchBtn").click(function () {
        roleId = $('.roleId').val();
        name = $(".userName").val();
        startPage = 1;
        search(roleId, name, startPage)
    });
    $(".step-backward").click(function () {
        pageTurn(1);
    });
    $(".chevron-left").click(function () {
        pageTurn(2);
    });
    $(".chevron-right").click(function () {
        pageTurn(3);
    });
    $(".step-forward").click(function () {
        pageTurn(4);
    });
    $(".pageSelect").change(function () {
        let currentPage = $(".pageSelect").val();
        search(roleId, name, currentPage);
    })
});