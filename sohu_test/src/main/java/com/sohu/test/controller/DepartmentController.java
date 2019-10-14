package com.sohu.test.controller;

import com.sohu.test.bean.Department;
import com.sohu.test.config.MyLog;
import com.sohu.test.exception.UserNotExistException;
import com.sohu.test.producer.DepartmentProducer;
import com.sohu.test.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @Autowired
    RedisTemplate<Object,Department> redisTemplate;
    @Autowired
	private DepartmentProducer kafkaSender;

    @ResponseBody
    @GetMapping(value="/test")
    public Map test2(){
        System.out.println("------------------");
        kafkaSender.sendLog(1,"dept");
        return new HashMap();
    }

    @ResponseBody
    @GetMapping(value="/query/{dept_id}")
    public Department test1(@PathVariable("dept_id") String id){
        //判断Redis中是否存在id，若是存在则从缓存中取，否则从数据库中取数据反馈并存入redis缓存中
        if(redisTemplate.hasKey(id)){
            System.out.println("缓存中存在数据："+redisTemplate.opsForValue().get(id));
            return redisTemplate.opsForValue().get(id);
        }
        System.out.println("缓存中不存在");
        Department department=departmentService.searchById(Integer.parseInt(id));
        redisTemplate.opsForValue().set(id,department,20, TimeUnit.SECONDS);
        return department;

    }

    @ResponseBody
    @GetMapping(value="/searchAll")
    @MyLog(module="部门模块", method="查询全部")
    public List<Department> searchAll(){
        try{
            throw new UserNotExistException();
        }catch(NullPointerException e){
            System.out.println("--------------");
        }

        return departmentService.searchAll();
    }



}
