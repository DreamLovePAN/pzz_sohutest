package com.sohu.test.producer;

import com.alibaba.fastjson.JSON;
import com.sohu.test.bean.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class DepartmentProducer {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * 发送数据
     * @param
     */
    public void sendLog(Integer dept_id,String deptname){
        Department dept=new Department(dept_id,deptname);
        System.err.println("发送用户日志数据:"+dept);
        kafkaTemplate.send("dept-test-pzz", JSON.toJSONString(dept));
    }

}
