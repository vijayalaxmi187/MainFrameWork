package com.crm.autodeskgenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * 
 * @author Vijaylaxmi
 *
 */
public class FileUtility {
	/**
	 * its used to read the data from commonData.properties File based on key which you pass as an argument
	 * @param key
	 * @throws Throwable
	 */
public String getPropertyKeyValue(String key)throws Throwable{

	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\credentials.properties");

	Properties pro_obj=new Properties();
	pro_obj.load(fis);
	String value = pro_obj.getProperty(key);
	return value;
}
}
