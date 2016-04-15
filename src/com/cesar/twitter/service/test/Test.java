package com.cesar.twitter.service.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cesar.twitter.service.ParseMainService;

import junit.framework.TestCase;

public class Test extends TestCase {
	
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	ParseMainService service = context.getBean(ParseMainService.class);
	public void test1(){
		service.parseXml();
	}
}
