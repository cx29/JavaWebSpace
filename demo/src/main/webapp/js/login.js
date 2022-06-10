//提取判断账户类型，管理员 or 用户
function jump(num) {
    if (num == "1")
        location.href = "./ModifyPassword.html";
    else
        location.href = "./UserManagement.html";
}
//登录主要方法
$(function () {
    // 获取缓存信息的中的时间，并将其转换为整型形式的数据
    let oldTime = parseInt(localStorage.getItem("time"));
    //获取访问界面的当下的时间
    let nowTime = new Date().getDate();
    // 判断是否超过了7天的期限
    if (nowTime - oldTime <= 7 && nowTime - oldTime >= 0) {
        jump(localStorage.getItem("role"));
    } else {
        //如果超过期限则将缓存信息移除
        localStorage.removeItem("email");
        localStorage.removeItem("time");
        localStorage.removeItem("role");
    }
    //登录按钮点击事件
    $(".loginbutton").click(function () {
        // 获取用户输入的信息
        let email = $(".email").val();
        let pwd = $(".password").val();
        $.ajax({
            type: "POST",
            url: " http://localhost:8080/SunshineAirlines/login?email=" + email + "&password=" + pwd,
            success: function (e) {
                //将请求成功的JSON数据转换为对象
                let data = JSON.parse(e);
                // 判断返回的数据是成功的或者失败
                if (data.flag == "success") {
                    // 判断是否勾选7天自动登录
                    let isCheck = $(".is7day").is(":checked");
                    if (isCheck) {
                        let usrEmail = data.data.Email;
                        let role = data.data.RoleId;
                        let time = new Date().getDate();
                        //存入缓存信息，使用localStorage（此方法存储了就是永久的，不进行删除操作的话是不会过期的）
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