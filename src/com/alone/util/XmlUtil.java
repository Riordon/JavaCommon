package com.alone.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import xstream.Person;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class XmlUtil {

	public static String toXml(Object obj) {
		XStream xstream = new XStream();
		xstream.processAnnotations(obj.getClass()); //注解可用
		return xstream.toXML(obj);
	}
	
	public static <T> T toBean(String xmlStr, Class<T> cls) {
		XStream xstream = new XStream(new DomDriver());
		xstream.processAnnotations(cls);
		T obj = (T) xstream.fromXML(xmlStr);
		return obj;
	}
	
	public static boolean toXmlFile(Object obj, String absPath, String fileName) {
	    String xml = toXml(obj);
        String filePath = absPath + fileName;
        File file = new File(filePath);
        
        OutputStream ous = null;
        try {
	        if(!file.exists()) {
	        	file.createNewFile();
	        }

	        ous = new FileOutputStream(file);
            ous.write(xml.getBytes());
            ous.flush();
            ous.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }    
		return true;
	}
	
    public static <T> T toBeanFromFile(String absPath, String fileName,Class<T> cls) throws Exception{
        String filePath = absPath +fileName;
        InputStream ins = null ;
        try {
            ins = new FileInputStream(new File(filePath ));
        } catch (Exception e) {
            throw new Exception("读{"+ filePath +"}文件失败！", e);
        }
         
        XStream xstream=new XStream(new DomDriver("utf-8"));
        xstream.processAnnotations(cls);
        T obj =null;
        try {
            obj = (T)xstream.fromXML(ins);
        } catch (Exception e) {
            throw new Exception("解析{"+ filePath +"}文件失败！",e);
        }
        if(ins != null)
            ins.close();
        return obj;         
    } 
	
//	public static void main(String[] args) throws Exception {
//
//		Person person = new Person("xiaolong",25,"hubei");
//		String xml = XmlUtil.toXml(person);
//		Person obj = XmlUtil.toBeanFromFile("F:/Projects/JavaCommon/", "info", Person.class);
//		System.out.println(obj.getName());
//		
//	}
}
