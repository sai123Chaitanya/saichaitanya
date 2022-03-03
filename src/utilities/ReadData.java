package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadData {

	public static String getData(String filename,String key) throws IOException
	{
		String filepath=".//resources//" +filename+".properties";
		FileInputStream isntream=new FileInputStream(filepath);
		Properties pro=new Properties();
		pro.load(isntream);
		return pro.getProperty(key);
	}
	
	/*
	 1. load file--> load(inputstream object)
	 2. getProperty--> getProperty(String key)
	 non static --> Properties--> java.util
	 */
}
