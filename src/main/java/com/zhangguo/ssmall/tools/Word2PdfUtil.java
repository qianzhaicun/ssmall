package com.zhangguo.ssmall.tools;

//import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
//import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
//import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.aspose.cells.Workbook;
import com.aspose.words.Document;
import com.aspose.words.License;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.Version;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;




public class Word2PdfUtil
{

  
  static final int wdFormatPDF = 17;
  
  private static final Log logger = LogFactory.getLog(Word2PdfUtil.class);

  public static boolean isLicense() {
      boolean result = false;
	     File directory = new File("");//设定为当前文件夹
	     String curpath = directory.getAbsolutePath();
	     System.out.println("curpath=" + curpath);
	     String license = curpath + "\\src\\testExcel\\license.xml";
	     
	     
	     
      InputStream licenseXml = com.aspose.words.Document.class.getResourceAsStream(license);
      try {
          License aposeLic = new License();
          aposeLic.setLicense(licenseXml);
          // TODO ignore
          result = true;
          System.out.println("Aspose.Words验证License通过...");
      } catch (Exception e) {
          e.printStackTrace();
          System.out.println("Aspose.Words验证License失败，导致的原因是：" + e.getMessage());
      }
      return result;
  }


  
  public static boolean getLicense() {
    boolean result = false;
    
    try {
	     File directory = new File("");//设定为当前文件夹
	     String curpath = directory.getAbsolutePath();
	     System.out.println("curpath=" + curpath);
	     String license = curpath + "\\src\\testExcel\\license.xml";
	     System.out.println("license=" + license);
      InputStream is = Word2PdfUtil.class.getClassLoader().getResourceAsStream(license);
      System.out.println("1");
      License aposeLic = new License();
      System.out.println("2");
      aposeLic.setLicense(is);
      System.out.println("3");
      result = true;
    } catch (Exception e) {
      System.out.println("获取密钥失败"+ e.getMessage());
      e.printStackTrace();
    } 
    return result;
  }







  
  public static void doc2pdf(String inPath, String outPath) {
    if (!isLicense()) {
      return;
    }
    try {
      long old = System.currentTimeMillis();
      System.out.println("Word转Pdf开始时间"+ new Date());
      File file = new File(outPath);
      FileOutputStream os = new FileOutputStream(file);
      Document doc = new Document(inPath);
      doc.save(os, 40);
      
      long now = System.currentTimeMillis();
      System.out.println("Word转Pdf结束时间"+ new Date());
      System.out.println("共耗时"+ ((now - old) / 1000.0D) + "秒");
  
    } catch (Exception e) {
    	System.out.println("Word转pdf出错"+ e.getMessage());
      e.printStackTrace();
    } 
  }







  
  public static void excel2pdf(String excelPath, String pdfPath) {
//    if (!isLicense()) {
//      return;
//    }
    try {
      long old = System.currentTimeMillis();
      System.out.println("excel转Pdf开始时间"+ new Date());
      Workbook wb = new Workbook(excelPath);
      System.out.println(1111);
      FileOutputStream fileOS = new FileOutputStream(new File(pdfPath));
      wb.save(fileOS, 13);
      fileOS.close();
      long now = System.currentTimeMillis();
      System.out.println("excel转Pdf结束时间"+ new Date());
      System.out.println("共耗时:"+ ((now - old) / 1000.0D) + "秒");
      System.out.println("共耗时:"+ ((now - old) / 1000.0D) + "秒");
    } catch (Exception e) {
      System.out.println("excel转Pdf报错"+ e.getMessage());
      e.printStackTrace();
    } 
  }







  
//  public static void WordExcelToPDF(String startFile, String overFile) {
//    try {
//      File inputFile = new File(startFile);
//      if (!inputFile.exists()) {
//        System.out.println("源文件不存在");
//        
//        return;
//      } 
//      
//      File outputFile = new File(overFile);
//      if (!outputFile.getParentFile().exists()) {
//        outputFile.getParentFile().exists();
//      }
//
//
//
//      
//      String command = "C:/Program Files (x86)/OpenOffice 4/program/soffice.exe -headless -accept=\"socket,host=127.0.0.1,port=8100;urp;\"";
//      Process p = Runtime.getRuntime().exec(command);
//
//      
//      SocketOpenOfficeConnection socketOpenOfficeConnection = new SocketOpenOfficeConnection("127.0.0.1", 8100);
//      socketOpenOfficeConnection.connect();
//
//      
//      OpenOfficeDocumentConverter openOfficeDocumentConverter = new OpenOfficeDocumentConverter((OpenOfficeConnection)socketOpenOfficeConnection);
//      openOfficeDocumentConverter.convert(inputFile, outputFile);
//
//      
//      socketOpenOfficeConnection.disconnect();
//
//      
//      p.destroy();
//    } catch (Exception e) {
//      System.out.println("WordToPDF报错"+ e.getMessage());
//      e.printStackTrace();
//    } 
//  }
//  
  
  public static String createExcelFile(Map<String, Object> dataMap) throws Exception {
      Writer out = null;
      
      	//绝对路径
      	WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        ServletContext servletContext = webApplicationContext.getServletContext();
        // 得到文件绝对路径
        String curpath = servletContext.getRealPath("/");
        logger.info("realPath:"+curpath);

	    
    try {
    	logger.info("1");
      Configuration configuration = new Configuration(new Version("2.3.23"));
      configuration.setDefaultEncoding("UTF-8");
      logger.info("2");
      File excelTempletePath = new File(curpath + "\\excelTemplete");
      logger.info("3");
      configuration.setDirectoryForTemplateLoading(excelTempletePath);
      logger.info("4");
      Template template = configuration.getTemplate("商品信息.ftl");
      logger.info("5");
      
      String filePath = curpath + "\\excel";
      File outFilePath = new File(filePath);
      logger.info("6");
      FileUtils.createAndDeleteFile(outFilePath);
      logger.info("7");
      
      String fileName = "商品信息" + "_" + System.currentTimeMillis() + 
        ".xls";
      logger.info("wwww=" + String.valueOf(filePath) + "\\" + fileName);
      File outFile = new File(String.valueOf(filePath) + "\\" + fileName);
      out = new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8");
      template.process(dataMap, out);
      return fileName;
    } catch (Exception e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (out != null) {
        out.close();
      }
    } 
  }	
  
  
}
