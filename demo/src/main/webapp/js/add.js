var email = "";
var role = "";
var gender = "";
var fName = "";
var lName = "";
var birth = "";
var phone = "";
var photo = "";
var addr = "";
$(function () {
    $(".cancel").click(function () {
        location.href = "UserManagement.html";
    });

    $(".submit").click(function () {
        email = $(".email").val();
        role = $(".roleUser").is(":checked") ? "1" : "2";
        gender = $(".genderMale").is(":checked") ? "M" : "F";
        fName = $(".firstName").val();
        lName = $(".lastName").val();
        birth = $(".dateOfBirth").val();
        phone = $(".phone").val();
        photo = $(".photo").attr("src");
        photo = encodeURIComponent(photo);
        addr = $(".address").val();
        let data="email="+email+"&firstName="+fName+"&lastName="+lName+"&gender="+gender+"&dateOfBirth="+birth+"&phone="+phone+"&photo="+photo+"&address="+addr+"&roleId="+role;
        console.log(data);
        $.ajax({
            type: "POST",
            url: "http://localhost:8080/SunshineAirlines/addUser",
            data: data,
            success: function (e) {
                let msg = JSON.parse(e);
                if (msg.flag == "success") {
                    location.href = "aaaaa.html";
                } else {
                    alert(msg.data);
                }
            }
        })
    });

    $(".upload-input").change(function () {
        let file = this.files[0];
        let read = new FileReader();
        read.onload = function (e) {
            console.log(1);
            $(".photo").attr("src", e.target.result);
        }
        read.readAsDataURL(file);
    });
});