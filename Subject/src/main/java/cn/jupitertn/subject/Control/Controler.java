package cn.jupitertn.subject.Control;

import cn.jupitertn.subject.domain.Result;
import cn.jupitertn.subject.service.impl.QuestionServiceImpl;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

public class Controler {
    @Test
    public void test1(){
        QuestionServiceImpl service = new QuestionServiceImpl();
        Result result = service.queryQuestion("0");
        System.out.println(JSON.toJSONString(result));
    }
}
