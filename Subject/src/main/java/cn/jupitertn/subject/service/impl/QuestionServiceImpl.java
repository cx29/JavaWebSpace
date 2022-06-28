package cn.jupitertn.subject.service.impl;

import cn.jupitertn.subject.domain.Result;
import cn.jupitertn.subject.service.QuestionService;
import cn.jupitertn.subject.utils.JDBCUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuestionServiceImpl implements QuestionService {

    @Override
    public Result queryQuestion(String start) {
        String sql = "SELECT q.name,\n" +
                "       a2.value answer,\n" +
                "       a2.YorN,\n" +
                "       a.value1,\n" +
                "       a.value2,\n" +
                "       a.value3,\n" +
                "       a.value4,\n" +
                "       a.value5,\n" +
                "       s.address\n" +
                "FROM question q\n" +
                "         LEFT JOIN additional a on q.id = a.qId\n" +
                "         LEFT JOIN answer a2 on q.id = a2.questionId\n" +
                "         LEFT JOIN source s on q.id = s.qId\n" +
                "LIMIT "+start+",20";
        List<HashMap<String, String>> query = JDBCUtils.query(sql);
        Result result = new Result();
        result.setFlag("fail");
        if (!query.isEmpty()) {
            result.setFlag("success");
            List<HashMap<String, String>> hashMaps = new ArrayList<>();
            for (int i = 0; i < query.size(); i+=4) {
                HashMap<String, String> map = new HashMap<>();
                map.put("question", query.get(i).get("name"));
                int num=1;
                String trueAnswer="";
                for (int j = i; j <= i+3; j++) {
                    map.put("answer"+num, query.get(j).get("answer"));
                    if(query.get(j).get("YorN").equals("1")){
                        trueAnswer=num+"";
                    }
                    num++;
                }
                map.put("trueAnswer",trueAnswer);
                num=1;
                for (int k = 1; k <= 5; k++) {
                    String s = query.get(i).get("value" + k);
                    if (s != null && s.equals('.')) {
                        map.put("value" + k, s);
                    }
                }
                hashMaps.add(map);
            }
            result.setData(hashMaps);
        }
        return result;
    }
}
