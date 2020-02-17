package com.zhangguo.ssmall.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collection;


public final class FileUtils
{
  private static final int BYTEOFM = 1024;

  public static String getLocalPath() {
	    String classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
	    return classPath.substring(0, classPath.indexOf("/WEB-INF/"));
	  }

  
  public static void createAndDeleteFile(File file) throws Exception {
    long timeOneDay = 86400000L;
    
    if (!file.exists()) {
      Boolean isOk = Boolean.valueOf(file.mkdirs());
      if (!isOk.booleanValue()) {
        System.out.println("FileUtils saveFile mkdirs error");
        throw new Exception("FileUtils saveFile mkdirs error");
      } 
    } else {
      
      File[] flist = file.listFiles(); byte b; int i; File[] arrayOfFile;
      for (i = (arrayOfFile = flist).length, b = 0; b < i; ) { File file2 = arrayOfFile[b];
        if (file2.exists() && file2.lastModified() < System.currentTimeMillis() - 86400000L) {
          Boolean deleOk = Boolean.valueOf(file2.delete());
          if (!deleOk.booleanValue()) {
        	  System.out.println("FileUtils saveFile deleteFile error");
          }
        } 
        b++; }
    
    } 
  }



}
