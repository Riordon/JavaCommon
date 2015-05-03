package com.alone.util;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class ConfigUtil {
	
	private static ConfigUtil configUtil = null;
	
	public synchronized static ConfigUtil getInstancee() {
		if (configUtil == null) {
			configUtil = new ConfigUtil();
		}
		return configUtil;
	}
	
	public static CompositeConfiguration config = null;
	static {
		config = new CompositeConfiguration();
		try {
			config.addConfiguration(new PropertiesConfiguration("test.properties"));
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}  
	}
	
	public String getProperty(String key) {  
		return config.getString(key);  
	} 
	
	public static void main(String[] args) throws ConfigurationException {
//		CompositeConfiguration config = new CompositeConfiguration();
//		config.addConfiguration(new PropertiesConfiguration("test.properties"));
//		String username  = config.getString("username");
//		String password  = config.getString("password");
		
		String username  = ConfigUtil.getInstancee().getProperty("ip");
		String password  = ConfigUtil.getInstancee().getProperty("port");
		
		System.out.println(username); 
		System.out.println(password); 
	}
}
