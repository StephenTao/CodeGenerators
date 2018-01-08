package com.codegenerators.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtil {
	
	public static void createDir(String path) {
		File file = new File(path);
		if (!file.isDirectory()) {
			file.mkdir();
		}
		
	}
	
	public static String getProjectDir() {
		return System.getProperty("user.dir");
	}
	
	public static void writeFile(String outPath, String content) {
	    File outFile = new File(outPath);
        FileWriter fw;
		try {
			fw = new FileWriter(outFile);
			fw.write(content);
		    fw.flush();
		    fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       
	}

}
