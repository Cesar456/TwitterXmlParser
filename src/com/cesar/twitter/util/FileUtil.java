package com.cesar.twitter.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

/**
 * 对文件的读取和写入
 * 
 * @author Cesar
 * 
 */
public class FileUtil {

	private FileUtil() {
	}

	private static String xml_root_folder;
	
	static{
		xml_root_folder =  CommonSource.XML_ROOT_PATH;
		if(!xml_root_folder.endsWith("\\")||!xml_root_folder.endsWith("/")){
			xml_root_folder+="/";
		}
	}
	

	// 根目录下所有文件夹列表
	public static String[] getRootFolderList() {
		File file = new File(xml_root_folder);
		return file.list();
	}
	
	/**
	 * 传入相对路径，不要绝对路径
	 * @param folderName
	 * @return 路径下所有文件
	 */
	public static File[] getFileList(String folderName) {
		File file = new File(xml_root_folder+folderName);
		File[] fileList = file.listFiles();
		return fileList;
	}
	
	public static String getXmlToString(File fileName) {
		try {
			return Files.toString(fileName, Charsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
			CommonUtil.log(fileName.getAbsolutePath()+" getXmlToString Error");
		}
		return null;
	}
}
