package com.test.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Example

    {
	@Autowired
	MyBeanProperties my;
	
	@Value("${name}")
	private String name;
	@RequestMapping("/")
	String home()
	{
	   System.out.println(my.getName());
	   System.out.println("name :" + name);
	    return "hello world";
	}
	public static void main(String[] args) {
	    SpringApplication.run(Example.class, args);
	}
    }
