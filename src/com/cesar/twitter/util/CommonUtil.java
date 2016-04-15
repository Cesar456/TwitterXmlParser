package com.cesar.twitter.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

/**
 * 不可实例化类 只提供基础操作，包括properties文件操作，sql语句清洗等
 * 
 * @author Cesar
 * 
 */
public class CommonUtil {

	private CommonUtil() {
	}

	private static Properties properties = new Properties();
	private static File log_file = new File("log.txt");

	static {
		try {
			properties.load(CommonUtil.class.getClassLoader()
					.getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Properties getProperties() {
		return properties;
	}

	public static String getPropertyValue(String key) {
		String keyValue = properties.getProperty(key);
		if (keyValue == null) {
			try {
				throw new Exception("没有获取到" + key + "属性，请检查");
			} catch (Exception e) {
				e.printStackTrace();
				System.exit(1);
			}
		}
		return keyValue;
	}

	public static void setProperty(String key, String value) {
		properties.setProperty(key, value);
	}

	/**
	 * 替换SQL中的特殊字符
	 * 
	 * @param input
	 * @return
	 */
	public static String sqlReplace(String input) {
		try {
			return input.replaceAll("'", "''").replaceAll("\\\\", "\\\\\\\\");
		} catch (Exception e) {
			return input;
		}
	}

	/**
	 * 简易的日志记录，由于并不复杂，所以不用log4j
	 */
	public static void log(String log) {
		try {
			Files.append(log + "  " + new Date() + "\n", log_file,
					Charsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
