package com.capgemini.microservice;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@EnableAutoConfiguration
public class UserService {
	
	public List<Greeting> list= new ArrayList<Greeting>();
	
    @RequestMapping("/hello.do")
    @ResponseBody
    public String home() {

        return "Hello World! this is sprint boot";
    }
    
//    @CrossOrigin(origins = "http://localhost:8080")
    @RequestMapping("/greeting")
    @ResponseBody
    public List<Greeting> sayGreeting()
    {
    	list = new ArrayList<Greeting>();
    	for(int i=0;i<10;i++)
    	{
    		Greeting greeting = new Greeting();
    		greeting.setId(i);
    		greeting.setName("chinese "+ i +" "+new Date());
    		list.add(greeting);
    	}
    	return list;
    }

}
