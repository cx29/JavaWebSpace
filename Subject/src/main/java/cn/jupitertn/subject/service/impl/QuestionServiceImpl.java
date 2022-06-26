package cn.jupitertn.subject.service.impl;

import cn.jupitertn.subject.domain.Result;
import cn.jupitertn.subject.service.QuestionService;
import cn.jupitertn.subject.utils.JDBCUtils;

import java.util.HashMap;
import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    @Override
    public Result queryQuestion() {
        String sql="SELECT a.id a,q.id q,q.name,a.value,a.YorN FROM question q LEFT JOIN answer a on q.id = a.questionId";
        List<HashMap<String, String>> query = JDBCUtils.query(sql);
        Result result = new Result();
        result.setFlag("fail");
        if(!query.isEmpty()){
            result.setFlag("success");
            result.setData(query);
        }
        return result;
    }
}
