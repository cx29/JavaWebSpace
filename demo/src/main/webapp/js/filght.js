$(function () {
    $(".list_out").click(function () {
        localStorage.removeItem("email");
        localStorage.removeItem("time");
        localStorage.removeItem("role");
        location.href = "./Login.html";
    });
})