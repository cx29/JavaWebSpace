$(function () {
    let email = localStorage.getItem("email");
    let userId = "";
    $.ajax({
        type: "POST",
        url: "http://localhost:8080/SunshineAirlines/search?email=" + email,
        success: function (e) {
            let msg = JSON.parse(e);
            if (msg.flag == "success") {
                $(".email").val(msg.data[0].Email);
                $(".name").val(msg.data[0].FirstName + " " + msg.data[0].LastName);
                userId = msg.data[0].UserId;
            }
        },
        error: function () {
            location.href = "./Login.html";
        }
    });
    $(".list_out").click(function () {
        localStorage.removeItem("email");
        localStorage.removeItem("time");
        localStorage.removeItem("role");
        location.href = "./Login.html";
    });
    $(".newPassword").blur(function () {
        let newPwd = $(".newPassword").val();
        if (newPwd.length < 8 || newPwd.length > 16) {
            alert("请输入符合要求的密码");
        }
    });
    $(".newPasswordAgain").blur(function () {
        let newPwd = $(".newPassword").val();
        let newPwds = $(".newPasswordAgain").val();
        if (newPwd != newPwds) {
            alert("两次输入密码不一致,请重新输入");
        }
    });
    $(".submit").click(function () {
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/SunshineAirlines/updatePassword?userId=" + userId + "&password=" + $(".newPassword").val(),
            success: function (e) {
                let msg = JSON.parse(e);
                if (msg.flag == "success") {
                    localStorage.setItem("email", null);
                    localStorage.setItem("time", null);
                    localStorage.setItem("role", null);
                    location.href = "./Login.html";
                }
            }
        });
    });
    $(".cancel").click(function () {
        $(".newPassword").val("");
        $(".newPasswordAgain").val("");
    });
});