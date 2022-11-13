package Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	public static Properties ps =null;
	
	public static  Properties readFile() {
		ps = new Properties();
		try {
			
			FileInputStream reader = new FileInputStream("resources\\config.properties");
			ps.load(reader);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}
}
