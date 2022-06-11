function search(roleId, name, startPage) {
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/SunshineAirlines/userList?roleId=" + roleId + "&name=" + name + "&startPage=" + startPage + "&pageSize=10",
        success: function (e) {
            let line = "";
            let msg = JSON.parse(e);
            if (msg.flag == "success") {
                for (let i = 0; i < msg.data.length; i++) {
                    line += "<tr class=\"" + (i % 2 == 0 ? "tdcolor" : "tdcolor1") + "\"><td>" + msg.data[i].Email + "</td><td>" + msg.data[i].FirstName + " " + msg.data[i].LastName + "</td><td>" + (msg.data[i].Gender == "M" ? "Male" : "Female") + "</td><td>" + msg.data[i].DateOfBirth + "</td><td>" + msg.data[i].Phone + "</td><td>" + (msg.data[i].RoleId == "1" ? "Office User" : "Administrator") + "</td><td><input class='editUser' style='width: 80px;  font-size: 16px;' type='button' value='Edit'/></td></tr>";
                }
                $(".resultList").html(line);
            }
        }
    })
}
function pageTurn(btnName, operatNum) {
    let roleId = $('.roleId').val();
    let name = $(".userName").val();
    let startPage = 1;
    switch (operatNum) {
        case 1: {
            startPage = 1;
            search(roleId, name, startPage);
        } break;
        case 2:{
            startPage -=1;
            if(startPage==0){
                alert("已经是第一页了！");
            }else{
                search(roleId, name, startPage);
            }
        }break;
        case 3:{
            startPage +=1;
            if(startPage==0){
                alert("已经是第一页了！");
            }else{
                search(roleId, name, startPage);
            }
        }
    }
}
$(function () {
    let roleId = 0;
    let name = "";
    let startPage = 1;
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
});