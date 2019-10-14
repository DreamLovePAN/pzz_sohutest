package com.sohu.test;

import com.sohu.test.producer.DepartmentProducer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@MapperScan(value = "com.sohu.test.mapper")
@SpringBootApplication
public class TestApplication {

	/*@Autowired
	private DepartmentProducer kafkaSender;

	@PostConstruct
	public void init(){
		for (int i = 1; i < 10; i++) {
			//调用消息发送类中的消息发送方法
			kafkaSender.sendLog(i,"dept"+i);
		}
	}*/


	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}






}
