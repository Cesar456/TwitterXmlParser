package com.cesar.twitter.dao.test;

import java.io.File;

import junit.framework.TestCase;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cesar.twitter.dao.StatuDAO;
import com.cesar.twitter.util.XmlUtil;

public class DAOTest extends TestCase {

	public static void test1() {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		StatuDAO statuDAO = context.getBean(StatuDAO.class);

		statuDAO.save(XmlUtil.twitter_xml_parser(
				new File("C:/Users/Cesar/Desktop/xml_demo.xml")).get(0));

	}

}
