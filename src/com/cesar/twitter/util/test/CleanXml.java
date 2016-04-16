package com.cesar.twitter.util.test;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cesar.twitter.util.CommonUtil;
import com.cesar.twitter.util.FileUtil;
import com.google.common.base.Charsets;
import com.google.common.io.Files;

/**
 * 由于xml文档格式不对，使用正则实现对xml文档进行一次处理
 * 
 * @author Cesar
 * 
 */
public class CleanXml {

	private static String root_folder = "F:/twitterData3/";

	static {
		File file = new File(root_folder);
		if (!file.exists()) {
			file.mkdir();
		}
	}

	public static void main(String[] args) {
		cleanAll();
	}

	public static void cleanOne(File folder) {
		System.out.println(folder + "开始");
		File[] files = folder.listFiles();
		for (File file : files) {
			replace(file, folder.getName());
			System.out.println("...");
		}
		System.out.println(folder + "  结束");
	}

	private static void cleanAll() {
		String[] folders = FileUtil.getRootFolderList();
		int i = 0;
		for (String folder : folders) {
			System.out.println("id= " + i++ + "  " + folder + "开始");
			File[] files = FileUtil.getFileList(folder);
			for (File file : files) {
				replace(file, folder);
				System.out.println("...");
			}
			System.out.println(folder + "  结束");
		}
	}

	private static void replace(File file, String folderName) {
		try {
			String s;
			s = Files.toString(file, Charsets.UTF_8);

			// 匹配数字的根节点,使用非贪婪算法
			s = s.replaceAll("<[0-9]+?>", "<statu>").replaceAll("</[0-9]+?>",
					"</statu>");

			// 匹配为url的不合法根节点，使用非贪婪算法，
			s = s.replaceAll("</https://t.co/.+?>", "");
			s = s.replaceAll("</http://t.co/.+?>", "");

			Pattern pattern = Pattern.compile("<https://t.co/.+?>");
			Matcher matcher = pattern.matcher(s);
			while (matcher.find()) {
				String re = matcher.group(0);
				s = s.replace(re, re.replace("<", "").replace(">", "="));
			}

			pattern = Pattern.compile("<http://t.co/.+?>");
			matcher = pattern.matcher(s);
			while (matcher.find()) {
				String re = matcher.group(0);
				s = s.replace(re, re.replace("<", "").replace(">", "="));
			}

			// 替换四个字节的字符 '\xF0\x9F\x98\x84\xF0\x9F）的解决方案 😁
			byte[] conbyte = s.getBytes();
			for (int i = 0; i < conbyte.length; i++) {
				if ((conbyte[i] & 0xF8) == 0xF0) {
					for (int j = 0; j < 4; j++) {
						conbyte[i + j] = 0x30;
					}
					i += 3;
				}
			}
			s = new String(conbyte);
			s = s.replaceAll("0000", "");

			File folder = new File(root_folder + folderName + "/");
			if (!folder.exists()) {
				folder.mkdir();
			}
			File file2 = new File(root_folder + folderName + "/"
					+ file.getName());
			Files.append(s, file2, Charsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
			CommonUtil.log(file.getAbsolutePath() + " 读取错误");
		}
	}
}
