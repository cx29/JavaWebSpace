var startNum = 1;
var qNum = 1;
var trueAnswer = [
    "", "", "", "", ""
];
$(document).ready(function () {
    getq(startNum);
    $(".next").click(function () {
        $(".tip").html("点我查看答案!");
        if (qNum >= 5) {
            qNum = 1;
            startNum++;
            getq(startNum);
        } else {
            $(".q-box" + qNum).fadeOut();
            qNum++;
            $(".q-box" + qNum).fadeIn();
        }
        console.log("next" + qNum);
        console.log("next" + startNum);
    });
    $(".pre").click(function () {
        $(".tip").html("点我查看答案!");
        if (qNum <= 1) {
            alert("当前已是第一题");
        } else {
            $(".q-box" + qNum).fadeOut();
            qNum--;
            $(".q-box" + qNum).fadeIn();
        }
    });
    $(".tip").click(function () {
        $(".tip").html(trueAnswer[qNum-1]);
    });
});
function getq(start) {
    start = (start - 1) * 20;
    $.ajax({
        url: "http://localhost:8080/subject/getq?start=" + start,
        type: "POST",
        success(e) {
            let msg = JSON.parse(e);
            if (msg.flag = "success") {
                let line = "";
                for (let i = 0; i < msg.data.length; i++) {
                    line += "<div class=\"q-box" + (i + 1) + "\">\n" +
                        "                <div class=\"title\">" + msg.data[i].question + "</div>\n" +
                        "                <div class=\"answer-list\">\n" +
                        "                    <li>\n" +
                        "                        <input type=\"radio\" name=\"qu\" value=\"1\" id=\"a\">\n" +
                        "                        <label for=\"a\">\n" +
                        "                            A." + msg.data[i].answer1 + "\n" +
                        "                        </label>\n" +
                        "                    </li>\n" +
                        "                    <li>\n" +
                        "                        <input type=\"radio\" name=\"qu\" value=\"2\" id=\"b\">\n" +
                        "                        <label for=\"b\">\n" +
                        "                            B." + msg.data[i].answer2 + "\n" +
                        "                        </label>\n" +
                        "                    </li>\n" +
                        "                    <li>\n" +
                        "                        <input type=\"radio\" name=\"qu\" value=\"3\" id=\"c\">\n" +
                        "                        <label for=\"c\">\n" +
                        "                            C." + msg.data[i].answer3 + "\n" +
                        "                        </label>\n" +
                        "                    </li>\n" +
                        "                    <li>\n" +
                        "                        <input type=\"radio\" name=\"qu\" value=\"4\" id=\"d\">\n" +
                        "                        <label for=\"d\">\n" +
                        "                            D." + msg.data[i].answer4 + "\n" +
                        "                        </label>\n" +
                        "                    </li>\n" +
                        "                </div>\n" +
                        "            </div>";
                    let trueth = parseInt(msg.data[i].trueAnswer);
                    switch(trueth){
                        case 1:{
                            trueAnswer[i]=msg.data[i].answer1
                        }break;
                        case 2:{
                            trueAnswer[i]=msg.data[i].answer2
                        }break;
                        case 3:{
                            trueAnswer[i]=msg.data[i].answer3
                        }break;
                        case 4:{
                            trueAnswer[i]=msg.data[i].answer4
                        }break;
                    }
                    $(".list").html(line);
                }
            }
        },
        error() {
            startNum = 1;
        }
    })
}