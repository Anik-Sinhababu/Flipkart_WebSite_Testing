package utils;
 
import java.io.FileInputStream;
import java.util.Properties;
 
public class Prop {
	public static FileInputStream file;
	public static Properties prop;
	public static String key = "";
 
	public static String getProperties(String key) {
 
		try {
			file = new FileInputStream(System.getProperty("user.dir") + "\\config\\config.properties");
			prop = new Properties();
			prop.load(file);
			key = prop.getProperty(key);
 
		} catch (Exception e) {
 
			e.printStackTrace();
		}
		return key;
	}
}