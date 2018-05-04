package com.ctgu.qmx.utils;

import java.io.File;
import java.util.Date;
import java.util.Random;

import org.apache.tomcat.util.http.fileupload.FileItem;

public class ImgSave {
	static String ImgSavePath = null;
	static String str = null;
	static {
		ImgSavePath = System.getProperty("catalina.home");
		str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	}

	public static String SaveImg(FileItem fileItem) {
		String path = getImgPath(fileItem);
		File file = new File(path);
		try {
			fileItem.write(file);
			fileItem.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return path;

	}

	public static String getImgPath(FileItem fileItem) {
		String fileName = fileItem.getName();
		String lastName = fileName.substring(fileName.lastIndexOf("."));
		String newFileName = ImgSavePath + "/webapps/storeImg/" + new Date().getTime() + getRandomString() + lastName;
		return newFileName;
	}

	public static String getRandomString() {
		Random random = new Random();
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < 4; i++) {
			int number = random.nextInt(48);
			stringBuffer.append(str.charAt(number));
		}
		return stringBuffer.toString();
	}
}
