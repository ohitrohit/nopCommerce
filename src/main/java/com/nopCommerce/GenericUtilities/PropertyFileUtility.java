package com.nopCommerce.GenericUtilities;
/**
 * this class contain all the property file releted genric methods
 * @author rohit
 *
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtility {

	/**
	 * this class is used to read the data from properties file
	 * @return 
	 * @throws IOException 
	 */
	public String ReadDatafromPropertiesFile(String key) throws IOException {
		
	
	FileInputStream fis = new FileInputStream(IContactsUtility.PropertyFilePath);
	Properties property = new Properties();
	property.load(fis);
	String data=property.getProperty(key);
	return data;
	}
}
