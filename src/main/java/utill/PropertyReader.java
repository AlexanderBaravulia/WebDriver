package utill;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Property {

    public static String getValue(String key){
        FileInputStream fis;
        Properties property = new Properties();

        try {
            fis = new FileInputStream("src/main/resources/config.properties");
            property.load(fis);
            return property.getProperty(key);
        } catch (IOException e) {
            System.err.println("Error to get property by the key : " + key);
            return null;
        }
    }
}
