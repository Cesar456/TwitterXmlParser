package com.cesar.twitter.util;

/**
 * 记录了在config中定义的属性
 * 
 * @author Cesar
 * 
 */
public class CommonSource {

	private CommonSource() {
	}

	public static String XML_ROOT_PATH = CommonUtil
			.getPropertyValue("xml_root_path");
}
