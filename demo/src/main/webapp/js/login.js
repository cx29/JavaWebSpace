function jump(num) {
    if (num == "1")
        location.href = "./ModifyPassword.html";
    else
        location.href = "./UserManagement.html";
}

$(function () {
    let oldTime = parseInt(localStorage.getItem("time"));
    let nowTime = new Date().getDate();
    if (nowTime - oldTime <= 7 && nowTime - oldTime >= 0) {
        jump(localStorage.getItem("role"));
    } else {
        localStorage.removeItem("email");
        localStorage.removeItem("time");
        localStorage.removeItem("role");
    }
    $(".loginbutton").click(function () {
        let email = $(".email").val();
        let pwd = $(".password").val();
        $.ajax({
            type: "POST",
            url: " http://localhost:8080/SunshineAirlines/login?email=" + email + "&password=" + pwd,
            success: function (e) {
                let data = JSON.parse(e);
                if (data.flag == "success") {
                    let isCheck = $(".is7day").is(":checked");
                    if (isCheck) {
                        let usrEmail = data.data.Email;
                        let role = data.data.RoleId;
                        let time = new Date().getDate();
                        console.log(usrEmail + "," + role + "," + time);
                        localStorage.setItem("email", usrEmail);
                        localStorage.setItem("time", time);
                        localStorage.setItem("role", role);
                    }
                    jump(data.data.RoleId);
                } else {
                    $(".alertInfo").html(data.data)
                }
            }
        })
    });
})