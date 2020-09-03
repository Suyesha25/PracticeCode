package Library;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyValues {
	
	public static Properties prop;
	public PropertyValues()
	{
		prop = new Properties();
	    InputStream input = null;
	    
	    try {

	        input = new FileInputStream("src/main/resources/config.properties");

	        // load a properties file
	        prop.load(input);
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    }
	}
		
	public String getValue(String attribute)
	{
		String value= prop.getProperty(attribute);
		return value;
		
	}


}
