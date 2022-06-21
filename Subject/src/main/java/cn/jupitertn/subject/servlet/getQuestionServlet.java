package cn.jupitertn.subject.servlet;

import cn.jupitertn.subject.domain.Result;
import cn.jupitertn.subject.service.impl.QuestionServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "getQuestionServlet", value = "/getQuestionServlet")
public class getQuestionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        QuestionServiceImpl service = new QuestionServiceImpl();
        Result result = service.queryQuestion();
        response.getWriter().write(JSON.toJSONString(result));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
