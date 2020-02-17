package com.zhangguo.ssmall.tools;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;


public class PropertyLoader
{
    File directory = new File("");//设定为当前文件夹
    String curpath = directory.getAbsolutePath();
    String propertiesfile = curpath + "\\src\\testExcel\\config.properties";
  private  String CONFIG_FILE = propertiesfile;
  
  private Properties properties;
  
  private static PropertyLoader single = null;

  
  private PropertyLoader() throws IOException {
    this.properties = new Properties();
    
    FileInputStream in = new FileInputStream(new File(PropertyLoader.class.getResource(CONFIG_FILE).getFile()));
    InputStreamReader sr = new InputStreamReader(in, "UTF-8");
    this.properties.load(sr);
  }

  
  public static synchronized PropertyLoader getInstance() throws IOException {
    if (single == null) {
      single = new PropertyLoader();
    }
    
    return single;
  }







  
  public String getValue(String key) {
    if (this.properties.containsKey(key)) {
      return this.properties.getProperty(key);
    }
    return "";
  }
}
