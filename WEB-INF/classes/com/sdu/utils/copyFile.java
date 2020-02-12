package com.sdu.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class copyFile {
	public static void copy(String url1, String url2) throws Exception {
	    FileInputStream in = new FileInputStream(new File(url1));
	    FileOutputStream out = new FileOutputStream(new File(url2));
	    byte[] buff = new byte[512];
	    int n = 0;
	    while ((n = in.read(buff)) != -1) {
	        out.write(buff, 0, n);
	    }
	    out.flush();
	    in.close();
	    out.close();
	}
	
	public static void copy(File file, String url2) throws Exception {
	    FileInputStream in = new FileInputStream(file);
	    FileOutputStream out = new FileOutputStream(new File(url2));
	    byte[] buff = new byte[512];
	    int n = 0;
	    while ((n = in.read(buff)) != -1) {
	        out.write(buff, 0, n);
	    }
	    out.flush();
	    in.close();
	    out.close();
	}
}
