package com.cesar.twitter.util.test;

import java.io.File;

import com.cesar.twitter.util.CommonSource;
import com.cesar.twitter.util.CommonUtil;
import com.cesar.twitter.util.FileUtil;

import junit.framework.TestCase;

public class UtilTest extends TestCase {

	String s = CommonUtil.getPropertyValue("jdbc_url");
	String s2 = CommonSource.XML_ROOT_PATH;
	public void test1() {
		
		for(String s:FileUtil.getRootFolderList()){
			for(File file:FileUtil.getFileList(s)){
				System.out.println(FileUtil.getXmlToString(file).substring(0,20));
				return;
			}
		}

	}

}
